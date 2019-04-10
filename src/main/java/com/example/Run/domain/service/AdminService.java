package com.example.Run.domain.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.Run.domain.entity.Admin;


public interface AdminService {
	List<Admin> getAllAd();
	public Admin createAdmin(Admin ad);
	public void deleteAdminById(long id);
	public Admin update(Admin ad);
	public List<Admin> findAdmin(@Param("id") long id);
}
