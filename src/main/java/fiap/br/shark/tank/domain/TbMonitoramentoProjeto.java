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
 * The persistent class for the TB_MONITORAMENTO_PROJETO database table.
 * 
 */
@Entity
@Table(name="TB_MONITORAMENTO_PROJETO")
@NamedQuery(name="TbMonitoramentoProjeto.findAll", query="SELECT t FROM TbMonitoramentoProjeto t")
public class TbMonitoramentoProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MONITORAMENTO")
	private long idMonitoramento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RELATORIO")
	private Date dataRelatorio;

	@Column(name="METRICA_SUCESSO")
	private String metricaSucesso;

	private String relatorio;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	public TbMonitoramentoProjeto() {
	}

	public long getIdMonitoramento() {
		return this.idMonitoramento;
	}

	public void setIdMonitoramento(long idMonitoramento) {
		this.idMonitoramento = idMonitoramento;
	}

	public Date getDataRelatorio() {
		return this.dataRelatorio;
	}

	public void setDataRelatorio(Date dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}

	public String getMetricaSucesso() {
		return this.metricaSucesso;
	}

	public void setMetricaSucesso(String metricaSucesso) {
		this.metricaSucesso = metricaSucesso;
	}

	public String getRelatorio() {
		return this.relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public TbProjeto getTbProjeto() {
		return this.tbProjeto;
	}

	public void setTbProjeto(TbProjeto tbProjeto) {
		this.tbProjeto = tbProjeto;
	}

}