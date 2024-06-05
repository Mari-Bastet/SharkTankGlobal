package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the TB_INVESTIMENTO database table.
 * 
 */
@Entity
@Table(name="TB_INVESTIMENTO")
@NamedQuery(name="TbInvestimento.findAll", query="SELECT t FROM TbInvestimento t")
public class TbInvestimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INVESTIMENTO")
	private long idInvestimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INVESTIMENTO")
	private Date dataInvestimento;
	
	@Column
	private BigDecimal quantia;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	public TbInvestimento() {
	}

	public long getIdInvestimento() {
		return this.idInvestimento;
	}

	public void setIdInvestimento(long idInvestimento) {
		this.idInvestimento = idInvestimento;
	}

	public Date getDataInvestimento() {
		return this.dataInvestimento;
	}

	public void setDataInvestimento(Date dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public BigDecimal getQuantia() {
		return this.quantia;
	}

	public void setQuantia(BigDecimal quantia) {
		this.quantia = quantia;
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