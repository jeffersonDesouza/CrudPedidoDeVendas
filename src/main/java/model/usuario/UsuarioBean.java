package model.usuario;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private String tipoDocumento;

	private TipoPermissaoUsuario[] tiposDePermicaoUsuario = TipoPermissaoUsuario.values();
	

	private List<String> permisoes = Arrays.asList("GERENTE","ADMINISTRADOR");
	
	
	public List<String> getPermisoes() {
		return permisoes;
	}

	public TipoPermissaoUsuario[] getTiposDePermicaoUsuario() {
		return tiposDePermicaoUsuario;
	}

	public boolean isCPF(){
		if(this.tipoDocumento!= null){
			return this.tipoDocumento.equals("cpf");
		}
		return false;
	}
	
	public boolean isCNPJ(){
		if(this.tipoDocumento!= null){
			return this.tipoDocumento.equals("cnpj");
		}
		return false;
	}
	
	
	public void atualizar() {
		isCNPJ();
		isCPF();
		System.out.println("Tipo: " + this.tipoDocumento);
		System.out.println("Tipo cpf: " + isCPF());
		System.out.println("Tipo cnpj: " + isCNPJ());
		
		
		
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado"));
	}
	
	public String getTipoCliente() {
		return tipoDocumento;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoDocumento = tipoCliente;
	}

	@Override
	public String toString() {
		return "ClienteBean [tipoDocumento=" + tipoDocumento + "]";
	}
	
	
}
