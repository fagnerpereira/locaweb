package locaweb.pedido.entidade;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_NOTA_FISCAL")
@SequenceGenerator(name="nota", allocationSize=1, sequenceName="seq_nota")
public class NotaFiscal {

	@Id
	@GeneratedValue(generator="nota", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataEmissao;
	
	@Column(nullable=false)
	private float valorBruto;
	
	@Column(nullable=false)
	private float valorImpostos;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_pedido")
	private List<Pedido> pedidos;
	
	public NotaFiscal(){}

	public NotaFiscal(Calendar dataEmissao, float valorBruto,
		float valorImpostos, Cliente cliente) {
	this.dataEmissao = dataEmissao;
	this.valorBruto = valorBruto;
	this.valorImpostos = valorImpostos;
	this.cliente = cliente;
}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(float valorBruto) {
		this.valorBruto = valorBruto;
	}
	public double getValorImpostos() {
		return valorImpostos;
	}
	public void setValorImpostos(float valorImpostos) {
		this.valorImpostos = valorImpostos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
