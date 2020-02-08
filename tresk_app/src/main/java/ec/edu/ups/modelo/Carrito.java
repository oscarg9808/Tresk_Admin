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
	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 45)
	private int cantidad;
	private double ptotal;
	
	/*@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "carritoid" , referencedColumnName = "id")
	private List<Productos> productosList;
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPtotal() {
		return ptotal;
	}
	public void setPtotal(double ptotal) {
		this.ptotal = ptotal;
	}
	
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", cantidad=" + cantidad + ", ptotal=" + ptotal + "]";
	}
	
	
}
