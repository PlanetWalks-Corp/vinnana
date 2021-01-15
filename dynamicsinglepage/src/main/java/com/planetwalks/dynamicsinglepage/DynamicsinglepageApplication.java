package com.planetwalks.dynamicsinglepage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.models.Fair;
import com.planetwalks.dynamicsinglepage.repositories.FairRepository;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.planetwalks.dynamicsinglepage.services.FairRepositoryImpl;
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
	//FairRepositoryImpl fairRepositories;
	public static void main(String[] args) {
		SpringApplication.run(DynamicsinglepageApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<City>> typeReference = new TypeReference<List<City>>(){} ;
			//TypeReference<List<Fair>> typeFair = new TypeReference<List<Fair>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/JSON/City.json");
			try {
				List<City> cities = mapper.readValue(inputStream,typeReference);
				//List<Fair> fair= mapper.readValue(inputStream,typeFair);
				for(City city : cities){
					citiesRepositories.create((City) city);
//					for(Fair fair1 : fair){
//						fairRepositories.create((Fair) fair1);
//					}
				}
				System.out.println("Cities Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Cities: " + e.getMessage());
			}
		};
	}

}
