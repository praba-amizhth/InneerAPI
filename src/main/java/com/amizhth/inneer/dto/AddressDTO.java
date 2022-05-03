package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressDTO {
	private int id;
	private String buildingNo;
	private String buildingName;
	private String streetName;
	private int userid;
	private String city;
	private String state;
}
