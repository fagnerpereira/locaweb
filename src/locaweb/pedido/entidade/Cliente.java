package locaweb.pedido.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TAB_CLIENTE")
@SequenceGenerator(name="cliente", allocationSize=1, sequenceName="seq_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=true)
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	
	@Column(nullable=false)
	private Documento tipoDocumento;
	
	@Column(nullable=false)
	private String numeroDocumento;
	
	@OneToMany(mappedBy="cliente")
	private NotaFiscal notaFiscal;
	
	public Cliente(){}
	
	
	public Cliente(String nome, String email, String telefone,
			Calendar dataCadastro, Documento tipoDocumento,
			String numeroDocumento) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public Documento getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(Documento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	

}
