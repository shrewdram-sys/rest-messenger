package src.main.java.com.demo.food.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.demo.food.delivery.model.Order;
import src.main.java.com.demo.food.delivery.model.OrderStatusUpdateMessage;
import src.main.java.com.demo.food.delivery.service.OrderService;

@RestController
public class FoodOrderController {

	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public Order getOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}
	

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public Order getByOrderId(@PathVariable("orderId") int orderId) {
        return orderService.getByOrderId(orderId);
    }
    
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.PUT)
    public void updateOrderStatus(@PathVariable("orderId") int orderId,
    		@RequestBody OrderStatusUpdateMessage orderStatusUpdateMessage) {
    	this.orderService.updateOrderStatus(orderId, orderStatusUpdateMessage);
    }
    
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Order>> findOrderById(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(orderService.getUserId(userId));
    }

    
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean cancelOrder(@PathVariable("userId") String userId) {
        return orderService.deleteOrder(userId);
    }

}
