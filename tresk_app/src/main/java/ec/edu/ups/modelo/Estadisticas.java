package ec.edu.ups.modelo;

import java.io.Serializable;

/**
 * @(#)Entidad.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la clase entidad 
 * para el manejo de reporte de ventas.
 *
 * @author Oscar Pizarro
 * @author Jose Agustin Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

public class Estadisticas implements Comparable<Estadisticas>, Serializable {
	
	
	/**
	 * V
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variable nombre de Producto en la calase estadistica
	 */
	private String nombre;
	/**
	 * atributo cantidad del modelo Estadistica
	 */
	private int cantidad;
	/**
	 * variable idProducto del contine e l model producto
	 */
	private int idProducto;
	
	/**
	 * 
	 * @return obtene el nombre delo modelo Estadistica
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *
	 * @param nombre toma el parametro nombre para se asignado a la variable nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Atributo que contiene la catidad de porductos vendidos
	 * @return obtiene la cantidad del modelo Estadistica
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * 
	 * @param cantidad toma la cantidad para se asiganda al atributo cantidad del modelo
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * 
	 * @return obtiene el id del producto del modelo Estadistica
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * 
	 * @param idProducto toma el parametri idproducto para ser asigando al atributo idProducto del modelo 
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * Metodo sobre escrito que parsea datos para su interpretacion
	 */
	@Override
	public String toString() {
		return "Estadisticas [nombre=" + nombre + ", cantidad=" + cantidad + ", idProducto=" + idProducto + "]";
	}
	/**
	 * Metdod sobre escrito para ordenar las variables
	 */
	@Override
	public int compareTo(Estadisticas o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
