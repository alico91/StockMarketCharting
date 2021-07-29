package com.smca.Company.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smca.Company.Models.User1;
import com.smca.Company.Models.Userdetails1;
import com.smca.Company.Repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userrepo;
   
//	@Autowired
//	UserRepository2 userrepo2;	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
	       
        User1 user = new User1() ;
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
       
         
        return authorities;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User1 user = userrepo.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	//non dto code below	//return new org.springframework.security.core.userdetails.User(user.getname(), user.getpassword(),
			//	new ArrayList<>());
		return new Userdetails1(user);//you have to implement userdetails if you dont want to use dto
	}

// implement without dto	public com.stockexchange.phase3.User1 save(UserDto user) {
	
	public User1 signup(User1 user) {
		User1 newUser = new User1();
		
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    newUser.setEmail(user.getEmail());
		newUser.setRole(user.getRole());
		Boolean a = true;
		if(user.getRole()!="Admin") {
			a = false;
		}
		newUser.setAdmin(a);
		return userrepo.save(newUser);
	}
}
