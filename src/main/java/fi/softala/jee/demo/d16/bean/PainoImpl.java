package fi.softala.jee.demo.d16.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PainoImpl implements Paino {
	
	private int id;
	private String pvm;
	
	@Size(min = 10, max = 999)
	private String paino;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	public String getPaino() {
		return paino;
	}
	public void setPaino(String paino) {
		this.paino = paino;
	}
	@Override
	public String toString() {
		return "PainoImpl [id=" + id + ", pvm=" + pvm + ", paino=" + paino
				+ "]";
	}
}
