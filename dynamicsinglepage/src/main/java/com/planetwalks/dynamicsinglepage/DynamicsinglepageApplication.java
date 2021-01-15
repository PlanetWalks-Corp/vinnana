package com.planetwalks.dynamicsinglepage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DynamicsinglepageApplication extends SpringBootServletInitializer {

	@Autowired
	CitiesRepositoriesImpl citiesRepositories;

	public static void main(String[] args) {
		SpringApplication.run(DynamicsinglepageApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Cities>> typeReference = new TypeReference<List<Cities>>(){} ;
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/city.json");
			try {
				List<Cities> cities = mapper.readValue(inputStream,typeReference);
				for(Cities city : cities){
					citiesRepositories.create((Cities) city);
				}
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

}
