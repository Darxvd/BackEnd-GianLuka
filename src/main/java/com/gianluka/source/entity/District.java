package com.gianluka.source.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_distrito")
public class District {
	@Id
	@Column(name = "id_distrito")
	private int idDistrito;
	@Column(name = "des_distrito")
	private String desDistrito;
	@Column(name = "id_provincia")
	private int idProvincia;
	
	@ManyToOne
	@JoinColumn(name = "id_provincia", insertable = false, updatable = false)
	private Province objProvince;

}
