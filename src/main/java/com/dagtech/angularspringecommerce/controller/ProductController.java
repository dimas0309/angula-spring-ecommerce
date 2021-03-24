package com.dagtech.angularspringecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dagtech.angularspringecommerce.dao.ProductRepository;
import com.dagtech.angularspringecommerce.entity.Product;

@RestController
public class ProductController {
	
	
	private ProductRepository pRepository;

	
	@Autowired
	ProductController(ProductRepository pRepository){
		
		this.pRepository = pRepository;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public List<Product> showProducts(){
		
		return pRepository.findAll();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		
		return pRepository.save(product);
	}
	 
	
	

}
