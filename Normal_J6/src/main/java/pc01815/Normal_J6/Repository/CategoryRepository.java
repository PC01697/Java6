package pc01815.Normal_J6.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pc01815.Normal_J6.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Transactional
	@Query(value = "select * from category where name LIKE :name", nativeQuery = true)
	List<Category> findCategoryByName(@Param("name") String name);
	

	
}
