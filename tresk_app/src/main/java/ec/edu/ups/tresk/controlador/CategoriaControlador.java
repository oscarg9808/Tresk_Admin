package ec.edu.ups.tresk.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.CategoriaDAO;
import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Productos;

@ManagedBean
@ViewScoped
public class CategoriaControlador {

		private Categorias cate;
		public int pro;
		
		@Inject 
		private CategoriaDAO catdao;

		@PostConstruct
		private void init() {
			cate = new Categorias();
			cate.addProducto(new Productos());
			
		}

		public Categorias getCate() {
			return cate;
		}

		public void setCate(Categorias cate) {
			this.cate = cate;
		}

		public String addProductos() {
			System.out.println("add prod");
			cate.addProducto(new Productos());
			return null;
		}

		public String guardar() {
			System.out.println(cate);
			catdao.insertar(cate);
			return null;
		}	
		
		public String Buscar() {
			System.out.println(catdao.leer(pro));
			catdao.leer(pro);
			return null;
		}

		public int getPro() {
			return pro;
		}

		public void setPro(int pro) {
			this.pro = pro;
		}
		
		
		
}
