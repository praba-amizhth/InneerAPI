package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.WaterCanModel;

@Repository
public interface WaterCanDao extends JpaRepository<WaterCanModel, Integer> ,JpaSpecificationExecutor<WaterCanModel>{

	Object findByVendoridAndBrandnameIgnoreCase(int vendorId, String brandName);

	Object findByIdNotAndVendoridAndBrandnameIgnoreCase(int id, int vendorId, String brandName);


}