package pc01815.Normal_J6.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Services.ProductsService;

@RestController
@RequestMapping("api")
public class ProductsController {

	@Autowired
	ProductsService productsService;
	
	@GetMapping(value = "/products", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Products>> findAllCategory(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("entry") Optional<Integer> entry,
			@RequestParam("sortBy") Optional<String> sortBy
			){
		return new ResponseEntity<List<Products>>(productsService.findAllCProductsService(page,sortBy, entry).stream().collect(Collectors.toList()),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/products")
	public ResponseEntity<Products> saveCategory(@RequestBody Products products){
		return new ResponseEntity<Products>(productsService.saveProductsService(products),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/products/{idProducts}")
	public ResponseEntity<HttpStatus> deleteProductsById(@PathVariable("idProducts") int id){
		productsService.deleteProductsById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
