package com.example.Run.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.Tb_order;

@Repository
public interface Tb_orderRepository extends JpaRepository< Tb_order, Long>{

}
