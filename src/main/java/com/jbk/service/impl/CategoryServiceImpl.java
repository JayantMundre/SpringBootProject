package com.jbk.service.impl;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CategoryDao;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;

	@Override
	public int addCategory(Category category) {

		String categoryId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		category.setCategoryId(Long.parseLong(categoryId));

		return dao.addCategory(category);

	}


	@Override
	public Category getCategoryById(long categoryId) 
	{
		
		return dao.getCategoryById(categoryId);
	}

	@Override
	public List<Category> getAllCategory() 
	{
		return dao.getAllCategory();
	}

	@Override
	public Object deleteCategory(long categoryId) 
	{
		
		return dao.deleteCategory(categoryId);
	}

	@Override
	public Category updateCategory(Category category) 
	{
		return dao.updateCategory(category);
	}

}
