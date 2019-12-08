package ec.edu.ups.tresk.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.ClienteDAO;
import ec.edu.ups.tesk.modelo.*;

@ManagedBean
public class ClienteControlador {

		private Clientes cliente;
		
		@Inject 
		private ClienteDAO cdao;

		@PostConstruct
		private void init() {
			cliente = new Clientes();
		}
		public Clientes getCliente() {
			return cliente;
		}

		public void setCliente(Clientes cliente) {
			this.cliente = cliente;
		}
		
		public String guardar() {
			System.out.println(cliente);
			cdao.insertar(cliente);
			return null;
		}
		
}
