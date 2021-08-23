package com.iyzico.challenge.service;

import com.iyzico.challenge.entity.Payment;
import com.iyzico.challenge.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class IyzicoPaymentService {

	private Logger logger = LoggerFactory.getLogger(IyzicoPaymentService.class);

	private BankService bankService;
	private PaymentRepository paymentRepository;

	public IyzicoPaymentService(BankService bankService, PaymentRepository paymentRepository) {
		this.bankService = bankService;
		this.paymentRepository = paymentRepository;
	}

	public void pay(BigDecimal price) {
		// pay with bank
		BankPaymentRequest request = new BankPaymentRequest();
		request.setPrice(price);

		CompletableFuture<BankPaymentResponse> completableFuture = CompletableFuture.supplyAsync(() -> {
			return bankService.pay(request);
		}).handle((s, t) -> s != null ? s : new BankPaymentResponse("abagannus"));

		BankPaymentResponse response = new BankPaymentResponse();
		try {
			response = completableFuture.get();
			// insert records
			Payment payment = new Payment();
			payment.setBankResponse(response.getResultCode());
			payment.setPrice(price);
			paymentRepository.save(payment);
			logger.info("Payment saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
