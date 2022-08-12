package pc01815.Normal_J6.Services;


import java.util.List;
import java.util.stream.Collectors;


//import org.objectweb.asm.TypeReference;
//import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.expression.spel.ast.TypeReference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import pc01815.Normal_J6.Entity.Orders;
import pc01815.Normal_J6.Entity.Orderdetails;
import pc01815.Normal_J6.Repository.OrderdetailsRepository;
import pc01815.Normal_J6.Repository.OrdersRepository;

public class OrderServiceImpl implements OrderService {
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	OrderdetailsRepository orderdetailsRepository;
	
	@Override
	public Orders create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Orders order = mapper.convertValue(orderData, Orders.class);
		ordersRepository.save(order);
		
		TypeReference<List<Orderdetails>> type = new TypeReference<List<Orderdetails>>() {};
		List<Orderdetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrders(order)).collect(Collectors.toList());
		orderdetailsRepository.saveAll(details);
		return order;
	}

}
