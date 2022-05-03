package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.VendorModel;

@Repository
public interface VendorDao extends JpaRepository<VendorModel, Integer>, JpaSpecificationExecutor<VendorModel> {

}