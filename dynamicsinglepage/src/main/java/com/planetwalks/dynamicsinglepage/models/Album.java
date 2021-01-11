package com.planetwalks.dynamicsinglepage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Album implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long albumId;
	private String albumName;

	@OneToOne
	@JsonIgnore
	public Cities cities;

	@OneToMany(targetEntity = Image.class, cascade = CascadeType.ALL, mappedBy = "album", fetch = FetchType.LAZY)
	public List<Image> imageList;
}
