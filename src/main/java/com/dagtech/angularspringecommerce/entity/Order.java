package com.dagtech.angularspringecommerce.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="order_tracking_number")
	private String orderTrackingNumber;
	
	@Column(name="total_price")
	private BigDecimal totalPrice;
	
	@Column(name="total_quantity")
	private int totalQuantity;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order")
	private Set<OrderItem> items;
	
	public void addItems(OrderItem item) {
		
		if (item != null) {
			
			if (items == null) {
				
				items = new HashSet<>();
			}
			
			item.setOrder(this);
			items.add(item);
		}
	}

}
