package com.aes.procesos.autogestion.sor.util;

import org.springframework.stereotype.Service;
@Service
public class Normalizador {

	public String normalizar(String idService) {
		return idService.replaceAll("[^0-9]", "");
	}
	
	

}
