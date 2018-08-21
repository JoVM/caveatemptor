package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public Category getCategory(long id);
	public void persist(Category category);
	public void remove(Category category);
}
