package pc01815.Normal_J6.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Services.ProductsService;
import pc01815.Normal_J6.Util.FileUploadUtil;

@RestController
@RequestMapping("api")
public class ProductsRestController {

	@Autowired
	ProductsService productsService;
	
	@Autowired
	ServletContext app;
	
	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<List<Products>> findAllCategory(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("entry") Optional<Integer> entry,
			@RequestParam("sortBy") Optional<String> sortBy
			){
		return new ResponseEntity<List<Products>>(productsService.findAllCProductsService(page,sortBy, entry).stream().collect(Collectors.toList()),HttpStatus.OK);
	}
	
	@GetMapping("/products/{productsName}")
	public ResponseEntity<List<Products>> findProductsByName(@PathVariable("productsName") String productsName){
		List<Products> list = productsService.findProductsByNameService("%" + productsName + "%");
		if(list.isEmpty()) {
			return new ResponseEntity<List<Products>>(list,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Products>>(list,HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<Products> saveCategory(@RequestBody Products products){
		return new ResponseEntity<Products>(productsService.saveProductsService(products),HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/test")
	public String test(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		FileUploadUtil test = new FileUploadUtil();
		test.saveFile(file, app);
		
		return "ok";
	}
	
	
	@DeleteMapping("/products/{idProducts}")
	public ResponseEntity<HttpStatus> deleteProductsById(@PathVariable("idProducts") int id){
		productsService.deleteProductsById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
//	@PutMapping(value = "/products/{id}", consumes = "application/json")
//	public ResponseEntity<Products> updateProducts(@PathVariable("id") int id,@RequestBody Products products){
//		Optional<Products> productsOption = productsService.findByIdProducts(id);
//		return (ResponseEntity<Products>) productsOption.map(p -> {
//			products.setId(p.getId());
////			products.setName(p.getName());
////			products.setUnitPrice(p.getUnitPrice());
//			products.setImage(p.getImage());
//			products.setProductDate(p.getProductDate());
//			products.setAvaible(p.isAvaible());
//			products.setCategory(p.getCategory());
//			products.setQuantity(p.getQuantity());
//			products.setDescription(p.getDescription());
//			products.setDiscount(p.getDiscount());
//			products.setViewCount(p.getViewCount());
//			products.setSpecial(p.isSpecial());
//			return new ResponseEntity<>(productsService.saveProductsService(products),HttpStatus.OK);
//		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
	
	
}
