package com.estudo.util.design_patterns;

import com.estudo.controller.model.Cliente;
import com.estudo.controller.model.Endereco;

public class EnderecoBuilder {

	private Endereco instanciaEndereco;

	public EnderecoBuilder() {
		this.instanciaEndereco = new Endereco();
	}
	
	public Endereco construir() {
		return this.instanciaEndereco;
	}
	

	public EnderecoBuilder comCep(String cep) {
		this.instanciaEndereco.setCep(cep);

		return this;
	}

	public EnderecoBuilder comCidade(String cidade) {
		this.instanciaEndereco.setCidade(cidade);

		return this;
	}

	public EnderecoBuilder comCliente(Cliente cliente) {
		this.instanciaEndereco.setCliente(cliente);

		return this;
	}

	public EnderecoBuilder comComplemento(String complemento) {
		this.instanciaEndereco.setComplemento(complemento);

		return this;
	}

	public EnderecoBuilder comlogradouro(String logradouro) {

		this.instanciaEndereco.setLogradouro(logradouro);
		return this;
	}

	public EnderecoBuilder comNumero(String numero) {

		this.instanciaEndereco.setNumero(numero);
		return this;
	}

	public EnderecoBuilder comUf(String uf) {

		this.instanciaEndereco.setUf(uf);
		return this;
	}

}
