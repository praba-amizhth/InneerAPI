package com.amizhth.inneer.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthUser extends  User{

	public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, String firstname, String entityname,  int entityid,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.firstname = firstname;
		this.entityname = entityname;
		this.entityid = entityid;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	
	private String entityname;
	
	private int entityid;

	public String getFirstname() {
		return firstname;
	}

	public String getEntityname() {
		return entityname;
	}

	public int getEntityid() {
		return entityid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public void setEntityid(int entityid) {
		this.entityid = entityid;
	}

	
}
