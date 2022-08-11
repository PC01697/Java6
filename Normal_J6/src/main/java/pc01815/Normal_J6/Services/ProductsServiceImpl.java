package pc01815.Normal_J6.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Repository.ProductsRepository;


@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public Products saveProductsService(Products products) {
		return productsRepository.save(products);
	}

//	@Override
//	public Page<Products> findAllCProductsService(Optional<Integer> page, Optional<String> sortBy,
//			Optional<Integer> entry) {
//		return productsRepository.findAll(
//				PageRequest.of(page.orElse(0), entry.orElse(3), Sort.Direction.ASC, sortBy.orElse("name"))
//		);
//	}
	
	


	@Override
	public List<Products> findProductsByNameService(String productName) {
		return productsRepository.findProductByName(productName);
	}

	@Override
	public void deleteProductsById(int id) {
		 productsRepository.deleteById(id);
	}
	@Override
	public Products findById(Integer id) {
		
		return  productsRepository.findById(id).get();
	}
	@Override
	public Optional<Products> findByIdProducts(int id) {
		return productsRepository.findById(id);
	}

	@Override
	public List<Products> findAllProductService() {
		return productsRepository.findAll();
	}

}
