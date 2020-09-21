package com.style3.evento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.style3.evento.model.Convidado;
import com.style3.evento.repository.ConvidadosRepository;

public class ConvidadoService implements CRUDGenerico{
	
	@Autowired
	ConvidadosRepository convidadosRepository;
	
	@Override
	public List<Convidado> findAll() {
		return convidadosRepository.findAll();
	}

	@Override
	public Convidado findById(long id) {
		return convidadosRepository.findById(id).get();
		
	}

	@Override
	public Convidado save(Convidado convidado) {
		
		return convidadosRepository.save(convidado);
	}

}
