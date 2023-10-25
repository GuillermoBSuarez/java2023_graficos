package service;

import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Usuario;

public class UsuarioService {

	private Stream<Usuario> getUsuarios() {
		String dir = "C:\\temp\\usuarios.json";
		Gson gson = new Gson();											// Objeto de Google para interpretar jsons.

		try ( FileReader fr = new FileReader(dir); ) {
			Usuario[] usuarios = gson.fromJson(fr, Usuario[].class);
			return Arrays.stream(usuarios);
		} catch (Exception e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}

	public boolean comprobarUsuario (Usuario user) {
		return getUsuarios()
				.anyMatch( u -> u.getUsuario().equals(user.getUsuario())
							 && u.getPassword().equals(user.getPassword())
						 );				
	}
}