package dad.Micv.javafx;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.SimpleStringProperty;
@XmlType
public class Idiomas extends Habilidades{
	private SimpleStringProperty certificacion; 
	public Idiomas(String denominacion, String nivel,String certificacion) {
		super(denominacion, nivel);
		this.certificacion = new SimpleStringProperty(certificacion);
	}
	@XmlAttribute
	public String getCertificacion() {
		return certificacion.get();
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = new SimpleStringProperty(certificacion);
	}
	@Override
	public String toString() {
		return  getDenominacion()  + " " + getNivel()+" "+getCertificacion();
	}
}
