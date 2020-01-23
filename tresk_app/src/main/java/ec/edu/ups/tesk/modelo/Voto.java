package ec.edu.ups.tesk.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "voto")
public class Voto {

	@Id
	@Column(length = 10)
	private int id;
	@Column(length = 100)
	private int numvoto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumvoto() {
		return numvoto;
	}
	public void setNumvoto(int numvoto) {
		this.numvoto = numvoto;
	}
	@Override
	public String toString() {
		return "Voto [id=" + id + ", numvoto=" + numvoto + "]";
	}
	
	
}
