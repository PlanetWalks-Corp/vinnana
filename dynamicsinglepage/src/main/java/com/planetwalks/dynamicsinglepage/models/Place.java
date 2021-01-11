package com.planetwalks.dynamicsinglepage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Place implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long placeId;
	private String placeName;
	private String Address;
	private String imageName;

	@Column(length = 4000)
	private String description;
	private String placeType;

	@ManyToOne
	@JsonIgnore
	private Cities cities;

}
