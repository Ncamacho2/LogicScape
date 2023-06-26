/**
 * 
 */
package logicscape.modelos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import logicscape.utilidades.EncriptarPassword;

/**
 * Representacion del Usuario.
 *
 * @author ncamacho.
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario extends Base {
	private String usuario;
	private String password;
	private LocalDateTime ultimoIngreso;
	private Integer EscenarioActual;
	private Integer NivelActual;
	private Integer vidas;

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = EncriptarPassword.encriptarPassword(password);
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPasswordSe(String password) {
		this.password = password;
	}

	/**
	 * @return the ultimoIngreso
	 */
	public LocalDateTime getUltimoIngreso() {
		return ultimoIngreso;
	}

	/**
	 * @param ultimoIngreso the ultimoIngreso to set
	 */
	public void setUltimoIngreso(LocalDateTime ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}

	/**
	 * @return the escenarioActual
	 */
	public Integer getEscenarioActual() {
		return EscenarioActual;
	}

	/**
	 * @param escenarioActual the escenarioActual to set
	 */
	public void setEscenarioActual(Integer escenarioActual) {
		EscenarioActual = escenarioActual;
	}

	/**
	 * @return the nivelActual
	 */
	public Integer getNivelActual() {
		return NivelActual;
	}

	/**
	 * @param nivelActual the nivelActual to set
	 */
	public void setNivelActual(Integer nivelActual) {
		NivelActual = nivelActual;
	}

	/**
	 * @return the vidas
	 */
	public Integer getVidas() {
		return vidas;
	}

	/**
	 * @param vidas the vidas to set
	 */
	public void setVidas(Integer vidas) {
		this.vidas = vidas;
	}
	
}
