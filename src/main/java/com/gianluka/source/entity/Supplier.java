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
@Table(name = "tb_proveedor")
public class Supplier {
	@Id
	private int idProveedor;
    private String nomProveedor;
    private String rscoProveedor;
    private String desProveedor;
    private String rucProveedor;
    private String activoProveedor;
    private int idPais;
    private int idDepartamento; 
    private int idProvincia;
    private int idDistrito;
    
    @ManyToOne
    @JoinColumn(name = "idPais", insertable = false, updatable = false)
    private Country objCountry;
    
    @ManyToOne
    @JoinColumn(name = "idDepartamento", insertable = false, updatable = false)
    private Department objDepartment;
    
    @ManyToOne
    @JoinColumn(name = "idProvincia", insertable = false, updatable = false)
    private Province objProvince;
    
    @ManyToOne
    @JoinColumn(name = "idDistrito", insertable = false, updatable = false)
    private District objDistrict;
}
