package com.smca.Company.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.smca.Company.Models.User1;

@Repository
public interface UserRepository extends JpaRepository<User1,Long> {

	public User1 findByUsername(String username);

	public User1 findByUsernameOrEmail(String username, String email);
	
}
