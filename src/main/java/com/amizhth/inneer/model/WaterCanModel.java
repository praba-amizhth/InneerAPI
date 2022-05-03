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
@Entity(name = "watercan")
public class WaterCanModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brandname;
	private int capacity;
	private float price;
	private int vendorid;
	private String imgname;
	private String createdby;
	private String modifiedby;
	private LocalDateTime createdtime;
	private LocalDateTime modifiedtime;
	

	@PrePersist
	public void setCreationDateTime() {
		this.createdtime = LocalDateTime.now();

	}
	@PreUpdate 
	public void setModifiedDateTime() {
		this.modifiedtime = LocalDateTime.now();
	}

}
