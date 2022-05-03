package com.amizhth.inneer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.common.ReturnStatus;
import com.amizhth.common.UtilConstants;
import com.amizhth.inneer.dao.VendorDao;
import com.amizhth.inneer.dto.VendorDTO;
import com.amizhth.inneer.model.VendorModel;

@Service
@Transactional
public class VendorService implements UtilConstants {

	@Autowired
	private VendorDao vendorDao;

	public ReturnStatus save(VendorDTO vendorDTO) {
		ReturnStatus retStatus = null;
		VendorModel vendorModel = VendorModel.builder().id(vendorDTO.getId()).emailid(vendorDTO.getEmailId())
				.emptycanscount(0).filename(vendorDTO.getFileName()).phonenumber(vendorDTO.getPhonenumber())
				.vendorname(vendorDTO.getVendorName()).build();
		vendorDao.save(vendorModel);
		retStatus = ReturnStatus.builder().status(STATUS_SUCCESS).build();
		return retStatus;
	}
}