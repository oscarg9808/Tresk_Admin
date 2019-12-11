package ec.edu.ups.tesk.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Productos {

		@Id 
		private int id;

		private String nombre;
		private String descripcion;
		private double precio_uni;
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
