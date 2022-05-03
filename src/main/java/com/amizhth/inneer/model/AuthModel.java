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
@Entity(name = "auth_model")
public class AuthModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int status;
	private String username;
	private String firstname;
	private String entityname;
	private int entityid;
	private String password;
	private String mobilenumber;
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
