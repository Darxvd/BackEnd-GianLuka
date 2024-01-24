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
@Table(name = "tb_provincia")
public class Province {
	@Id
	@Column(name = "id_provincia")
	private int idProvincia;
	@Column(name = "des_provincia")
    private String desProvincia;
	@Column(name = "id_departamento")
    private int idDepartamento; 
    
    @ManyToOne
    @JoinColumn(name = "id_departamento", insertable = false, updatable = false)
    private Department objDepartment;
}
