package n3exercici1.beans;

public abstract class Noticia {
	
	public String titular = "";
	public String texto = "";
	public int puntuacion = 0;
	public int precio = 0;
	
	public Noticia(String titular) {
		super();
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Noticia [ titular = " + titular 
							+ ", texto = " + texto 
							+ ", puntuacion = " + puntuacion 
							+ ", precio = " + precio + " ]";
	}

	//métodos abstractos
	public abstract void calcularPuntuacion();
	
	public abstract void calcularPrecio();


}
