package ec.edu.ups.modelo;

public class Estadisticas implements Comparable<Estadisticas> {
	
	
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
