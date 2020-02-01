package ec.ups.edu.servicio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.modelo.Productos;
import ec.ups.edu.ON.CategoriasOn;




@Path("/tresk")
public class Servicio {
	
	@Inject
	private CategoriasOn categoriasOn;
	
	
	@GET
	@Path("/productos")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Productos> realizaCredito() {
		
		return categoriasOn.getProductos();
	}

}
