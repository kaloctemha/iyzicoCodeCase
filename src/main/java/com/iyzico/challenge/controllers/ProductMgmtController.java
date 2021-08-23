package com.iyzico.challenge.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.entity.CreateProductRequestBody;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.entity.UpdateProductRequestBody;
import com.iyzico.challenge.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductMgmtController {

	@Autowired
	public ProductService productSvc;

	@PostMapping("/add")
	private ResponseEntity addProduct(@RequestBody CreateProductRequestBody newProducts) {
		return productSvc.addProduct(newProducts);
	}

	@DeleteMapping("/remove/{id}")
	private ResponseEntity deleteProduct(@PathVariable Long id) {
		return productSvc.removeProduct(id);

	}

	@GetMapping("retrieve/{id}")
	private ResponseEntity<Product> retrieveProductById(@PathVariable Long id) {
		return new ResponseEntity<Product>(productSvc.getProduct(id), HttpStatus.OK);
	}

	@GetMapping("retrieve/all")
	private ResponseEntity<List<Product>> retrieveAllProducts() {
		return new ResponseEntity<List<Product>>(productSvc.listProducts(), HttpStatus.OK);

	}

	@PutMapping("update/{id}")
	private ResponseEntity updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestBody productBody) {
		return productSvc.updateProduct(id, productBody);
	}

}
