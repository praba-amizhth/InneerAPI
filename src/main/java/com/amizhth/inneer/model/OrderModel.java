package com.amizhth.inneer.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "ordermodel")
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int watercanid;
	private int userid;
	private int vendorid;
	private int quantity;
	private float unitprice;
	private float totalprice;
	private float paidamt;
	private int status;
	private int paidfg;
	private int emptycancount;
	private String createdby;
	private String modifiedby;
	private LocalDateTime createdtime;
	private LocalDateTime modifiedtime;
	private long submittedtimeval;

	@PrePersist
	public void setCreationDateTime() {
		this.createdtime = LocalDateTime.now();

	}

	@PreUpdate
	public void setModifiedDateTime() {
		this.modifiedtime = LocalDateTime.now();
	}

}
