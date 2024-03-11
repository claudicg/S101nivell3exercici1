package n3exercici1.beans;

import n3exercici1.utils.Constants;

public class NoticiaMotociclismo extends Noticia {
	
	private String equipo = "";
	
	public NoticiaMotociclismo(String titular, String equipo) {
		super(titular);
		this.equipo = equipo;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return super.toString() + " NoticiaMotociclismo [ equipo = " + equipo + " ]";
	}

	@Override
	public void calcularPuntuacion() {
		
		int puntosIniciales = Constants.PuntosNoticias.MOTOCICLISMO;
		
		int puntosEquipo = 0;
		if(this.equipo.equalsIgnoreCase(Constants.Nombres.HONDA)
				|| this.equipo.equalsIgnoreCase(Constants.Nombres.YAMAHA)) {
			puntosEquipo = Constants.PuntosDeportistaEscuderia.MOTOCICLISMO_HONDA_YAMAHA;
		} else {
			puntosEquipo = Constants.PuntosDeportistaEscuderia.OTRO;
		}
		
		int puntosTotales = puntosIniciales + puntosEquipo;
		
		super.setPuntuacion(puntosTotales);
		
	}

	@Override
	public void calcularPrecio() {
		
		int precioInicial = Constants.PrecioInicialNoticias.MOTOCICLISMO;
		
		int precioEquipo = 0;
		if(this.equipo.equalsIgnoreCase(Constants.Nombres.HONDA)
				|| this.equipo.equalsIgnoreCase(Constants.Nombres.YAMAHA)) {
			precioEquipo = Constants.PrecioDeportistaEscuderia.MOTOCICLISMO_HONDA_YAMAHA;
		} else {
			precioEquipo = Constants.PrecioDeportistaEscuderia.OTRO;
		}
		
		int precioTotal = precioInicial + precioEquipo;
		
		super.setPrecio(precioTotal);
		
	}


}
