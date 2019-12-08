package ec.edu.ups.tresk.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.CategoriaDAO;
import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Productos;

@ManagedBean
public class CategoriaControlador {

		private Categorias cate;
		
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



		public String guardar() {
			System.out.println(cate);
			catdao.insertar(cate);
			return null;
		}
		
}
