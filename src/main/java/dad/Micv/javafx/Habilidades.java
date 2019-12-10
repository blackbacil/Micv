package dad.Micv.javafx;


import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlType
public class Habilidades {
	
	private SimpleStringProperty denominacion;
	private SimpleStringProperty nivel;
	public Habilidades() {
		
	}
	public Habilidades(String denominacion,String nivel) {
		this.denominacion = new SimpleStringProperty(denominacion);
		this.nivel = new SimpleStringProperty(nivel);
	}
	@XmlAttribute
	public String getDenominacion() {
		return denominacion.get();
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = new SimpleStringProperty(denominacion);
	}
	@XmlAttribute
	public String getNivel() {
		return nivel.get();
	}

	public void setNivel(String nivel) {
		this.nivel = new SimpleStringProperty(nivel);
	}

	@Override
	public String toString() {
		return  getDenominacion()  + " " + getNivel();
	}

}
