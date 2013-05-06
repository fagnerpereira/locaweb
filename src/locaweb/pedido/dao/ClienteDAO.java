package locaweb.pedido.dao;

import java.util.List;

import locaweb.pedido.entidade.Cliente;

public interface ClienteDAO extends DAO<Cliente,Integer>{
	
	List<Cliente> consultarClientes();
	
	List<Cliente> semNotaFiscal();

}
