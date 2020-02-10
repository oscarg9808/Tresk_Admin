package ec.edu.ups.modelo;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @(#)Direccion.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad direccion del usuario
 * para usarlo en la tienda virtual.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "direccion")
@Table(name = "direccion")
public class Direccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variables
	
	/**
	 * 
	 */
	@Id
	@Column (length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;/** Variable de la id primaria del modelo Direccion*/
	@Column (length = 45)
	private String cprincipal;/** Varible que almacena un atributo del Modelo Direcion */
	@Column (length = 45)
	private String csecunfaria;/** Varible que almacena un atributo del Modelo Direcion */
	@Column (length = 6)
	private String numero;/** Varible que almacena un atributo del Modelo Direcion */
	@Column (length = 25)
	private String ciudad;/** Varible que almacena un atributo del Modelo Direcion */
	@Column (length = 10)
	private int codpstal;/** Varible que almacena un atributo del Modelo Direcion */

	/**
	 * Metodos getter del id del Modelo Direccion
	 * @return id variable pincipal
	 */
	public int getId() {
		return id;
	}
/**
 * Metodos setter del id del  Modelo Direccion
 * @param id metodo que envia el id del modelo Direccion
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * 
 * @return metodo que obtine la calle principal del modelo direccion
 */
	public String getCprincipal() {
		return cprincipal;
	}
	/**
	 * 
	 * @param cprincipal metodo que envia el cprincipal del modelo Direccion
	 */

	public void setCprincipal(String cprincipal) {
		this.cprincipal = cprincipal;
	}
	/**
	 * 
	 * @return metodo que obtine la calle secundaria del modelo direccion
	 */

	public String getCsecunfaria() {
		return csecunfaria;
	}
/**
 * 
 * @param csecunfaria toma el parametro csecunfaria para ser asignada a la variable csecunfaria
 */
	public void setCsecunfaria(String csecunfaria) {
		this.csecunfaria = csecunfaria;
	}
/**
 * 
 * @return metodo que obtine el numero de casa del modelo direccion
 */
	public String getNumero() {
		return numero;
	}
/**
 * 
 * @param numero toma el parametro numero para se asigmada a la variable numero
 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
/**
 * 
 * @return metodo que obtine la variable ciudad del modelo direccion
 */
	public String getCiudad() {
		return ciudad;
	}
/**
 * 
 * @param ciudad toma el parametro ciudad para ser asignada a la variable ciudad
 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
/**
 * 
 * @return obtine la variable codpostal del modelo Direccion
 */
	public int getCodpstal() {
		return codpstal;
	}
/**
 * 
 * @param codpstal toma el parametro codpstal para ser asignada a la variable codpstal
 */
	public void setCodpstal(int codpstal) {
		this.codpstal = codpstal;
	}

	
/**
 * Metodo sobre escrito que parsea datos para su interpretacion
 */
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", cprincipal=" + cprincipal + ", csecunfaria=" + csecunfaria + ", numero="
				+ numero + ", ciudad=" + ciudad + ", codpstal=" + codpstal + ", fcabecera= ]";
	}	
}
