package com.planetwalks.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private Long phNo;


	public User() {

	}
}
