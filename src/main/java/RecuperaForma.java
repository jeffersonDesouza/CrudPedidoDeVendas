import javax.inject.Inject;
import javax.inject.Named;


@Named
public class RecuperaForma {
	
	@Inject 
	private FormaGeometrica formaGeometrica;
		
	public String getForma(){
		return formaGeometrica.nomeForma();
	}
	
}
