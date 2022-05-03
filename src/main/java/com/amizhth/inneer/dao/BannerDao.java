package com.amizhth.inneer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.inneer.model.BannerModel;

@Repository
public interface BannerDao extends JpaRepository<BannerModel, Integer> {

}