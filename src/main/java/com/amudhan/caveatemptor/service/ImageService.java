package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.Image;

public interface ImageService {
	public List<Image> getImages();
	public Image getImage(long id);
	public void persist(Image image);
	public void remove(Image image);
}
