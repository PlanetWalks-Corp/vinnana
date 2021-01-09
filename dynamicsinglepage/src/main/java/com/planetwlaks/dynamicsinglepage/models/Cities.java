package com.planetwlaks.dynamicsinglepage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cities implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String cityName;

}
