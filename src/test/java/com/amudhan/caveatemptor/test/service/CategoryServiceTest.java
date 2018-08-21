package com.amudhan.caveatemptor.test.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.Category;
import com.amudhan.caveatemptor.service.CategoryService;
import com.amudhan.caveatemptor.test.ServiceTest;

public class CategoryServiceTest extends ServiceTest {
	
	@Inject
	private CategoryService categoryService;
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceTest.class);
	
	@Test
	public void getCategory(){
		Category category = categoryService.getCategory(10000000);
		Assert.assertNotNull(category);
		Assert.assertEquals(category.getId(), 10000000);
		Assert.assertEquals(category.getName(), "book");
		logger.info(category.getId()+" "+category.getName());
	}
	
	@Test
	public void getCategories(){
		List<Category> categories = categoryService.getCategories();
		Assert.assertNotNull(categories);
		for(Category category : categories){
			logger.info(category.getId()+" "+category.getName());
		}
	}
}
