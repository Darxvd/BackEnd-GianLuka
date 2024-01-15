package com.gianluka.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "tb_usuario")
public class User {
	@Id
	private int idUsuario;
    private int idPersona;
    private String usuUsuario;
    private String claUsuario;
    private String activoUsuario;
    
    @ManyToOne
    @JoinColumn(name = "idPersona", insertable = false, updatable = false)
    private Person objPerson;
}
