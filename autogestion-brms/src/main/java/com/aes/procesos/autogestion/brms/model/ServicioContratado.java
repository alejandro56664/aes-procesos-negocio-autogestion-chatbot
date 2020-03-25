package com.aes.procesos.autogestion.brms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicioContratado {
	 @JsonProperty
    private String nombreComercial;
    private String codigo;
    private boolean internet;
    private boolean tv;
    private boolean voz;
    private String tipoInternet;
    private String tipoVoz;
    
    public ServicioContratado() {
    	 this.internet = false;
         this.voz = false;
         this.tv = false;
         this.tipoInternet = "";
         this.tipoVoz = "";
         this.codigo = "";
    }

    public ServicioContratado(String nombreComercial) {
    	this();
        this.nombreComercial = nombreComercial;
       
    }

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public boolean isInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isVoz() {
		return voz;
	}

	public void setVoz(boolean voz) {
		this.voz = voz;
	}

	public String getTipoInternet() {
		return tipoInternet;
	}

	public void setTipoInternet(String tipoInternet) {
		this.tipoInternet = tipoInternet;
	}

	public String getTipoVoz() {
		return tipoVoz;
	}

	public void setTipoVoz(String tipoVoz) {
		this.tipoVoz = tipoVoz;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
    
    


}
