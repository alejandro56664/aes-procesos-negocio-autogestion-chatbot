package com.aes.procesos.autogestion.sor.model.dto;

import java.util.Date;

public class EstadoServicioHadaDTO {
	protected boolean bloqueado;
    protected Date fechaBloqueo;
    protected String motivoBloqueo;
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public Date getFechaBloqueo() {
		return fechaBloqueo;
	}
	public void setFechaBloqueo(Date fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
	}
	public String getMotivoBloqueo() {
		return motivoBloqueo;
	}
	public void setMotivoBloqueo(String motivoBloqueo) {
		this.motivoBloqueo = motivoBloqueo;
	}

    
    

}
