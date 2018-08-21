package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.ImageQueries;
import com.amudhan.caveatemptor.dao.ImageDao;
import com.amudhan.caveatemptor.entity.Image;

@Repository
public class ImageDaoImpl implements ImageDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getImages() {
		Query query = entityManager.createNamedQuery(ImageQueries.GETALLIMAGES); 
		return query.getResultList();
	}

	@Override
	public Image getImage(long id) {
		return entityManager.find(Image.class, id);
	}

	@Override
	public void persist(Image image) {
		entityManager.persist(image);
	}

	@Override
	public void remove(Image image) {
		entityManager.persist(image);
	}

}
