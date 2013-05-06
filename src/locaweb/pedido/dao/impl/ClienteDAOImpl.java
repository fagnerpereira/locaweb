package locaweb.pedido.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import locaweb.pedido.dao.ClienteDAO;
import locaweb.pedido.entidade.Cliente;


public class ClienteDAOImpl extends DAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> consultarClientes() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c", Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> semNotaFiscal() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.notaFiscal is null", Cliente.class);
		return query.getResultList();
	}

}
