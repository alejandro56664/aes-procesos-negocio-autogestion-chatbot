package com.aes.procesos.autogestion.sor.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "registro_accion_correctiva")
public class RegistroAccionCorrectiva {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servicio", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ServicioContratado servicioContratado;
	
	private Timestamp timestamp;
	
	@NotBlank
	private String accionEjecutada;
	
	private boolean exitosos;
	

	private String resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServicioContratado getServicioContratado() {
		return servicioContratado;
	}

	public void setServicioContratado(ServicioContratado servicioContratado) {
		this.servicioContratado = servicioContratado;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getAccionEjecutada() {
		return accionEjecutada;
	}

	public void setAccionEjecutada(String accionEjecutada) {
		this.accionEjecutada = accionEjecutada;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public boolean isExitosos() {
		return exitosos;
	}

	public void setExitosos(boolean exitosos) {
		this.exitosos = exitosos;
	}
	
	
	
	
	
}
