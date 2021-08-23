package com.iyzico.challenge.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CreateProductRequestBody {
	private List<Product> productList;

	public CreateProductRequestBody() {
		// TODO Auto-generated constructor stub
	}

	@JsonCreator
	public CreateProductRequestBody(@JsonProperty("products") List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
