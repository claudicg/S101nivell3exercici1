package n3exercici1.beans;

import java.util.ArrayList;
import java.util.List;

import n3exercici1.utils.Constants;

public class Redactor {
	
	private String nombre = "";
	private String dni = "";
	private int sueldo = 0;
	private List<Noticia> noticias = null;
	
	public Redactor(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = Constants.Redactores.SUELDO;
		this.noticias = new ArrayList<>();	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public void cambiarSueldo() {
		this.sueldo = Constants.Redactores.SUELDO;
	}
	
	public void asignarNoticia(Noticia noticia) {
		this.noticias.add(noticia);
	}
	
	public void borrarNoticia(Noticia noticia) {
		this.noticias.remove(noticia);
	}

	@Override
	public String toString() {
		return "Redactor [ nombre = " + nombre 
							+ ", dni = " + dni 
							+ ", sueldo = " + sueldo 
							+ ", noticias ="  + noticias + " ]";
	}

}
