package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
	private int id;
	private String userName;
	private String phonenumber;
	private String emailId;
	private float walletBalance;
}
