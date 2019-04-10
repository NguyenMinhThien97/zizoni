package com.example.Run.domain.entity;

import java.time.LocalDate;

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
@Table(name = "transaction")
@Getter @Setter @NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_phone")
	private String user_phone;
	
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="payment_info")
	private String payment_info;
	
	@Column(name="message")
	private String message;
	
	@Column(name="security")
	private String security;
	
	@Column(name="created")
	private LocalDate created;
}
