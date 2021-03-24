package com.dagtech.angularspringecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dagtech.angularspringecommerce.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	
	public List<OrderItem> findByOrderId(Long orderId);
	
	@Query(value="select count(product_id) from order_item where order_id=:orderId",
		   nativeQuery=true)
	public int findTotalItems(@Param("orderId") Long orderId);

}
