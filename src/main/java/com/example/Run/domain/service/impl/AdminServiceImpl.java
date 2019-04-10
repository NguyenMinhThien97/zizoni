package com.example.Run.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Admin;
import com.example.Run.domain.repository.AdminRespository;
import com.example.Run.domain.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRespository adminRespository;
	
	@Override
	public Admin createAdmin(Admin ad) {
		return adminRespository.save(ad);
	}

	@Override
	public void deleteAdminById(long id) {
		// TODO Auto-generated method stub
		adminRespository.deleteById(id);
	}

	@Override
	public Admin update(Admin ad) {
		return adminRespository.save(ad);
	}

	@Override
	public List<Admin> findAdmin(long id) {
		// TODO Auto-generated method stub
		return adminRespository.findId(id);
	}

	@Override
	public List<Admin> getAllAd() {
		// TODO Auto-generated method stub
		return adminRespository.findAll();
	}
	
}
