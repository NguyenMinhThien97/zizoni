package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;


import com.example.Run.domain.entity.Tag;

public interface TagService {
	public List<Tag> getAllTag();
	public Tag createTag(Tag tag);
	public Tag Update(Tag tag);
	public void deleteTagById(long id);
	public Optional<Tag> findById(long id);
}
