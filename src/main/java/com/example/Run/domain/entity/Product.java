package com.example.Run.domain.entity;

import java.io.Serializable;
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
@Table(name = "product")
@Getter @Setter @NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="catalogID")
	private int catalogID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="content")
	private String content;
	
	@Column(name="discount")
	private int discount ;
	
	@Column(name="image_link")
	private String image_link;
	
	@Column(name="imagelist")
	private String imagelist;
	
	@Column(name="view")
	private int view;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;
	
	@Column(name="nb_like")
	private int nb_like;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="created_date")
	private LocalDate created_date;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="modified_date")
	private LocalDate modified_date;
	
	@Column(name="modified_by")
	private String modified_by;
	
	@Column(name="status")
	private String status;
}
