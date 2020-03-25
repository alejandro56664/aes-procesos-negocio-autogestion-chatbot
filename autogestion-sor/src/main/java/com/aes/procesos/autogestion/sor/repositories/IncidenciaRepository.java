package com.aes.procesos.autogestion.sor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aes.procesos.autogestion.sor.model.Incidencia;
import com.aes.procesos.autogestion.sor.model.ServicioContratado;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

	List<Incidencia> findByServicioContratadoAndTipoIncidenciaAndEstado(ServicioContratado servicioContratado,
			String tipoIncidencia, String estado);

}

