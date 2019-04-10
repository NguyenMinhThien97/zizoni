package com.example.Run.domain.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.Run.domain.entity.UploadFile;
import com.example.Run.domain.repository.FileRepository;
import com.example.Run.domain.service.FileService;
import com.example.Run.exception.FileStorageException;
import com.example.Run.exception.MyFileNotFoundException;

import java.io.IOException;

@Service
public class FileStorageService implements FileService{

	@Autowired
    private FileRepository fileRepository;

    public UploadFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            UploadFile uploadFile = new UploadFile(fileName, file.getContentType(), file.getBytes());

            return fileRepository.save(uploadFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public UploadFile getFile(long id) {
        return fileRepository.findById(id).orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }
}