package ec.edu.ups.tesk.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "fcabecera")
public class Factura_Cabecera {
	
	@Id
	@Column (length = 10)
	private int id;
	@Column (length = 10)
	private int numero;
	private double subtotal;
	private double iva;
	private double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Factura_Cabecera [id=" + id + ", numero=" + numero + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", total=" + total + "]";
	}
	
	
	
		
}
