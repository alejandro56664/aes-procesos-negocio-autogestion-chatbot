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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;sequence&gt;
 *         &lt;element name="idServicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="accion" type="{http://aes.com/procesos/autogestion-integracion-sor}tipoAccionCorrectivaAutomatica"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idServicio",
    "accion"
})
@XmlRootElement(name = "ejecutarAccionCorrectivaAutomaticaRequest")
public class EjecutarAccionCorrectivaAutomaticaRequest {

    @XmlElement(required = true)
    protected String idServicio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoAccionCorrectivaAutomatica accion;

    /**
     * Obtiene el valor de la propiedad idServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdServicio() {
        return idServicio;
    }

    /**
     * Define el valor de la propiedad idServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdServicio(String value) {
        this.idServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad accion.
     * 
     * @return
     *     possible object is
     *     {@link TipoAccionCorrectivaAutomatica }
     *     
     */
    public TipoAccionCorrectivaAutomatica getAccion() {
        return accion;
    }

    /**
     * Define el valor de la propiedad accion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoAccionCorrectivaAutomatica }
     *     
     */
    public void setAccion(TipoAccionCorrectivaAutomatica value) {
        this.accion = value;
    }

}
