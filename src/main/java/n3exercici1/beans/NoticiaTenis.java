package n3exercici1.beans;

import n3exercici1.utils.Constants;

public class NoticiaTenis extends Noticia {
	
	private String competicion = "";
	private String tenista1 = "";
	private String tenista2 = "";
	
	public NoticiaTenis(String titular, String competicion, String tenista1, String tenista2) {
		super(titular);
		this.competicion = competicion;
		this.tenista1 = tenista1;
		this.tenista2 = tenista2;
	}

	public String getCompeticion() {
		return competicion;
	}

	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}

	public String getTenista1() {
		return tenista1;
	}

	public void setTenista1(String tenista1) {
		this.tenista1 = tenista1;
	}

	public String getTenista2() {
		return tenista2;
	}

	public void setTenista2(String tenista2) {
		this.tenista2 = tenista2;
	}

	@Override
	public String toString() {
		return super.toString() + " NoticiaTenis [ competicion = " + competicion 
													+ ", tenista1 = " + tenista1 
													+ ", tenista2 = " + tenista2 + " ]";
	}

	@Override
	public void calcularPuntuacion() {
		
		int puntosIniciales = Constants.PuntosNoticias.TENIS;
		
		int puntosJugador = 0;
		if(this.tenista1.equalsIgnoreCase(Constants.Nombres.FEDERER)
				|| this.tenista1.equalsIgnoreCase(Constants.Nombres.NADAL)
				|| this.tenista1.equalsIgnoreCase(Constants.Nombres.DJOKOVIC)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.FEDERER)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.NADAL)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.DJOKOVIC)) {
			puntosJugador = Constants.PuntosDeportistaEscuderia.TENIS_FEDERER_NADAL_DJOKOVIC;
		} else {
			puntosJugador = Constants.PuntosDeportistaEscuderia.OTRO;
		}
		
		int puntosTotales = puntosIniciales + puntosJugador;
		
		super.setPuntuacion(puntosTotales);
		
	}

	@Override
	public void calcularPrecio() {
		
		int precioInicial = Constants.PrecioInicialNoticias.TENIS;
		
		int precioJugador = 0;
		if(this.tenista1.equalsIgnoreCase(Constants.Nombres.FEDERER)
				|| this.tenista1.equalsIgnoreCase(Constants.Nombres.NADAL)
				|| this.tenista1.equalsIgnoreCase(Constants.Nombres.DJOKOVIC)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.FEDERER)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.NADAL)
				|| this.tenista2.equalsIgnoreCase(Constants.Nombres.DJOKOVIC)) {
			precioJugador = Constants.PrecioDeportistaEscuderia.TENIS_FEDERER_NADAL_DJOKOVIC;
		} else {
			precioJugador = Constants.PrecioDeportistaEscuderia.OTRO;
		}
		
		int precioTotal = precioInicial + precioJugador;
		
		super.setPrecio(precioTotal);
		
	}


}
