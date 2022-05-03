package com.amizhth.inneer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.inneer.dao.UserVendorDao;

@Service
@Transactional
public class DashboardService {

	@Autowired
	private UserVendorDao messageDao;

}