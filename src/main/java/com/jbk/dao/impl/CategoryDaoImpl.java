package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {


	List<Category> list = new ArrayList<>();

	public CategoryDaoImpl() {
		list.add(new Category(1l, "Electronics", "electronic product", 5, 12, 60d));
		list.add(new Category(2l, "General", "general product", 3, 8, 30d));
	}

	private boolean isExists(Category category) {
		boolean isExists = false;

		for (Category dbCategory : list) {
			if (category.getCategoryName().equalsIgnoreCase(dbCategory.getCategoryName())) {

				isExists = true;
				break;

			}
		}

		return isExists;
	}

	@Override
	public int addCategory(Category category) {

		if (isExists(category) == false) {
			list.add(category);
			return 1;
		} else {

			return 2;
		}


	}

	@Override
	public Category getCategoryById(long categoryId) 
	{
		
		for (Category dbCategory : list) 
		{
			if (dbCategory.getCategoryId() == categoryId) 
			{
				return dbCategory;
			}
		}
		return null;
	}
	@Override
	public List<Category> getAllCategory() 
	{		
		return list;
	}

	@Override
	public Object deleteCategory(long categoryId) 
	{
        int status = 0;
		
		if (!list.isEmpty())  
		{
			for (Category dbSupplier : list) 
			{
				if (dbSupplier.getCategoryId() == categoryId) 
				{
					list.remove(dbSupplier);  
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
	public Category updateCategory(Category category)
	{
		for (Category dbCategory : list) 
		{

			if (dbCategory.getCategoryId() == category.getCategoryId()) 
			{
				list.set(list.indexOf(dbCategory), category); 
				
			}
		}


		return null;
	}

}
