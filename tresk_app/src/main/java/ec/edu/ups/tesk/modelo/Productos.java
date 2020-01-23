package ec.edu.ups.tesk.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Productos {

		@Id 
		private int id;

		private String nombre;
		private String descripcion;
		private double precio_uni;
		private String urlImagen;
		
		/*@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
		@JoinColumn(name="producto", referencedColumnName = "id")
		private List<Carrito> carrito ;*/
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="producto", referencedColumnName = "id")
		private List<Factura_Detalle> fdetalle ;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getPrecio_uni() {
			return precio_uni;
		}

		public void setPrecio_uni(double precio_uni) {
			this.precio_uni = precio_uni;
		}

		public String getUrlImagen() {
			return urlImagen;
		}

		public void setUrlImagen(String urlImagen) {
			this.urlImagen = urlImagen;
		}

		/*public List<Carrito> getCarrito() {
			return carrito;
		}

		public void setCarrito(List<Carrito> carrito) {
			this.carrito = carrito;
		}*/

		/*public List<Factura_Detalle> getFdetalle() {
			return fdetalle;
		}

		public void setFdetalle(List<Factura_Detalle> fdetalle) {
			this.fdetalle = fdetalle;
		}

		@Override
		public String toString() {
			return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_uni="
					+ precio_uni + ", urlImagen=" + urlImagen + ", carrito=" + carrito + ", fdetalle=" + fdetalle + "]";
		}*/


}
