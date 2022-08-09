package pc01815.Normal_J6.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Services.CategoryService;

@RestController
@RequestMapping("api")
@Validated
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping(value = "/categories", consumes = "application/json")
	public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category category){
		if(categoryService.checkCategoryName(category.getName())> 0) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}else {
			return new ResponseEntity<Category>(categoryService.saveCategoryService(category),HttpStatus.CREATED);
		}
	}
	
	@PutMapping(value = "/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category){
			Optional<Category> categoryOption = categoryService.findByIdCategory(id);
			return (ResponseEntity<Category>) categoryOption.map(c -> {
				category.setId(c.getId());
				return new ResponseEntity<>(categoryService.saveCategoryService(category),HttpStatus.OK);
			}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(value = "/categories")
	public ResponseEntity<List<Category>> findAllCategory(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("entry") Optional<Integer> entry,
			@RequestParam("sortBy") Optional<String> sortBy
			){
//		return new ResponseEntity<List<Category>>(categoryService.findAllCategoryService(page,sortBy, entry).stream().collect(Collectors.toList()),HttpStatus.OK);
		return new ResponseEntity<List<Category>>(categoryService.findAllCategoryService().stream().collect(Collectors.toList()),HttpStatus.OK);
	}
	
	
	@GetMapping("/categories/{categoryName}")
	public ResponseEntity<List<Category>> findCategoryByName(@PathVariable("categoryName") String categoryName) {
		List<Category> list = categoryService.findCategoryByNameService("%" + categoryName + "%");
		if(list.isEmpty()) {
			return new ResponseEntity<List<Category>>(list,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
		}	
	}
	
	@DeleteMapping("/categories/{idCategory}")
	public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("idCategory") int id){
		
		if(categoryService.checkProductExitInCategory(id) > 0) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_GATEWAY);
		}else {
			categoryService.deleteCategoryById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		
		
	}
}
