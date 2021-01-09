package com.planetwlaks.dynamicsinglepage.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FamousThings implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String type;
	private Long cityId;
	private String description;
	private String image;

	public FamousThings(String name, String address, String type, Long cityId, String desc, String image) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.cityId = cityId;
		this.description = desc;
		this.image = image;
	}
}
