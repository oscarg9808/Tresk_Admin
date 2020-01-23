package ec.edu.ups.tresk.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.tesk.ON.CategoriasOn;
import ec.edu.ups.tesk.datos.ProductoDAO;
import ec.edu.ups.tesk.modelo.Productos;
import ec.edu.ups.tresk.Bean.ProductoBean;



@Path("/productos")
public class ProductosService {
	

	@Inject 
	private ProductoDAO prodao;
	@Inject
	private CategoriasOn ca;
	@Inject
	private ProductoBean pc;
	
	@GET
	@Path("/ProductosLis")
	@Produces("application/json")
	public List<Productos> getProductos(){
		return pc.listarP();
	}
	
	@POST
	@Path("/busproducto")
	@Consumes("application/json")
	@Produces("application/json")
	public Productos  producto(Productos p) {
		Productos pr = new Productos();
		try {
			pr = ca.getProducto(p.getId());
			return pr;
		}catch (Exception e) {
			System.out.println("error en curso");
		}
		return pr;
	}
}
