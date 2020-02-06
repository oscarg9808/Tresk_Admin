package ec.edu.ups.modelo;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "direccion")
@Table(name = "direccion")
public class Direccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column (length = 10)
	private int id;
	@Column (length = 45)
	private String cprincipal;
	@Column (length = 45)
	private String csecunfaria;
	@Column (length = 6)
	private String numero;
	@Column (length = 25)
	private String ciudad;
	@Column (length = 10)
	private int codpstal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCprincipal() {
		return cprincipal;
	}

	public void setCprincipal(String cprincipal) {
		this.cprincipal = cprincipal;
	}

	public String getCsecunfaria() {
		return csecunfaria;
	}

	public void setCsecunfaria(String csecunfaria) {
		this.csecunfaria = csecunfaria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodpstal() {
		return codpstal;
	}

	public void setCodpstal(int codpstal) {
		this.codpstal = codpstal;
	}

	

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", cprincipal=" + cprincipal + ", csecunfaria=" + csecunfaria + ", numero="
				+ numero + ", ciudad=" + ciudad + ", codpstal=" + codpstal + ", fcabecera= ]";
	}	
}
