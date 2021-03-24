package com.dagtech.angularspringecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.dagtech.angularspringecommerce.dao.OrderItemRepository;
import com.dagtech.angularspringecommerce.dao.OrderRepository;
import com.dagtech.angularspringecommerce.dao.ProductCategoryRepository;
import com.dagtech.angularspringecommerce.dao.ProductRepository;
import com.dagtech.angularspringecommerce.entity.Order;
import com.dagtech.angularspringecommerce.entity.OrderItem;
import com.dagtech.angularspringecommerce.entity.Product;
import com.dagtech.angularspringecommerce.entity.ProductCategory;

@SpringBootTest
class AngularSpringEcommerceApplicationTests {
	
	@Autowired
	OrderItemRepository oiRepository;
	
	@Autowired
	OrderRepository oRepository;
	
	@Autowired
	ProductRepository pRepository;
	
	@Autowired
	ProductCategoryRepository pcRepository;

    /*
	@Test
	public void testAddItemOrder() {
		
		Order order = new Order();
		order.setOrderTrackingNumber("11-22-00");
		order.setTotalQuantity(18);
		order.setTotalPrice(BigDecimal.valueOf(4140.00));
		
		OrderItem item = new OrderItem();
		OrderItem item1 = new OrderItem();
		OrderItem item2 = new OrderItem();
		
		item.setImageUrl(
				"assets/images/products/accesories/logitech-keyboard-pc-01.png");
		item.setProductId(3L);
		item.setQuantity(5);
		item.setUnitPrice(BigDecimal.valueOf(15.00));
		
		item1.setImageUrl(
				"assets/images/products/accesories/logitech-mouse-pc-01.png");
		item1.setProductId(4L);
		item1.setQuantity(10);
		item1.setUnitPrice(BigDecimal.valueOf(13.00));
		
		item2.setImageUrl(
				"assets/images/products/components/nvidia-graphic-card-01.png");
		item2.setProductId(5L);
		item2.setQuantity(3);
		item2.setUnitPrice(BigDecimal.valueOf(500.00));
		
		order.addItems(item);
		order.addItems(item1);
		order.addItems(item2);
		
		oRepository.save(order);
	} 
	
	
	@Test
	public void testUpdateStockPtroduct() {
		
		 List<OrderItem> prod = oiRepository.findByOrderId(6L);
		 
		 int length = oiRepository.findTotalItems(6L);
		 
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
	}
	
	@Test
	public void testInsertProduct() {
		
		ProductCategory pCategory = new ProductCategory();
		Long id = pcRepository.findByCategoryName("Printers").get(0).getId();
		pCategory.setId(id);;
		
		Product prod = new Product();
		
		prod.setSku("PRINTER-03");
		prod.setBrand("Epson");
		prod.setUnitPrice(BigDecimal.valueOf(80.00));
		prod.setUnitsInStock(20);
		
		pCategory.addProducts(prod);
		
		pcRepository.save(pCategory);
	}
	*/
	
}
