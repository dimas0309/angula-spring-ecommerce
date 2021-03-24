package com.dagtech.angularspringecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.angularspringecommerce.dao.OrderItemRepository;
import com.dagtech.angularspringecommerce.dao.OrderRepository;
import com.dagtech.angularspringecommerce.dao.ProductRepository;
import com.dagtech.angularspringecommerce.dto.Purchase;
import com.dagtech.angularspringecommerce.dto.PurchaseResponse;
import com.dagtech.angularspringecommerce.entity.Order;
import com.dagtech.angularspringecommerce.entity.OrderItem;
import com.dagtech.angularspringecommerce.entity.Product;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private OrderRepository oRepository;
	private OrderItemRepository oiRepository;
	private ProductRepository pRepository;
	
	@Autowired
	public CheckoutServiceImpl(OrderRepository oRepository, 
			                   OrderItemRepository oiRepository,
			                   ProductRepository pRepository) {
		
		this.oRepository = oRepository;
		this.oiRepository = oiRepository;
		this.pRepository = pRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		Order order = purchase.getOrder();
		
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.addItems(item));
		
		oRepository.save(order);
		
		Long orderId = oRepository.findByOTN(orderTrackingNumber).get(0).getId();
		
		List<OrderItem> prod = oiRepository.findByOrderId(orderId);
		 
		 int length = oiRepository.findTotalItems(orderId);
		 
		 for (int i=0; i<length; i++) {
			 
			 Long id = prod.get(i).getProductId();
			 int iquan = prod.get(i).getQuantity();
			 
			 Optional<Product> resq = pRepository.findById(id);
			 Product product = resq.get();
			 
			 int pquan = product.getUnitsInStock();
			 
			 int stock = pquan-iquan;
			 
			 System.out.println(id + " " + iquan + " " + pquan + " " + stock);
			 
            product.setUnitsInStock(stock);
			 
			 pRepository.save(product);
		 }
		
		return new PurchaseResponse(orderTrackingNumber, orderId);
	}
	
	private String generateOrderTrackingNumber() {
		
		return UUID.randomUUID().toString();
	}

}
