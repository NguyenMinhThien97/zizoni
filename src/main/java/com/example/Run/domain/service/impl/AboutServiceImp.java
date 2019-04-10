package com.example.Run.domain.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.About;
import com.example.Run.domain.repository.AboutRepository;
import com.example.Run.domain.service.AboutService;

@Service
public class AboutServiceImp implements AboutService{
	@Autowired
	private AboutRepository AboutRespository;

	@Override
	public Optional<About> getAbout() {
		long id=0;
		return AboutRespository.findById(id);
	}

	@Override
	public About update(About about) {
		return AboutRespository.save(about);
	}
}
