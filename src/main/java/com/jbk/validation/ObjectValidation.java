package com.jbk.validation;

import org.springframework.stereotype.Component;

import com.jbk.model.Address;
import com.jbk.model.Product;
import com.jbk.model.Supplier;
@Component
public class ObjectValidation {
	

	public boolean validateObject(Supplier supplier) 
	{
		boolean isValid=true;
		
	if(supplier.getSupplierName()==null || supplier.getSupplierName().trim().equals("")){
		isValid=false;
	}
	
	if(supplier.getSupplierMobileNumber().length()!=10) {
		isValid=false;
	}
		
		return isValid;
		
	}
	
	
	public boolean validateObject(Product product) 
	{
		boolean isValid=true;


		return false;
		
	}
}
