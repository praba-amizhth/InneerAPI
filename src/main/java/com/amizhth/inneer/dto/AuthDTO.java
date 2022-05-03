package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthDTO {
	private int id;
	private int status;
	private String userName;
	private String token;
	private String name;
	private String password;
	private String mobileNumber;
	private int otp;
	private int type;
}
