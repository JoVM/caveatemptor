package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Image;

public interface ImageDao {
	public List<Image> getImages();
	public Image getImage(long id);
	public void persist(Image image);
	public void remove(Image image);
}
