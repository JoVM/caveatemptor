package com.amudhan.caveatemptor.test.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.service.ImageService;
import com.amudhan.caveatemptor.test.ServiceTest;

public class ImageServiceTest extends ServiceTest {

	@Inject
	private ImageService imageService;
	private static final Logger logger = LoggerFactory.getLogger(ImageServiceTest.class);
	
	@Test
	public void getImage(){
		Image image = imageService.getImage(10000001);
		Assert.assertNotNull(image);
		Assert.assertEquals(image.getId(), 10000001);
		Assert.assertEquals(image.getName(), "Book about steve jobs");
		Assert.assertEquals(image.getImageUrl(),"/resources/images/thelifeofjobs.jpg");
		logger.info(image.getName()+" "+image.getImageUrl());
	}
	
	@Test
	public void getImages(){
		List<Image> images = imageService.getImages();
		Assert.assertNotNull(images);
		for(Image image : images){
			logger.info(image.getName()+" "+image.getImageUrl());
		}
	}
}
