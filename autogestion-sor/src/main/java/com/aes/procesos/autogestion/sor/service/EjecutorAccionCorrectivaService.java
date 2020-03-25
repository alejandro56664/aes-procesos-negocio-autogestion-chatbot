package com.aes.procesos.autogestion.sor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.sor.model.ServicioContratado;
import com.aes.procesos.autogestion.sor.model.dto.ResultadoEjecucionAccionCorrectivaDTO;
import com.aes.procesos.autogestion.sor.repositories.RegistroAccionCorrectivaRepository;
import com.aes.procesos.autogestion.sor.repositories.ServicioContratadoRepository;
import com.aes.procesos.autogestion.sor.util.Traductor;

@Service
public class EjecutorAccionCorrectivaService {
	
	@Autowired
	private ServicioContratadoRepository servicioRepo;
	
	@Autowired
	private RegistroAccionCorrectivaRepository registro;
	
	@Autowired
	private Traductor traductor;


	public ResultadoEjecucionAccionCorrectivaDTO ejecutar(String idServicio, String accion) {
		ResultadoEjecucionAccionCorrectivaDTO resultado = ejecutarMock(idServicio, accion);
		
		ServicioContratado servicioContratado = servicioRepo.findByIdServicio(idServicio);
		//registrar resultado
		registro.save(traductor.toEntity(resultado, servicioContratado));
		
		return resultado;
	}
	
	
	
	/*
	 * Esta funcion emula los servicios externos que realizan las operaciones
	 */
	private ResultadoEjecucionAccionCorrectivaDTO ejecutarMock(String idServicio, String accion) {
		ResultadoEjecucionAccionCorrectivaDTO resultadoDTO = new ResultadoEjecucionAccionCorrectivaDTO();
		
		
		String codigo;
		String mensaje;
		
		//ejecutar la acción requerida
		try {
			Thread.sleep(1000L);
			
			//en caso de ejecución de pruebas fisicas vamos a dar un 50% de que falle
			if(accion.equalsIgnoreCase("EJECUTAR_PRUEBAS_FISICAS")) {
				codigo = (Math.random()>0.5) ? "OK" : "ERROR";
			} else {
				codigo = "OK";
			}
			mensaje = "Resultado operación: " +codigo;
			
		} catch (InterruptedException e) {
			codigo = "EXCEPTION";
			mensaje = e.getMessage();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();
		}

		//empaquetar
		resultadoDTO.setTipoAccion(accion);
		resultadoDTO.setCodigo(codigo);
		resultadoDTO.setMensaje(mensaje);
		
		return resultadoDTO;
		
	}

}
