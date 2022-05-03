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
@Entity(name = "addressmodel")
public class AddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String buildingno;
	private String buildingname;
	private String streetname;
	private int userid;
	private String city;
	private String state;
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
