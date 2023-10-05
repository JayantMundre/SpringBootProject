package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao {

	public int addProduct(Product product);
	public Product getProductById(long productId);
	public List<Product> getAllProduct();
	public Object deleteProduct(long productId);
	public Product updateProduct(Product product);
	
}
