package n3exercici1.beans;

import n3exercici1.utils.Constants;

public class NoticiaBaloncesto extends Noticia {
	
	private String competicion = "";
	private String club = "";
	
	public NoticiaBaloncesto(String titular, String competicion, String club) {
		super(titular);
		this.competicion = competicion;
		this.club = club;
	}

	public String getCompeticion() {
		return competicion;
	}

	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return super.toString() + " NoticiaBaloncesto [ competicion = " + competicion 
															+ ", club = " + club + " ]";
	}

	@Override
	public void calcularPuntuacion() {
		
		int puntosIniciales = Constants.PuntosNoticias.BALONCESTO;
		
		int puntosCompeticion = 0;
		if(this.competicion.equalsIgnoreCase(Constants.Nombres.EUROLIGA)) {
			puntosCompeticion = Constants.PuntosCampeonato.EUROLIGA;
		} else if(this.competicion.equalsIgnoreCase(Constants.Nombres.ACB)) {
			puntosCompeticion = Constants.PuntosCampeonato.ACB;
		} else {
			puntosCompeticion = Constants.PuntosCampeonato.OTRO;
		}
		
		int puntosEquipo = 0;
		if(this.club.equalsIgnoreCase(Constants.Nombres.BARCA)
				|| this.club.equalsIgnoreCase(Constants.Nombres.MADRID)) {
			puntosEquipo = Constants.PuntosEquipo.BALONCESTO_BARCA_MADRID;
		} else {
			puntosEquipo = Constants.PuntosEquipo.OTRO;
		}
		
		int puntosTotales = puntosIniciales + puntosCompeticion + puntosEquipo;
		
		super.setPuntuacion(puntosTotales);
		
	}

	@Override
	public void calcularPrecio() {
		
		int precioInicial = Constants.PrecioInicialNoticias.BALONCESTO;
		
		int precioCompeticion = 0;
		if(this.competicion.equalsIgnoreCase(Constants.Nombres.EUROLIGA)) {
			precioCompeticion = Constants.PrecioCampeonato.EUROLIGA;
		} else {
			precioCompeticion = Constants.PrecioCampeonato.OTRO;
		}
		
		int precioEquipo = 0;
		if(this.club.equalsIgnoreCase(Constants.Nombres.BARCA)
				|| this.club.equalsIgnoreCase(Constants.Nombres.MADRID)) {
			precioEquipo = Constants.PrecioEquipo.BALONCESTO_BARCA_MADRID;
		} else {
			precioEquipo = Constants.PrecioEquipo.OTRO;
		}
		
		int precioTotal = precioInicial + precioCompeticion + precioEquipo;
		
		super.setPrecio(precioTotal);
		
	}


}
