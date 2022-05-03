package com.amizhth.inneer.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amizhth.common.ReturnStatus;
import com.amizhth.common.UtilConstants;
import com.amizhth.inneer.dao.OrderDao;
import com.amizhth.inneer.dto.OrderDTO;
import com.amizhth.inneer.model.OrderModel;

@Service
@Transactional
public class OrderService implements UtilConstants {

	@Autowired
	private OrderDao orderDao;

	public ReturnStatus placeOrder(OrderDTO orderDTO) {
		ReturnStatus retStatus = null;
		OrderModel orderModel = OrderModel.builder().id(orderDTO.getId()).emptycancount(orderDTO.getEmptyCanCount())
				.paidamt(orderDTO.getPaidAmt()).paidfg(orderDTO.getPaidFg()).quantity(orderDTO.getQuantity())
				.submittedtimeval(LocalDate.now().toEpochDay()).totalprice(orderDTO.getTotalPrice())
				.unitprice(orderDTO.getUnitPrice()).userid(orderDTO.getUserid()).vendorid(orderDTO.getVendorid())
				.watercanid(orderDTO.getWatercanId()).build();
		orderDao.save(orderModel);
		retStatus = ReturnStatus.builder().status(STATUS_SUCCESS).build();
		return retStatus;
	}

	public List<OrderDTO> list() {
		List<OrderDTO> orderDTOs = null;
		List<OrderModel> orderModels = orderDao.findAll();
		if (orderModels != null) {
			orderDTOs = orderModels.stream().map(model -> constructOrderDTO(model)).collect(Collectors.toList());
		} else {
			orderDTOs = new ArrayList<OrderDTO>();
		}
		return orderDTOs;
	}

	private OrderDTO constructOrderDTO(OrderModel orderModel) {
		return OrderDTO.builder().id(orderModel.getId()).emptyCanCount(orderModel.getEmptycancount())
				.paidAmt(orderModel.getPaidamt()).paidFg(orderModel.getPaidfg()).quantity(orderModel.getQuantity())
				.status(orderModel.getStatus()).totalPrice(orderModel.getTotalprice())
				.unitPrice(orderModel.getUnitprice()).userid(orderModel.getUserid()).vendorid(orderModel.getVendorid())
				.watercanId(orderModel.getWatercanid()).build();
	}

	public OrderDTO get(int id) {
		return constructOrderDTO(orderDao.getOne(id));
	}

}