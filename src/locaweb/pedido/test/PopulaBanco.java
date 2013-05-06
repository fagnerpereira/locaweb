package locaweb.pedido.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import locaweb.pedido.dao.ClienteDAO;
import locaweb.pedido.dao.NotaFiscalDAO;
import locaweb.pedido.dao.PedidoDAO;
import locaweb.pedido.dao.impl.ClienteDAOImpl;
import locaweb.pedido.dao.impl.NotaFiscalDAOImpl;
import locaweb.pedido.dao.impl.PedidoDAOImpl;
import locaweb.pedido.dao.singleton.EntityManagerFactorySingleton;
import locaweb.pedido.entidade.Cliente;
import locaweb.pedido.entidade.Documento;
import locaweb.pedido.entidade.NotaFiscal;
import locaweb.pedido.entidade.Pedido;

import org.junit.Test;

public class PopulaBanco {
	
	@Test
	public void inserir(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		PedidoDAO pedidoDao = new PedidoDAOImpl(em);
		NotaFiscalDAO notaDao = new NotaFiscalDAOImpl(em);
		
		//Inserindo Clientes
		Calendar dataCadastro = Calendar.getInstance();
		dataCadastro.set(2013, 4, 1);
		Cliente cliente1 = new Cliente("Wellington Ribeiro", "wrs@email.com", "40028923", dataCadastro, Documento.CPF, "111.111.111-11");
		Cliente cliente2 = new Cliente("Gabriel Rodrigo", "biel@email.com", "40028924", dataCadastro, Documento.CPF, "222.222.222-22");
		Cliente cliente3 = new Cliente("Isabelle Tavares", "isa@email.com", "40028925", dataCadastro, Documento.CPF, "333.333.333-33");
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		clienteDao.inserir(cliente1);
		clienteDao.inserir(cliente2);
		clienteDao.inserir(cliente3);
		assertNotNull(cliente1.getId());
		assertNotNull(cliente2.getId());
		assertNotNull(cliente3.getId());
		
		//Inserindo Pedidos
		Pedido pedido1 = new Pedido("Hospedagem", 2, 20.00f, cliente2, 0);
		Pedido pedido2 = new Pedido("Servidor Cloud", 3, 50.00f, cliente1, 5);
		Pedido pedido3 = new Pedido("Loja Virtual", 10, 50.00f, cliente1, 5);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		pedidos.add(pedido3);
		
		pedidoDao.inserir(pedido1);
		pedidoDao.inserir(pedido2);
		pedidoDao.inserir(pedido3);
		assertNotNull(pedido1.getId());
		assertNotNull(pedido2.getId());
		assertNotNull(pedido3.getId());
		


	}
	

	

}
