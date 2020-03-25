package com.aes.procesos.autogestion.sor.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.ServicioContratado;

@Repository
public interface ServicioContratadoRepository extends JpaRepository<ServicioContratado, Long> {

	ServicioContratado findByIdServicio(String idServicio);
	
	

}
