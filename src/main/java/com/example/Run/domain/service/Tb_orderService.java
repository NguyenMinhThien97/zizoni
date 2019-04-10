package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.Run.domain.entity.Tb_order;

public interface Tb_orderService {
	public List<Tb_order> getAllTb_order();
	public Tb_order createTb_order(Tb_order tb_order);
	public Tb_order Update(Tb_order tb_order);
	public void deleteTb_orderById(long id);
	public Optional<Tb_order> findById(long id);
}
