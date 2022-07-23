package pc01815.Normal_J6.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Services.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.saveCategoryService(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAllCategory")
	public List<Category> findAll(){
		return categoryService.findAllCategoryService().stream().collect(Collectors.toList());
	}
	
	
	@PostMapping("/findCategoryByName/{name}")
	public List<Category> findCategoryByName(@PathVariable("name") String name) {
		return categoryService.findCategoryByNameService("%" + name + "%"); 
	}
}
