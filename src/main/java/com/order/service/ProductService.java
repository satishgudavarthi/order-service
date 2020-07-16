package com.order.service;

import com.order.entity.Product;

public interface ProductService {
	
public Product addProduct(Product product);
public Product fetchProduct(String productCode);

}

