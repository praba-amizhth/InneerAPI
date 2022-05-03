package com.amizhth.inneer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
	private int id;
	private int watercanId;
	private int userid;
	private int vendorid;
	private int quantity;
	private float unitPrice;
	private float totalPrice;
	private float paidAmt;
	private int status;
	private int paidFg;
	private int emptyCanCount;
}
