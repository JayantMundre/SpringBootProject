package com.jbk.dao.impl;

import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Address;
import com.jbk.model.Category;
import com.jbk.model.Product;
import com.jbk.model.Supplier;

@Repository

public class ProductDaoImpl implements ProductDao {

	List<Product> list = new ArrayList<>();

	public ProductDaoImpl() {
		list.add(new Product(1l, "pen", 19.99d, 100, "This is a sample product description.",
				new java.sql.Date(2022, 8, 13), new java.sql.Date(2024, 8, 13),
				new Supplier(1l, "Yash Distributor", "9011223344",
						new Address(1l, "pune", "pune", "Maharashtra", "411052")),
				new Category(2l, "General", "general product", 3, 8, 30d)));

		list.add(new Product(2l, "book", 400d, 100, "This is a sample product description.",
				new java.sql.Date(2022, 8, 13), new java.sql.Date(2024, 8, 13),
				new Supplier(1l, "Yash Distributor", "9011223344",
						new Address(1l, "pune", "pune", "Maharashtra", "411052")),
				new Category(2l, "General", "general product", 3, 8, 30d)));

	}


	private boolean isExists(Product product, String supplierName,String categoryName) 
	{
	    for (Product dbProduct : list)
	    {
	        if (product.getProductName().equalsIgnoreCase(dbProduct.getProductName())
	                || supplierName.equalsIgnoreCase(dbProduct.getProductSupplier().getSupplierName())
	                ||categoryName.equalsIgnoreCase(dbProduct.getProductCategory().getCategoryName())) 
	        {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public int addProduct(Product product)
	{
	    String supplierName = product.getProductSupplier().getSupplierName();
	    String categoryName = product.getProductCategory().getCategoryName();
	    
	    if (!isExists(product, supplierName,categoryName)) 
	    {
	        list.add(product);
	        return 1; 
	    } 
	    else 
	    {
	        return 2; 
	    }
	}


	@Override
	public Product getProductById(long productId) 
	{
		
		for (Product ele : list) 
		{
			if (productId==ele.getProductId())
			{
				return ele;
			}

		}
		return null;
	}


	@Override
	public List<Product> getAllProduct() 
	{

		return list;
	}

	@Override
	public Object deleteProduct(long productId) 
	{
        int status = 0;
		
		if (!list.isEmpty())  //if list is not empty
		{
			for (Product dbProduct : list) 
			{
				if (dbProduct.getProductId() == productId) 
				{
					list.remove(dbProduct);  
					return list;    
				}
				else 
				{
					status = 1;  
				}
			}
		}
		else 
		{
			status = 2;  
		}

		return status;
	}

	@Override
	public Product updateProduct(Product product) 
	{

		for (Product dbProduct : list) 
		{

			if (dbProduct.getProductId() == product.getProductId()) 
			{
				list.set(list.indexOf(dbProduct), product);  
				
			}
		}

		return null;
	}

}
