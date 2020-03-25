package com.aes.procesos.autogestion.sor.model.dto;

import java.util.Date;

public class EstadoFinancieroServicioDTO {
	protected String codEstado;
    protected float valorAPagar;
    protected Date fechaSuspension;
    protected String motivoSuspension;
    

	public float getValorAPagar() {
		return valorAPagar;
	}
	public void setValorAPagar(float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	public Date getFechaSuspension() {
		return fechaSuspension;
	}
	public void setFechaSuspension(Date fechaSuspension) {
		this.fechaSuspension = fechaSuspension;
	}
	public String getMotivoSuspension() {
		return motivoSuspension;
	}
	public void setMotivoSuspension(String motivoSuspension) {
		this.motivoSuspension = motivoSuspension;
	}
	public String getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}
	
	
    
    

}
