/**
 * 
 */
package logicscape.modelos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ncamacho.
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario extends Base {
	private String usuario;
	private String password;
	private LocalDateTime ultimoIngreso;
	@ManyToOne
    @JoinColumn(name = "id_escenario_actual")
    private Escenario EscenarioActual;
	@ManyToOne
    @JoinColumn(name = "id_nivel_actual")
    private Nivel NivelActual;
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
	public Escenario getEscenarioActual() {
		return EscenarioActual;
	}
	/**
	 * @param escenarioActual the escenarioActual to set
	 */
	public void setEscenarioActual(Escenario escenarioActual) {
		EscenarioActual = escenarioActual;
	}
	/**
	 * @return the nivelActual
	 */
	public Nivel getNivelActual() {
		return NivelActual;
	}
	/**
	 * @param nivelActual the nivelActual to set
	 */
	public void setNivelActual(Nivel nivelActual) {
		NivelActual = nivelActual;
	}

	
}
