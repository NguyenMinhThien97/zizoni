package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Slide;
import com.example.Run.domain.repository.SlideRepository;
import com.example.Run.domain.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService{
	@Autowired
	private SlideRepository slideRepository;
	
	@Override
	public List<Slide> getAllSlide() {
		
		return slideRepository.findAll();
	}

	@Override
	public Slide createSlide(Slide slide) {
		
		return slideRepository.save(slide);
	}

	@Override
	public Slide Update(Slide slide) {
		
		return slideRepository.save(slide);
	}

	@Override
	public void deleteSlideById(long id) {
		
		slideRepository.deleteById(id);
	}

	@Override
	public Optional<Slide> findById(long id) {
		
		return slideRepository.findById(id);
	}

}
