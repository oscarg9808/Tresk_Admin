package ec.ups.edu.vista;

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
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negociointerface.Tresklocal;
import ec.ups.edu.datos.FacturaDetalleDAO;
import ec.ups.edu.datos.ProductoDAO;

@ManagedBean
@SessionScoped
public class ProductoBean {

	private Productos prod;
	public int p;
	public String nombre;

	
	@Inject
	private Tresklocal tresk;

	@PostConstruct
	private void init() {
		prod = new Productos();

	}
/**
 * 
 * @return
 */
	public int getP() {
		return p;
	}
/**
 * 
 * @param p
 */
	public void setP(int p) {
		this.p = p;
	}
/**
 * 
 * @return
 */
	public Productos getProd() {
		return prod;
	}
/**
 * 
 * @param prod
 */
	public void setProd(Productos prod) {
		this.prod = prod;
	}
/**
 * 
 * @return
 */
	public List<Productos> listarProductos() {
		limpiar();
		return tresk.getProductos();
	}
/**
 * 
 * @return
 */
	public String guardar() {
		tresk.nuevoprod(prod);
		return null;
	}
/**
 * 
 * @param nombre
 * @return
 */
	public Productos Buscarpro(String nombre) {
		System.out.println(nombre+"Variabl enombre de produto");
		prod = tresk.busprod(nombre);
		System.out.println("555555555555555555555555555"+nombre);
		return null;
	}

	/*public String Buscarnom() {
		System.out.println(pdao.leernom(nombre));
		this.prod = pdao.leernom(nombre);

		return null;
	}*/
/**
 * 
 * @param codigo
 */
	public void eliminar(int codigo) {
		tresk.eliminar(codigo);
	}
/**
 * 
 * @param produ
 * @return
 */
	public String update(Productos produ) {
		tresk.actualizar(produ);
		return null;
	}
/**
 * 
 * @return
 */
	public List<Estadisticas> resporteDeProductos() {
		List<Productos> productosLisT = tresk.listarp();
		List<Factura_Detalle> detallesList = tresk.factlist();
		List<Estadisticas> estadisticasLista = new ArrayList<Estadisticas>();
		Estadisticas estadisticas;
		int canitdad = 0;

		for (Productos productos : productosLisT) {
			estadisticas = new Estadisticas();
			canitdad = 0;
			for (Factura_Detalle factura_Detalle2 : detallesList) {

				if (productos.getId() == factura_Detalle2.getProductos().getId()) {
					canitdad = canitdad + factura_Detalle2.getCantidad();
				}

			}
			estadisticas.setCantidad(canitdad);
			estadisticas.setIdProducto(productos.getId());
			estadisticas.setNombre(productos.getNombre());
			estadisticasLista.add(estadisticas);
		}

		Collections.sort(estadisticasLista, new Comparator<Estadisticas>() {
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
	

	/**
	 * 
	 * @return
	 */
	public Productos productoasMasBotados() {
		List<Productos> getListaproductos = tresk.getProductos();
		Productos productosN = new Productos();
		int productosV=0;
		int productosAnteriores=0;
		for (Productos productos : getListaproductos) {
			
		productosV = productos.getVoto().size();
			if(productosV>productosAnteriores) {
				System.out.println("******************************************");
				System.out.println(productos.toString());
				productosN = productos;
			}
			productosAnteriores = productos.getVoto().size();
			
		}
		/*System.out.println("productos");
		System.out.println(productosN.toString());
		System.out.println("BBBBBBBBBBBBBBBBBBBBBB");*/
		return productosN;
	}
	/**
	 * 
	 * @return
	 */
	public Usuario usuarioMasComprado() {		
		List<Usuario> getListaUsuarios = tresk.getUsuarioList();
		Usuario usuario = new Usuario();
		int facturas=0;
		int factutasAnteriores=0;
		for (Usuario usuarioLis : getListaUsuarios) {
			
		facturas = usuarioLis.getFactura_Cabeceras().size();
			if(facturas>factutasAnteriores) {
				usuario = usuarioLis;
			}
				factutasAnteriores = usuarioLis.getFactura_Cabeceras().size();
			
		}
		System.out.println("Usuarios");
		System.out.println(usuario.toString());
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		return usuario;
	}
	
/**
 * 
 * @return
 */
	public String limpiar() {
		this.prod.setId(0);
		this.prod.setNombre("");
		this.prod.setDescripcion("");
		this.prod.setCategoria(0);
		this.prod.setPrecio_uni(0);
		this.prod.setUrlImagen("");
		this.prod.setStock(0);
		
		return "Productos.xhtm";
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

}
