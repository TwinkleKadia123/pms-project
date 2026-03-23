package com.pms.imageupload.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pms.imageupload.IFileStorageService;

import io.jsonwebtoken.io.IOException;

@Service
public class FileStorageServiceImpl implements IFileStorageService {

	 private final Path fileStorageLocation;
	 
	 public FileStorageServiceImpl(@Value("${file.upload-dir}") String uploadDir) throws IOException, java.io.IOException {
	        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
	        Files.createDirectories(this.fileStorageLocation); // Create folder if not exists
	    }
	
	 
	 public String storeFile(MultipartFile file) throws IOException, java.io.IOException {
	        // Validate file
	        if (file.isEmpty()) {
	            throw new IOException("File is empty");
	        }

	        // Normalize file name
	        String fileName = Path.of(file.getOriginalFilename()).getFileName().toString();

	        // Copy file to target location (replace existing)
	        Path targetLocation = this.fileStorageLocation.resolve(fileName);
	        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	        return fileName;
	    }

	    public Path loadFile(String fileName) {
	        return fileStorageLocation.resolve(fileName).normalize();
	    }
}
