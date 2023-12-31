package pc01815.Normal_J6.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;



import pc01815.Normal_J6.Entity.Orders;
import pc01815.Normal_J6.Services.OrderService;


@RestController
@RequestMapping("/api/orders")
@Validated
public class OrderRestController {
	@Autowired
	OrderService orderService; 
	
	
	@PostMapping()
	public Orders create(@RequestBody JsonNode orderData ) {
		return orderService.create(orderData);
	}
}
