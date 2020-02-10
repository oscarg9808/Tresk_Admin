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
 * @(#)Carrito.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidaddel carrito de compras
 * para usarlo en la tienda virtual.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity
@Table(name = "carrito")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Atributos
	
	/**
	 * codigo del carrito
	 * clave primaria
	 * rango de 10 caracteres
	 * va a ser auto increment en la DB
	 */	
	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * cantidad que tendra el carrito
	 */	
	@Column(length = 45)
	private int cantidad;
	
	/**
	 * ptotal del carrito
	 */	
	private double ptotal;
	
	/*@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "carritoid" , referencedColumnName = "id")
	private List<Productos> productosList;
	*/
	
	/**
	 * metodo que contiene el id del carrito
	 * @return id 
	 */	
	public int getId() {
		return id;
	}
	
	/**
	 * metodo que sive para poner un id del carrito
	 * @param id de tipo entero
	 */	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * metodo que contiene la cantidad del carrito
	 * @return cantidad 
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * metodo que sive para poner la canidad del carrito
	 * @param cantidad de tipo entero
	 */	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * metodo que contiene precio total del carrito
	 * @return ptotal 
	 */
	public double getPtotal() {
		return ptotal;
	}
	
	/**
	 * metodo que sive para poner precio total del carrito
	 * @param ptotal de tipo entero
	 */	
	public void setPtotal(double ptotal) {
		this.ptotal = ptotal;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", cantidad=" + cantidad + ", ptotal=" + ptotal + "]";
	}
	
	
}
