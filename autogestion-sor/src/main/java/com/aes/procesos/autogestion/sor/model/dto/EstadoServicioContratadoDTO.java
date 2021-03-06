package com.aes.procesos.autogestion.sor.model.dto;

import java.util.Date;

public class EstadoServicioContratadoDTO {
	protected boolean activo;
	protected String descripcionPlan;
    protected float valorAPagar;
    protected Date fechaCorte;
    protected Date fechaSuspension;
    protected String motivoSuspension;
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public float getValorAPagar() {
		return valorAPagar;
	}
	public void setValorAPagar(float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	public Date getFechaCorte() {
		return fechaCorte;
	}
	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
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
	public String getDescripcionPlan() {
		return descripcionPlan;
	}
	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}
    
    

}
