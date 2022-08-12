package pc01815.Normal_J6.Services;



import com.fasterxml.jackson.databind.JsonNode;

import pc01815.Normal_J6.Entity.Orders;

public interface OrderService {

	Orders create(JsonNode orderData);

	
}
