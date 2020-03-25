package com.aes.procesos.autogestion.brms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aes.procesos.autogestion.brms.model.ServicioContratado;
import com.aes.procesos.autogestion.brms.service.ServicioContratadoService;

@RestController
public class RulesController {
	
	@Autowired
	private ServicioContratadoService productService;
	
	@PostMapping("/rules/{ruleID}/execute")
    public ServicioContratado execute(@Valid @RequestBody ServicioContratado product) {
        return productService.tipificacionPorNombreComercial(product);
    }
	
	@GetMapping("/rules/init")
    public ResponseEntity<?> init() {
		productService.init();
        return ResponseEntity.ok().build();
    }

}
