package locaweb.pedido.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_PEDIDO")
@SequenceGenerator(name="pedido", allocationSize=1, sequenceName="seq_pedido")
public class Pedido {

	@Id
	@GeneratedValue(generator="pedido", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false)
	private String tipoProduto;
	
	@Column(nullable=false)
	private int quantidade;
	
	@Column(nullable=false)
	private float valorUnitario;
	
	@Column(nullable=false)
	private float aliquota;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	public Pedido(){}

	public Pedido(String tipoProduto, int quantidade,
			float valorUnitario, Cliente cliente, float aliquota) {
		this.tipoProduto = tipoProduto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.cliente = cliente;
		this.aliquota = aliquota;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}	
	public double getAliquota() {
		return aliquota/100;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
