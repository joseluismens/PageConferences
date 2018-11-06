package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

public class catalogo {
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name="cantidad_de_productos")
	@NotEmpty
	private int cantidad_de_prooductos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_de_prooductos() {
		return cantidad_de_prooductos;
	}

	public void setCantidad_de_prooductos(int cantidad_de_prooductos) {
		this.cantidad_de_prooductos = cantidad_de_prooductos;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo", fetch = FetchType.EAGER)
    private Set<evento>events;
    
    @ManyToOne
    @JoinColumn(name = "ID_evento")
    private evento ID_evento;
    
    
    
}
