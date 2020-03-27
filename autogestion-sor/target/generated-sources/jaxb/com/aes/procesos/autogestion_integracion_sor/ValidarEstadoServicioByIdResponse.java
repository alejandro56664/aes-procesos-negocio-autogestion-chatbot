//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.03.26 a las 10:42:46 PM COT 
//


package com.aes.procesos.autogestion_integracion_sor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="estado" type="{http://aes.com/procesos/autogestion-integracion-sor}estadoServicioContratado"/&gt;
 *         &lt;element name="estadoHADA" type="{http://aes.com/procesos/autogestion-integracion-sor}estadoServicioHADA"/&gt;
 *         &lt;element name="estadoFinanciero" type="{http://aes.com/procesos/autogestion-integracion-sor}estadoFinancieroServicio"/&gt;
 *         &lt;element name="error" type="{http://aes.com/procesos/autogestion-integracion-sor}error"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "estado",
    "estadoHADA",
    "estadoFinanciero",
    "error"
})
@XmlRootElement(name = "validarEstadoServicioByIdResponse")
public class ValidarEstadoServicioByIdResponse {

    protected EstadoServicioContratado estado;
    protected EstadoServicioHADA estadoHADA;
    protected EstadoFinancieroServicio estadoFinanciero;
    protected Error error;

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoServicioContratado }
     *     
     */
    public EstadoServicioContratado getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoServicioContratado }
     *     
     */
    public void setEstado(EstadoServicioContratado value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoHADA.
     * 
     * @return
     *     possible object is
     *     {@link EstadoServicioHADA }
     *     
     */
    public EstadoServicioHADA getEstadoHADA() {
        return estadoHADA;
    }

    /**
     * Define el valor de la propiedad estadoHADA.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoServicioHADA }
     *     
     */
    public void setEstadoHADA(EstadoServicioHADA value) {
        this.estadoHADA = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoFinanciero.
     * 
     * @return
     *     possible object is
     *     {@link EstadoFinancieroServicio }
     *     
     */
    public EstadoFinancieroServicio getEstadoFinanciero() {
        return estadoFinanciero;
    }

    /**
     * Define el valor de la propiedad estadoFinanciero.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoFinancieroServicio }
     *     
     */
    public void setEstadoFinanciero(EstadoFinancieroServicio value) {
        this.estadoFinanciero = value;
    }

    /**
     * Obtiene el valor de la propiedad error.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setError(Error value) {
        this.error = value;
    }

}
