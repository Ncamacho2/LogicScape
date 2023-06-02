package logicscape.modelos;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Superclase Generica con atributos generales que son reusados como singleton
 * para las obtenerEspecificacion clases entidades relacionales del sistema.
 * 
 * @author ncamacho
 *
 */

public class Base {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@JsonIgnore
	protected Boolean visible = true;
	@JsonIgnore
	protected Boolean disponible = true;
	@JsonIgnore
	protected LocalDateTime ultimaActualizacion;
	@JsonIgnore
	protected LocalDateTime fechaCreacion;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the ultimaActualizacion
	 */
	public LocalDateTime getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	/**
	 * @param ultimaActualizacion the ultimaActualizacion to set
	 */
	public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
