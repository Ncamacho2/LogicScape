package logicscape.modelos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "niveles")
public class Nivel {
	@ManyToOne
	@JoinColumn(name = "id_escenario")
	private Escenario escenario;
	private String nombre;
	private String descripcion;
	private String operacion;
	private int resultadoCorrecto;
	/**
	 * @return the escenario
	 */
	public Escenario getEscenario() {
		return escenario;
	}
	/**
	 * @param escenario the escenario to set
	 */
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}
	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	/**
	 * @return the resultadoCorrecto
	 */
	public int getResultadoCorrecto() {
		return resultadoCorrecto;
	}
	/**
	 * @param resultadoCorrecto the resultadoCorrecto to set
	 */
	public void setResultadoCorrecto(int resultadoCorrecto) {
		this.resultadoCorrecto = resultadoCorrecto;
	}
	
	
}
