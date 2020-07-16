package com.order.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.order.dao.ProductDao;
import com.order.entity.Product;
import com.order.exception.ProductException;

@Service
@Repository
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional(rollbackOn=Exception.class,value=TxType.REQUIRES_NEW)
	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product fetchProduct(String productCode) {
		Optional<Product> optional = productDao.findById(productCode);
		if(!optional.isPresent()){
			throw new ProductException("O1234", "No Product Found");
		}
		return optional.get();
	}

}
