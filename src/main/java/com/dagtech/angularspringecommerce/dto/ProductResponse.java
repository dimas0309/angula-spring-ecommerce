package com.dagtech.angularspringecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProductResponse {
	
	private final Long categoryId;
	private final String name;
	private final String brand;
	private final String partNumber;
	private final BigDecimal unitPrice;
	private final int unitsInStock;
	private final Date dateCreated;
	
}
