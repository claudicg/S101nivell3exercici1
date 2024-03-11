package n3exercici1.main;

import n3exercici1.handlers.AplicacionHandler;
import n3exercici1.handlers.Redaccion;

public class RedaccionNoticiasMain {
	

	public static void main(String[] args) {
		
		Redaccion redaccion = new Redaccion();
		AplicacionHandler.ejecutarAplicacion(redaccion);
	}	
}


