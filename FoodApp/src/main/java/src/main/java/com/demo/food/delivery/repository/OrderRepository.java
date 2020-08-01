package src.main.java.com.demo.food.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import src.main.java.com.demo.food.delivery.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Order findById(int orderId);
	
	boolean deleteById(String orderId);
	
	@Query("select o from Order o where o.userid=:userId")
	List<Order> findByUserId(String userId);
	
	
	
	

}
