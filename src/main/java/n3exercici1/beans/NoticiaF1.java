package n3exercici1.beans;

import n3exercici1.utils.Constants;

public class NoticiaF1 extends Noticia {
	
	private String escuderia = "";
	
	public NoticiaF1(String titular, String escuderia) {
		super(titular);
		this.escuderia = escuderia;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	@Override
	public String toString() {
		return super.toString() + "NoticiaF1 [ escuderia = " + escuderia + " ]";
	}

	@Override
	public void calcularPuntuacion() {
		
		int puntosIniciales = Constants.PuntosNoticias.F1;
		
		int puntosEscuderia = 0;
		if(this.escuderia.equalsIgnoreCase(Constants.Nombres.FERRARI)
				|| this.escuderia.equalsIgnoreCase(Constants.Nombres.MERCEDES)) {
			puntosEscuderia = Constants.PuntosDeportistaEscuderia.F1_FERRARI_MERCEDES;
		} else {
			puntosEscuderia = Constants.PuntosDeportistaEscuderia.OTRO;
		}
		
		int puntosTotales = puntosIniciales + puntosEscuderia;
		
		super.setPuntuacion(puntosTotales);
		
	}

	@Override
	public void calcularPrecio() {
		
		int precioInicial = Constants.PrecioInicialNoticias.F1;
		
		int precioEscuderia = 0;
		if(this.escuderia.equalsIgnoreCase(Constants.Nombres.FERRARI)
				|| this.escuderia.equalsIgnoreCase(Constants.Nombres.MERCEDES)) {
			precioEscuderia = Constants.PrecioDeportistaEscuderia.F1_FERRARI_MERCEDES;
		} else {
			precioEscuderia = Constants.PrecioDeportistaEscuderia.OTRO;
		}
		
		int precioTotal = precioInicial + precioEscuderia;
		
		super.setPrecio(precioTotal);
		
	}


}
