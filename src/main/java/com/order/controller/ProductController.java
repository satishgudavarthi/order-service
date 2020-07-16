package com.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderResponse;
import com.order.entity.Product;
import com.order.exception.ProductException;
import com.order.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/orders")
	public ResponseEntity<OrderResponse> createOrder(
			@RequestBody @Valid Product product) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setResult(productService.addProduct(product));
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);

	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderResponse> fetchOrder(
			@PathVariable("id") String productCode) {
		Product product = productService.fetchProduct(productCode);
		OrderResponse orderResponse = new OrderResponse();
		if (product == null) {
			throw new ProductException("O1003", "Product Not Found");
		}
		orderResponse.setResult(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);

	}

}
