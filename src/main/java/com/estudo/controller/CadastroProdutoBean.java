package com.estudo.controller;


import java.io.Serializable;
import java.util.List;

import com.estudo.model.Categoria;
import com.estudo.model.Produto;
import com.estudo.repository.Categorias;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;

	private Produto produto;
	private List<Categoria> categoriaRaizes;
	
	
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar(){
		
		categoriaRaizes = categorias.raizes();
	}
	
	public void salvar() {
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriaRaizes() {
		return categoriaRaizes;
	}


	

}