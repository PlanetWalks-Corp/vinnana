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
public class Image implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long imageId;
	private String imageName;

	@ManyToOne
	@JsonIgnore
	private Album album;

}
