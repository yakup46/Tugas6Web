package ujian6web.main.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ujian6web.main.entity.Admin;


public class CustomUserDetail implements UserDetails {
	 
    private Admin user;
     
    public CustomUserDetail(Admin user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

    	final List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    	
    	switch (this.user.getRole()) {
    	case "admin":
    		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    		break;
    	case "user":
    		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    		break;
    	}
    	
    	return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return user.getUsername();
    }
 
}