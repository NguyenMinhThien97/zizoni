package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Tb_order;
import com.example.Run.domain.repository.Tb_orderRepository;
import com.example.Run.domain.service.Tb_orderService;

@Service
public class Tb_orderServiceImpl implements Tb_orderService{
	@Autowired
	private Tb_orderRepository tb_orderRepository;
	
	@Override
	public List<Tb_order> getAllTb_order() {
		
		return tb_orderRepository.findAll();
	}

	@Override
	public Tb_order createTb_order(Tb_order Tb_order) {
		
		return tb_orderRepository.save(Tb_order);
	}

	@Override
	public Tb_order Update(Tb_order Tb_order) {
		
		return tb_orderRepository.save(Tb_order);
	}

	@Override
	public void deleteTb_orderById(long id) {
		
		tb_orderRepository.deleteById(id);
	}

	@Override
	public Optional<Tb_order> findById(long id) {
		
		return tb_orderRepository.findById(id);
	}
}
