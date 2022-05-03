package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BannerDTO {
	private int id;
	private String filename;
	private int seq;
	private String createdby;
	private String modifiedby;
}
