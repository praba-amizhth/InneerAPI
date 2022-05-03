package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WaterCanDTO {
	private int id;
	private String brandName;
	private int capacity;
	private float price;
	private int vendorId;
	private String imgName;

}
