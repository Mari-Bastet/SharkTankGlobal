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
 * The persistent class for the TB_RECOMENDACAO database table.
 * 
 */
@Entity
@Table(name="TB_RECOMENDACAO")
@NamedQuery(name="TbRecomendacao.findAll", query="SELECT t FROM TbRecomendacao t")
public class TbRecomendacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RECOMENDACAO")
	private long idRecomendacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RECOMENDACAO")
	private Date dataRecomendacao;

	private String notas;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	public TbRecomendacao() {
	}

	public long getIdRecomendacao() {
		return this.idRecomendacao;
	}

	public void setIdRecomendacao(long idRecomendacao) {
		this.idRecomendacao = idRecomendacao;
	}

	public Date getDataRecomendacao() {
		return this.dataRecomendacao;
	}

	public void setDataRecomendacao(Date dataRecomendacao) {
		this.dataRecomendacao = dataRecomendacao;
	}

	public String getNotas() {
		return this.notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public TbProjeto getTbProjeto() {
		return this.tbProjeto;
	}

	public void setTbProjeto(TbProjeto tbProjeto) {
		this.tbProjeto = tbProjeto;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

}