package ec.ups.edu.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Productos;
import ec.ups.edu.DAO.CategoriaDAO;
import ec.ups.edu.DAO.ProductoDAO;



@Stateless
public class CategoriasOn {

	
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
		CategoriasOn c = new CategoriasOn();
		System.out.println(c.getCategoriasL());
	}
	
}
