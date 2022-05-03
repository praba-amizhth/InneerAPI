package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FilterCriteria {
	private String key;
	private String operation;
	private Object value;

}
