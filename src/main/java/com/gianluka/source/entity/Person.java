package com.gianluka.source.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tb_persona")
public class Person {
	@Id
	private int idPersona;
    private String nomPersona;
    private String aplPersona;
    private String dniPersona;
    private String correoPersona;
    private String fnaciPersona;
    private String celuPersona;
    private String activoPersona;
    private int idSexo;
    private int idTipo;
    
    @ManyToOne
    @JoinColumn(name = "idSexo", insertable = false, updatable = false)
    private Sex objSex;
    
    @ManyToOne
    @JoinColumn(name = "idTipo", insertable = false, updatable = false)
    private Type objType;

}
