package com.retail.loyalty.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class AppUtil {

    public static File unzipFile(MultipartFile file, Path tempDir) throws IOException {
        File unzippedFile = null;
        try (ZipInputStream zis = new ZipInputStream(file.getInputStream())) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                Path newFilePath = tempDir.resolve(zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    Files.createDirectories(newFilePath);
                } else {
                    Files.createDirectories(newFilePath.getParent());
                    Files.copy(zis, newFilePath);
                    unzippedFile = newFilePath.toFile();
                }
                zipEntry = zis.getNextEntry();
            }
        }
        return unzippedFile;
    }

}
