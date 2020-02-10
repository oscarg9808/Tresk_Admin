package ec.ups.edu.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.negociointerface.Tresklocal;
import ec.ups.edu.datos.CategoriaDAO;

@ManagedBean
@SessionScoped
public class CategoriaBean {

	private Categorias cate;
	public int pro;
	public String nombre;

	@Inject
	private Tresklocal tresk;

	@PostConstruct
	private void init() {
		cate = new Categorias();
	}

	public Categorias getCate() {
		return cate;
	}

	public void setCate(Categorias cate) {
		this.cate = cate;
	}

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

	/**
	 * 
	 * @return
	 */
	public List<Categorias> listarCategorias() {
		limpiar();
		return tresk.getCategoriasL();
	}

	/**
	 * 
	 * @return
	 */
	public String addProductos() {
		System.out.println("add prod");
		cate.addProducto(new Productos());
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String guardar() {
		System.out.println(cate);
		tresk.guardarcat(cate);
		return null;
	}

	/*
	 * public String Buscar() { System.out.println(catdao.leer(pro));
	 * this.cate=catdao.leer(pro);
	 * 
	 * return null; }
	 */
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public Categorias Buscarcate(String nombre) {
		System.out.println(nombre + "Variabl enombre de produto");
		cate = tresk.buscate(nombre);
		System.out.println("555555555555555555555555555" + nombre);
		return null;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void eliminar(int codigo) {
		tresk.delete(codigo);
	}

	/**
	 * 
	 * @param categ
	 * @return
	 */
	public String update(Categorias categ) {
		tresk.actualizarcate(categ);
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String limpiar() {
		this.cate.setId(0);
		this.cate.setNombre("");
		this.cate.setProductos(new ArrayList<Productos>());
		return "Categorias.xhtml";
	}
}
