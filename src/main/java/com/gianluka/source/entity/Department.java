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
@Table(name = "tb_departamentos")
public class Department {
	@Id
	private int idDepartamento;
	private String desDepartamento;
	private int idPais; 
	
	@ManyToOne
	@JoinColumn(name = "idPais", insertable = false, updatable = false)
	private Country objCountry;

}
