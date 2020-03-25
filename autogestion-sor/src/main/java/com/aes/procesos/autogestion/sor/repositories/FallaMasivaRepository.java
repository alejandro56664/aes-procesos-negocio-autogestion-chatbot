package com.aes.procesos.autogestion.sor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.FallaMasiva;

@Repository
public interface FallaMasivaRepository extends JpaRepository<FallaMasiva, Long> {

	List<FallaMasiva> findByEstadoOrderByTimestampDesc(String estado);

}

