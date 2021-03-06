package com.estudo.util.design_patterns;

import com.estudo.model.Cliente;
import com.estudo.model.Endereco;
import com.estudo.model.TipoPessoa;

public class ClienteBuilder {

	private Cliente instanciaCliente;

	public ClienteBuilder() {
		this.instanciaCliente = new Cliente();
	}

	public Cliente construir() {
		return this.instanciaCliente;
	}

	public ClienteBuilder comNome(String nome) {

		this.instanciaCliente.setNome(nome);

		return this;
	}

	public ClienteBuilder comEmail(String email) {

		this.instanciaCliente.setEmail(email);
		return this;
	}

	public ClienteBuilder comDocumentoReceita(String doc) {

		this.instanciaCliente.setDocumentoReceitaFederal(doc);
		return this;
	}

	public ClienteBuilder comTipoPessoaFisia() {
		this.instanciaCliente.setTipo(TipoPessoa.FISICA);
		return this;
	}

	public ClienteBuilder comTipoPessoaJuridica() {
		this.instanciaCliente.setTipo(TipoPessoa.JURIDICA);
		return this;
	}

	public ClienteBuilder comEndereco(Endereco endereco) {
		
		this.instanciaCliente.getEnderecos().add(endereco);
		
		return this;
	}
	
	
}
