package com.aes.procesos.autogestion.sor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aes.procesos.autogestion.sor.model.AfectadoFallaMasiva;
import com.aes.procesos.autogestion.sor.model.FallaMasiva;
import com.aes.procesos.autogestion.sor.repositories.AfectadoFallaMasivaRepository;
import com.aes.procesos.autogestion.sor.repositories.FallaMasivaRepository;

@Service
public class GestorFallaMasivaService {
	
	@Autowired
	private FallaMasivaRepository fallaMasivaRepo;
	
	@Autowired
	private AfectadoFallaMasivaRepository afectadoRepo;
	
	
	public Optional<AfectadoFallaMasiva> buscarFallaMasivaByIdServicio(String idServicio) {

		//buscamos las fallas masivas abiertas
		List<FallaMasiva> listFallasMasivasAbiertas = fallaMasivaRepo.findByEstadoOrderByTimestampDesc("ABIERTA");
		
		for (FallaMasiva fallaMasiva: listFallasMasivasAbiertas) {
			Optional<AfectadoFallaMasiva> posibleAfectodFallaMasiva = afectadoRepo.findByFallaMasivaAndIdServicio(fallaMasiva, idServicio);
			if(posibleAfectodFallaMasiva.isPresent()) {
				return posibleAfectodFallaMasiva;
			}
		}

		return Optional.empty();
	}
}
