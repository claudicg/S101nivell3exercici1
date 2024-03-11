package n3exercici1.handlers;

import java.util.Scanner;

import n3exercici1.beans.Noticia;
import n3exercici1.beans.NoticiaBaloncesto;
import n3exercici1.beans.NoticiaF1;
import n3exercici1.beans.NoticiaFutbol;
import n3exercici1.beans.NoticiaMotociclismo;
import n3exercici1.beans.NoticiaTenis;
import n3exercici1.beans.Redactor;
import n3exercici1.enums.TiposNoticiasEnum;

public class AplicacionHandler {
	
	private static Scanner entrada = new Scanner(System.in);
	
	

	public static void ejecutarAplicacion(Redaccion redaccion) {
		
		String opcion = "";
			
		do {
				
			System.out.println(getMenuGeneral());
			opcion = cogerOpcion();
			procesarOpcion(opcion, redaccion);
				
		} while(!opcion.equalsIgnoreCase("8"));
			
		System.out.println(getMensajeDespedida());
			
		entrada.close();
			
	}

	//----- MÉTODOS PARA MENÚS Y MENSAJES -----------------------------------------------------------------------------
		
	private static String getMenuGeneral() {
			
		StringBuilder sb = new StringBuilder();
			
		sb.append("AGENCIA DE NOTICIAS\n\n");
		sb.append("1. - Introducir redactor/a.\n");
		sb.append("2. - Eliminar redactor/a.\n");
		sb.append("3. - Introducir una noticia a un redactor/a.\n");
		sb.append("4. - Eliminar una noticia.\n");
		sb.append("5. - Mostrar todas las noticias por redactor/a.\n");
		sb.append("6. - Calcular puntuación de una noticia.\n");
		sb.append("7. - Calcular precio de una noticia.\n");
		sb.append("8. - Salir.\n\n");
			
		return sb.toString();
	}
		
	private static String getMensajeDespedida() {
			
		return "Agencia de noticias cerrada.";
			
	}
		
	private static String getMenuTipoNoticia() {
			
		StringBuilder sb = new StringBuilder();
			
		sb.append("TIPO DE NOTICIA\n\n");
		sb.append("1. - ").append(TiposNoticiasEnum.FUTBOL.getNombreTipo()).append(".\n");
		sb.append("2. - ").append(TiposNoticiasEnum.BALONCESTO.getNombreTipo()).append(".\n");
		sb.append("3. - ").append(TiposNoticiasEnum.TENIS.getNombreTipo()).append(".\n");
		sb.append("4. - ").append(TiposNoticiasEnum.F1.getNombreTipo()).append(".\n");
		sb.append("5. - ").append(TiposNoticiasEnum.MOTOCICLISMO.getNombreTipo()).append(".\n");
			
		return sb.toString();
			
	}
		
	//----- SWITCH -----------------------------------------------------------------------------

	private static void procesarOpcion(String opcion, Redaccion redaccion) {
			
		switch(opcion) {
			case "1":
				System.out.println(introducirRedactor(redaccion));
				break;
			case "2":
				System.out.println(eliminarRedactor(redaccion));
				break;
			case "3":
				System.out.println(crearYAsignarNoticiaARedactor(redaccion));
				break;
			case "4":
				System.out.println(borrarNoticia(redaccion));
				break;
			case "5":
				System.out.println(mostrarTodasNoticiasRedactor(redaccion));
				break;
			case "6":
				System.out.println(calcularPuntuacionNoticia(redaccion));
				break;
			case "7":
				System.out.println(calcularPrecioNoticia(redaccion));
				break;
			default:
				break;
		}
			
	}

	//----- MÉTODOS RECOLECTORES DE DATOS -----------------------------------------------------------------------------
		
	private static String cogerOpcion() {
			
		String opcion = entrada.nextLine();
			
		while(!esOpcionGeneralValida(opcion.trim())) {
			System.out.println("Opción inválida. Introduzca una opción válida del menú.\n");
			opcion = entrada.nextLine();
		}
			
		return opcion;
			
	}
		
	private static String cogerNombreRedactor() {
			
		System.out.println("Introduzca el nombre del redactor/a:\n");
		String nombreRedactor = entrada.nextLine();
		return nombreRedactor.trim().toUpperCase();
			
	}
		
	private static String cogerDniRedactor() {
			
		System.out.println("Introduzca el DNI del redactor/a:\n");
		String dniRedactor = entrada.nextLine();
		return dniRedactor.trim().toUpperCase();
			
	}
		
	private static String cogerTitularNoticia() {
			
		System.out.println("Introduzca el titular de la noticia:\n");
		String titularNoticia = entrada.nextLine();
		return titularNoticia.trim();
			
	}
		
	private static String cogerTipoNoticia() {
			
		String opcion = "";
			
		while(!esOpcionTipoValida(opcion.trim())) {
			System.out.println("Seleccione un tipo de noticia del menú:\n");
			System.out.println(getMenuTipoNoticia());
			opcion = entrada.nextLine();
		}

		return mapearOpcionTipoNoticia(opcion);
			
	}
		
	private static String cogerJugador() {
			
		System.out.println("Introduzca el jugador destacado:\n");
		String jugador = entrada.nextLine();
		return jugador.trim();
			
	}
		
	private static String cogerCompeticion() {
			
		System.out.println("Introduzca la competición:\n");
		String competicion = entrada.nextLine();
		return competicion.trim();
			
	}
		
	private static String cogerTenista(String otroTenista) {
			
		String tenista = "";
			
		if(otroTenista.equals("")) {
				
			System.out.println("Introduzca el tenista 1:\n");
			tenista = entrada.nextLine();
				
			while(tenista.equals("")) {
				System.out.println("Introduzca el tenista 1:\n");
				tenista = entrada.nextLine();
			}
				
		} else {
				
			System.out.println("Introduzca el tenista 2:\n");
			tenista = entrada.nextLine();
				
			while(tenista.equals("") || tenista.equalsIgnoreCase(otroTenista)) {
				System.out.println("Introduzca el tenista 2:\n");
				tenista = entrada.nextLine();
			}
				
		}

		return tenista.trim();
			
	}
		
	private static String cogerEscuderia() {
			
		System.out.println("Introduzca la escuderia:\n");
		String escuderia = entrada.nextLine();
		return escuderia.trim();
			
	}
		
	private static String cogerEquipo() {
			
		System.out.println("Introduzca el equipo:\n");
		String equipo = entrada.nextLine();
		return equipo.trim();
			
	}

	//----- MÉTODOS DEL SWITCH -----------------------------------------------------------------------------
		
	private static String introducirRedactor(Redaccion redaccion) {
			
		String nombreRedactor = cogerNombreRedactor();
		String dniRedactor = cogerDniRedactor();
		Redactor redactor = new Redactor(nombreRedactor, dniRedactor);
			
		String resultado = redaccion.introducirRedactor(redactor);
			
		return resultado;
			
	}
		
	private static String eliminarRedactor(Redaccion redaccion) {
			
		String dniRedactor = cogerDniRedactor();
			
		String resultado = redaccion.eliminarRedactor(dniRedactor);
			
		return resultado;
					
	}
		
	private static String crearYAsignarNoticiaARedactor(Redaccion redaccion) {
			
		String dniRedactor = cogerDniRedactor();
		String tipoNoticia = cogerTipoNoticia();
			
		Noticia noticia = null;
			
		//crea noticia de fútbol
		if(tipoNoticia.equalsIgnoreCase(TiposNoticiasEnum.FUTBOL.getNombreTipo())) {
				
			String titularNoticia = cogerTitularNoticia();
			String competicion = cogerCompeticion();
			String equipo = cogerEquipo();
			String jugador = cogerJugador();
				
			noticia = new NoticiaFutbol(titularNoticia, competicion, equipo, jugador);
			
		//crea noticia de baloncesto
		} else if(tipoNoticia.equalsIgnoreCase(TiposNoticiasEnum.BALONCESTO.getNombreTipo())) {
				
			String titularNoticia = cogerTitularNoticia();
			String competicion = cogerCompeticion();
			String equipo = cogerEquipo();
				
			noticia = new NoticiaBaloncesto(titularNoticia, competicion, equipo);
			
		//crea noticia de tenis
		} else if(tipoNoticia.equalsIgnoreCase(TiposNoticiasEnum.TENIS.getNombreTipo())) {
				
			String titularNoticia = cogerTitularNoticia();
			String competicion = cogerCompeticion();
			String tenista1 = "";
			String tenista2 = "";
			tenista1 = cogerTenista(tenista2);
			tenista2 = cogerTenista(tenista1);
				
			noticia = new NoticiaTenis(titularNoticia, competicion, tenista1, tenista2);
				
		//crea noticia de F1
		} else if(tipoNoticia.equalsIgnoreCase(TiposNoticiasEnum.F1.getNombreTipo())) {
				
			String titularNoticia = cogerTitularNoticia();
			String escuderia = cogerEscuderia();
				
			noticia = new NoticiaF1(titularNoticia, escuderia);
				
		//crea noticia de motociclismo
		} else {
				
			String titularNoticia = cogerTitularNoticia();
			String equipo = cogerEquipo();
				
			noticia = new NoticiaMotociclismo(titularNoticia, equipo);
				
		}
			
		String resultado = redaccion.asignarNoticiaARedactor(dniRedactor, noticia);
			
		return resultado;
			
	}
		
	private static String borrarNoticia(Redaccion redaccion) {
			
		String dniRedactor = cogerDniRedactor();
		String titularNoticia = cogerTitularNoticia();
			
		String resultado = redaccion.borrarNoticia(dniRedactor, titularNoticia);
			
		return resultado;
			
	}
		
	private static String mostrarTodasNoticiasRedactor(Redaccion redaccion) {
			
		String dniRedactor = cogerDniRedactor();
			
		String resultado = redaccion.mostrarTodasNoticiasRedactor(dniRedactor);
			
		return resultado;
			
	}
		
	private static String calcularPuntuacionNoticia(Redaccion redaccion) {
			
		String titularNoticia = cogerTitularNoticia();
			
		String resultado = redaccion.calcularPuntuacionNoticia(titularNoticia);
			
		return resultado;
			
	}
		
	private static String calcularPrecioNoticia(Redaccion redaccion) {
			
		String titularNoticia = cogerTitularNoticia();
			
		String resultado = redaccion.calcularPrecioNoticia(titularNoticia);
			
		return resultado;
			
	}
		
	//----- MÉTODOS DE VALIDACIÓN -----------------------------------------------------------------------------
		
	private static boolean esOpcionGeneralValida(String opcion) {
			
			
		return opcion.equals("1")
				|| opcion.equals("2")
				|| opcion.equals("3")
				|| opcion.equals("4")
				|| opcion.equals("5")
				|| opcion.equals("6")
				|| opcion.equals("7")
				|| opcion.equals("8");
			
	}
		
	private static boolean esOpcionTipoValida(String opcion) {
			
			
			
		return opcion.equals("1")
				|| opcion.equals("2")
				|| opcion.equals("3")
				|| opcion.equals("4")
				|| opcion.equals("5");
			
	}
		
	
		
	private static String mapearOpcionTipoNoticia(String opcion) {
			
		String tipoNoticia = "";
			
		if("1".equals(opcion)) {
			tipoNoticia = TiposNoticiasEnum.FUTBOL.getNombreTipo();
		} else if("2".equals(opcion)) {
			tipoNoticia = TiposNoticiasEnum.BALONCESTO.getNombreTipo();
		} else if("3".equals(opcion)) {
			tipoNoticia = TiposNoticiasEnum.TENIS.getNombreTipo();
		} else if("4".equals(opcion)) {
			tipoNoticia = TiposNoticiasEnum.F1.getNombreTipo();
		} else {
			tipoNoticia = TiposNoticiasEnum.MOTOCICLISMO.getNombreTipo();
		}
			
		return tipoNoticia;
			
	}	
		
}
