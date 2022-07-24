package pc01815.Normal_J6.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Services.CategoryService;
import pc01815.Normal_J6.Util.ApplicationExceptionHandler;

@RestController
@RequestMapping("api")
@Validated
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.saveCategoryService(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAllCategory")
	public List<Category> findAll(){
		return categoryService.findAllCategoryService().stream().collect(Collectors.toList());
	}
	
	
	@PostMapping("/findCategoryByName")
	public List<Category> findCategoryByName(@RequestParam(name = "categoryName") @NotEmpty(message = "Không được để trống category") String categoryName) {
		return categoryService.findCategoryByNameService("%" + categoryName + "%"); 
		
		
	}
}
