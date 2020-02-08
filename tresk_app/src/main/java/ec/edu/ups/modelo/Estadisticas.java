package ec.edu.ups.modelo;

import java.io.Serializable;

/*
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
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

public class Estadisticas implements Comparable<Estadisticas>, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int cantidad;
	private int idProducto;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	@Override
	public String toString() {
		return "Estadisticas [nombre=" + nombre + ", cantidad=" + cantidad + ", idProducto=" + idProducto + "]";
	}
	@Override
	public int compareTo(Estadisticas o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
