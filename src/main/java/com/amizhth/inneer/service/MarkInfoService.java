package com.amizhth.inneer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.common.UtilConstants;
import com.amizhth.inneer.dao.BannerDao;
import com.amizhth.inneer.dao.QuotesDao;
import com.amizhth.inneer.dto.BannerDTO;
import com.amizhth.inneer.dto.QuotesDTO;
import com.amizhth.inneer.model.BannerModel;
import com.amizhth.inneer.model.QuotesModel;

@Service
@Transactional
public class MarkInfoService implements UtilConstants {

	@Autowired
	private BannerDao bannerDao;

	@Autowired
	private QuotesDao quotesDao;

	public List<BannerDTO> getBanners() {
		List<BannerModel> bannerModels = bannerDao.findAll();
		return bannerModels.stream().map(model -> constructBannerDTO(model)).collect(Collectors.toList());
	}

	public List<QuotesDTO> getQuotes() {
		List<QuotesModel> quoteModels = quotesDao.findAll();
		return quoteModels.stream().map(model -> constructQuotesDTO(model)).collect(Collectors.toList());
	}

	private BannerDTO constructBannerDTO(BannerModel bannerModel) {
		return BannerDTO.builder().id(bannerModel.getId()).filename(bannerModel.getFilename()).build();
	}

	private QuotesDTO constructQuotesDTO(QuotesModel quotesModel) {
		return QuotesDTO.builder().id(quotesModel.getId()).quote(quotesModel.getQuote()).build();
	}

}