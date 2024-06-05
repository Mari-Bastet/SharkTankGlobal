package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the TB_USUARIO database table.
 * 
 */
@Entity
@Table(name="TB_USUARIO")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column
	private String email;

	@Column
	private String nome;

	@Column
	private String senha;

	@Column(name="TIPO_USUARIO")
	private String tipoUsuario;

	@OneToMany(mappedBy="tbUsuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<TbAvaliacoesProjeto> tbAvaliacoesProjetos;

	@OneToMany(mappedBy="tbUsuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<TbComunicacao> tbComunicacaos;

	@OneToMany(mappedBy="tbUsuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<TbEducacaoEngajamento> tbEducacaoEngajamentos;

//	@OneToMany(mappedBy="tbUsuario")
//	private List<TbInteresse> tbInteresses1;

	//bi-directional many-to-many association to TbInteresse
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name="TB_INTERESSE_USUARIO"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_INTERESSE")
			}
		)
    @JsonManagedReference
	private List<TbInteresse> tbInteresses;

	@OneToMany(mappedBy="tbUsuario")
	private List<TbInvestimento> tbInvestimentos;

	@OneToMany(mappedBy="tbUsuario")
	private List<TbProjeto> tbProjetos;

	@OneToMany(mappedBy="tbUsuario")
	private List<TbRecomendacao> tbRecomendacoes;

	public TbUsuario() {
	}
	
	public TbUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

//	public List<TbAvaliacoesProjeto> getTbAvaliacoesProjetos() {
//		return this.tbAvaliacoesProjetos;
//	}
//
//	public void setTbAvaliacoesProjetos(List<TbAvaliacoesProjeto> tbAvaliacoesProjetos) {
//		this.tbAvaliacoesProjetos = tbAvaliacoesProjetos;
//	}
//
//	public TbAvaliacoesProjeto addTbAvaliacoesProjeto(TbAvaliacoesProjeto tbAvaliacoesProjeto) {
//		getTbAvaliacoesProjetos().add(tbAvaliacoesProjeto);
//		tbAvaliacoesProjeto.setTbUsuario(this);
//
//		return tbAvaliacoesProjeto;
//	}
//
//	public TbAvaliacoesProjeto removeTbAvaliacoesProjeto(TbAvaliacoesProjeto tbAvaliacoesProjeto) {
//		getTbAvaliacoesProjetos().remove(tbAvaliacoesProjeto);
//		tbAvaliacoesProjeto.setTbUsuario(null);
//
//		return tbAvaliacoesProjeto;
//	}
//
//	public List<TbComunicacao> getTbComunicacaos() {
//		return this.tbComunicacaos;
//	}
//
//	public void setTbComunicacaos(List<TbComunicacao> tbComunicacaos) {
//		this.tbComunicacaos = tbComunicacaos;
//	}
//
//	public TbComunicacao addTbComunicacao(TbComunicacao tbComunicacao) {
//		getTbComunicacaos().add(tbComunicacao);
//		tbComunicacao.setTbUsuario(this);
//
//		return tbComunicacao;
//	}
//
//	public TbComunicacao removeTbComunicacao(TbComunicacao tbComunicacao) {
//		getTbComunicacaos().remove(tbComunicacao);
//		tbComunicacao.setTbUsuario(null);
//
//		return tbComunicacao;
//	}
//
//	public List<TbEducacaoEngajamento> getTbEducacaoEngajamentos() {
//		return this.tbEducacaoEngajamentos;
//	}
//
//	public void setTbEducacaoEngajamentos(List<TbEducacaoEngajamento> tbEducacaoEngajamentos) {
//		this.tbEducacaoEngajamentos = tbEducacaoEngajamentos;
//	}
//
//	public TbEducacaoEngajamento addTbEducacaoEngajamento(TbEducacaoEngajamento tbEducacaoEngajamento) {
//		getTbEducacaoEngajamentos().add(tbEducacaoEngajamento);
//		tbEducacaoEngajamento.setTbUsuario(this);
//
//		return tbEducacaoEngajamento;
//	}
//
//	public TbEducacaoEngajamento removeTbEducacaoEngajamento(TbEducacaoEngajamento tbEducacaoEngajamento) {
//		getTbEducacaoEngajamentos().remove(tbEducacaoEngajamento);
//		tbEducacaoEngajamento.setTbUsuario(null);
//
//		return tbEducacaoEngajamento;
//	}

//	public List<TbInteresse> getTbInteresses1() {
//		return this.tbInteresses1;
//	}
//
//	public void setTbInteresses1(List<TbInteresse> tbInteresses1) {
//		this.tbInteresses1 = tbInteresses1;
//	}
//
//	public TbInteresse addTbInteresses1(TbInteresse tbInteresses1) {
//		getTbInteresses1().add(tbInteresses1);
//		tbInteresses1.setTbUsuario(this);
//
//		return tbInteresses1;
//	}
//
//	public TbInteresse removeTbInteresses1(TbInteresse tbInteresses1) {
//		getTbInteresses1().remove(tbInteresses1);
//		tbInteresses1.setTbUsuario(null);
//
//		return tbInteresses1;
//	}

//	public List<TbInteresse> getTbInteresses() {
//		return this.tbInteresses;
//	}
//
//	public void setTbInteresses(List<TbInteresse> tbInteresses) {
//		this.tbInteresses = tbInteresses;
//	}
//
//	public List<TbInvestimento> getTbInvestimentos() {
//		return this.tbInvestimentos;
//	}
//
//	public void setTbInvestimentos(List<TbInvestimento> tbInvestimentos) {
//		this.tbInvestimentos = tbInvestimentos;
//	}
//
//	public TbInvestimento addTbInvestimento(TbInvestimento tbInvestimento) {
//		getTbInvestimentos().add(tbInvestimento);
//		tbInvestimento.setTbUsuario(this);
//
//		return tbInvestimento;
//	}
//
//	public TbInvestimento removeTbInvestimento(TbInvestimento tbInvestimento) {
//		getTbInvestimentos().remove(tbInvestimento);
//		tbInvestimento.setTbUsuario(null);
//
//		return tbInvestimento;
//	}
//
//	public List<TbProjeto> getTbProjetos() {
//		return this.tbProjetos;
//	}
//
//	public void setTbProjetos(List<TbProjeto> tbProjetos) {
//		this.tbProjetos = tbProjetos;
//	}

//	public TbProjeto addTbProjeto(TbProjeto tbProjeto) {
//		getTbProjetos().add(tbProjeto);
//		tbProjeto.setTbUsuario(this);
//
//		return tbProjeto;
//	}
//
//	public TbProjeto removeTbProjeto(TbProjeto tbProjeto) {
//		getTbProjetos().remove(tbProjeto);
//		tbProjeto.setTbUsuario(null);
//
//		return tbProjeto;
//	}

//	public List<TbRecomendacao> getTbRecomendacaos() {
//		return this.tbRecomendacoes;
//	}
//
//	public void setTbRecomendacaos(List<TbRecomendacao> tbRecomendacaos) {
//		this.tbRecomendacoes = tbRecomendacaos;
//	}
//
//	public TbRecomendacao addTbRecomendacao(TbRecomendacao tbRecomendacao) {
//		getTbRecomendacaos().add(tbRecomendacao);
//		tbRecomendacao.setTbUsuario(this);
//
//		return tbRecomendacao;
//	}
//
//	public TbRecomendacao removeTbRecomendacao(TbRecomendacao tbRecomendacao) {
//		getTbRecomendacaos().remove(tbRecomendacao);
//		tbRecomendacao.setTbUsuario(null);
//
//		return tbRecomendacao;
//	}

}