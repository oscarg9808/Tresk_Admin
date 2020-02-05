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
		private int categoria;
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="productoDetalle", referencedColumnName = "id")
		private List<Factura_Detalle> listaFacturadetalle ;
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="productoCarrito", referencedColumnName = "id")
		private List<Carrito> listaCarrito ;
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
		@JoinColumn(name="votoproducto", referencedColumnName = "id")
		private List<Voto> voto;

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

		public List<Carrito> getListaCarrito() {
			return listaCarrito;
		}

		public void setListaCarrito(List<Carrito> listaCarrito) {
			this.listaCarrito = listaCarrito;
		}

		public List<Voto> getVoto() {
			return voto;
		}

		public void setVoto(List<Voto> voto) {
			this.voto = voto;
		}

		public int getCategoria() {
			return categoria;
		}

		public void setCategoria(int categorias) {
			this.categoria = categorias;
		}

		@Override
		public String toString() {
			return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_uni="
					+ precio_uni + ", urlImagen=" + urlImagen + ", categoria=" + categoria + ", voto=" + voto + "]";
		}

		
}
