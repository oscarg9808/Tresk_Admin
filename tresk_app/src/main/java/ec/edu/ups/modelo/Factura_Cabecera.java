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
 * @(#)Factura_Cabecera.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Factura_Cabecera hace referencia a la
 * compra que se realizara
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARR.......................
 */

@Entity(name = "facturacabecera")
@Table(name = "facturacabecera")
public class Factura_Cabecera implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * id atributo principal del modelo Factura Cabecera
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private int id;
	@Column(length = 10)
	/**
	 * atributo numero de factura
	 */
	private int numero;
	/**
	 * atributo que contine el subtotal suma del iva*subtotal
	 */
	private double subtotal;
	/**
	 * atributo que contine el iva del modelo Factura Cabecera
	 */
	private double iva;
	/**
	 * atributo que contiene el total de compras del modelo factura cabcecera
	 */
	private double total;
	/**
	 * atributo que verifica si el estdo de la factura esta pagado
	 */
	private boolean estado;

	/**
	 * 
	 * @return obtiene la variable estado que compruba si una factura esta pagada
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * 
	 * @param estado toma el paramtro esatdo para se asignado a la variable esatdo del modelo factura Cabecera
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Relacion JAP que relaciona la factura Cabcera Con la Factura detalle
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "f_cabecera", referencedColumnName = "id")
	/**
	 * Lista de Fcatura detalle que tiene un producto
	 */
	private List<Factura_Detalle> fdetalle;

	/**
	 * 
	 * @return obtine el la variable id que esta en le modelo Factura Cabcera
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id toma el id de parametro para ser asignada a la variable id del metodo
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return obtiene el numero del modelo Factura Cabecera
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero toma el paramtro numero para ser asignada a la variable numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return obtine la variable subtotal del modelo factura cabecera
	 */
	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * 
	 * @param subtotal toma el parametro subtotal para ser asignada al la variable subtotla
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * 
	 * @return obtine el iva del modelo factura cabecera
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * 
	 * @param iva toma el paramtro iva para se insertado en la variable iva
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * 
	 * @return obtien el totakl del modelo del a factura cabecera
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total toma el parametro total para ser asignado a la variable total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * 
	 * @return obtine la lsita de factura detalle dentro del modelo factura cabecera
	 */
	public List<Factura_Detalle> getFdetalle() {
		return fdetalle;
	}

	/**
	 * 
	 * @param fdetalle toma el parametro tipo List fdetalle para ser asigando al la variable fdetalle
	 */
	public void setFdetalle(List<Factura_Detalle> fdetalle) {
		this.fdetalle = fdetalle;
	}

	/**
	 * Metodo sobre escrito que parsea datos para su interpretacion
	 */
	@Override
	public String toString() {
		return "Factura_Cabecera [id=" + id + ", numero=" + numero + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", total=" + total + ", fdetalle=" + fdetalle + "]";
	}

}
