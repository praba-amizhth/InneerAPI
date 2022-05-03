package com.amizhth.inneer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.common.ReturnStatus;
import com.amizhth.common.UtilConstants;
import com.amizhth.inneer.dao.UserDao;
import com.amizhth.inneer.dto.UserDTO;
import com.amizhth.inneer.model.UserModel;

@Service
@Transactional
public class UserService implements UtilConstants {

	@Autowired
	private UserDao userDao;

	public ReturnStatus save(UserDTO userDTO) {
		ReturnStatus retStatus = null;
		UserModel userModel = UserModel.builder().id(userDTO.getId()).emailid(userDTO.getEmailId())
				.phonenumber(userDTO.getPhonenumber()).username(userDTO.getUserName()).build();
		userDao.save(userModel);
		retStatus = ReturnStatus.builder().status(STATUS_SUCCESS).build();
		return retStatus;
	}

}