package fiap.br.shark.tank.dto;

import java.math.BigDecimal;

public class MonitoramentoDTO {
	
	private String tituloProjeto;

	private BigDecimal quantia;

	private BigDecimal metaFinanciamento;

	private BigDecimal diferenca;
	
	public MonitoramentoDTO(String tituloProjeto, BigDecimal quantia, BigDecimal metaFinanciamento, BigDecimal diferenca) {
		super();
		this.tituloProjeto = tituloProjeto;
		this.quantia = quantia;
		this.metaFinanciamento = metaFinanciamento;
		this.diferenca = diferenca;
	}
	
	public MonitoramentoDTO(){};

	public String getTituloProjeto() {
		return tituloProjeto;
	}

	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}

	public BigDecimal getQuantia() {
		return quantia;
	}

	public void setQuantia(BigDecimal quantia) {
		this.quantia = quantia;
	}

	public BigDecimal getMetaFinanciamento() {
		return metaFinanciamento;
	}

	public void setMetaFinanciamento(BigDecimal metaFinanciamento) {
		this.metaFinanciamento = metaFinanciamento;
	}

	public BigDecimal getDiferenca() {
		return diferenca;
	}

	public void setDiferenca(BigDecimal diferenca) {
		this.diferenca = diferenca;
	}



}
