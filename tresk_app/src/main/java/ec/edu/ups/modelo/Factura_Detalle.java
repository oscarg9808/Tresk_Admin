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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * @(#)Factura_Detalle.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Factura_Detalle
 * hace referencia a la compra que se realizara
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "facturadetalle")
@Table(name = "facturadetalle")
public class Factura_Detalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (length = 10)
	private int id;
	@Column (length = 25)
	private int cantidad;
	private double p_total;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productoid", referencedColumnName = "id")
	private Productos productos;

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

	public double getP_total() {
		return p_total;
	}

	public void setP_total(double p_total) {
		this.p_total = p_total;
	}
	

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Factura_Detalle [id=" + id + ", cantidad=" + cantidad + ", p_total=" + p_total + ", productos="
				+ productos + "]";
	}
	
	

}
