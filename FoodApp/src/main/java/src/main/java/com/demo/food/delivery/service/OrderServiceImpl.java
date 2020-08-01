package src.main.java.com.demo.food.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.demo.food.delivery.model.Order;
import src.main.java.com.demo.food.delivery.model.OrderStatusUpdateMessage;
import src.main.java.com.demo.food.delivery.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getUserId(String userId) {
		return orderRepository.findByUserId(userId);
	}
	
	@Override
	public Order placeOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getByOrderId(int orderId) {
		return orderRepository.findById(orderId);
	}
	

	@Override
	public void updateOrderStatus(int orderId, OrderStatusUpdateMessage message) {
		Order order =orderRepository.findById(orderId);
		String newStatus = message.getOrderStatus();
		order.setOrderStatus(newStatus);
        orderRepository.save(order);
	}

	@Override
	public boolean deleteOrder(String orderId) {
		return orderRepository.deleteById(orderId);
	}	

}
