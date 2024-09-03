<?php

namespace App\Controllers;

use CodeIgniter\RESTful\ResourceController;
use App\Services\FileProcessingService;
use CodeIgniter\HTTP\ResponseInterface;

class FileController extends ResourceController
{
    protected $fileProcessingService;

    public function __construct()
    {
        $this->fileProcessingService = new FileProcessingService();
    }

    public function processFile()
    {
        $file = $this->request->getFile('file');
        $filePath = $this->request->getPost('file_path');

        if (!$file && !$filePath) {
            return $this->fail('Either file or file_path must be provided', ResponseInterface::HTTP_BAD_REQUEST);
        }

        try {
            $this->fileProcessingService->process($file, $filePath);
            return $this->respond(['message' => 'File processing has been started'], ResponseInterface::HTTP_ACCEPTED);
        } catch (\Exception $e) {
            return $this->fail($e->getMessage(), ResponseInterface::HTTP_INTERNAL_SERVER_ERROR);
        }
    }
}