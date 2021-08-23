package com.iyzico.challenge.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OrderProduct {
	
	@Id
	private Long id;

	private Integer quantity;

	@JsonIgnore
	private BigDecimal price;
	

	@JsonIgnore
	private Long productID;



	public OrderProduct() {
		super();
	}

	@JsonCreator
	public OrderProduct(@JsonProperty("productID") Long productID,
						@JsonProperty("quantity") Integer quantity) {
		super();
		this.id = productID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}


}
