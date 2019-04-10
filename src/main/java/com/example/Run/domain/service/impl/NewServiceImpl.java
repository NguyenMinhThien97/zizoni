package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.New;
import com.example.Run.domain.repository.NewRepository;
import com.example.Run.domain.service.NewService;

@Service
public class NewServiceImpl implements NewService{
	@Autowired
	private NewRepository newRepository;
	
	@Override
	public List<New> getAllNew() {
		return newRepository.findAll();
	}

	@Override
	public New createNew(New news) {
		return newRepository.save(news);
	}

	@Override
	public New Update(New news) {
		return newRepository.save(news);
	}

	@Override
	public void deleteNewById(long id) {
		newRepository.deleteById(id);
	}

	@Override
	public Optional<New> findById(long id) {
		return newRepository.findById(id);
	}
	@Override
	public List<New> getTopNew() {
		return newRepository.TopNew();
	}

}
