package com.gianluka.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_tipo")
public class Type {
	@Id
	private int idTipo;
    private String nomTipo;
    private String desTipo;
    private String activoTipo;
}
