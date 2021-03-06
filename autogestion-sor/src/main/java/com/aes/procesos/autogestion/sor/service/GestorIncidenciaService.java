package com.aes.procesos.autogestion.sor.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.sor.model.Auditoria;
import com.aes.procesos.autogestion.sor.model.Incidencia;
import com.aes.procesos.autogestion.sor.model.Satisfaccion;
import com.aes.procesos.autogestion.sor.model.ServicioContratado;
import com.aes.procesos.autogestion.sor.repositories.AuditoriaRepository;
import com.aes.procesos.autogestion.sor.repositories.IncidenciaRepository;
import com.aes.procesos.autogestion.sor.repositories.SatisfaccionRepository;
import com.aes.procesos.autogestion.sor.repositories.ServicioContratadoRepository;

@Service
public class GestorIncidenciaService {
	
	@Autowired
	private ServicioContratadoRepository servicioRepo;
	
	@Autowired
	private IncidenciaRepository incidenciaRepo;
	
	@Autowired
	private AuditoriaRepository auditoriaRepo;
	
	
	@Autowired
	private SatisfaccionRepository satisfaccionRepo;
	
	
	public Long registrarSatisfaccion(String idServicio, String codSatisfaccion, String sesion) {
		Satisfaccion registro = new Satisfaccion();
		
		registro.setIdServicio(idServicio);
		registro.setCodSatisfaccion(codSatisfaccion);
		registro.setSesion(sesion);
		registro.setTimestamp(new Timestamp(System.currentTimeMillis()));
		registro = satisfaccionRepo.save(registro);
		return registro.getId();
	}
	

	public long registrarAuditoria(String idServicio, String codigo, String mensaje, String sesion) {
		
		Auditoria registro = new Auditoria();
		
		registro.setIdServicio(idServicio);
		registro.setCodigo(codigo);
		registro.setMensaje(mensaje);
		registro.setSesion(sesion);
		registro.setTimestamp(new Timestamp(System.currentTimeMillis()));
		registro = auditoriaRepo.save(registro);
		return registro.getId();
		
	}
	
	public long generarPeticion(String idServicio, String titulo, String descripcion, String canal) {
		return guardarIncidencia((generarIncidencia(idServicio, "PETICION", titulo, descripcion, canal)));
	}	
	
	public long generarAveria(String idServicio, String titulo, String descripcion, String canal) {
		return guardarIncidencia((generarIncidencia(idServicio, "AVERIA", titulo, descripcion, canal)));
	}	
	
	public List<Incidencia> traerAverias(String idServicio, String estado) {
		return traerIncidencias(idServicio, "AVERIA", estado);
	}	
	
	public List<Incidencia> traerPeticiones(String idServicio, String estado) {
		return traerIncidencias(idServicio, "PETICION", estado);
	}
	
	private List<Incidencia> traerIncidencias(String idServicio, String tipoIncidencia, String estado) {
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		return incidenciaRepo.findByServicioContratadoAndTipoIncidenciaAndEstado(servicioContratado, tipoIncidencia, estado);
	}

	private Incidencia generarIncidencia(String idServicio, String tipoIncidencia, String titulo, String descripcion, String canal) {
		Incidencia nueva = new Incidencia();
		
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		nueva.setServicioContratado(servicioContratado);
		
		nueva.setTipoIncidencia(tipoIncidencia);
		nueva.setFechaEstimadaResolucion(calcularFechaEstimadaResolucion(tipoIncidencia));
		nueva.setTitulo(titulo);
		nueva.setDescripcion(descripcion);
		nueva.setCanal(canal);
		nueva.setTimestamp(new Timestamp(System.currentTimeMillis()));
		nueva.setFechaActualizacion(nueva.getTimestamp());
		nueva.setEstado("ABIERTA");
		nueva.setRegistradoPor(nueva.getCanal() + "-autogestion-sor");
		nueva.setActualizadoPor(nueva.getRegistradoPor());
		return nueva;
	}	
	
	private Timestamp calcularFechaEstimadaResolucion(String tipoIncidencia) {
		Date fechaEstimadaResolucion = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaEstimadaResolucion);
		
		cal.add(Calendar.HOUR_OF_DAY, obtenerSLA(tipoIncidencia));
		fechaEstimadaResolucion = cal.getTime();
		return new Timestamp(fechaEstimadaResolucion.toInstant().toEpochMilli());
	}
	
	private int obtenerSLA(String tipoIncidencia) {
		//TODO: no se calculan si es con horario laboral o no. Los SLA estan aquí quemados
		//deberían estar externos
		int sla = 0;
		
		if(tipoIncidencia.equalsIgnoreCase("AVERIA")) {
			sla = 5;
		} else if(tipoIncidencia.equalsIgnoreCase("PETICION")) {
			sla = 24;
		}
		
		return sla;
	}

	private long guardarIncidencia(Incidencia incidencia) {
		Incidencia guardada = incidenciaRepo.save(incidencia);
		
		return guardada.getId();
	}
	
}
