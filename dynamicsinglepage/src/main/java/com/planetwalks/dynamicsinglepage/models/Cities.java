package com.planetwalks.dynamicsinglepage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cities implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cityId;
	private String cityName;
	private String weatherConditions;
	private Long population;
	private String geoLocation;

	@Column(length = 4000)
	private String history;

	@OneToMany(targetEntity = Fair.class, cascade = CascadeType.ALL, mappedBy = "cities", fetch = FetchType.LAZY)
	private List<Fair> fairList;

	@OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL, mappedBy = "cities", fetch = FetchType.LAZY)
	private List<Person> personList;

	@OneToMany(targetEntity = Place.class, cascade = CascadeType.ALL, mappedBy = "cities", fetch = FetchType.LAZY)
	private List<Place> placeList;

	@OneToOne(targetEntity = Album.class, cascade = CascadeType.ALL,mappedBy = "cities", fetch = FetchType.LAZY)
	private Album album;

}
