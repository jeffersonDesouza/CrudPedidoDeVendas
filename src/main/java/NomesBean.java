import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class NomesBean {
	
	private List<String> nomes = new ArrayList<>();
	

	
	public NomesBean() {
	
		nomes.add("Joso");
		nomes.add("Luiz");		
	}
	
	private String nome;
	
	
	public void addNome(){
		nomes.add(nome);
		
		getNomes();
		
	}	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	
	
	

	
	
}
