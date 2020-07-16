package com.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.Product;

public interface ProductDao extends JpaRepository<Product, String> {

}
