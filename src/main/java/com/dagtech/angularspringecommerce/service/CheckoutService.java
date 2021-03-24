package com.dagtech.angularspringecommerce.service;

import com.dagtech.angularspringecommerce.dto.Purchase;
import com.dagtech.angularspringecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
