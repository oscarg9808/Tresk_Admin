package ec.ups.edu.vista;

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
		
		
		
		public List<Categorias> listarCategorias(){
			return tresk.getCategoriasL();
		}
		
		public String addProductos() {
			System.out.println("add prod");
			cate.addProducto(new Productos());
			return null;
		}

		public String guardar() {
			System.out.println(cate);
			tresk.guardarcat(cate);
			return null;
		}	
		
		/*public String Buscar() {
			System.out.println(catdao.leer(pro));
			this.cate=catdao.leer(pro);
						
			return null;
		}
		
		public String Buscarnom() {
			System.out.println(catdao.leernom(nombre));
			this.cate=catdao.leernom(nombre);
						
			return null;
		}*/
		
		public void eliminar(int codigo) {
			tresk.delete(codigo);		
		}
		
		/*public String update() {
			catdao.actualizar(cate);
			return null;
		}
*/
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
}
