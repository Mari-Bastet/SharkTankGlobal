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
 * The persistent class for the TB_COMUNICACAO database table.
 * 
 */
@Entity
@Table(name="TB_COMUNICACAO")
@NamedQuery(name="TbComunicacao.findAll", query="SELECT t FROM TbComunicacao t")
public class TbComunicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMUNICACAO")
	private long idComunicacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENVIO")
	private Date dataEnvio;

	private String mensagem;

	@Column(name="TIPO_COMUNICACAO")
	private String tipoComunicacao;

	//bi-directional many-to-one association to TbProjeto
	@ManyToOne
	@JoinColumn(name="ID_PROJETO")
	private TbProjeto tbProjeto;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private TbUsuario tbUsuario;

	public TbComunicacao() {
	}

	public long getIdComunicacao() {
		return this.idComunicacao;
	}

	public void setIdComunicacao(long idComunicacao) {
		this.idComunicacao = idComunicacao;
	}

	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTipoComunicacao() {
		return this.tipoComunicacao;
	}

	public void setTipoComunicacao(String tipoComunicacao) {
		this.tipoComunicacao = tipoComunicacao;
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