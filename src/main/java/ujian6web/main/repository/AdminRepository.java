package ujian6web.main.repository;

import org.springframework.data.repository.CrudRepository;

import ujian6web.main.entity.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	public Admin findById(long id);
	public Admin findByUsername(String username);

}