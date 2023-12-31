package pc01815.Normal_J6.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Category;
import pc01815.Normal_J6.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category saveCategoryService(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findCategoryByNameService(String categoryName) {
		return categoryRepository.findCategoryByName(categoryName);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Optional<Category> findByIdCategory(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findAllCategoryService() {
		List<Category> list = categoryRepository.findAll();
		return list;
	}

	@Override
	public int checkCategoryName(String name) {
		return categoryRepository.IsExitCategory(name);
	}

	@Override
	public int checkProductExitInCategory(int id) {
		return categoryRepository.checkProductExitInCategory(id);
	}

	
	
	
//	@Override
//	public Page<Category> findAllCategoryService(Optional<Integer> page, Optional<String> sortBy, Optional<Integer> entry) {
//		Page<Category> test = categoryRepository.findAll(
//						PageRequest.of(page.orElse(0), entry.orElse(3), Sort.Direction.ASC, sortBy.orElse("name"))
//				);
//		System.err.println(test.getSize());
//		System.err.println(test.getTotalPages());
//		return test;
//	}

	


}
