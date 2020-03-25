package com.aes.procesos.autogestion.sor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.RegistroAccionCorrectiva;

@Repository
public interface RegistroAccionCorrectivaRepository extends JpaRepository<RegistroAccionCorrectiva, Long> {

}

