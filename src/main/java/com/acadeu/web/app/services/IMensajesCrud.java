package com.acadeu.web.app.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acadeu.web.app.entity.Mensajes;

public interface IMensajesCrud extends CrudRepository<Mensajes, Long> {

	@Query(value="SELECT * FROM mensajes WHERE hacia =:searchTerm", nativeQuery = true)
	public List<Mensajes> findRecibidosByUsername(@Param("searchTerm") String searchTerm);
	
	@Query(value="SELECT * FROM mensajes WHERE desde =:searchTerm", nativeQuery = true)
	public List<Mensajes> findEnviadosByUsername(@Param("searchTerm") String searchTerm);
}
