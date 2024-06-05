package fiap.br.shark.tank.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the TB_INTERESSE database table.
 * 
 */
@Entity
@Table(name="TB_INTERESSE")
public class TbInteresse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INTERESSE")
	private long idInteresse;

	@Column
	private String interesse;

	@JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "TB_INTERESSE_USUARIO",
        joinColumns = @JoinColumn(name = "ID_INTERESSE"), 
        inverseJoinColumns = @JoinColumn(name = "ID_USUARIO"))
    @JsonBackReference
	private List<TbUsuario> tbUsuarios;
    
	
	public TbInteresse() {
	}

	public long getIdInteresse() {
		return this.idInteresse;
	}

	public void setIdInteresse(long idInteresse) {
		this.idInteresse = idInteresse;
	}

	public String getInteresse() {
		return this.interesse;
	}

	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}

//	public List<TbUsuario> getTbUsuarios() {
//		return this.tbUsuarios;
//	}
//
//	public void setTbUsuarios(List<TbUsuario> tbUsuarios) {
//		this.tbUsuarios = tbUsuarios;
//	}

}