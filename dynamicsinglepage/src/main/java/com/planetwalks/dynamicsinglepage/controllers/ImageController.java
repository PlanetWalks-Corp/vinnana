package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Album;
import com.planetwalks.dynamicsinglepage.models.Image;
import com.planetwalks.dynamicsinglepage.services.AlbumRepositoryImpl;
import com.planetwalks.dynamicsinglepage.services.ImageRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

	@Autowired
	private ImageRepositoryImpl imageRepository;
	@Autowired
	private AlbumRepositoryImpl albumRepository;

	@PostMapping("/save")
	public Image create(@RequestParam("imageName") String imageName,
	                    @RequestParam("albumId") Long albumId){
		Album album = new Album();
		Optional<Album> album1= albumRepository.findByAlbumId(albumId);
		album.setAlbumId(album1.get().getAlbumId());
		album.setAlbumName(album1.get().getAlbumName());
		album.setCities(album1.get().getCities());

		Image image = new Image();
		image.setImageName(imageName);
		image.setAlbum(album);
		return imageRepository.create(image);
	}
}
