package logicscape.utilidades;

import java.time.LocalDateTime;
import java.util.List;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;

/**
 * La clase Autenticacion proporciona métodos para el registro y autenticación
 * de usuarios.
 */
public class Autenticacion {
	private ConexionSql<Usuario> conexionSql = new ConexionSql<>();

	/**
	 * Registra un nuevo usuario con el nombre de usuario y contraseña
	 * especificados.
	 * 
	 * @param usuarioNew el nombre de usuario del nuevo usuario
	 * @param password   la contraseña del nuevo usuario
	 * @return true si el usuario se registra correctamente, false en caso contrario
	 */
	public boolean registrarUsuario(String usuarioNew, String password) {
		if (existeUsuario(usuarioNew)) {
			System.out.println("El usuario ya existe");
			return false;
		}
		Usuario usuario = new Usuario();
		usuario.setVisible(true);
		usuario.setDisponible(true);
		usuario.setUltimaActualizacion(LocalDateTime.now());
		usuario.setFechaCreacion(LocalDateTime.now());
		usuario.setUsuario(usuarioNew);
		usuario.setPassword(password);
		usuario.setUltimoIngreso(LocalDateTime.now());
		usuario.setEscenarioActual(0);
		usuario.setNivelActual(0);

		try {
			conexionSql.insert("usuarios", usuario.getColumnas(), usuario.getValores());
			System.out.println("El usuario se creo");
			return true;
		} catch (Exception e) {
			System.out.println("Error al crear el usuario");
			e.printStackTrace();
			return false;
		}

	}

	private boolean existeUsuario(String usuarioNew) {
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		Usuario result = conexionSql.findByUsuario(usuarioNew, usuarioMapper);
		return result != null;
	}

	/**
	 * Autentica un usuario con el nombre de usuario y contraseña especificados.
	 * 
	 * @param nombreUsuario el nombre de usuario del usuario a autenticar
	 * @param password      la contraseña del usuario a autenticar
	 * @return true si el usuario se autentica correctamente, false en caso
	 *         contrario
	 */
	public boolean autenticarUsuario(String nombreUsuario, String password) {
		Usuario authusuario = new Usuario();
		authusuario.setUsuario(nombreUsuario);
		authusuario.setPassword(password);
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		List<Usuario> resultado = conexionSql.findAll("usuarios", usuarioMapper);
		for (Usuario usuario : resultado) {
			if (usuario.getUsuario().equals(authusuario.getUsuario())
					&& usuario.getPassword().equals(authusuario.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
