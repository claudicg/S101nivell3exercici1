package n3exercici1.handlers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n3exercici1.beans.Noticia;
import n3exercici1.beans.NoticiaBaloncesto;
import n3exercici1.beans.NoticiaF1;
import n3exercici1.beans.NoticiaFutbol;
import n3exercici1.beans.NoticiaMotociclismo;
import n3exercici1.beans.NoticiaTenis;
import n3exercici1.beans.Redactor;

public class Redaccion {
	
	
	private List<Redactor> redactores = null;
	
	public Redaccion() {
		super();
		this.redactores = new ArrayList<>();
	}
	
	public String introducirRedactor(Redactor redactor) {
		
		
		
		String resultado = "";
		
		if(buscarRedactorPorDni(redactor.getDni()) == null) {
			
			this.redactores.add(redactor);
			
			if(existeRedactor(redactor)) {
				resultado =  "El redactor/a ha sido introducido correctamente.\n";
			} else {
				resultado =  "Error al introducir el redactor/a.\n";
			}
			
		} else {
			resultado =  "El redactor/a ya existe.\n";
		}
		
		return resultado;

	}
	
	public String eliminarRedactor(String dniRedactor) {
		
		String resultado = "";
		
		Redactor redactor = buscarRedactorPorDni(dniRedactor);
		
		if(redactor != null) {
			
			this.redactores.remove(redactor);
			
			if(!existeRedactor(redactor)) {
				resultado = "El redactor/a ha sido borrado/a correctamente.\n";
			} else {
				resultado = "Error al borrar el redactor/a.\n";
			}
			
		} else {
			resultado =  "El redactor/a no existe.\n";
		}
		
		return resultado;

	}
	
	public String asignarNoticiaARedactor(String dniRedactor, Noticia noticia) {
		
		String resultado = "";
		
		Redactor redactor = buscarRedactorPorDni(dniRedactor);
		
		if(redactor != null) {
			
			redactor.getNoticias().add(noticia);
			
			if(existeNoticia(noticia, redactor.getNoticias())) {
				resultado = "La noticia ha sido creada y asignada correctamente.\n";
			} else {
				resultado = "Error al crear o asignar la noticia.\n";
			}
			
		} else {
			resultado =  "El redactor/a no existe.\n";
		}
		
		return resultado;

	}
	
	public String borrarNoticia(String dniRedactor, String titularNoticia) {
		
		String resultado = "";
		
		Redactor redactor = buscarRedactorPorDni(dniRedactor);
		
		if(redactor != null) {
			
			Noticia noticia = buscarNoticiaPorTitularConociendoRedactor(redactor, titularNoticia);
			
			if(noticia != null) {
				
				redactor.getNoticias().remove(noticia);
				
				if(!existeNoticia(noticia, redactor.getNoticias())) {
					resultado = "La noticia ha sido borrada correctamente.\n";
				} else {
					resultado = "Error al borrar la noticia.\n";
				}
				
			} else {
				resultado =  "La noticia no existe.\n";
			}
			
		} else {
			resultado =  "El redactor/a no existe.\n";
		}
		
		return resultado;
		
	}
	
	public String mostrarTodasNoticiasRedactor(String dniRedactor) {
		
		String resultado = "";

		Redactor redactor = buscarRedactorPorDni(dniRedactor);
		
		if(redactor != null) {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("Noticias de ").append(redactor.getNombre()).append(":\n");
			
			if(redactor.getNoticias().isEmpty()) {
				sb.append("No tiene noticias asignadas.\n");
			} else {
				for(Noticia n : redactor.getNoticias()) {
					sb.append(n.toString()).append("\n");
				}
			}
			
			resultado = sb.toString();
			
		} else {
			resultado =  "El redactor/a no existe.\n";
		}
		
		return resultado;
		
	}
	
	public String calcularPuntuacionNoticia(String titularNoticia) {
		
		String resultado = "";
		
		Noticia noticia = buscarNoticiaPorTitularSinConocerRedactor(titularNoticia);
		
		if(noticia != null) {
			
			if(noticia instanceof NoticiaFutbol) {
				NoticiaFutbol nf = (NoticiaFutbol) noticia;
				nf.calcularPuntuacion();
			} else if(noticia instanceof NoticiaBaloncesto) {
				NoticiaBaloncesto nb = (NoticiaBaloncesto) noticia;
				nb.calcularPuntuacion();
			} else if(noticia instanceof NoticiaTenis) {
				NoticiaTenis nt = (NoticiaTenis) noticia;
				nt.calcularPuntuacion();
			} else if(noticia instanceof NoticiaF1) {
				NoticiaF1 nf1 = (NoticiaF1) noticia;
				nf1.calcularPuntuacion();
			} else if(noticia instanceof NoticiaMotociclismo) {
				NoticiaMotociclismo nm = (NoticiaMotociclismo) noticia;
				nm.calcularPuntuacion();
			}
			
			resultado = "La puntuación de la noticia es " + noticia.getPuntuacion() + " pto(s).";
			
		} else {
			resultado =  "La noticia no existe.\n";
		}
		
		return resultado;
		
	}
	
	public String calcularPrecioNoticia(String titularNoticia) {
		
		String resultado = "";
		
		Noticia noticia = buscarNoticiaPorTitularSinConocerRedactor(titularNoticia);
		
		if(noticia != null) {
			
			if(noticia instanceof NoticiaFutbol) {
				NoticiaFutbol nf = (NoticiaFutbol) noticia;
				nf.calcularPrecio();
			} else if(noticia instanceof NoticiaBaloncesto) {
				NoticiaBaloncesto nb = (NoticiaBaloncesto) noticia;
				nb.calcularPrecio();
			} else if(noticia instanceof NoticiaTenis) {
				NoticiaTenis nt = (NoticiaTenis) noticia;
				nt.calcularPrecio();
			} else if(noticia instanceof NoticiaF1) {
				NoticiaF1 nf1 = (NoticiaF1) noticia;
				nf1.calcularPrecio();
			} else if(noticia instanceof NoticiaMotociclismo) {
				NoticiaMotociclismo nm = (NoticiaMotociclismo) noticia;
				nm.calcularPrecio();
			}
			
			resultado = "El precio de la noticia es " + noticia.getPrecio() + " euro(s).";
			
		} else {
			resultado =  "La noticia no existe.\n";
		}
		
		return resultado;
		
	}
	
	public Noticia buscarNoticiaPorTitularSinConocerRedactor(String titularNoticia) {
		
		Noticia noticia = null;
		
		boolean encontrado = false;
		
		for(int i = 0; i < this.redactores.size() && !encontrado; i++) {
			for(Noticia n : this.redactores.get(i).getNoticias()) {
				if(n.getTitular().equalsIgnoreCase(titularNoticia)) {
					noticia = n;
					encontrado = true;
					break;
				}
			}	
		}
		
		return noticia;
		
	}
	
	public Noticia buscarNoticiaPorTitularConociendoRedactor(Redactor redactor, String titularNoticia) {
		
		Noticia noticia = null;

		for(Noticia n : redactor.getNoticias()) {
			if(n.getTitular().equalsIgnoreCase(titularNoticia)) {
				noticia = n;
				break;
			}
		}
		
		return noticia;
		
	}
	
	public Redactor buscarRedactorPorDni(String dni) {
		
		Redactor redactor = null;
		
		for(Redactor r : this.redactores) {
			if(dni.equalsIgnoreCase(r.getDni())) {
				redactor = r;
				break;
			}
		}
		
		return redactor;
		
	}
	
	private boolean existeRedactor(Redactor redactor) {
		return this.redactores.contains(redactor);
	}
	
	private boolean existeNoticia(Noticia noticia, List<Noticia> noticiasRedactor) {
		return noticiasRedactor.contains(noticia);
	}

}
