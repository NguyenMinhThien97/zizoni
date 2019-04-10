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
@Table(name = "new")
@Getter @Setter @NoArgsConstructor
public class New {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="meta_title")
	private String meta_title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@Column(name="new_categoryid")
	private int new_categoryid;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="created_date")
	private LocalDate created_date;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="modified_date")
	private LocalDate modified_date;
	
	@Column(name="modified_by")
	private String modified_by;
	
	@Column(name="meta_key_words")
	private String meta_key_words;
	
	@Column(name="metadescription")
	private String metadescription;
	
	@Column(name="status")
	private String status;
	
	@Column(name="top_hot")
	private LocalDate top_hot;
	
	@Column(name="viewcount")
	private int viewcount;
	
	@Column(name="tagID")
	private String tagID;
}
