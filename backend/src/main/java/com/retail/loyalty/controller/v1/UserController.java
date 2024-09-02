package com.retail.loyalty.controller;

import com.retail.loyalty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            userService.uploadCsv(file);
            return ResponseEntity.ok("CSV file uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload CSV file: " + e.getMessage());
        }
    }
}