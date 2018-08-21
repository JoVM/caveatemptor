package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.CategoryDao;
import com.amudhan.caveatemptor.entity.Category;
import com.amudhan.caveatemptor.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDao categoryDao;
	
	@Override
	public Category getCategory(long id) {
		return categoryDao.getCategory(id);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@Override
	public void persist(Category category) {
		categoryDao.persist(category);
	}

	@Override
	public void remove(Category category) {
		categoryDao.remove(category);
	}

}
