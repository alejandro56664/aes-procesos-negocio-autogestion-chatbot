//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.03.24 a las 10:45:26 PM COT 
//


package com.aes.procesos.autogestion_integracion_sor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoAccionCorrectivaAutomatica.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoAccionCorrectivaAutomatica"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ENVIAR_REFRESH"/&gt;
 *     &lt;enumeration value="EJECUTAR_CONCILIACION"/&gt;
 *     &lt;enumeration value="EJECUTAR_CONCILIACION_MOVIL"/&gt;
 *     &lt;enumeration value="EJECUTAR_RESET_PUERTO"/&gt;
 *     &lt;enumeration value="EJECUTAR_PRUEBAS_FISICAS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipoAccionCorrectivaAutomatica")
@XmlEnum
public enum TipoAccionCorrectivaAutomatica {

    ENVIAR_REFRESH,
    EJECUTAR_CONCILIACION,
    EJECUTAR_CONCILIACION_MOVIL,
    EJECUTAR_RESET_PUERTO,
    EJECUTAR_PRUEBAS_FISICAS;

    public String value() {
        return name();
    }

    public static TipoAccionCorrectivaAutomatica fromValue(String v) {
        return valueOf(v);
    }

}
