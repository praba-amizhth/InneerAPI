package com.amizhth.inneer.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.inneer.dao.AuthDao;
import com.amizhth.inneer.dto.AuthDTO;
import com.amizhth.inneer.jwt.JwtTokenUtil;
import com.amizhth.inneer.model.AuthModel;

@Service
@Transactional
public class AuthService {

	@Autowired
	private AuthDao authDao;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;


	public AuthDTO login(AuthDTO authDTO) {
		AuthModel authModel = authDao.findByUsernameAndPassword(authDTO.getUserName(), authDTO.getPassword());
		AuthDTO retAuthDTO = null;
		if (authModel != null) {
			try {
				authenticate(authModel.getUsername(),authModel.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			retAuthDTO = AuthDTO.builder().status(1).token(jwtTokenUtil.generateToken(authModel.getUsername()))
					.id(authModel.getId()).build();
		} else {
			retAuthDTO = AuthDTO.builder().status(-1).build();
		}
		return retAuthDTO;
	}

	public AuthDTO forgotPassword(AuthDTO authDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public AuthDTO confirmOTP(AuthDTO authDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		catch (Exception e)
		{
			throw new Exception("Exception occured in authenticateee method"+e.getMessage());
		}
	}

}