package com.amizhth.inneer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.common.ReturnStatus;
import com.amizhth.common.UtilConstants;
import com.amizhth.inneer.dao.WaterCanDao;
import com.amizhth.inneer.dto.WaterCanDTO;
import com.amizhth.inneer.model.WaterCanModel;

@Service
@Transactional
public class WaterService implements UtilConstants {

	@Autowired
	private WaterCanDao waterCanDao;

	public ReturnStatus save(WaterCanDTO waterCanDTO) {
		ReturnStatus retStatus = null;
		if ((waterCanDTO.getId() == 0 && waterCanDao.findByVendoridAndBrandnameIgnoreCase(waterCanDTO.getVendorId(),
				waterCanDTO.getBrandName()) != null)
				|| waterCanDao.findByIdNotAndVendoridAndBrandnameIgnoreCase(waterCanDTO.getId(),
						waterCanDTO.getVendorId(), waterCanDTO.getBrandName()) != null) {
			retStatus = ReturnStatus.builder().status(STATUS_DUPLICATE).build();
		} else {
			WaterCanModel masterCourseModel = WaterCanModel.builder().id(waterCanDTO.getId())
					.brandname(waterCanDTO.getBrandName()).capacity(waterCanDTO.getCapacity())
					.imgname(waterCanDTO.getImgName()).price(waterCanDTO.getPrice()).vendorid(waterCanDTO.getVendorId())
					.build();
			waterCanDao.save(masterCourseModel);
			retStatus = ReturnStatus.builder().status(STATUS_SUCCESS).build();
		}
		return retStatus;
	}

	public List<WaterCanDTO> list(int vendorid) {
		List<WaterCanDTO> waterCanDTOs = null;
		List<WaterCanModel> waterCanModels = waterCanDao.findAll();
		if (waterCanModels != null) {
			waterCanDTOs = waterCanModels.stream().map(model -> constructWatercanDTO(model))
					.collect(Collectors.toList());
		} else {
			waterCanDTOs = new ArrayList<WaterCanDTO>();
		}
		return waterCanDTOs;
	}

	private WaterCanDTO constructWatercanDTO(WaterCanModel waterCanModel) {
		return WaterCanDTO.builder().id(waterCanModel.getId()).brandName(waterCanModel.getBrandname())
				.capacity(waterCanModel.getCapacity()).imgName(waterCanModel.getImgname())
				.price(waterCanModel.getPrice()).vendorId(waterCanModel.getVendorid()).build();
	}

	public WaterCanDTO get(int id) {
		return constructWatercanDTO(waterCanDao.getOne(id));
	}

}