package com.aes.procesos.autogestion.sor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.AfectadoFallaMasiva;
import com.aes.procesos.autogestion.sor.model.FallaMasiva;

@Repository
public interface AfectadoFallaMasivaRepository extends JpaRepository<AfectadoFallaMasiva, Long> {

	Optional<AfectadoFallaMasiva> findByFallaMasivaAndIdServicio(FallaMasiva fallaMasiva, String idServicio);

}

