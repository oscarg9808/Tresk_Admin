package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "tarjeta")
@Table(name = "tarjeta")
public class Tarjeta {


	@Id
	@Column (length = 10)
	private int id;
	@Column (length = 20)
	private int numero;
	private String fechaV;
	@Column (length = 4)
	private int numVeri;
	
	
	/*@OneToMany (cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="tarjeta", referencedColumnName = "id")
	private List<Factura_Cabecera> fcabecera;
	
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
	public String getFechaV() {
		return fechaV;
	}
	public void setFechaV(String fechaV) {
		this.fechaV = fechaV;
	}
	public int getNumVeri() {
		return numVeri;
	}
	public void setNumVeri(int numVeri) {
		this.numVeri = numVeri;
	}
	
	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numero=" + numero + ", fechaV=" + fechaV + ", numVeri=" + numVeri + "]";
	}		*/
}
