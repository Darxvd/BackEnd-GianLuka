package com.gianluka.source.entity;

import org.springframework.boot.context.properties.bind.Name;

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
@Table(name = "tb_departamentos")
public class Department {
    @Id
    @Column(name = "id_departamento")
    private int idDepartamento;
    
    @Column(name = "des_departamento")
    private String desDepartamento;
    
    @Column(name = "id_pais")
    private int idPais;
    
    @ManyToOne
    @JoinColumn(name = "id_pais", insertable = false, updatable = false)
    private Country objCountry;

}
