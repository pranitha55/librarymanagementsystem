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
@Table(name="request_details")
@SequenceGenerator(name="seq1", initialValue=1, allocationSize=100)
public class RequestDetails implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq1")
	private int uId;
	@Column
	private String fullName;
	@Column
	private int bId;
	@Column
	private String bookName;
	
}
