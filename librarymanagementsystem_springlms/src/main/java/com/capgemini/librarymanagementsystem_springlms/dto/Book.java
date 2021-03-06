package com.capgemini.librarymanagementsystem_springlms.dto;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name="book")
@SequenceGenerator(name="seq3", initialValue=101, allocationSize=100)
public class Book implements Serializable {
	@Id
	@Column(name = "bId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq3")
	private int bId;
	@Column
	private String bookName;
	@Column
	private String author;
	@Column
	private String category;
	@Column
	private String publisher;
	
	
	

}
