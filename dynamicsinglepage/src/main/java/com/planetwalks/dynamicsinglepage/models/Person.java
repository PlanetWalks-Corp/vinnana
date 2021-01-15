package com.planetwalks.dynamicsinglepage.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;
	private String personFirstName;
	private String personLastName;

	@Column(length = 4000)
	private String description;
	private String profession;
	private Integer age;
	private String imageName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@ManyToOne
	@JsonIgnore
	private City city;
}
