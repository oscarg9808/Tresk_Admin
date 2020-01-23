package ec.edu.ups.tesk.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "carrito")
public class Carrito {

	@Id
	@Column(length = 10)
	private int id;
	@Column(length = 45)
	private int cantidad;
	private double ptotal;
	
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
