package pc01815.Normal_J6.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pc01815.Normal_J6.Entity.Category;

public interface CategoryService {
	
	Category saveCategoryService(Category category);
	
//	Page<Category> findAllCategoryService(Optional<Integer> page, Optional<String> sortBy, Optional<Integer> entry);
	List<Category> findAllCategoryService();
	
	List<Category> findCategoryByNameService(String categoryName);
	
	void deleteCategoryById(int id);
	
	Optional<Category> findByIdCategory(int id);
}
