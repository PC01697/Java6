package pc01815.Normal_J6.Services;



import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import pc01815.Normal_J6.Entity.Orders;

public interface OrderService {

	Orders create(JsonNode orderData);

	Orders findById(Integer id);

	List<Orders> findByUsername(String username);
	
}
