package ec.edu.ups.modelo;

import java.io.Serializable;
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

/*
 * @(#)Producto.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Producto
 * para usarlo en la tienda virtual.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "productos")
@Table(name = "productos")
public class Productos implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String nombre;
		private String descripcion;
		private double precio_uni;
		private String urlImagen;
		private int categoria;
		private int stock;
		
		/*@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name="productoDetalle", referencedColumnName = "id")
		private List<Factura_Detalle> listaFacturadetalle;*/
		
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


		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		@Override
		public String toString() {
			return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_uni="
					+ precio_uni + ", urlImagen=" + urlImagen + ", categoria=" + categoria + ", stock=" + stock + "]";
		}
		
		
}
