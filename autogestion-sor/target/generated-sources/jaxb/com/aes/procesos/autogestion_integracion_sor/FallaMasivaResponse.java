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
 * <p>Clase Java para fallaMasivaResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="fallaMasivaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="existeFallaMasivaAsociada" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="servicioAfectado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaEstimadaResolucion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fallaMasivaResponse", propOrder = {
    "existeFallaMasivaAsociada",
    "servicioAfectado",
    "timestamp",
    "descripcion",
    "estado",
    "fechaEstimadaResolucion"
})
public class FallaMasivaResponse {

    protected boolean existeFallaMasivaAsociada;
    @XmlElement(required = true)
    protected String servicioAfectado;
    @XmlElement(required = true)
    protected String timestamp;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String fechaEstimadaResolucion;

    /**
     * Obtiene el valor de la propiedad existeFallaMasivaAsociada.
     * 
     */
    public boolean isExisteFallaMasivaAsociada() {
        return existeFallaMasivaAsociada;
    }

    /**
     * Define el valor de la propiedad existeFallaMasivaAsociada.
     * 
     */
    public void setExisteFallaMasivaAsociada(boolean value) {
        this.existeFallaMasivaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad servicioAfectado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicioAfectado() {
        return servicioAfectado;
    }

    /**
     * Define el valor de la propiedad servicioAfectado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicioAfectado(String value) {
        this.servicioAfectado = value;
    }

    /**
     * Obtiene el valor de la propiedad timestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Define el valor de la propiedad timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEstimadaResolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEstimadaResolucion() {
        return fechaEstimadaResolucion;
    }

    /**
     * Define el valor de la propiedad fechaEstimadaResolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEstimadaResolucion(String value) {
        this.fechaEstimadaResolucion = value;
    }

}
