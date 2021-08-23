package com.iyzico.challenge.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrderRequestBody {
	
	private List<OrderProduct> orderProductList;
	
	public CreateOrderRequestBody() {
		// TODO Auto-generated constructor stub
	}
	
	
	@JsonCreator
	public CreateOrderRequestBody(@JsonProperty("orderProducts") List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}


	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}


	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	

}
