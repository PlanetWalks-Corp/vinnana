package com.planetwalks.dynamicsinglepage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class CloudinaryUploader {

	private final String CLOUDINARY_URL= "cloudinary://199947817137632:KtnvtP3KnPaP9X2EdsDcFygRo14@ksush";

	public String upload(MultipartFile imageName) throws IOException {
		File imagePath = new File("uploads/"+imageName.getOriginalFilename());
		imagePath.createNewFile();
		try(FileOutputStream fout = new FileOutputStream(imagePath)){
			fout.write(imageName.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
		Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
		Map uploadResult = cloudinary.uploader().upload(imagePath, ObjectUtils.emptyMap());
		return (String) uploadResult.get("url");
	}
}
