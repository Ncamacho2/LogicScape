package logicscape.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "escenarios")
public class Escenario extends Base {
	private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "escenario")
    private List<Nivel> niveles;
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
	 * @return the niveles
	 */
	public List<Nivel> getNiveles() {
		return niveles;
	}
	/**
	 * @param niveles the niveles to set
	 */
	public void setNiveles(List<Nivel> niveles) {
		this.niveles = niveles;
	}

    
}
