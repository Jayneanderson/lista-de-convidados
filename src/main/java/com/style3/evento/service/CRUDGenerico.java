package com.style3.evento.service;

import java.util.List;

import com.style3.evento.model.Convidado;

public interface CRUDGenerico{
	
	List<Convidado> findAll();
	Convidado findById(long id);
	Convidado save(Convidado Convidado);
}
