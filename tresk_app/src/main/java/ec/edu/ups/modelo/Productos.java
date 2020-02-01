package ec.edu.ups.modelo;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "productos")
@Table(name = "productos")
public class Productos {

		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

		private String nombre;
		private String descripcion;
		private double precio_uni;
		private String urlImagen;
		
		/*@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="productoDetalle", referencedColumnName = "id")
		private List<Factura_Detalle> listaFacturadetalle ;
		
		
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="productoCarrito", referencedColumnName = "id")
		private List<Carrito> listaCarrito ;*/
		
		
		public String getUrlImagen() {
			return urlImagen;
		}
		public void setUrlImagen(String urlImagen) {
			this.urlImagen = urlImagen;
		}
		private int categoria;
		
		
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
		 
		public int getCategoria() {
			return categoria;
		}
		public void setCategoria(int categoria) {
			this.categoria = categoria;
		}
		@Override
		public String toString() {
			return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_uni="
					+ precio_uni + ", categoria=" + categoria + "]";
		}
	
		
		
}