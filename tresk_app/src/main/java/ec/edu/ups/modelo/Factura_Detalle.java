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
 * Esta clase hace referencia a la entidad Factura_Detalle hace referencia a la
 * compra que se realizara
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARR.......................
 */

@Entity(name = "facturadetalle")
@Table(name = "facturadetalle")
public class Factura_Detalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * JPA que define que la variabke es primary key id atributo que almacena la
	 * variable primaria del modelo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private int id;
	/**
	 * atributo cantidad que almacen la cantida del producto en el modeo factura
	 * detalle
	 */
	@Column(length = 25)
	private int cantidad;
	/**
	 * atributo p_total que almacen la cantida el total en el modeo factura detalle
	 */
	private double p_total;

	/**
	 * Relacion JPA que hacer referencia que el modelo Factura detalle tine un
	 * Producto del modelo Producto
	 */
	@OneToOne()
	@JoinColumn(name = "productoid", referencedColumnName = "id")
	private Productos productos;

	/**
	 * 
	 * @return obtiene el id del modelo Factura detalle
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id toma el parametro id para se asignado a la variable id
	 */
	 
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return obtiene  la cantidad del modelo Factura detalle
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * 
	 * @param cantidad toma el parametro cantidad para se asignado a la variable cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * 
	 * @return obtiene el p_total del modelo Factura detalle
	 */
	public double getP_total() {
		return p_total;
	}

	/**
	 * 
	 * @param p_total toma el parametro p_total para se asignado a la variable p_total
	 */
	public void setP_total(double p_total) {
		this.p_total = p_total;
	}

	/**
	 * 
	 * @return obtiene el productos del modelo Factura detalle
	 */

	public Productos getProductos() {
		return productos;
	}

	/**
	 * 
	 * @param productos productos el parametro cantidad para se asignado a la variable productos
	 */
	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	/**
	 * Metodo sobre escrito que parsea datos para su interpretacion
	 */
	@Override
	public String toString() {
		return "Factura_Detalle [id=" + id + ", cantidad=" + cantidad + ", p_total=" + p_total + ", productos="
				+ productos + "]";
	}

}
