package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @(#)Categorias.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad categorias de compras
 * para usarlo en la tienda virtual.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "categorias")
@Table(name = "categorias")
public class Categorias implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * codigo de la categoria
	 * clave primaria
	 * caracteres
	 * va a ser auto increment en la DB
	 */	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String nombre;
		
		/**
		 * Lista de Prodcutos que se anadirana a la clase al modelo categoria
		 */
		@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
		@JoinColumn(name="categoria", referencedColumnName = "id")
		private List<Productos> productos;
		
		/**
		 * 
		 * @return metdodo get que obtine la variable pincipal
		 */
		public int getId() {
			return id;
		}
		/**
		 * 
		 * @param id toma el parametro id pra ser asiganda a la variable id
		 */
		public void setId(int id) {
			this.id = id;
		}
		
		/**
		 * 
		 * @return metodo que obteine la varibale nombre del modelo Categoria
		 */
		public String getNombre() {
			return nombre;
		} 
		
		/**
		 * 
		 * @param nombre toma el parametro el nombre para ser asiganda a la vaiable nombre
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre; 
		}
		/**
		 * 
		 * @return metodo que obtiene la lista de las productos de modelo catagorias 
		 */
		public List<Productos> getProductos() {
			return productos;
		}
		public void setProductos(List<Productos> productos) {
			this.productos = productos;
		}
		/**
		 * 
		 * @param pro toma el parametro pro para ser asiganda al atributo 
		 * si el parametros es nulo se crea uno nuevo para ser asignado
		 */
		public void addProducto(Productos pro) {
			if(productos == null) {
				productos = new ArrayList<>();
			}
			productos.add(pro);
		}
		/**
		 * Metodo sobre escrito que parsea datos para su interpretacion
		 */
		@Override
		public String toString() {
			return "Categorias [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
		}
}
