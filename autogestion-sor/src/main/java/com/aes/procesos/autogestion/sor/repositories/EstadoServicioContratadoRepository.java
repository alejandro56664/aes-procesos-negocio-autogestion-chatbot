package com.aes.procesos.autogestion.sor.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.EstadoServicioContratado;
import com.aes.procesos.autogestion.sor.model.ServicioContratado;

@Repository
public interface EstadoServicioContratadoRepository extends JpaRepository<EstadoServicioContratado, Long> {

	List<EstadoServicioContratado> findByServicioContratadoOrderByTimestampDesc(ServicioContratado servicio);
	List<EstadoServicioContratado> findByServicioContratadoAndCodigoOrderByTimestampDesc(ServicioContratado servicio, String codigo);


}
