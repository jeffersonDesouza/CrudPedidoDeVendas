import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.estudo.model.Categoria;
import com.estudo.model.Cliente;
import com.estudo.model.Endereco;
import com.estudo.model.GrupoUsuario;
import com.estudo.model.Produto;
import com.estudo.model.Usuario;
import com.estudo.util.design_patterns.ClienteBuilder;
import com.estudo.util.design_patterns.EnderecoBuilder;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Endereco endereco = new EnderecoBuilder()
									.comCep("075993939-2")
									.comCidade("Patos")
									.comComplemento("casa")
									.comlogradouro("rua")
									.comNumero("123")
									.comUf("PB")
									.construir();

		Endereco endereco2 = new EnderecoBuilder()
									.comCep("4553434-2")
									.comCidade("Santa")
									.comComplemento("ap")
									.comlogradouro("av")
									.comNumero("546")
									.comUf("PE")
									.construir();		
		
		
		Cliente cliente = new ClienteBuilder()
								.comNome("Mané de Côco")
								.comDocumentoReceita("222.434.777-90")
								.comEmail("manedecoco@gmail.com")
								.comTipoPessoaFisia()
								.comEndereco(endereco)
								.comEndereco(endereco2)
								.construir();
	
		endereco.setCliente(cliente);
		endereco2.setCliente(cliente);
			
		
		Usuario usuario = new Usuario();
		usuario.setNome("Maria");
		usuario.setEmail("maria@abadia.com");
		usuario.setSenha("123");

		GrupoUsuario grupo = new GrupoUsuario();
		grupo.setNome("Vendedores");
		grupo.setDescricao("Vendedores da empresa");

		usuario.getGrupoUsuarios().add(grupo);

		manager.persist(usuario);

		
		
		

		manager.persist(cliente);

		
		
		
		// instanciamos a categoria pai (Bebidas)
		Categoria categoriaPai = new Categoria();
		categoriaPai.setDescricao("Bebidas");
				
		// instanciamos a categoria filha (Refrigerantes)
		Categoria categoriaFilha = new Categoria();
		categoriaFilha.setDescricao("Refrigerantes");
		categoriaFilha.setCategoriaPai(categoriaPai);
				
		// adicionamos a categoria Refrigerantes como filha de Bebidas
		categoriaPai.getSubcategorias().add(categoriaFilha);
				
		// ao persistir a categoria pai (Refrigerantes), a filha (Bebidas) 
		// deve ser persistida também
		manager.persist(categoriaPai);
				
		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setCategoria(categoriaFilha);
		produto.setNome("Guaraná 2L");
		produto.setQuantidadeEstoque(10);
		produto.setSku("GUA00123");
		produto.setValorUnitario(new BigDecimal(2.21));
		
		
		
		trx.commit();

	}
}
