package com.gianluka.source.entity;

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
	private int idDistrito;
	private String desDistrito;
	private int idProvincia;
	
	@ManyToOne
	@JoinColumn(name = "idProvincia", insertable = false, updatable = false)
	private Province objProvince;

}
