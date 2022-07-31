package pc01815.Normal_J6.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pc01815.Normal_J6.Entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

	@Transactional
	@Query(value = "select * from products where Name LIKE :name", nativeQuery = true)
	List<Products> findProductByName(@Param("name") String productName);
}
