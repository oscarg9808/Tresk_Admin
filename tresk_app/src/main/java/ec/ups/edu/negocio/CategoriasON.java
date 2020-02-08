package ec.ups.edu.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Productos;
import ec.ups.edu.datos.CategoriaDAO;
import ec.ups.edu.datos.ProductoDAO;



@Stateless
public class CategoriasON {

	
	@Inject
	private CategoriaDAO categdao;
	@Inject
	private ProductoDAO prodDao;
	
	private Categorias categorias;
	private List<Categorias> lisCat;
	
	
	public List<Categorias> getCategoriasL() {
		return categdao.listar();
	}
	
	public List<Productos> getProductos() {
		return prodDao.listar();
	}
	
	public Productos getProducto(int id) {
		return prodDao.leer(id);
	}
	
	public static void main(String arg []) {
		CategoriasON c = new CategoriasON();
		System.out.println(c.getCategoriasL());
	}
	
}
