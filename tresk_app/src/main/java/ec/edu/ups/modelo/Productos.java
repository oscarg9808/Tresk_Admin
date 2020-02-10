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
import javax.xml.soap.Text;

/*
 * @(#)Producto.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Producto para usarlo en la tienda
 * virtual.
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
	@Column(columnDefinition = "text")
	private String descripcion;
	private double precio_uni;
	private String urlImagen;
	private int categoria;
	private int stock;

	/**
	 * Relacion JPA que relaciona al producto con el modelo carrito
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "productoCarrito", referencedColumnName = "id")
	private List<Carrito> listaCarrito;

	/**
	 * Relacion JPA que relaciona al producto con el modelo carrito
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "votoproducto", referencedColumnName = "id")
	private List<Voto> voto;

	/**
	 * 
	 * @return obtiene la variable id del modelo Productos
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id toma el parametro id para ser asignado a la variable id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return obtiene la variable nombre del modelo Productos
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre toma el parametro nombre para ser asignado a la variable nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return obtiene la variable descripcion del modelo Productos
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * 
	 * @param descripcion toma el parametro descripcion para ser asignado a la variable descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @return obtiene la variable precio_uni del modelo Productos
	 */
	public double getPrecio_uni() {
		return precio_uni;
	}

	/**
	 * 
	 * @param precio_uni toma el parametro precio_uni para ser asignado a la variable precio_uni
	 */
	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
	}

	/**
	 * 
	 * @return obtiene la variable urlImagen del modelo Productos
	 */
	public String getUrlImagen() {
		return urlImagen;
	}

	/**
	 * 
	 * @param urlImagen toma el parametro urlImagen para ser asignado a la variable urlImagen
	 */
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	/**
	 * 
	 * @return obtiene la variable id del modelo Productos
	 */
	public List<Carrito> getListaCarrito() {
		return listaCarrito;
	}

	/**
	 * 
	 * @param listaCarrito
	 */
	public void setListaCarrito(List<Carrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

	/**
	 * 
	 * @return obtiene la variable id del modelo Productos
	 */
	public List<Voto> getVoto() {
		return voto;
	}

	/**
	 * 
	 * @param voto toma el parametro voto para ser asignado a la variable voto
	 */
	public void setVoto(List<Voto> voto) {
		this.voto = voto;
	}

	/**
	 * 
	 * @return obtiene la variable id del modelo Productos
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * 
	 * @param categorias toma el parametro categoria para ser asignado a la variable categoria
	 */
	public void setCategoria(int categorias) {
		this.categoria = categorias;
	}

	/**
	 * 
	 * @return obtiene la variable stock del modelo Productos
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 
	 * @param stock toma el parametro stock para ser asignado a la variable stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_uni="
				+ precio_uni + ", urlImagen=" + urlImagen + ", categoria=" + categoria + ", stock=" + stock
				+ ", listaCarrito=" + listaCarrito + ", voto=" + voto + "]";
	}

	/**
	 * Metodo sobre escrito que parsea datos para su interpretacion
	 */
	

}
