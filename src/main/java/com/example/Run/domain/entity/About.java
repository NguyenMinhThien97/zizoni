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
@Table(name = "about")
@Getter @Setter @NoArgsConstructor
public class About {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private long id;
	
	@Column(name="info")
	private String info;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
}