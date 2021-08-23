package com.iyzico.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iyzico.challenge.entity.CreateProductRequestBody;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.entity.UpdateProductRequestBody;
import com.iyzico.challenge.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public ResponseEntity addProduct(CreateProductRequestBody newProducts) {
		for (Product product : newProducts.getProductList()) {
			productRepo.save(product);
		}
		return ResponseEntity.status(HttpStatus.OK).body("Product Saved");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public ResponseEntity removeProduct(Long productID) {
		productRepo.deleteById(productID);
		return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public ResponseEntity updateProduct(Long id, UpdateProductRequestBody productBody) {
		Optional<Product> optProduct = productRepo.findById(id);
		Product product = null;
		Product newProduct = null;
		if (optProduct.isPresent()) {
			product = optProduct.get();
			newProduct = productBody.getNewProduct();
			product.setRemainingStock(newProduct.getRemainingStock());
			product.setProductPrice(newProduct.getProductPrice());
			product.setProductDescription(newProduct.getProductDescription());
			product.setProductName(newProduct.getProductName());
			productRepo.save(product);
			return ResponseEntity.status(HttpStatus.OK).body("Products Updated");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product cannot be found");
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public Product getProduct(Long id) {
		Optional<Product> optProduct = productRepo.findById(id);
		Product product = null;
		if (optProduct.isPresent()) {
			product = optProduct.get();
		}
		return product;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public List<Product> listProducts() {
		List<Product> products = (List<Product>) productRepo.findAll();
		return products;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void updateProductStock(Product product, int quantity) {
		product.setRemainingStock(product.getRemainingStock() - quantity);
		productRepo.save(product);
	}

}
