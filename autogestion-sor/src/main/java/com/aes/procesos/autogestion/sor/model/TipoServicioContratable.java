package com.aes.procesos.autogestion.sor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_servicio_contratable")
public class TipoServicioContratable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private int corte;
	
	private float valor;
	
	private String descripcion;
	
	private int categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getCorte() {
		return corte;
	}

	public void setCorte(int corte) {
		this.corte = corte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	
	
}
