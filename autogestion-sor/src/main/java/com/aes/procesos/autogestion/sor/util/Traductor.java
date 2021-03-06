package com.aes.procesos.autogestion.sor.util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.sor.model.AfectadoFallaMasiva;
import com.aes.procesos.autogestion.sor.model.FallaMasiva;
import com.aes.procesos.autogestion.sor.model.Incidencia;
import com.aes.procesos.autogestion.sor.model.RegistroAccionCorrectiva;
import com.aes.procesos.autogestion.sor.model.ServicioContratado;
import com.aes.procesos.autogestion.sor.model.dto.EstadoFinancieroServicioDTO;
import com.aes.procesos.autogestion.sor.model.dto.EstadoServicioContratadoDTO;
import com.aes.procesos.autogestion.sor.model.dto.EstadoServicioHadaDTO;
import com.aes.procesos.autogestion.sor.model.dto.ResultadoEjecucionAccionCorrectivaDTO;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAfectacionFallaMasivaByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAveriasByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.ConsultarPeticionesByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.EjecutarAccionCorrectivaAutomaticaResponse;
import com.aes.procesos.autogestion_integracion_sor.EstadoServicioContratado;
import com.aes.procesos.autogestion_integracion_sor.EstadoServicioHADA;
import com.aes.procesos.autogestion_integracion_sor.FallaMasivaResponse;
import com.aes.procesos.autogestion_integracion_sor.IncidenciaResponse;
import com.aes.procesos.autogestion_integracion_sor.ResultadoOperacion;
import com.aes.procesos.autogestion_integracion_sor.ResultadoRegistro;
import com.aes.procesos.autogestion_integracion_sor.ValidarEstadoServicioByIdResponse;
import com.aes.procesos.autogestion_integracion_sor.Error;
import com.aes.procesos.autogestion_integracion_sor.EstadoFinancieroServicio;
@Service
public class Traductor {

	public ValidarEstadoServicioByIdResponse toResponse(EstadoServicioContratadoDTO dto) {
		ValidarEstadoServicioByIdResponse response = new ValidarEstadoServicioByIdResponse();
		
		EstadoServicioContratado estado = new EstadoServicioContratado();
		estado.setActivo(dto.isActivo());
	
		if(dto.isActivo()) {
			estado.setFechaCorte(toString(dto.getFechaCorte()));
			estado.setValorAPagar(dto.getValorAPagar());
		} else {
			estado.setFechaCorte(toString(dto.getFechaSuspension()));
			estado.setValorAPagar(0.0F);
		}
		estado.setDescripcionPlan(dto.getDescripcionPlan());
		response.setEstado(estado);
		return response;
	}

	public EjecutarAccionCorrectivaAutomaticaResponse toResponse(
			ResultadoEjecucionAccionCorrectivaDTO resultadoDTO) {
		EjecutarAccionCorrectivaAutomaticaResponse response = new EjecutarAccionCorrectivaAutomaticaResponse();
		ResultadoOperacion resultadoAC = new ResultadoOperacion();
		
		resultadoAC.setExitoso(resultadoDTO.getCodigo().equalsIgnoreCase("OK"));
		resultadoAC.setCodigo(resultadoDTO.getCodigo());
		resultadoAC.setDescripcion(resultadoDTO.getMensaje());
		response.setResultado(resultadoAC);
		return response;
	}

	public RegistroAccionCorrectiva toEntity(ResultadoEjecucionAccionCorrectivaDTO dto, ServicioContratado servicioContratado) {
		RegistroAccionCorrectiva entity = new RegistroAccionCorrectiva();
		entity.setAccionEjecutada(dto.getTipoAccion());
		entity.setExitosos(dto.getCodigo().equalsIgnoreCase("OK"));
		entity.setResultado("codigo: "+ dto.getCodigo() + ", mensaje: " + dto.getMensaje());
		entity.setServicioContratado(servicioContratado);
		entity.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
	
	
	public ResultadoRegistro toResultadoRegistro(Long id) {
		ResultadoRegistro resultOp = new ResultadoRegistro();
		
		resultOp.setId(id.toString());
		return resultOp;
	}
	
	public ResultadoOperacion toResultadoOperacion(boolean exitoso) {
		ResultadoOperacion resultOp = new ResultadoOperacion();
		resultOp.setExitoso(exitoso);
		if(exitoso) {
			resultOp.setCodigo("OK");
		} else {
			resultOp.setCodigo("ERROR");
		}
		
		return resultOp;
	}

	public ConsultarPeticionesByIdServicioResponse toResponsePeticiones(
			List<Incidencia> incidencias) {
		ConsultarPeticionesByIdServicioResponse response = new ConsultarPeticionesByIdServicioResponse();
		response.getResultado().addAll(toResponse(incidencias));
		return response;
	}

	public ConsultarAveriasByIdServicioResponse toResponseAverias(List<Incidencia> incidencias) {
		ConsultarAveriasByIdServicioResponse response = new ConsultarAveriasByIdServicioResponse();
		response.getResultado().addAll(toResponse(incidencias));
		return response;
	}
	
	public List<IncidenciaResponse> toResponse(List<Incidencia> incidencias) {
		return incidencias.stream().map((incidencia) -> {
			return toResponse(incidencia);
		}).collect(Collectors.toList());
	}
	
	public IncidenciaResponse toResponse(Incidencia incidencia) {
		IncidenciaResponse response = new IncidenciaResponse();
		response.setCanal(incidencia.getCanal());
		response.setTitulo(incidencia.getTitulo());
		response.setDescripcion(incidencia.getDescripcion());
		response.setEstado(incidencia.getEstado());
		response.setTimestamp(incidencia.getTimestamp().toString());
		response.setFechaEstimadaResolucion(incidencia.getFechaEstimadaResolucion().toString());
		return response;
	}

	public ValidarEstadoServicioByIdResponse toError(String codigo, String descripcion) {
		ValidarEstadoServicioByIdResponse response = new ValidarEstadoServicioByIdResponse();
		Error error = new Error();
		error.setCodigo(codigo);
		error.setDescripcion(descripcion);
		
		response.setError(error);
		return response;
	}

	public ValidarEstadoServicioByIdResponse toResponse(EstadoServicioHadaDTO dto) {
		ValidarEstadoServicioByIdResponse response = new ValidarEstadoServicioByIdResponse();
		
		EstadoServicioHADA estado = new EstadoServicioHADA();
		estado.setBloqueado(dto.isBloqueado());
		
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		estado.setFechaBloqueo(sdf.format(dto.getFechaBloqueo()));
		estado.setMotivoBloqueo(dto.getMotivoBloqueo());
		
		response.setEstadoHADA(estado);
		return response;
	}

	public ValidarEstadoServicioByIdResponse toResponse(EstadoFinancieroServicioDTO dto) {
		ValidarEstadoServicioByIdResponse response = new ValidarEstadoServicioByIdResponse();
		
		EstadoFinancieroServicio estado = new EstadoFinancieroServicio();
		estado.setCodEstado(dto.getCodEstado());

		estado.setFechaSuspension(toString(dto.getFechaSuspension()));
		estado.setValorAPagar(dto.getValorAPagar());
		estado.setMotivoSuspension(dto.getMotivoSuspension());
		response.setEstadoFinanciero(estado);
		return response;
	}

	public ConsultarAfectacionFallaMasivaByIdServicioResponse toResponse(
			Optional<AfectadoFallaMasiva> posibleAfectadoFallaMasiva) {
		ConsultarAfectacionFallaMasivaByIdServicioResponse response = new ConsultarAfectacionFallaMasivaByIdServicioResponse();
		
		FallaMasivaResponse resultado = new FallaMasivaResponse();
		
		resultado.setExisteFallaMasivaAsociada(posibleAfectadoFallaMasiva.isPresent());
		
		if(resultado.isExisteFallaMasivaAsociada()) {
			AfectadoFallaMasiva afectadoFallaMasiva = posibleAfectadoFallaMasiva.get();
			
			FallaMasiva fm = afectadoFallaMasiva.getFallaMasiva();
			//poblar
			resultado.setServicioAfectado(afectadoFallaMasiva.getIdServicio());
			
			resultado.setEstado(fm.getEstado());
			resultado.setDescripcion(fm.getDescripcion());
			resultado.setTimestamp(toString(fm.getTimestamp()));
			resultado.setFechaEstimadaResolucion(toString(fm.getFechaActualizacion()));
			
		} 
		
		response.setResultado(resultado);
		return response;
	}
	
	private String toString(Timestamp ts) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(ts);
	}
	
	private String toString(Date d) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}

	
	

}
