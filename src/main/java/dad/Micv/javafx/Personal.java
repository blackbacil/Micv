package dad.Micv.javafx;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dad.Micv.javafx.utils.LocalDateAdapter;

@XmlType
public class Personal {
	private String identificacion;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String direcion;
	private String codigoPostal;
	private String localidad;
	private String pais;
	private List<Nacionalidades> nacionalidades= new ArrayList<>();
	@XmlAttribute
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@XmlElement
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@XmlElement
	public String getDirecion() {
		return direcion;
	}
	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}
	@XmlElement
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@XmlElement
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	@XmlElement
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@XmlElement
	public List<Nacionalidades> getNacionalidades() {
		return nacionalidades;
	}
	public void setNacionalidades(List<Nacionalidades> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}
	@Override
	public String toString() {
		return getIdentificacion() + " " +getNombre() + " " + getApellidos()+" "+ getFechaNacimiento() + " "  +getDirecion() + " " +getCodigoPostal() + " " +getLocalidad() + " " +getPais() + " " + " (" + getNacionalidades().size() + " nacionalidades registradas)";
	}

}
