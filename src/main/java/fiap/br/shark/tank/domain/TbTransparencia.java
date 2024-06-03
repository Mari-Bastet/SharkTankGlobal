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
 * The persistent class for the TB_TRANSPARENCIA database table.
 * 
 */
@Entity
@Table(name="TB_TRANSPARENCIA")
@NamedQuery(name="TbTransparencia.findAll", query="SELECT t FROM TbTransparencia t")
public class TbTransparencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TRANSPARENCIA")
	private long idTransparencia;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ATIVIDADE")
	private Date dataAtividade;

	@Column(name="DESCRICAO_ATIVIDADE")
	private String descricaoAtividade;

	private String resultado;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	public TbTransparencia() {
	}

	public long getIdTransparencia() {
		return this.idTransparencia;
	}

	public void setIdTransparencia(long idTransparencia) {
		this.idTransparencia = idTransparencia;
	}

	public Date getDataAtividade() {
		return this.dataAtividade;
	}

	public void setDataAtividade(Date dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

	public String getDescricaoAtividade() {
		return this.descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public TbProjeto getTbProjeto() {
		return this.tbProjeto;
	}

	public void setTbProjeto(TbProjeto tbProjeto) {
		this.tbProjeto = tbProjeto;
	}

}