package com.app.interfaces;

import java.util.List;

import com.app.model.Category;

public interface CategoryInterface {

	List<Category> getAllCategory();
	
	Category getCategoryById(int categoryId);
	int saveCategory(Category category);
	boolean deleteCategory(int categoryId);
	boolean updateCategory(Category category);
	
}
