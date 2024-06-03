package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the TB_PROJETO database table.
 * 
 */
@Entity
@Table(name="TB_PROJETO")
@NamedQuery(name="TbProjeto.findAll", query="SELECT t FROM TbProjeto t")
public class TbProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PROJETO")
	private long idProjeto;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INICIO")
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_TERMINO")
	private Date dataTermino;

	private String descricao;

	@Column(name="IMPACTO_AMBIENTAL")
	private String impactoAmbiental;

	@Column(name="IMPACTO_SOCIAL")
	private String impactoSocial;

	@Column(name="META_FINANCIAMENTO")
	private BigDecimal metaFinanciamento;

	private String objetivos;

	private String status;

	private String titulo;

	//bi-directional many-to-one association to TbAvaliacoesProjeto
	@OneToMany(mappedBy="tbProjeto")
	private List<TbAvaliacoesProjeto> tbAvaliacoesProjetos;

	//bi-directional many-to-one association to TbComunicacao
	@OneToMany(mappedBy="tbProjeto")
	private List<TbComunicacao> tbComunicacaos;

	//bi-directional many-to-one association to TbInvestimento
	@OneToMany(mappedBy="tbProjeto")
	private List<TbInvestimento> tbInvestimentos;

	//bi-directional many-to-one association to TbMonitoramentoProjeto
	@OneToMany(mappedBy="tbProjeto")
	private List<TbMonitoramentoProjeto> tbMonitoramentoProjetos;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	//bi-directional many-to-one association to TbRecomendacao
	@OneToMany(mappedBy="tbProjeto")
	private List<TbRecomendacao> tbRecomendacaos;

	//bi-directional many-to-one association to TbTransparencia
	@OneToMany(mappedBy="tbProjeto")
	private List<TbTransparencia> tbTransparencias;

	public TbProjeto() {
	}

	public long getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImpactoAmbiental() {
		return this.impactoAmbiental;
	}

	public void setImpactoAmbiental(String impactoAmbiental) {
		this.impactoAmbiental = impactoAmbiental;
	}

	public String getImpactoSocial() {
		return this.impactoSocial;
	}

	public void setImpactoSocial(String impactoSocial) {
		this.impactoSocial = impactoSocial;
	}

	public BigDecimal getMetaFinanciamento() {
		return this.metaFinanciamento;
	}

	public void setMetaFinanciamento(BigDecimal metaFinanciamento) {
		this.metaFinanciamento = metaFinanciamento;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<TbAvaliacoesProjeto> getTbAvaliacoesProjetos() {
		return this.tbAvaliacoesProjetos;
	}

	public void setTbAvaliacoesProjetos(List<TbAvaliacoesProjeto> tbAvaliacoesProjetos) {
		this.tbAvaliacoesProjetos = tbAvaliacoesProjetos;
	}

	public TbAvaliacoesProjeto addTbAvaliacoesProjeto(TbAvaliacoesProjeto tbAvaliacoesProjeto) {
		getTbAvaliacoesProjetos().add(tbAvaliacoesProjeto);
		tbAvaliacoesProjeto.setTbProjeto(this);

		return tbAvaliacoesProjeto;
	}

	public TbAvaliacoesProjeto removeTbAvaliacoesProjeto(TbAvaliacoesProjeto tbAvaliacoesProjeto) {
		getTbAvaliacoesProjetos().remove(tbAvaliacoesProjeto);
		tbAvaliacoesProjeto.setTbProjeto(null);

		return tbAvaliacoesProjeto;
	}

	public List<TbComunicacao> getTbComunicacaos() {
		return this.tbComunicacaos;
	}

	public void setTbComunicacaos(List<TbComunicacao> tbComunicacaos) {
		this.tbComunicacaos = tbComunicacaos;
	}

	public TbComunicacao addTbComunicacao(TbComunicacao tbComunicacao) {
		getTbComunicacaos().add(tbComunicacao);
		tbComunicacao.setTbProjeto(this);

		return tbComunicacao;
	}

	public TbComunicacao removeTbComunicacao(TbComunicacao tbComunicacao) {
		getTbComunicacaos().remove(tbComunicacao);
		tbComunicacao.setTbProjeto(null);

		return tbComunicacao;
	}

	public List<TbInvestimento> getTbInvestimentos() {
		return this.tbInvestimentos;
	}

	public void setTbInvestimentos(List<TbInvestimento> tbInvestimentos) {
		this.tbInvestimentos = tbInvestimentos;
	}

	public TbInvestimento addTbInvestimento(TbInvestimento tbInvestimento) {
		getTbInvestimentos().add(tbInvestimento);
		tbInvestimento.setTbProjeto(this);

		return tbInvestimento;
	}

	public TbInvestimento removeTbInvestimento(TbInvestimento tbInvestimento) {
		getTbInvestimentos().remove(tbInvestimento);
		tbInvestimento.setTbProjeto(null);

		return tbInvestimento;
	}

	public List<TbMonitoramentoProjeto> getTbMonitoramentoProjetos() {
		return this.tbMonitoramentoProjetos;
	}

	public void setTbMonitoramentoProjetos(List<TbMonitoramentoProjeto> tbMonitoramentoProjetos) {
		this.tbMonitoramentoProjetos = tbMonitoramentoProjetos;
	}

	public TbMonitoramentoProjeto addTbMonitoramentoProjeto(TbMonitoramentoProjeto tbMonitoramentoProjeto) {
		getTbMonitoramentoProjetos().add(tbMonitoramentoProjeto);
		tbMonitoramentoProjeto.setTbProjeto(this);

		return tbMonitoramentoProjeto;
	}

	public TbMonitoramentoProjeto removeTbMonitoramentoProjeto(TbMonitoramentoProjeto tbMonitoramentoProjeto) {
		getTbMonitoramentoProjetos().remove(tbMonitoramentoProjeto);
		tbMonitoramentoProjeto.setTbProjeto(null);

		return tbMonitoramentoProjeto;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public List<TbRecomendacao> getTbRecomendacaos() {
		return this.tbRecomendacaos;
	}

	public void setTbRecomendacaos(List<TbRecomendacao> tbRecomendacaos) {
		this.tbRecomendacaos = tbRecomendacaos;
	}

	public TbRecomendacao addTbRecomendacao(TbRecomendacao tbRecomendacao) {
		getTbRecomendacaos().add(tbRecomendacao);
		tbRecomendacao.setTbProjeto(this);

		return tbRecomendacao;
	}

	public TbRecomendacao removeTbRecomendacao(TbRecomendacao tbRecomendacao) {
		getTbRecomendacaos().remove(tbRecomendacao);
		tbRecomendacao.setTbProjeto(null);

		return tbRecomendacao;
	}

	public List<TbTransparencia> getTbTransparencias() {
		return this.tbTransparencias;
	}

	public void setTbTransparencias(List<TbTransparencia> tbTransparencias) {
		this.tbTransparencias = tbTransparencias;
	}

	public TbTransparencia addTbTransparencia(TbTransparencia tbTransparencia) {
		getTbTransparencias().add(tbTransparencia);
		tbTransparencia.setTbProjeto(this);

		return tbTransparencia;
	}

	public TbTransparencia removeTbTransparencia(TbTransparencia tbTransparencia) {
		getTbTransparencias().remove(tbTransparencia);
		tbTransparencia.setTbProjeto(null);

		return tbTransparencia;
	}

}