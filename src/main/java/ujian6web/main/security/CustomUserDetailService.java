package ujian6web.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ujian6web.main.entity.Admin;
import ujian6web.main.repository.AdminRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private AdminRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin user = userRepo.findByUsername(username);		
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(user);
	}

}