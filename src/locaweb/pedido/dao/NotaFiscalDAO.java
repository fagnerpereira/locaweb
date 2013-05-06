package locaweb.pedido.dao;

import java.util.List;

import locaweb.pedido.entidade.Cliente;
import locaweb.pedido.entidade.NotaFiscal;

public interface NotaFiscalDAO extends DAO<NotaFiscal,Integer>{
	
	NotaFiscal GerarNotaFiscal(Cliente cliente);
	
	List<NotaFiscal> NotasFiscaisCliente(int id);

}
