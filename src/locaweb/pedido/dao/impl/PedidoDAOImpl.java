package locaweb.pedido.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import locaweb.pedido.dao.PedidoDAO;
import locaweb.pedido.entidade.Pedido;

public class PedidoDAOImpl extends DAOImpl<Pedido,Integer> implements PedidoDAO{

	public PedidoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pedido> consultarPedidos() {
		TypedQuery<Pedido> query = em.createQuery("from Pedido p", Pedido.class);
		return query.getResultList();
	}

	@Override
	public List<Pedido> consultarPedidosDecrescente() {
		TypedQuery<Pedido> query = em.createQuery("from Pedido p order by desc p.quantidade", Pedido.class);
		return query.getResultList();
	}

}
