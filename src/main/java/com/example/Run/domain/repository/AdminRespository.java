package com.example.Run.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.Admin;


@Repository
public interface AdminRespository extends JpaRepository<Admin, Long> {
	@Query(value ="SELECT n FROM Admin n WHERE n.id = :id") 
	List<Admin> findId(@Param("id")long id);
}
