package dad.Micv.javafx;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class CV {
	private List<Contactos> contacto= new ArrayList<>();
	private List<Experiencias> experiencias = new ArrayList<>();
	private List<Formacion> formacion = new ArrayList<>();
	private List<Habilidades> habilidades= new ArrayList<>();
	private List<Personal> personal= new ArrayList<>();
	@XmlElement
	public List<Contactos> getContacto() {
		return contacto;
	}
	public void setContacto(List<Contactos> contacto) {
		this.contacto = contacto;
	}
	@XmlElement
	public List<Experiencias> getExperiencias() {
		return experiencias;
	}
	public void setExperiencias(List<Experiencias> experiencias) {
		this.experiencias = experiencias;
	}
	@XmlElement
	public List<Formacion> getFormacion() {
		return formacion;
	}
	public void setFormacion(List<Formacion> formacion) {
		this.formacion = formacion;
	}
	@XmlElement
	public List<Habilidades> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}
	@XmlElement
	public List<Personal> getPersonal() {
		return personal;
	}
	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}
	
	
}
