package com.dagtech.angularspringecommerce.dto;

import java.util.Set;

import com.dagtech.angularspringecommerce.entity.Product;

import lombok.Data;

@Data
public class ProductRequest {
	 
	private Set<Product> products;
	
}
