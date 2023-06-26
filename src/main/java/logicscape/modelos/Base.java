package logicscape.modelos;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	/**
	 * visible.
	 */
	@JsonIgnore
	protected Boolean visible = true;
	/**
	 * disponible.
	 */
	@JsonIgnore
	protected Boolean disponible = true;
	/**
	 * ultimaActualizacion.
	 */
	@JsonIgnore
	protected LocalDateTime ultimaActualizacion;
	/**
	 * fechaCreacion.
	 */
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

	/**
	 * obtiene las columnas de la clase.
	 *
 	 * @return las columnas.
	 */
	public List<String> getColumnas() {
        List<String> columnas = new ArrayList<>();
        Class<?> claseActual = this.getClass();
        while (claseActual != null) {
            Field[] fields = claseActual.getDeclaredFields();
            for (Field field : fields) {
                columnas.add(field.getName());
            }
            claseActual = claseActual.getSuperclass();
        }
        return columnas;
    }

	/**
	 * Obtiene los valores de la clase.
	 *
	 * @return los valores.
	 */
    public List<Object> getValores() {
        List<Object> valores = new ArrayList<>();
        Class<?> claseActual = this.getClass();
        while (claseActual != null) {
            Field[] fields = claseActual.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object valor = field.get(this);
                    valores.add(valor);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            claseActual = claseActual.getSuperclass();
        }
        return valores;
    }
}
