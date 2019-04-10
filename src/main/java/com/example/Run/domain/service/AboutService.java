package com.example.Run.domain.service;

import java.util.Optional;

import com.example.Run.domain.entity.About;

public interface AboutService {
	public Optional<About> getAbout();
	public About update(About about);
}
