package com.planetwlaks.dynamicsinglepage.controllers;

import com.planetwlaks.dynamicsinglepage.models.FamousThings;
import com.planetwlaks.dynamicsinglepage.services.FamousThingsRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/famous/things")
public class FamousThingsController {

	private FamousThingsRepositoryImpl famousThingsRepository;

	@GetMapping("/city")
	public List<FamousThings> getThings(@RequestParam("cityId") Long cityId){
		return famousThingsRepository.getCityId(cityId);
	}

	@PostMapping("/save")
	public String saveThing(@RequestParam("name") String name,
	                        @RequestParam("address") String address,
                            @RequestParam("type") String type,
                            @RequestParam("cityId") Long cityId,
                            @RequestParam("description") String desc,
                            @RequestParam("image") String image){
		FamousThings famousThings = new FamousThings(name, address, type, cityId, desc, image);
		famousThingsRepository.create(famousThings);
		return "saved Successfully";
	}
}
