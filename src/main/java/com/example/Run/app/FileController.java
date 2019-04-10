package com.example.Run.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Run.domain.entity.UploadFile;
import com.example.Run.domain.service.impl.FileStorageService;
import com.example.Run.payload.UploadFileResponse;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RestController
@RequestMapping("file")
public class FileController {

	@Autowired
    private FileStorageService fileStorageService;
	
	
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	UploadFile uploadFile = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/img/")
                .path(String.valueOf(uploadFile.getId()))
                .toUriString();
        
        return new UploadFileResponse(uploadFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/img/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") long id) {
        // Load file from database
    	UploadFile uploadFile = fileStorageService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadFile.getFileName() + "\"")
                .body(new ByteArrayResource(uploadFile.getData()));
    }

}
