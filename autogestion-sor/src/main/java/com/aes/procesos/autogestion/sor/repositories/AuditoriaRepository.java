package com.aes.procesos.autogestion.sor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

}

