package com.dagtech.angularspringecommerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dagtech.angularspringecommerce.dto.Purchase;
import com.dagtech.angularspringecommerce.dto.PurchaseResponse;
import com.dagtech.angularspringecommerce.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService cService;
	
	public CheckoutController(CheckoutService cService) {
		
		this.cService = cService;
	}
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = cService.placeOrder(purchase);
		
		return purchaseResponse;
	}

}
