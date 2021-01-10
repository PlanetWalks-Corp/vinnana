package com.planetwlaks.dynamicsinglepage.controllers;

import com.planetwlaks.dynamicsinglepage.models.FamousThings;
import com.planetwlaks.dynamicsinglepage.services.FamousThingsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/famous/things")
@CrossOrigin("*")
public class FamousThingsController {

	@Autowired
	private FamousThingsRepositoryImpl famousThingsRepository;

	@GetMapping("/city")
	public List<FamousThings> getThings(@RequestParam("cityId") Long cityId){
		return famousThingsRepository.getCityId(cityId);
	}

	@PostMapping(value = "/save", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
	public FamousThings saveThing(@RequestParam("name") String name,
	                        @RequestParam("address") String address,
                            @RequestParam("type") Long type,
                            @RequestParam("cityId") Long cityId,
                            @RequestParam("description") String desc,
                            @RequestParam("image") String image){
		FamousThings famousThings = new FamousThings();
		famousThings.setName(name);
		famousThings.setAddress(address);
		famousThings.setType(type);
		famousThings.setCityId(cityId);
		famousThings.setDescription(desc);
		famousThings.setImage(image);

		famousThingsRepository.create(famousThings);

		return famousThings;
	}
}
