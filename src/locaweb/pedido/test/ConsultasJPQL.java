package locaweb.pedido.test;

import java.util.List;

import javax.persistence.EntityManager;

import locaweb.pedido.dao.impl.ClienteDAOImpl;
import locaweb.pedido.dao.impl.NotaFiscalDAOImpl;
import locaweb.pedido.dao.impl.PedidoDAOImpl;
import locaweb.pedido.dao.singleton.EntityManagerFactorySingleton;
import locaweb.pedido.entidade.Cliente;
import locaweb.pedido.entidade.NotaFiscal;
import locaweb.pedido.entidade.Pedido;



public class ConsultasJPQL {
	
	
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		// Consultando Clientes sem nota FIscal
		List<Cliente> clientesSemNota = new ClienteDAOImpl(em).semNotaFiscal();
		for (Cliente cliente : clientesSemNota) {
			System.out.println(cliente.getId());
			System.out.println(cliente.getNome());
			System.out.println(cliente.getEmail());
			System.out.println(cliente.getNumeroDocumento());
			System.out.println(cliente.getTipoDocumento());
			System.out.println(cliente.getTelefone());
			
		}
		
		// Consultando todos Clientes
		List<Cliente> todosClientes = new ClienteDAOImpl(em).consultarClientes();
		for (Cliente cliente : todosClientes) {
			System.out.println(cliente.getId());
			System.out.println(cliente.getNome());
			System.out.println(cliente.getEmail());
			System.out.println(cliente.getNumeroDocumento());
			System.out.println(cliente.getTipoDocumento());
			System.out.println(cliente.getTelefone());
			
		}
		
		// Consultando NotasFiscais por código do cliente
		List<NotaFiscal> notaFiscal = new NotaFiscalDAOImpl(em).NotasFiscaisCliente(1);
		for (NotaFiscal notaFiscal2 : notaFiscal) {
			System.out.println(notaFiscal2.getCliente().getId());
			System.out.println(notaFiscal2.getCliente().getNome());
			System.out.println(notaFiscal2.getId());
			System.out.println(notaFiscal2.getValorBruto());
			System.out.println(notaFiscal2.getValorImpostos());
			
		}
		
		// Consultando Pedidos por ordem decrescente
		List<Pedido> pedidos= new PedidoDAOImpl(em).consultarPedidosDecrescente();
		for (Pedido pedido : pedidos) {
			System.out.println(pedido.getId());
			System.out.println(pedido.getTipoProduto());
			System.out.println(pedido.getValorUnitario());
			System.out.println(pedido.getAliquota());
			System.out.println(pedido.getCliente().getId());
			System.out.println(pedido.getCliente().getNome());
		}
		
		// Consultando todos os clientes sem notaFiscal
		List<Cliente> clientes = new ClienteDAOImpl(em).semNotaFiscal();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getId());
			System.out.println(cliente.getNome());
			System.out.println(cliente.getEmail());
			System.out.println(cliente.getNumeroDocumento());
			System.out.println(cliente.getTipoDocumento());
			System.out.println(cliente.getTelefone());
			
		}

		
		
		
	}
	
}
	

