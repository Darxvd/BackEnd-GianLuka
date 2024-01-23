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
@Table(name = "tb_provincia")
public class Province {
	@Id
	private int idProvincia;
    private String desProvincia;
    private int idDepartamento; 
    
    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
    private Department objDepartment;
}
