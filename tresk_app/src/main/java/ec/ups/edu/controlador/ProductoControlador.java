package ec.ups.edu.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Estadisticas;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.ups.edu.DAO.FacturaDetalleDAO;
import ec.ups.edu.DAO.ProductoDAO;


@ManagedBean
@ViewScoped
public class ProductoControlador {

		private Productos prod;
		public int p;
		
		@Inject 
		private ProductoDAO pdao;
		@Inject
		private FacturaDetalleDAO facturaDetalleDAO;

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

		public List<Estadisticas> resporteDeProductos() {
			List<Productos> productosLisT = pdao.listar();
			List<Factura_Detalle> detallesList = facturaDetalleDAO.getlistar();
			List<Estadisticas> estadisticasLista = new ArrayList<Estadisticas>();
			Estadisticas estadisticas;
			int canitdad=0;

			for (Productos productos : productosLisT) {
				estadisticas = new Estadisticas();
				canitdad =0;
				for (Factura_Detalle factura_Detalle2 : detallesList) {
					
					if(productos.getId()==factura_Detalle2.getProductos().getId()) {
						canitdad =canitdad+factura_Detalle2.getCantidad();
					}
					
				}
				estadisticas.setCantidad(canitdad);
				estadisticas.setIdProducto(productos.getId());
				estadisticas.setNombre(productos.getNombre());
				estadisticasLista.add(estadisticas);
			}
			
			
			Collections.sort(estadisticasLista, new Comparator<Estadisticas>(){
	            @Override
	            public int compare(Estadisticas o1, Estadisticas o2) {
	                return o2.getCantidad() - (o1.getCantidad());
	            }

				
				
	        });
			
			for (Estadisticas estadisticas2 : estadisticasLista) {
				System.out.println(estadisticas2.toString());
			}
			
			
			
			return estadisticasLista;

		}
		




}
