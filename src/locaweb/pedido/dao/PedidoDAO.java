package locaweb.pedido.dao;

import java.util.List;

import locaweb.pedido.entidade.Pedido;

public interface PedidoDAO extends DAO<Pedido,Integer>{
	
	List<Pedido> consultarPedidos();
	
	List<Pedido> consultarPedidosDecrescente();

}
