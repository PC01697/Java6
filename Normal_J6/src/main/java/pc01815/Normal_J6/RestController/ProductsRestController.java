package pc01815.Normal_J6.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pc01815.Normal_J6.Entity.Products;
import pc01815.Normal_J6.Services.ProductsService;
import pc01815.Normal_J6.Util.FileUploadUtil;

@RestController
@RequestMapping("api")
@Validated
public class ProductsRestController {

	@Autowired
	ProductsService productsService;
	
	@Autowired
	ServletContext app;
	
//	@GetMapping(value = "/products", produces = "application/json")
//	public ResponseEntity<List<Products>> findAllCategory(
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("entry") Optional<Integer> entry,
//			@RequestParam("sortBy") Optional<String> sortBy
//			){
//		return new ResponseEntity<List<Products>>(productsService.findAllCProductsService(page,sortBy, entry).stream().collect(Collectors.toList()),HttpStatus.OK);
//	}
	
	
	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<List<Products>> findAllCategory(){
		return new ResponseEntity<List<Products>>(productsService.findAllProductService().stream().collect(Collectors.toList()),HttpStatus.OK);
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
	
//	@PostMapping(value = "/products", consumes = "multipart/form-data")
//	public ResponseEntity<Products> saveCategory(@RequestParam(value = "fileProduct") MultipartFile file,@RequestBody Products products) throws IllegalStateException, IOException{
//		FileUploadUtil fileUtil = new FileUploadUtil();
//		fileUtil.saveFile(file, app);
////		return new ResponseEntity<Products>(productsService.saveProductsService(products),HttpStatus.CREATED);
//		return new ResponseEntity<Products>(products,HttpStatus.CREATED);
//	}

	
	@PostMapping(value = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Products> saveCategory(@RequestPart(value = "fileProduct") MultipartFile file,@RequestPart(value = "product") @Valid Products products) throws IllegalStateException, IOException{
//		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		FileUploadUtil fileUtil = new FileUploadUtil();
		fileUtil.saveFile(file, app);
		products.setImage(fileUtil.getGetFileNameForEntity());
		System.err.println(products.getClass().getTypeName());
//		productsService.saveProductsService(products);
		return new ResponseEntity<Products>(productsService.saveProductsService(products),HttpStatus.CREATED);
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
