package dad.Micv.javafx;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Contactos {
	private List<Telefonos> telefonos= new ArrayList<>();
	private List<Correo> emails= new ArrayList<>();
	private List<Webs> webs= new ArrayList<>();
	@XmlElement
	public List<Telefonos> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefonos> telefonos) {
		this.telefonos = telefonos;
	}
	@XmlElement
	public List<Correo> getEmails() {
		return emails;
	}
	public void setEmails(List<Correo> emails) {
		this.emails = emails;
	}
	@XmlElement
	public List<Webs> getWebs() {
		return webs;
	}
	public void setWebs(List<Webs> webs) {
		this.webs = webs;
	}
	@Override
	public String toString() {
		return  " (" + getEmails().size() + " emails registrados)"+" (" + getTelefonos().size() + " teléfonos registrados)"+" (" + getWebs().size() + " webs registradas)";
	}
	
}
