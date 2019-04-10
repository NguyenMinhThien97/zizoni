package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.Run.domain.entity.New;


public interface NewService {
	public List<New> getAllNew();
	public New createNew(New New);
	public New Update(New New);
	public void deleteNewById(long id);
	public Optional<New> findById(long id);
	public List<New> getTopNew();
}
