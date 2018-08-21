package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.ImageDao;
import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Inject
	private ImageDao imageDao;
	
	@Override
	public List<Image> getImages() {
		return imageDao.getImages();
	}

	@Override
	public Image getImage(long id) {
		return imageDao.getImage(id);
	}

	@Override
	public void persist(Image image) {
		imageDao.persist(image);
	}

	@Override
	public void remove(Image image) {
		imageDao.remove(image);
	}

}
