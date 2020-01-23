package ec.edu.ups.tesk.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="f_cabecera", referencedColumnName = "id")
	private List<Factura_Detalle> fdetalle;

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

	public List<Factura_Detalle> getFdetalle() {
		return fdetalle;
	}

	public void setFdetalle(List<Factura_Detalle> fdetalle) {
		this.fdetalle = fdetalle;
	}

	@Override
	public String toString() {
		return "Factura_Cabecera [id=" + id + ", numero=" + numero + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", total=" + total + ", fdetalle=" + fdetalle + "]";
	}
	
	
}
