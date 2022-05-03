package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.OrderModel;

@Repository
public interface OrderDao extends JpaRepository<OrderModel, Integer> ,JpaSpecificationExecutor<OrderModel>{

}