package com.example.Run.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter @Setter @NoArgsConstructor
public class Tb_order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="transaction_id")
	private long transaction_id;
	
	@Column(name="product_id")
	private int product_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="data")
	private String data;
	
	@Column(name="status")
	private String status;
}
