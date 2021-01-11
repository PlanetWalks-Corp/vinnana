package com.planetwalks.dynamicsinglepage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Fair implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fairId;
	private String fairName;

	@Column(length = 4000)
	private String description;
	private String fairType;
	private String imageName;

	@ManyToOne
	@JsonIgnore
	private Cities cities;
}
