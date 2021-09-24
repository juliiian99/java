package Negocio;

import Datos.DataJugador;
import Entidades.Encrypt;
import Entidades.Jugador;

public class Login {

	private DataJugador dj;
	
	public Login() {
		this.dj = new DataJugador();
	}
	
	public Jugador validate(String usuario, String contraseņa) {
		
		Jugador j = new Jugador();
		String hash = Encrypt.convertirSHA256(contraseņa);
		j = dj.login(usuario, hash);
		return j;
		
	}
}
