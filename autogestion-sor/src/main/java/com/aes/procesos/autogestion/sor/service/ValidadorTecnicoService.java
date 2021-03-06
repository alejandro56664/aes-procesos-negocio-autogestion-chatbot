package com.aes.procesos.autogestion.sor.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.sor.model.EstadoServicioContratado;
import com.aes.procesos.autogestion.sor.model.ServicioContratado;
import com.aes.procesos.autogestion.sor.model.dto.EstadoFinancieroServicioDTO;
import com.aes.procesos.autogestion.sor.model.dto.EstadoServicioContratadoDTO;
import com.aes.procesos.autogestion.sor.model.dto.EstadoServicioHadaDTO;
import com.aes.procesos.autogestion.sor.repositories.EstadoServicioContratadoRepository;
import com.aes.procesos.autogestion.sor.repositories.ServicioContratadoRepository;

@Service
public class ValidadorTecnicoService {
	
	@Autowired
	private EstadoServicioContratadoRepository estadoServicioRepo;
	
	@Autowired
	private ServicioContratadoRepository servicioRepo;

	public EstadoServicioContratadoDTO validarEstadoServicioContratado(String idServicio) {
		EstadoServicioContratadoDTO estadoDTO = new EstadoServicioContratadoDTO();
		
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		List<EstadoServicioContratado> estadosServicio = estadoServicioRepo.findByServicioContratadoOrderByTimestampDesc(servicioContratado);
		
		//validamos si el ultimo estado es activo o inactivo
		EstadoServicioContratado ultimoEstado = estadosServicio.get(0);
		boolean activo = ultimoEstado.getEstado().equalsIgnoreCase("ACTIVO");
		
		estadoDTO.setActivo(activo);
		estadoDTO.setDescripcionPlan(servicioContratado.getTipoServicio().getDescripcion());
		//empaquetado
		if(activo) {
			estadoDTO.setFechaCorte(calcularFechaCorte(servicioContratado.getTipoServicio().getCorte()));
			estadoDTO.setValorAPagar(servicioContratado.getTipoServicio().getValor());
		} else {
			estadoDTO.setFechaSuspension(ultimoEstado.getTimestamp());
			estadoDTO.setMotivoSuspension(ultimoEstado.getDescripcion());
		}
		

		return estadoDTO;
	}

	private Date calcularFechaCorte(int corte) {
		Calendar calendar = Calendar.getInstance();
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(corte < day) {
			calendar.add(Calendar.MONTH, 1);
		}
		calendar.set(Calendar.DAY_OF_MONTH, corte);
		return calendar.getTime();
		
	}

	public EstadoServicioHadaDTO  validarEstadoServicioEnHADA(String idServicio) {
		EstadoServicioHadaDTO resultado = new EstadoServicioHadaDTO();
		
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		List<EstadoServicioContratado> estadosServicio = estadoServicioRepo.findByServicioContratadoAndCodigoOrderByTimestampDesc(servicioContratado, "HADA");
		boolean bloqueado = false;
		String motivos = "";
		Timestamp fechaBloqueo = new Timestamp(0l);;
		//hay estados relacionados con HADA
		if(!estadosServicio.isEmpty()) {
			EstadoServicioContratado ultimoEstado = estadosServicio.get(0);
			bloqueado = ultimoEstado.getEstado().equalsIgnoreCase("BLOQUEADO");
			motivos = ultimoEstado.getDescripcion();
			fechaBloqueo = ultimoEstado.getTimestamp();
		}

		
		resultado.setBloqueado(bloqueado);
		resultado.setMotivoBloqueo(motivos);
		resultado.setFechaBloqueo(fechaBloqueo);
		return resultado;
	}

	public EstadoFinancieroServicioDTO validarEstadoFinancieroServicio(String idServicio) {
		EstadoFinancieroServicioDTO resultado = new EstadoFinancieroServicioDTO();
		
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		List<EstadoServicioContratado> estadosServicio = estadoServicioRepo.findByServicioContratadoAndCodigoOrderByTimestampDesc(servicioContratado, "FINANCIERO");
		String estado = "NO_SUSPENDIDO";
		String motivos = "";
		Timestamp fechasuspension = new Timestamp(0l);
		//hay estados relacionados con HADA
		if(!estadosServicio.isEmpty()) {
			EstadoServicioContratado ultimoEstado = estadosServicio.get(0);
			estado = ultimoEstado.getEstado();
			motivos = ultimoEstado.getDescripcion();
			fechasuspension = ultimoEstado.getTimestamp();
		}

		
		resultado.setCodEstado(estado);
		resultado.setMotivoSuspension(motivos);
		resultado.setFechaSuspension(fechasuspension);
		return resultado;
	}
}
