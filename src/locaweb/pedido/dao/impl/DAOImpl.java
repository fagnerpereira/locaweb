package locaweb.pedido.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import locaweb.pedido.dao.DAO;

public abstract class DAOImpl<T,K> implements DAO<T,K>{
	
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("all")
	public DAOImpl(EntityManager entityManager){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass() 
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
		this.em = entityManager;
	}

	@Override
	public void inserir(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@Override
	public void remover(T endidade) {
		em.getTransaction().begin();
		em.remove(endidade);
		em.getTransaction().commit();
	}

	@Override
	public void atualizar(T entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}

	@Override
	public T consultar(K id) {
		return em.find(entityClass, id);
	}

}
