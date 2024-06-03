package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the TB_AVALIACOES_PROJETO database table.
 * 
 */
@Entity
@Table(name="TB_AVALIACOES_PROJETO")
//@NamedQuery(name="TbAvaliacoesProjeto.findAll", query="SELECT t FROM TbAvaliacoesProjeto t")
public class TbAvaliacoesProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AVALIACAO")
	private long idAvaliacao;

	private String comentarios;

//	@Temporal(TemporalType.DATE)
	@Column(name="DATA_AVALIACAO")
	private Date dataAvaliacao;

	@Column(name="NOTA_IMPACTO")
	private String notaImpacto;

	@Column(name="NOTA_VIABILIDADE")
	private String notaViabilidade;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	public TbAvaliacoesProjeto() {
	}

	public long getIdAvaliacao() {
		return this.idAvaliacao;
	}

	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getDataAvaliacao() {
		return this.dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getNotaImpacto() {
		return this.notaImpacto;
	}

	public void setNotaImpacto(String notaImpacto) {
		this.notaImpacto = notaImpacto;
	}

	public String getNotaViabilidade() {
		return this.notaViabilidade;
	}

	public void setNotaViabilidade(String notaViabilidade) {
		this.notaViabilidade = notaViabilidade;
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