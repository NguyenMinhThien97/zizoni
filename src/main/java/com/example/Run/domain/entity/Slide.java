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
@Table(name = "slide")
@Getter @Setter @NoArgsConstructor
public class Slide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;

	@Column(name="image")
	private String image;
	
	@Column(name="link")
	private String link;
	
	@Column(name="title")
	private String title;
	
	@Column(name="button")
	private String button;
	
	@Column(name="created_date")
	private LocalDate created_date;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="modifie_date")
	private LocalDate modifie_date;
	
	@Column(name="modifie_by")
	private String modifie_by;
	
	@Column(name="display_order")
	private int display_order;
	
	@Column(name="description")
	private String description;
	
}
