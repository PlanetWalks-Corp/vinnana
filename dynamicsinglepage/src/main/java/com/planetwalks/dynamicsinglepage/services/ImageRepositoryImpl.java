package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.Image;
import com.planetwalks.dynamicsinglepage.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageRepositoryImpl {

	@Autowired
	private ImageRepository imageRepository;

	public Image create(Image image) {
		return imageRepository.save(image);
	}

	public Image update(Image image) {
		return imageRepository.save(image);
	}
}
