//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.03.26 a las 10:42:46 PM COT 
//


package com.aes.procesos.autogestion_integracion_sor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoServicioHADA complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estadoServicioHADA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bloqueado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="fechaBloqueo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="motivoBloqueo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoServicioHADA", propOrder = {
    "bloqueado",
    "fechaBloqueo",
    "motivoBloqueo"
})
public class EstadoServicioHADA {

    protected boolean bloqueado;
    @XmlElement(required = true)
    protected String fechaBloqueo;
    @XmlElement(required = true)
    protected String motivoBloqueo;

    /**
     * Obtiene el valor de la propiedad bloqueado.
     * 
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /**
     * Define el valor de la propiedad bloqueado.
     * 
     */
    public void setBloqueado(boolean value) {
        this.bloqueado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaBloqueo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaBloqueo() {
        return fechaBloqueo;
    }

    /**
     * Define el valor de la propiedad fechaBloqueo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaBloqueo(String value) {
        this.fechaBloqueo = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoBloqueo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoBloqueo() {
        return motivoBloqueo;
    }

    /**
     * Define el valor de la propiedad motivoBloqueo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoBloqueo(String value) {
        this.motivoBloqueo = value;
    }

}
