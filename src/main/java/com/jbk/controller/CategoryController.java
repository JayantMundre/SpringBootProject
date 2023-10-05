package com.jbk.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.CategoryAlreadyExistsException;
import com.jbk.exceptions.ResourceNotExistsExceptions;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping("/add-category")
	public String addCategory(@RequestBody @Valid Category category) {

		int status = service.addCategory(category);

		if (status == 1) {

			return "Data Added Successfully.";
		} else if (status == 2) {
			throw new CategoryAlreadyExistsException("Category Already Exists.");
		} else {
			return "Invalid Data";
		}
	}
		@GetMapping("/get-category-by-id/{categoryId}")
		public Category getCategoryById(@PathVariable long categoryId) 
		{

			Category category = service.getCategoryById(categoryId);
			
			if (category != null) 
			{
				return category;
			}
			else 
			{
				throw new ResourceNotExistsExceptions("Category Not Exists With Id = " + categoryId +" : /get-category-by-id/"+categoryId);
			}

		}
		
		@GetMapping("/get-all-category")
		public List<Category> getAllCategory() 
		{
			List<Category> list = service.getAllCategory();

			if (!list.isEmpty())
			{
				return list;
			}
			else
			{
				throw new ResourceNotExistsExceptions("Category Not Exists");
			}
		}
		
		@DeleteMapping("/delete-category-by-id")
		public List<Category> deleteCategory(@RequestParam long categoryId)
		{
			Object obj = service.deleteCategory(categoryId);

			if(obj instanceof Integer)
			{
				int i=(int)obj;
				if(i==1)
				{
					throw new ResourceNotExistsExceptions("category not exits");
				}
				else
				{
					throw new ResourceNotExistsExceptions("List is Empty");
				}

			}
			else			
			{
				return (List<Category>) obj;
			}		
		}
		
		@PutMapping("/update-category")
		public Category updateCategory(@RequestBody @Valid Category clientCategory)
		{
			Category category = service.updateCategory(clientCategory);
			
			if (category != null) 
			{
				return category;
			}
			else 
			{
				throw new ResourceNotExistsExceptions("Category Not Exists With Id = " + clientCategory.getCategoryId());
			}
			
		}

	
	}


