package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Tag;
import com.example.Run.domain.repository.TagRepository;
import com.example.Run.domain.service.TagService;

@Service
public class TagServiceImpl implements TagService{
	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public List<Tag> getAllTag() {
		
		return tagRepository.findAll();
	}

	@Override
	public Tag createTag(Tag tag) {
		
		return tagRepository.save(tag);
	}

	@Override
	public Tag Update(Tag tag) {
		
		return tagRepository.save(tag);
	}

	@Override
	public void deleteTagById(long id) {
		
		tagRepository.deleteById(id);
	}

	@Override
	public Optional<Tag> findById(long id) {
		
		return tagRepository.findById(id);
	}

}
