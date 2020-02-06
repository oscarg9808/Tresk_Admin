package ec.edu.ups.modelo;

import java.io.Serializable;

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
