package com.example.Run.domain.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.Run.domain.entity.UploadFile;

public interface FileService {
	
	public UploadFile storeFile (MultipartFile multipartFile);
	public UploadFile getFile (long id);
}
