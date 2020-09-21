package com.style3.evento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.style3.evento.model.Convidado;
import com.style3.evento.repository.ConvidadosRepository;

@Controller

public class ConvidadosController {
	
	@Autowired
	ConvidadosRepository convidadosRepository;
	
	@RequestMapping(value="/convidados", method = RequestMethod.GET)
	public ModelAndView listarConvidados() {
		ModelAndView modelView = new ModelAndView("listaconvidados");//referenciando a view que receberá a lista e o novo convidado
		modelView.addObject("apelidoConvidado", convidadosRepository.findAll()); //listando convidados na view
		modelView.addObject(new Convidado()); //adicionando novo convidado
		return modelView;
	}
	
	@RequestMapping(value="/convidados", method = RequestMethod.POST)
	public ModelAndView salvarConvidado(@Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			ModelAndView modelView = new ModelAndView("listaconvidados");//referenciando a view que receberá a lista e o novo convidado
			modelView.addObject("apelidoConvidado", convidadosRepository.findAll()); //listando convidados na view
			modelView.addObject(convidado);
			
			List<String> mensagem = new ArrayList<String>();
			for(ObjectError objectError: result.getAllErrors()) {
				mensagem.add(objectError.getDefaultMessage());
			}
			
			modelView.addObject("mensagem", mensagem);
			return modelView;
			
		}
		
		convidadosRepository.save(convidado);	
	
		ModelAndView modelView = new ModelAndView("listaconvidados");//referenciando a view que receberá a lista e o novo convidado
		modelView.addObject("apelidoConvidado", convidadosRepository.findAll()); //listando convidados na view
		modelView.addObject(convidado);
		
		return modelView;
	}

}
