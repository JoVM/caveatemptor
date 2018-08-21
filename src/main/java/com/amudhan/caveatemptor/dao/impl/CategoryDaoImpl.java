package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.CategoryQueries;
import com.amudhan.caveatemptor.dao.CategoryDao;
import com.amudhan.caveatemptor.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		Query query = entityManager.createNamedQuery(CategoryQueries.GETALLCATEGORIES);
		return query.getResultList();
	}
	
	@Override
	public Category getCategory(long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public void persist(Category category) {
		entityManager.persist(category);
	}

	@Override
	public void remove(Category category) {
		entityManager.remove(category);
	}
	
}
