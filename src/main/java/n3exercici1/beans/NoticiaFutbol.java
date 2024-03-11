package n3exercici1.beans;

import n3exercici1.utils.Constants;

public class NoticiaFutbol extends Noticia {
	
	private String competicion = "";
	private String club = "";
	private String jugador = "";
	
	public NoticiaFutbol(String titular, String competicion, String club, String jugador) {
		super(titular);
		this.competicion = competicion;
		this.club = club;
		this.jugador = jugador;
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return super.toString() + " NoticiaFutbol [ competicion = " + competicion 
													+ ", club = " + club 
													+ ", jugador = " + jugador + " ]";
	}

	@Override
	public void calcularPuntuacion() {
		
		int puntosIniciales = Constants.PuntosNoticias.FUTBOL;
		
		int puntosCompeticion = 0;
		if(this.competicion.equalsIgnoreCase(Constants.Nombres.CHAMPIONS)) {
			puntosCompeticion = Constants.PuntosCampeonato.CHAMPIONS;
		} else if(this.competicion.equalsIgnoreCase(Constants.Nombres.LIGA)) {
			puntosCompeticion = Constants.PuntosCampeonato.LIGA;
		} else {
			puntosCompeticion = Constants.PuntosCampeonato.OTRO;
		}
		
		int puntosEquipo = 0;
		if(this.club.equalsIgnoreCase(Constants.Nombres.BARCA)
				|| this.club.equalsIgnoreCase(Constants.Nombres.MADRID)) {
			puntosEquipo = Constants.PuntosEquipo.FUTBOL_BARCA_MADRID;
		} else {
			puntosEquipo = Constants.PuntosEquipo.OTRO;
		}
		
		int puntosJugador = 0;
		if(this.jugador.equalsIgnoreCase(Constants.Nombres.TORRES)
				|| this.jugador.equalsIgnoreCase(Constants.Nombres.BENZEMA)) {
			puntosJugador = Constants.PuntosDeportistaEscuderia.FUTBOL_TORRES_BENZEMA;
		} else {
			puntosJugador = Constants.PuntosDeportistaEscuderia.OTRO;
		}
		
		int puntosTotales = puntosIniciales + puntosCompeticion + puntosEquipo + puntosJugador;
		
		super.setPuntuacion(puntosTotales);
		
	}

	@Override
	public void calcularPrecio() {
		
		int precioInicial = Constants.PrecioInicialNoticias.FUTBOL;
		
		int precioCompeticion = 0;
		if(this.competicion.equalsIgnoreCase(Constants.Nombres.CHAMPIONS)) {
			precioCompeticion = Constants.PrecioCampeonato.CHAMPIONS;
		} else {
			precioCompeticion = Constants.PrecioCampeonato.OTRO;
		}
		
		int precioEquipo = 0;
		if(this.club.equalsIgnoreCase(Constants.Nombres.BARCA)
				|| this.club.equalsIgnoreCase(Constants.Nombres.MADRID)) {
			precioEquipo = Constants.PrecioEquipo.FUTBOL_BARCA_MADRID;
		} else {
			precioEquipo = Constants.PrecioEquipo.OTRO;
		}
		
		int precioJugador = 0;
		if(this.jugador.equalsIgnoreCase(Constants.Nombres.TORRES)
				|| this.jugador.equalsIgnoreCase(Constants.Nombres.BENZEMA)) {
			precioJugador = Constants.PrecioDeportistaEscuderia.FUTBOL_TORRES_BENZEMA;
		} else {
			precioJugador = Constants.PrecioDeportistaEscuderia.OTRO;
		}
		
		int precioTotal = precioInicial + precioCompeticion + precioEquipo + precioJugador;
		
		super.setPrecio(precioTotal);
		
	}


}
