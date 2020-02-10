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

/**
 * @(#)Tarjeta.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Tarjeta para el pago de una compra.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "tarjeta")
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * JPA que hace referencia que el campo es un primary key
	 * id atributo que almacena el campo id del modelo Tarjeta
	 */
	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * atributo que almacena el numero de la tarjeta
	 */
	@Column(length = 20)
	private int numero;
	/**
	 * atributo que almcena la fechaV 
	 */
	private String fechaV;
	/**
	 * atributo que almacena el numero de verificacion CSV
	 */
	@Column(length = 4)
	private int numVeri;

	/*
	 * @OneToMany (cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	 * 
	 * @JoinColumn(name="tarjeta", referencedColumnName = "id") private
	 * List<Factura_Cabecera> fcabecera;
	 */
	/**
	 * 
	 * @return obtiene la variable id del modelo Tarjeta
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id toma la el parametro id para ser  asignado la variable id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return  obtiene la variable numero del modelo Tarjeta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero toma el parametro numero para ser  asignado la variable numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return  obtiene la variable fechaV del modelo Tarjeta
	 */
	public String getFechaV() {
		return fechaV;
	}

	/**
	 * 
	 * @param fechaV toma el parametro fechaV para ser  asignado la variable fechaV
	 */
	public void setFechaV(String fechaV) {
		this.fechaV = fechaV;
	}

	/**
	 * 
	 * @return  obtiene la variable numVeri del modelo Tarjeta
	 */
	public int getNumVeri() {
		return numVeri;
	}

	/**
	 * 
	 * @param numVeri toma el parametro numVeri para ser  asignado la variable numVeri
	 */
	public void setNumVeri(int numVeri) {
		this.numVeri = numVeri;
	}

	/**
	 * Metodo sobre escrito que parsea datos para su interpretacion
	 */
	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numero=" + numero + ", fechaV=" + fechaV + ", numVeri=" + numVeri + "]";
	}
}
