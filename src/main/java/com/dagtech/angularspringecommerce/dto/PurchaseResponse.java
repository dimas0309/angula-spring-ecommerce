package com.dagtech.angularspringecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
	
	private final String orderTrackingNumber;
	private final Long orderId;

}
