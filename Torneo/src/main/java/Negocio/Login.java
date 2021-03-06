package Negocio;

import Datos.DataJugador;
import Entidades.Encrypt;
import Entidades.Jugador;

public class Login {
	
	public static Jugador validate(String usuario, String contraseņa) {
		
		Jugador j = new Jugador();
		DataJugador dj = new DataJugador();
		String hash = Encrypt.convertirSHA256(contraseņa);
		j = dj.login(usuario, hash);
		return j;
	}
}
