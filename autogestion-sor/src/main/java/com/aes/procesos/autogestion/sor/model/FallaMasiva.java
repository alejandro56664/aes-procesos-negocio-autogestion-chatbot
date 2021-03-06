package com.aes.procesos.autogestion.sor.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "falla_masiva")
public class FallaMasiva {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private Timestamp timestamp;
	
	private String descripcion;
	
	@NotBlank
	private String estado;
	
	private Timestamp fechaActualizacion;
	
	private String actualizadoPor;
	
	private Timestamp fechaEstimadaResolucion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(String actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Timestamp getFechaEstimadaResolucion() {
		return fechaEstimadaResolucion;
	}

	public void setFechaEstimadaResolucion(Timestamp fechaEstimadaResolucion) {
		this.fechaEstimadaResolucion = fechaEstimadaResolucion;
	}
	
}
