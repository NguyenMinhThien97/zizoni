package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;


import com.example.Run.domain.entity.Slide;

public interface SlideService {
	public List<Slide> getAllSlide();
	public Slide createSlide(Slide slide);
	public Slide Update(Slide slide);
	public void deleteSlideById(long id);
	public Optional<Slide> findById(long id);
}
