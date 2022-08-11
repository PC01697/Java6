package pc01815.Normal_J6.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pc01815.Normal_J6.Entity.Products;

public interface ProductsService {

	Products saveProductsService(Products products);
	
//	Page<Products> findAllCProductsService(Optional<Integer> page, Optional<String> sortBy, Optional<Integer> entry);
	List<Products> findAllProductService();
	
	List<Products> findProductsByNameService(String productName);
	
	void deleteProductsById(int id);
	
	Products findById(Integer id);
	
	Optional<Products> findByIdProducts(int id);
}
