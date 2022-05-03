package com.amizhth.inneer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amizhth.inneer.dao.AuthDao;
import com.amizhth.inneer.model.AuthModel;
import com.amizhth.inneer.util.AuthUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	AuthDao adminAuthDao;

	private String username;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthModel authModel = new AuthModel();
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		try {
			Object obj = adminAuthDao.findByUsernameEqualsAndStatusEquals(username, 1);

			if (obj instanceof AuthModel) {
				authModel = (AuthModel) obj;
				return new AuthUser(authModel.getUsername(), authModel.getPassword(), true, true, true, true,
						authModel.getFirstname(), authModel.getEntityname(), authModel.getEntityid(),
						grantedAuthorities);
			} else
				throw new UsernameNotFoundException("User not found with username: " + username);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new User(authModel.getUsername(), authModel.getPassword(), grantedAuthorities);
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}