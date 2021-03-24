package com.dagtech.angularspringecommerce.dto;

import java.util.Set;

import com.dagtech.angularspringecommerce.entity.Order;
import com.dagtech.angularspringecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Order order;
	private Set<OrderItem> orderItems;

}
