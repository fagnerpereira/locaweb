package locaweb.pedido.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import locaweb.pedido.dao.impl.ClienteDAOImpl;
import locaweb.pedido.dao.impl.NotaFiscalDAOImpl;
import locaweb.pedido.dao.impl.PedidoDAOImpl;
import locaweb.pedido.dao.singleton.EntityManagerFactorySingleton;
import locaweb.pedido.entidade.Cliente;
import locaweb.pedido.entidade.NotaFiscal;
import locaweb.pedido.entidade.Pedido;

public class GerarNotaFiscal {
	
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Cliente> clientes = new ClienteDAOImpl(em).consultarClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println("****************************************************");
			System.out.println("*                   CLIENTE                        *");
			System.out.println(cliente.getId());
			System.out.println(cliente.getNome());
			System.out.println(cliente.getNumeroDocumento());
			System.out.println(cliente.getEmail());
			System.out.println(cliente.getDataCadastro());
			System.out.println(cliente.getTipoDocumento());
			System.out.println(cliente.getTelefone());
			
			NotaFiscal nota = new NotaFiscalDAOImpl(em).GerarNotaFiscal(cliente);
			
			System.out.println("****************************************************");
			System.out.println("*                   NOTA FISCAL                    *");
			System.out.println(nota.getCliente().getId());

			System.out.println(nota.getId());
			System.out.println(nota.getDataEmissao());
			System.out.println(nota.getValorBruto());
			System.out.println(nota.getValorImpostos());
			
		}
		
	}
		
		
	}


