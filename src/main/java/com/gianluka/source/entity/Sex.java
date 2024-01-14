package com.gianluka.source.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="tb_sexo")
@Entity
public class Sex {
	@Id
    private Integer idSexo;
    private String nomSexo;
    private String desSexo;
}
