package dad.Micv.javafx;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Nacionalidades {
	private String nacionalidad;
	
	public Nacionalidades() {
		
	}
	public Nacionalidades(String nacion) {
		this.nacionalidad=nacion;
	}
	@XmlAttribute
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return  getNacionalidad();
	}

}
