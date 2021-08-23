package com.iyzico.challenge.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iyzico.challenge.entity.CreateOrderRequestBody;
import com.iyzico.challenge.entity.Order;
import com.iyzico.challenge.entity.OrderProduct;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.exception.InsufficientStockException;

@Service
public class OrderService {

//	@Autowired
//	OrderRepository orderRepo;

	@Autowired
	ProductService productSvc;
	
	@Autowired
	IyzicoPaymentService paymentSvc;

	@Transactional
	public ResponseEntity create(CreateOrderRequestBody order) {

		List<OrderProduct> orderProducts = order.getOrderProductList();
		Order newOrder = new Order();
		BigDecimal sum = BigDecimal.ZERO;
		for (OrderProduct orderProduct : orderProducts) {
			Product product = productSvc.getProduct(orderProduct.getProductID());
			orderProduct.setPrice(product.getProductPrice());
			int stock = product.getRemainingStock();
			if (stock < orderProduct.getQuantity()) {
				throw new InsufficientStockException("Stock of " + orderProduct.getQuantity() + " is not available");
			}
			newOrder.getOrderProducts().add(orderProduct);
			sum = sum.add(orderProduct.getTotalPrice());
			productSvc.updateProductStock(product, orderProduct.getQuantity());
		}
		
		paymentSvc.pay(sum);
		//orderRepo.save(newOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body("Order Created");
	}

}
