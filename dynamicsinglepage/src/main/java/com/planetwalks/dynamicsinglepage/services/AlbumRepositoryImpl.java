package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.Album;
import com.planetwalks.dynamicsinglepage.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumRepositoryImpl {

	@Autowired
	private AlbumRepository albumRepository;

	public Album create(Album album) {
		return albumRepository.save(album);
	}

	public Optional<Album> findByAlbumId(Long albumId) {
		return albumRepository.findById(albumId);
	}
}
