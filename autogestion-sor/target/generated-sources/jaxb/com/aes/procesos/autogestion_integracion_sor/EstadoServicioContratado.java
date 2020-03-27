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
 * <p>Clase Java para estadoServicioContratado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estadoServicioContratado"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="descripcionPlan" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="valorAPagar" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="fechaCorte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoServicioContratado", propOrder = {
    "activo",
    "descripcionPlan",
    "valorAPagar",
    "fechaCorte"
})
public class EstadoServicioContratado {

    protected boolean activo;
    @XmlElement(required = true)
    protected String descripcionPlan;
    protected float valorAPagar;
    @XmlElement(required = true)
    protected String fechaCorte;

    /**
     * Obtiene el valor de la propiedad activo.
     * 
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Define el valor de la propiedad activo.
     * 
     */
    public void setActivo(boolean value) {
        this.activo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionPlan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionPlan() {
        return descripcionPlan;
    }

    /**
     * Define el valor de la propiedad descripcionPlan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionPlan(String value) {
        this.descripcionPlan = value;
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
     * Obtiene el valor de la propiedad fechaCorte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCorte() {
        return fechaCorte;
    }

    /**
     * Define el valor de la propiedad fechaCorte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCorte(String value) {
        this.fechaCorte = value;
    }

}
