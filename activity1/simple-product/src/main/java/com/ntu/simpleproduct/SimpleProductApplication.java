package com.ntu.simpleproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProductApplication.class, args);
	}

	@GetMapping("/products")
	public String product() {
		return "This is the Product Page";
	}

	@GetMapping("/products/{productId}")
	public String getProduct(@PathVariable int productId) {
		return switch (productId) {
			case 1 -> "This is the detail for ID " + productId + ": Apple";
			case 2 -> "This is the detail for ID " + productId + ": Banana";
			case 3 -> "This is the detail for ID " + productId + ": Carrot";
			default -> "No product found";
		};
	}

}
