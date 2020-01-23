package ec.edu.ups.tresk.Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.ProductoDAO;
import ec.edu.ups.tesk.modelo.Productos;

@ManagedBean
@ViewScoped
public class ProductoBean {

		private Productos prod;
		public int p;
		
		@Inject 
		private ProductoDAO pdao;

		@PostConstruct
		private void init() {
			prod = new Productos();
			
		}

		public int getP() {
			return p;
		}

		public void setP(int p) {
			this.p = p;
		}
		

		public Productos getProd() {
			return prod;
		}



		public void setProd(Productos prod) {
			this.prod = prod;
		}
		
		
		public List<Productos> listarP(){
			return this.pdao.listar();
		}
		

		public String guardar() {
			System.out.println(prod);
			pdao.insertar(prod);
			return null;
		}	
		
		public String Buscar() {
			System.out.println(pdao.leer(p));
			this.prod=pdao.leer(p);
						
			return null;
		}
		
		public void eliminar(int codigo) {
			pdao.borrar(codigo);			
		}
		
		public String update() {
			pdao.actualizar(prod);;
			return null;
		}





}
