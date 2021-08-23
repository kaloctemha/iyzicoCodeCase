package com.iyzico.challenge.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProductRequestBody {
	
	private Product newProduct;
	
	public UpdateProductRequestBody() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonCreator
	public UpdateProductRequestBody(@JsonProperty("product") Product p) {
		this.newProduct = p;
	}

	public Product getNewProduct() {
		return newProduct;
	}

	public void setNewProduct(Product p) {
		this.newProduct = p;
	}

	
}
