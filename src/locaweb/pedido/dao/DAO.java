package locaweb.pedido.dao;

public interface DAO<T,K> {
	
	void inserir(T entidade);
	
	void remover(T endidade);
	
	void atualizar(T entidade);
	
	T consultar(K id);
	
	

}
