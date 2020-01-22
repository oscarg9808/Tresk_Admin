package ec.edu.ups.tesk.ON;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.CategoriaDAO;
import ec.edu.ups.tesk.datos.ProductoDAO;
import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Productos;

@ManagedBean
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
