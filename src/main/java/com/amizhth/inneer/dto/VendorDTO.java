package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VendorDTO {
	private int id;
	private String vendorName;
	private String phonenumber;
	private String emailId;
	private String fileName;
	private String qrcodeStr;
	private int emptyCansCount;
}
