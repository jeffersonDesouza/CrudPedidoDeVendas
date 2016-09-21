package persistencia;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.estudo.model.Cliente;
import com.estudo.model.EnderecoEntrega;
import com.estudo.model.FormaPagamento;
import com.estudo.model.GrupoUsuario;
import com.estudo.model.ItemPedido;
import com.estudo.model.Pedido;
import com.estudo.model.Produto;
import com.estudo.model.StatusPedido;
import com.estudo.model.Usuario;

public class TestesPersistencia {

	
	
	@BeforeClass
	public static void criandoEntityManager(){
		
	}
	
	@Test
	public void PersistindoUsuariosCadasrados() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Cliente cliente = manager.find(Cliente.class, 1L);
		Produto produto = manager.find(Produto.class, 1L);
		Usuario vendedor = manager.find(Usuario.class, 1L);
		
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("Rua dos Mercados");
		enderecoEntrega.setNumero("1000");
		enderecoEntrega.setCidade("Uberlândia");
		enderecoEntrega.setUf("MG");
		enderecoEntrega.setCep("38400-123");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setFormaDePagamento(FormaPagamento.CARTAO_CREDITO);
		pedido.setObservacao("Aberto das 08 às 18h");
		pedido.setStatusPedido(StatusPedido.ORCAMENTO);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(23.2));
		pedido.setVendedor(vendedor);
		pedido.setEnderecoEntrega(enderecoEntrega);
		
		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		item.setQuantidade(10);
		item.setValorUnitatrio(new BigDecimal(2.32));
		item.setPedido(pedido);
		
		pedido.getItemPedidos().add(item);
		
		manager.persist(pedido);
		
		
		trx.commit();
		
	
	}

}
