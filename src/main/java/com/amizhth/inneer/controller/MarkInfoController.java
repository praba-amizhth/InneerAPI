
package com.amizhth.inneer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amizhth.inneer.dto.BannerDTO;
import com.amizhth.inneer.dto.QuotesDTO;
import com.amizhth.inneer.service.MarkInfoService;

@RestController
@RequestMapping(value = "/inneer")
public class MarkInfoController {

	@Autowired
	private MarkInfoService markInfoService;

	@GetMapping
	public ResponseEntity<?> getBanners() {
		List<BannerDTO> bannerDTOList = markInfoService.getBanners();
		return ResponseEntity.ok().body(bannerDTOList);
	}

	@GetMapping
	public ResponseEntity<?> getQuotes() {
		List<QuotesDTO> quoteDTOList = markInfoService.getQuotes();
		return ResponseEntity.ok().body(quoteDTOList);
	}

}
