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
	private Long type;
	private Long cityId;
	private String description;
	private String image;
}
