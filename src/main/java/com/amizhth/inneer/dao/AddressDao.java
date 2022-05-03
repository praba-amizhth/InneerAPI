package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.AddressModel;

@Repository
public interface AddressDao extends JpaRepository<AddressModel, Integer>{

}