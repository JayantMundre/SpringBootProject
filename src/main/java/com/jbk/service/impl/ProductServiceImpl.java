package com.jbk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao dao;

	
	@Override
	public int saveProduct(Product product) 
	{
		
		return dao.addProduct(product);
	}
	

	@Override
	public Object deleteProduct(long productId) 
	{
		return dao.deleteProduct(productId);
	}


	@Override

	public Product getProductById(long productId) 
	{
		
		return dao.getProductById(productId);

	}


	@Override
	public List<Product> getAllProduct()
	{
		return dao.getAllProduct();
	}


	@Override
	public Product updateProduct(Product product) 
	{
		
		return dao.updateProduct(product);

	}

}
