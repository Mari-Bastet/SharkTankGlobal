package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the TB_EDUCACAO_ENGAJAMENTO database table.
 * 
 */
@Entity
@Table(name="TB_EDUCACAO_ENGAJAMENTO")
@NamedQuery(name="TbEducacaoEngajamento.findAll", query="SELECT t FROM TbEducacaoEngajamento t")
public class TbEducacaoEngajamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EDUCACAO")
	private long idEducacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PUBLICACAO")
	private Date dataPublicacao;

	private String descricao;

	private String titulo;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	public TbEducacaoEngajamento() {
	}

	public long getIdEducacao() {
		return this.idEducacao;
	}

	public void setIdEducacao(long idEducacao) {
		this.idEducacao = idEducacao;
	}

	public Date getDataPublicacao() {
		return this.dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

}