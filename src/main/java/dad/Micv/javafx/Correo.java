package dad.Micv.javafx;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


import javafx.beans.property.SimpleStringProperty;
@XmlType
public class Correo{
	private SimpleStringProperty email;
	public Correo(String email) {
		this.email = new SimpleStringProperty(email);
	}
	public Correo() {
		
	}
	@XmlAttribute
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email = new SimpleStringProperty(email);
	}
	@Override
	public String toString() {
		return getEmail();
	}

}
