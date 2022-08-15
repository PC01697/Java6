package pc01815.Normal_J6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	AuthoritiesRepository authRepo;
	@Autowired
	AccountsRepository acRepo;

	@Override
	public Authorities authService(int id) {
		return authRepo.findByIdAcc(id);
	}

	@Override
	public void delete(Authorities au) {
		 authRepo.delete(au);
		
	}

	@Override
	public List<Authorities> findAllAuthoritiesService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authorities> getAdministrators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authorities> findAuthoritiesOfAdministrators() {
		List<Accounts>accounts= acRepo.getAdministrators();
		return authRepo.authoritiesOf(accounts);
	}
	

	
}
