package com.aes.procesos.autogestion.brms.service;

import javax.annotation.PostConstruct;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.brms.config.DroolsBeanFactory;
import com.aes.procesos.autogestion.brms.model.ServicioContratado;

@Service
public class ServicioContratadoService {
	
	@Autowired
	private DroolsBeanFactory droolsBeanFactory;
	
	private KieSession kieSession;
	
	@PostConstruct
    public void init() {
		kieSession=droolsBeanFactory.getKieSession();
    }

    public ServicioContratado tipificacionPorNombreComercial(ServicioContratado servicio){
    	
        kieSession.insert(servicio);
        kieSession.fireAllRules();
        return servicio;

    }

}
