package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.AuthModel;

@Repository
public interface AuthDao extends JpaRepository<AuthModel, Integer> {

	AuthModel findByUsernameAndPassword(String userName, String password);
	
	AuthModel findByUsernameEqualsAndStatusEquals(String username , int status );
	
	AuthModel findByUsernameEquals(String username );
	
	AuthModel findByStatusEquals(int status );

}