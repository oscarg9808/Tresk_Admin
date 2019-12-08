package ec.edu.ups.tesk.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Categorias {

		@Id
		private int id;
		private String nombre;
		
		@OneToMany(cascade = {CascadeType.ALL})
		@JoinColumn(name="producto", referencedColumnName = "id")
		private List<Productos> productos;
		
		
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
		
		public List<Productos> getProductos() {
			return productos;
		}
		public void setProductos(List<Productos> productos) {
			this.productos = productos;
		}
		
		public void addProducto(Productos pro) {
			if(productos == null) {
				productos = new ArrayList<>();
			productos.add(pro);

			}
		}
		
		@Override
		public String toString() {
			return "Categorias [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
		}
}
