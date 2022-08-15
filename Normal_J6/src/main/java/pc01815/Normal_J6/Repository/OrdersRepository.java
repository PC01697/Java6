package pc01815.Normal_J6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pc01815.Normal_J6.Entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	@Query("select o from Orders o where o.accounts.username=?1")
	List<Orders> findByUsername(String username);
}
