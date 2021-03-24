package com.dagtech.angularspringecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dagtech.angularspringecommerce.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Query(value="select * from orders where order_tracking_number=:orderTrackingNumber", nativeQuery=true)
	List<Order> findByOTN(@Param("orderTrackingNumber") String orderTrackingNumber);


	
	
	


}
