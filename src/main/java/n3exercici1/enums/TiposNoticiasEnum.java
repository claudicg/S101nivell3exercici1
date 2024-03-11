package n3exercici1.enums;

public enum TiposNoticiasEnum {
	
	FUTBOL("Fútbol"),
	BALONCESTO("Baloncesto"),
	TENIS("Tenis"),
	F1("F1"),
	MOTOCICLISMO("Motociclismo");
	
	private String nombreTipo = "";
	
	private TiposNoticiasEnum(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}	

}
