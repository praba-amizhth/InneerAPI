package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.AWSConfigModel;

@Repository
public interface AWSConfigDao extends JpaRepository<AWSConfigModel, Integer> {
}