package locaweb.pedido.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import locaweb.pedido.dao.NotaFiscalDAO;
import locaweb.pedido.entidade.Cliente;
import locaweb.pedido.entidade.NotaFiscal;
import locaweb.pedido.entidade.Pedido;

public class NotaFiscalDAOImpl extends DAOImpl<NotaFiscal,Integer> implements NotaFiscalDAO{

	public NotaFiscalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public NotaFiscal GerarNotaFiscal(Cliente cliente) {
		
		NotaFiscalDAO notaDao = new NotaFiscalDAOImpl(em);
		// Cria Nota
		NotaFiscal nota = new NotaFiscal();
		// Pega data atual
		Calendar dataEmissao = Calendar.getInstance();
		// Busca Pedidos do cliente
		TypedQuery<Pedido> query = em.createQuery("from Pedido p where p.cliente.id = :id", Pedido.class);
		query.setParameter("id", cliente.getId());
		List<Pedido> pedidos = query.getResultList();
		// Calcula os valores
		float valorBruto = 0;
		float valorImpostos = 0;
		List<Pedido> pedidosNota = new ArrayList<Pedido>();
		// Itera os pedidos evitando os produtos com alicota zero
		for (Pedido pedido : pedidos) {
			if(pedido.getAliquota() !=0){
				valorBruto = (float) (valorBruto + pedido.getValorUnitario()*pedido.getQuantidade());
				valorImpostos = (float) (valorImpostos +(pedido.getQuantidade() * (pedido.getValorUnitario() * pedido.getAliquota())));
				pedidosNota.add(pedido);
			} else {
				System.out.println("Produto " + pedido.getTipoProduto() + " com aliquota 0%");
			}				
				// Guarda os valores
				nota.setCliente(cliente);
				nota.setDataEmissao(dataEmissao);
				nota.setValorBruto(valorBruto);
				nota.setPedidos(pedidosNota);
				nota.setValorImpostos(valorImpostos);
				
				if(pedido != null){
					notaDao.inserir(nota);	
				}
		}
		return nota;

	}

	@Override
	public List<NotaFiscal> NotasFiscaisCliente(int id) {
		TypedQuery<NotaFiscal> query = em.createQuery("from NotaFiscal n where n.cliente.id = :id", NotaFiscal.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
}
