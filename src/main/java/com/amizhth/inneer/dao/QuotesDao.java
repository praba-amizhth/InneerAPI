package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.QuotesModel;

@Repository
public interface QuotesDao extends JpaRepository<QuotesModel, Integer>{
	

}