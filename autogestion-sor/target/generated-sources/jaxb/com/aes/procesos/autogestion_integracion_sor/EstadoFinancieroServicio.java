//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.03.24 a las 10:45:26 PM COT 
//


package com.aes.procesos.autogestion_integracion_sor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoFinancieroServicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estadoFinancieroServicio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codEstado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="valorAPagar" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="motivoSuspension" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaSuspension" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoFinancieroServicio", propOrder = {
    "codEstado",
    "valorAPagar",
    "motivoSuspension",
    "fechaSuspension"
})
public class EstadoFinancieroServicio {

    @XmlElement(required = true)
    protected String codEstado;
    protected float valorAPagar;
    @XmlElement(required = true)
    protected String motivoSuspension;
    @XmlElement(required = true)
    protected String fechaSuspension;

    /**
     * Obtiene el valor de la propiedad codEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEstado() {
        return codEstado;
    }

    /**
     * Define el valor de la propiedad codEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEstado(String value) {
        this.codEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad valorAPagar.
     * 
     */
    public float getValorAPagar() {
        return valorAPagar;
    }

    /**
     * Define el valor de la propiedad valorAPagar.
     * 
     */
    public void setValorAPagar(float value) {
        this.valorAPagar = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoSuspension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoSuspension() {
        return motivoSuspension;
    }

    /**
     * Define el valor de la propiedad motivoSuspension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoSuspension(String value) {
        this.motivoSuspension = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSuspension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSuspension() {
        return fechaSuspension;
    }

    /**
     * Define el valor de la propiedad fechaSuspension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSuspension(String value) {
        this.fechaSuspension = value;
    }

}
