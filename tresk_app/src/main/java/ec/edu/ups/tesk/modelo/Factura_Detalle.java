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
@Table (name="fdetalle")
public class Factura_Detalle {

	@Id
	@Column (length = 10)
	private int id;
	@Column (length = 25)
	private String cantidad;
	private double p_total;

	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="fdetalle", referencedColumnName = "id")
	private List<Productos> producto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public double getP_total() {
		return p_total;
	}

	public void setP_total(double p_total) {
		this.p_total = p_total;
	}

	public List<Productos> getProducto() {
		return producto;
	}

	public void setProducto(List<Productos> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Factura_Detalle [id=" + id + ", cantidad=" + cantidad + ", p_total=" + p_total + ", producto="
				+ producto + "]";
	}
}
