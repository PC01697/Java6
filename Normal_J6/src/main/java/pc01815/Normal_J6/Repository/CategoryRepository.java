package pc01815.Normal_J6.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pc01815.Normal_J6.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Transactional
	@Query(value = "select * from category where name LIKE :name", nativeQuery = true)
	List<Category> findCategoryByName(@Param("name") String name);
	

	
	@Query(value = "select count(id) from category where name LIKE :name", nativeQuery = true)
	int IsExitCategory(@Param("name") String name);
	
	@Query(value = "SELECT COUNT(category.id)"
			+ "FROM category INNER JOIN products ON category.id = products.CategoryId WHERE category.id =:idCategory", nativeQuery = true)
	int checkProductExitInCategory(@Param("idCategory") int idCategory);
	
}
