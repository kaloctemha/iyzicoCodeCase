package com.iyzico.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iyzico.challenge.entity.CreateProductRequestBody;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			CreateProductRequestBody body = new CreateProductRequestBody();
			List<Product> list = new ArrayList<>();
			list.add(new Product("elma", "elma desc", new BigDecimal(4.95D), 20));
			list.add(new Product("armut", "armut desc", new BigDecimal(7.95D), 20));
			list.add(new Product("kiraz", "kiraz desc", new BigDecimal(11.95D), 20));
			list.add(new Product("avokado", "avokado desc", new BigDecimal(21.95D), 20));
			list.add(new Product("kavun", "kavun desc", new BigDecimal(2.95D), 20));
			list.add(new Product("karpuz", "karpuz desc", new BigDecimal(1.95D), 20));
			list.add(new Product("sirke", "sirke desc", new BigDecimal(8.95D), 20));
			list.add(new Product("pirinc", "piring desc", new BigDecimal(3.95D), 20));
			list.add(new Product("kepcap", "kepcap desc", new BigDecimal(6.95D), 20));
			list.add(new Product("macun", "macun desc", new BigDecimal(16.95D), 20));
			body.setProductList(list);
			productService.addProduct(body);
//            productService.addProduct(new Product("elma","elma desc",new BigDecimal(4.95D),20));
//            productService.addProduct(new Product("armut","armut desc",new BigDecimal(7.95D),20));
//            productService.addProduct(new Product("kiraz","kiraz desc",new BigDecimal(11.95D),20));
//            productService.addProduct(new Product("avokado","avokado desc",new BigDecimal(21.95D),20));
//            productService.addProduct(new Product("kavun","kavun desc",new BigDecimal(2.95D),20));
//            productService.addProduct(new Product("karpuz","karpuz desc",new BigDecimal(1.95D),20));
//            productService.addProduct(new Product("sirke","sirke desc",new BigDecimal(8.95D),20));
//            productService.addProduct(new Product("pirinc","piring desc",new BigDecimal(3.95D),20));
//            productService.addProduct(new Product("kepcap","kepcap desc",new BigDecimal(6.95D),20));
//            productService.addProduct(new Product("macun","macun desc",new BigDecimal(16.95D),20));

		};
	}
}