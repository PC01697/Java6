package pc01815.Normal_J6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	AuthoritiesRepository authRepo;

	@Override
	public Authorities authService(int id) {
		return authRepo.findByIdAcc(id);
	}

	@Override
	public void delete(Authorities au) {
		 authRepo.delete(au);
		
	}

	@Override
	public Authorities saveAuthoritiesService(Authorities authorities) {
		
		return authRepo.save(authorities);
	}

	
}
