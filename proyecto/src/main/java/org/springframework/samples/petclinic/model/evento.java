package org.springframework.samples.petclinic.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity 
@Table(name="eventos")
public class evento {
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name="fecha")
	@Temporal ( TemporalType . DATE )
    @DateTimeFormat ( pattern  =  " aaaa / MM / dd " )
	private Date fecha;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
