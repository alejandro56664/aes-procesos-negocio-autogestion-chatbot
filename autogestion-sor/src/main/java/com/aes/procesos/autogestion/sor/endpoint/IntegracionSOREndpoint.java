package com.aes.procesos.autogestion.sor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.aes.procesos.autogestion.sor.service.EjecutorAccionCorrectivaService;
import com.aes.procesos.autogestion.sor.service.GestorFallaMasivaService;
import com.aes.procesos.autogestion.sor.service.GestorIncidenciaService;
import com.aes.procesos.autogestion.sor.service.ValidadorTecnicoService;
import com.aes.procesos.autogestion.sor.util.Normalizador;
import com.aes.procesos.autogestion.sor.util.Traductor;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAfectacionFallaMasivaByIdServicioRequest;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAfectacionFallaMasivaByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAveriasByIdServicioRequest;
import com.aes.procesos.autogestion_integracion_sor.ConsultarAveriasByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.ConsultarPeticionesByIdServicioRequest;
import com.aes.procesos.autogestion_integracion_sor.ConsultarPeticionesByIdServicioResponse;
import com.aes.procesos.autogestion_integracion_sor.EjecutarAccionCorrectivaAutomaticaRequest;
import com.aes.procesos.autogestion_integracion_sor.EjecutarAccionCorrectivaAutomaticaResponse;
import com.aes.procesos.autogestion_integracion_sor.GenerarAveriaRequest;
import com.aes.procesos.autogestion_integracion_sor.GenerarAveriaResponse;
import com.aes.procesos.autogestion_integracion_sor.GenerarPeticionRequest;
import com.aes.procesos.autogestion_integracion_sor.GenerarPeticionResponse;
import com.aes.procesos.autogestion_integracion_sor.RegistrarAuditoriaRequest;
import com.aes.procesos.autogestion_integracion_sor.RegistrarAuditoriaResponse;
import com.aes.procesos.autogestion_integracion_sor.RegistrarSatisfaccionRequest;
import com.aes.procesos.autogestion_integracion_sor.RegistrarSatisfaccionResponse;
import com.aes.procesos.autogestion_integracion_sor.ValidarEstadoServicioByIdRequest;
import com.aes.procesos.autogestion_integracion_sor.ValidarEstadoServicioByIdResponse;


@Endpoint
public class IntegracionSOREndpoint {
	private static final String NAMESPACE_URI = "http://aes.com/procesos/autogestion-integracion-sor";
	
	@Autowired
	private ValidadorTecnicoService validadorTecnico;
	
	@Autowired
	private EjecutorAccionCorrectivaService ejecutorAccionCorrectiva;
	
	@Autowired
	private GestorIncidenciaService gestorIncidencia;
	
	@Autowired
	private GestorFallaMasivaService gestorFallaMasiva;

	@Autowired
	private Traductor traductor;
	
	@Autowired
	private Normalizador normalizador;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validarEstadoServicioByIdRequest")
	@ResponsePayload
	public ValidarEstadoServicioByIdResponse validarEstadoServicio(@RequestPayload ValidarEstadoServicioByIdRequest request) {
		switch(request.getTipoValidacion()) {
		case GENERAL:
			return traductor.toResponse(validadorTecnico.validarEstadoServicioContratado(normalizador.normalizar(request.getIdServicio())));
			
		case HADA:
			return traductor.toResponse(validadorTecnico.validarEstadoServicioEnHADA(normalizador.normalizar(request.getIdServicio())));

		case FINANCIERO:
			return traductor.toResponse(validadorTecnico.validarEstadoFinancieroServicio(normalizador.normalizar(request.getIdServicio())));
			
		default:
			return traductor.toError("Tipo Validacion Desconocido", "Tipo Validacion Desconocido");
	 
		}
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ejecutarAccionCorrectivaAutomaticaRequest")
	@ResponsePayload
	public EjecutarAccionCorrectivaAutomaticaResponse ejecutarAccionCorrectivaAutomatica(@RequestPayload EjecutarAccionCorrectivaAutomaticaRequest request) {
		
		return traductor.toResponse(ejecutorAccionCorrectiva.ejecutar(normalizador.normalizar(request.getIdServicio()), request.getAccion().toString()));
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generarPeticionRequest")
	@ResponsePayload
	public GenerarPeticionResponse generarPeticion(@RequestPayload GenerarPeticionRequest request) {
		
		Long id;
		id = gestorIncidencia.generarPeticion(normalizador.normalizar(request.getIdServicio()), 
													request.getTitulo(), 
													request.getDescripcion(),
													request.getCanal());
		
		GenerarPeticionResponse response = new GenerarPeticionResponse();
		response.setResultado(traductor.toResultadoRegistro(id));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registrarSatisfaccionRequest")
	@ResponsePayload
	public RegistrarSatisfaccionResponse registrarSatisfaccion(@RequestPayload RegistrarSatisfaccionRequest request) {
		
		Long id;
		id = gestorIncidencia.registrarSatisfaccion(normalizador.normalizar(request.getIdServicio()), 
														request.getCodSatisfaccion(),
														request.getSesion());
		
		RegistrarSatisfaccionResponse response = new RegistrarSatisfaccionResponse();
		response.setResultado(traductor.toResultadoRegistro(id));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registrarAuditoriaRequest")
	@ResponsePayload
	public RegistrarAuditoriaResponse registrarAuditoria(@RequestPayload RegistrarAuditoriaRequest request) {
		
		Long id;
		id = gestorIncidencia.registrarAuditoria(normalizador.normalizar(request.getIdServicio()), 
														request.getCodigo(),
														request.getMensaje(),
														request.getSesion());
		
		RegistrarAuditoriaResponse response = new RegistrarAuditoriaResponse();
		response.setResultado(traductor.toResultadoRegistro(id));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generarAveriaRequest")
	@ResponsePayload
	public GenerarAveriaResponse generarAveria(@RequestPayload GenerarAveriaRequest request) {
		
		Long id;
		id = gestorIncidencia.generarAveria(normalizador.normalizar(request.getIdServicio()), 
													request.getTitulo(), 
													request.getDescripcion(),
													request.getCanal());
		
		GenerarAveriaResponse response = new GenerarAveriaResponse();
		response.setResultado(traductor.toResultadoRegistro(id));
		return response;
	}
	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "consultarPeticionesByIdServicioRequest")
	@ResponsePayload
	public ConsultarPeticionesByIdServicioResponse consultarPeticionesByIdServicio(@RequestPayload ConsultarPeticionesByIdServicioRequest request) {

		return traductor.toResponsePeticiones(gestorIncidencia.traerPeticiones(normalizador.normalizar(request.getIdServicio()), request.getEstado()));
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "consultarAveriasByIdServicioRequest")
	@ResponsePayload
	public ConsultarAveriasByIdServicioResponse consultarAveriasByIdServicio(@RequestPayload ConsultarAveriasByIdServicioRequest request) {

		return traductor.toResponseAverias(gestorIncidencia.traerAverias(normalizador.normalizar(request.getIdServicio()), request.getEstado()));
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "consultarAfectacionFallaMasivaByIdServicioRequest")
	@ResponsePayload
	public ConsultarAfectacionFallaMasivaByIdServicioResponse consultarAfectacionFallaMasivaByIdServicio(@RequestPayload ConsultarAfectacionFallaMasivaByIdServicioRequest request) {

		return traductor.toResponse(gestorFallaMasiva.buscarFallaMasivaByIdServicio(normalizador.normalizar(request.getIdServicio())));
	}
}
