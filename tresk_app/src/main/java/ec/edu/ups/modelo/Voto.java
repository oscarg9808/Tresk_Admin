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
 * @(#)voto.java 08/01/20
 * 
 * Copyright 2020 1.0.0 UPS.
 * Proyecto Final APP DIST. Aprendizaje.
 */

/**
 * Esta clase hace referencia a la entidad Voto
 * para calificar al producto.
 *
 * @author Oscar Pizarro
 * @author Jose Atariguano
 * @version 1.0.0 08/01/20
 * @since 1.4 REVISARRR.......................
 */

@Entity(name = "voto")
@Table(name = "voto")
public class Voto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 100)
	private int numvoto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumvoto() {
		return numvoto;
	}
	public void setNumvoto(int numvoto) {
		this.numvoto = numvoto;
	}
	
	
}
