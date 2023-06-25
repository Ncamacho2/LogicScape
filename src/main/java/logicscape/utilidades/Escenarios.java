package logicscape.utilidades;

import java.util.List;
import java.util.Random;

import logicscape.mapper.UsuarioMapper;
import logicscape.modelos.Usuario;

/**
 * 
 * Esta clase representa un escenario en el juego Logicscape y contiene métodos
 * para generar preguntas y validar respuestas.
 */
public class Escenarios {
	private List<Integer> opciones;
	private String pregunta;
	private Integer resultado;
	private Integer escenarioId;
	private Integer nivelId;
	private Integer usuarioId;

	/**
	 * Crea una instancia de la clase Escenarios con los parámetros especificados.
	 *
	 * @param opciones    las opciones posibles para la pregunta
	 * @param pregunta    la pregunta generada
	 * @param resultado   el resultado de la pregunta
	 * @param escenarioId el ID del escenario
	 * @param nivelId     el ID del nivel
	 * @param usuarioId   el ID del usuario
	 */
	public Escenarios(List<Integer> opciones, String pregunta, Integer resultado, Integer escenarioId, Integer nivelId,
			Integer usuarioId) {
		super();
		this.opciones = opciones;
		this.pregunta = pregunta;
		this.resultado = resultado;
		this.escenarioId = escenarioId;
		this.nivelId = nivelId;
		this.usuarioId = usuarioId;
	}

	/**
	 * Obtiene el ID del escenario.
	 *
	 * @return el ID del escenario
	 */
	public Integer getEscenarioId() {
		return escenarioId;
	}

	/**
	 * Establece el ID del escenario.
	 *
	 * @param escenarioId el ID del escenario a establecer
	 */
	public void setEscenarioId(Integer escenarioId) {
		this.escenarioId = escenarioId;
	}

	/**
	 * Obtiene el ID del nivel.
	 *
	 * @return el ID del nivel
	 */
	public Integer getNivelId() {
		return nivelId;
	}

	/**
	 * Establece el ID del nivel.
	 *
	 * @param nivelId el ID del nivel a establecer
	 */
	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}

	/**
	 * Obtiene las opciones posibles para la pregunta.
	 *
	 * @return las opciones posibles
	 */
	public List<Integer> getOpciones() {
		return opciones;
	}

	/**
	 * Establece las opciones posibles para la pregunta.
	 *
	 * @param opciones las opciones a establecer
	 */
	public void setOpciones(List<Integer> opciones) {
		this.opciones = opciones;
	}

	/**
	 * Obtiene la pregunta generada.
	 *
	 * @return la pregunta generada
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Establece la pregunta generada.
	 *
	 * @param pregunta la pregunta a establecer
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * Obtiene el resultado de la pregunta.
	 *
	 * @return el resultado de la pregunta
	 */
	public Integer getResultado() {
		return resultado;
	}

	/**
	 * Establece el resultado de la pregunta.
	 *
	 * @param resultado el resultado de la pregunta a establecer
	 */
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	/**
	 * Obtiene el ID del usuario.
	 *
	 * @return el ID del usuario
	 */
	public Integer getUsuarioId() {
		return usuarioId;
	}

	/**
	 * Establece el ID del usuario.
	 *
	 * @param usuarioId el ID del usuario a establecer
	 */
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * Genera una pregunta y su resultado aleatoriamente según el nivel y escenario
	 * actuales.
	 */
	public void generarPregunta() {
		Integer numA = generaAleatorioPorNivel(getNivelId());
		Integer numB = generaAleatorioPorNivel(getNivelId());

		if (getEscenarioId() == 0) {
			setPregunta(numA + " + " + numB + "= ?");
			setResultado(numA + numB);
		} else if (getEscenarioId() == 1) {
			setPregunta(numA + " - " + numB + "= ?");
			setResultado(numA - numB);
		} else if (getEscenarioId() == 2) {
			setPregunta(numA + " * " + numB + "= ?");
			setResultado(numA * numB);
		} else if (getEscenarioId() == 3) {
			setPregunta(numA + " / " + numB + "= ?");
			setResultado(numA / numB);
		}
		opciones.add(getResultado());
		opciones.add(generaAleatorioPorNivel(getNivelId() + 1));
		opciones.add(generaAleatorioPorNivel(getNivelId() + 1));
		opciones.add(getResultado() + 1);
		generarOpcionesAleatorias();
	}

	/**
	 * Genera un número aleatorio basado en el nivel actual.
	 *
	 * @param idNivel el ID del nivel actual
	 * @return un número aleatorio generado
	 */
	private Integer generaAleatorioPorNivel(Integer idNivel) {
		Random random = new Random();
		Integer limite = (int) Math.pow(10, idNivel + 1);
		return random.nextInt(limite);
	}

	/**
	 * Genera opciones aleatorias reordenando la lista de opciones.
	 */
	private void generarOpcionesAleatorias() {
		Random random = new Random();
		for (int i = opciones.size() - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = opciones.get(i);
			opciones.set(i, opciones.get(j));
			opciones.set(j, temp);
		}
	}

	/**
	 * Valida el resultado proporcionado por el usuario. Si el resultado es
	 * correcto, actualiza el nivel y escenario del usuario en la base de datos.
	 *
	 * @param resultadoUser el resultado proporcionado por el usuario
	 * @return true si el resultado es correcto y se actualiza la base de datos,
	 *         false en caso contrario
	 */
	public Boolean validarResultado(Integer resultadoUser) {
		try {
			if (resultadoUser.equals(resultado)) {
				ConexionSql<Usuario> conexionSql = new ConexionSql<>();
				Usuario usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
				if (getNivelId() == 2) {
					usuario.setEscenarioActual(getEscenarioId() + 1);
					usuario.setNivelActual(0);
				} else {
					usuario.setNivelActual(getNivelId() + 1);
				}
				conexionSql.update("usuarios", "id", getUsuarioId(), usuario.getColumnas(), usuario.getValores());
				return true;
			} else {
				ConexionSql<Usuario> conexionSql = new ConexionSql<>();
				Usuario usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
				if (getNivelId() != 0) {
					usuario.setNivelActual(getNivelId() - 1);

				}
				usuario.setVidas(usuario.getVidas() - 1);
				conexionSql.update("usuarios", "id", getUsuarioId(), usuario.getColumnas(), usuario.getValores());
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Reinicia el número de vidas del usuario en 3. Actualiza la información del
	 * usuario en la base de datos.
	 *
	 * @param resultadoUser El resultado actual del usuario.
	 * @return El objeto Usuario actualizado después de reiniciar las vidas.
	 */
	public Usuario reiniciarVidas(Integer resultadoUser) {
		ConexionSql<Usuario> conexionSql = new ConexionSql<>();
		Usuario usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
		usuario.setVidas(3);
		conexionSql.update("usuarios", "id", getUsuarioId(), usuario.getColumnas(), usuario.getValores());
		usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
		return usuario;
	}

	/**
	 * Reinicia el juego del usuario. Establece el número de vidas en 3, el
	 * escenario actual y el nivel actual en 0. Actualiza la información del usuario
	 * en la base de datos.
	 *
	 * @param resultadoUser El resultado actual del usuario.
	 * @return El objeto Usuario actualizado después de reiniciar el juego.
	 */
	public Usuario reiniciarJuego(Integer resultadoUser) {
		ConexionSql<Usuario> conexionSql = new ConexionSql<>();
		Usuario usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
		usuario.setVidas(3);
		usuario.setEscenarioActual(0);
		usuario.setNivelActual(0);
		conexionSql.update("usuarios", "id", getUsuarioId(), usuario.getColumnas(), usuario.getValores());
		usuario = conexionSql.findById("usuarios", "id", getUsuarioId(), new UsuarioMapper());
		return usuario;
	}

}
