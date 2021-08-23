package com.iyzico.challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.entity.CreateOrderRequestBody;
import com.iyzico.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderSvc;

	@PostMapping("/create")
	public ResponseEntity create(@RequestBody CreateOrderRequestBody order) {
		return orderSvc.create(order);
	}
}
