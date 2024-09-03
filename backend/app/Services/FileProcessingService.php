<?php

namespace App\Services;

use App\Models\UserModel;
use CodeIgniter\Files\File;
use Throwable;

class FileProcessingService
{
    public function process($file = null, $filePath = null)
    {
        if ($file) {
            $this->processZipFile($file);
        } elseif ($filePath) {
            $this->processCsvFile($filePath);
        }
    }

    private function processZipFile(File $file)
    {
        if ($file->getClientMimeType() !== 'application/zip') {
            throw new \Exception('The file must be a zip file');
        }

        $zip = new \ZipArchive();
        if ($zip->open($file->getRealPath()) === TRUE) {
            $zip->extractTo('/path/to/extract/');
            $zip->close();
            $this->processCsvFile('/path/to/extract/extracted.csv');
        } else {
            throw new \Exception('Failed to unzip the file');
        }
    }

    private function processCsvFile($filePath)
    {
        if (!file_exists($filePath)) {
            throw new \Exception('The file path does not exist');
        }

        $file = fopen($filePath, 'r');
        $header = fgetcsv($file);
        $data = [];
        $userModel = new UserModel();

        while (($row = fgetcsv($file)) !== FALSE) {
            $record = array_combine($header, $row);
            $record['timestamp'] = date('Y-m-d H:i:s');
            $data[] = $record;

            if (count($data) >= 10000) {
                $userModel->insertBatch($data);
                $data = [];
            }
        }

        if (!empty($data)) {
            $userModel->insertBatch($data);
        }

        fclose($file);
    }

    private function logError($message)
    {
        $errorModel = new \App\Models\ErrorModel();
        $errorModel->save([
            'message' => $message,
            'timestamp' => date('Y-m-d H:i:s')
        ]);
    }
}

