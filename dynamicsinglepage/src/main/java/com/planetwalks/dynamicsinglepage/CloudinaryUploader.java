package com.planetwalks.dynamicsinglepage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryUploader {

	private final String CLOUDINARY_URL= "cloudinary://199947817137632:KtnvtP3KnPaP9X2EdsDcFygRo14@ksush";

	public String uploadImage(String filePath) throws IOException {
		File file = new File(filePath);

		Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		return (String) uploadResult.get("url");
	}
}
