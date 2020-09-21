package com.style3.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.style3.evento.model.Convidado;

public interface ConvidadosRepository extends JpaRepository<Convidado, Long> {

}
