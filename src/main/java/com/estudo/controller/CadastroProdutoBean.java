package com.estudo.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.estudo.service.NegocioException;

@Named
@RequestScoped
public class CadastroProdutoBean {
	
	
	double valor;
	
	public double getValor(){
		return valor;
	}
	
	
	
	public void salvar(){
		throw new NegocioException("O CLIENTE não pode ser salvo pois ainda não foi implementado");
	}

}

