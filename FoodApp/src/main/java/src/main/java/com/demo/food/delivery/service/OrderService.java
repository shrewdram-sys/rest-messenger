package src.main.java.com.demo.food.delivery.service;

import java.util.List;

import src.main.java.com.demo.food.delivery.model.Order;
import src.main.java.com.demo.food.delivery.model.OrderStatusUpdateMessage;

public interface OrderService {

	Order placeOrder(Order order);
	
	Order getByOrderId(int orderId);

	List<Order> getUserId(String userId);
	
    void updateOrderStatus(int orderId, OrderStatusUpdateMessage orderStatusUpdateMessage);
    
    boolean deleteOrder(String orderId);

}
