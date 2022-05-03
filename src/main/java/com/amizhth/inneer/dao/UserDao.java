package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer>, JpaSpecificationExecutor<UserModel> {


}