package com.retail.loyalty.controller.v1;

import com.retail.loyalty.service.UserService;
import com.retail.loyalty.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCsv(@RequestParam(value = "file", required = false) MultipartFile file,
                                            @RequestParam(value = "filePath", required = false) String filePath) {
        if (file == null && filePath == null) {
            throw new IllegalArgumentException("Either file or filePath must be provided");
        }

        try {
            if (file != null) {
                Path tempDir = Files.createTempDirectory("tempZip");
                File unzippedFile = AppUtil.unzipFile(file, tempDir);
                userService.uploadCsv(unzippedFile.getAbsolutePath());
            } else {
                userService.uploadCsv(filePath);
            }
            return ResponseEntity.ok("CSV file uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload CSV file: " + e.getMessage());
        }
    }
}