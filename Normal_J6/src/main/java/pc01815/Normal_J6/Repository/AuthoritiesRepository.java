package pc01815.Normal_J6.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer>{


	@Query(value = "SELECT * FROM authorities WHERE idAccounts=:id",nativeQuery = true)
	Authorities findByIdAcc(@Param("id")int id);
	
//	@Query(value = "DELETE FROM authorities WHERE idAccounts=:id",nativeQuery = true)
//	Authorities deleteByIdAcc(@Param("id")int id);
//	@Query("SELECT DISTINCT a FROM Authorities a WHERE a.account IN ?1 ")
//	List<Authorities> authoritiesOf(List<Accounts>accounts );
}
