package com.inn.spring_security_jwt;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user-details")
public class User implements UserDetails {

	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@Enumerated(EnumType.ORDINAL)
	private Role role;

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return List.of(new SimpleGrantedAuthority(role.name()));
//	}
	
	 @Override
	  public String getPassword() {
	    return password;
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

	@Override
	public String getUsername() {
		return email;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
