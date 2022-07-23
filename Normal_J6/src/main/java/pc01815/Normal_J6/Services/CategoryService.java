package pc01815.Normal_J6.Services;

import java.util.List;

import pc01815.Normal_J6.Entity.Category;

public interface CategoryService {
	
	Category saveCategoryService(Category category);
	
	List<Category> findAllCategoryService();
	
	List<Category> findCategoryByNameService(String categoryName);
}
