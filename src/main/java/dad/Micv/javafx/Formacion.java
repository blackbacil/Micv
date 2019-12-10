package dad.Micv.javafx;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType
public class Formacion {
	private LocalDate desde;
	private LocalDate hasta;
	private SimpleStringProperty denominacion;
	private SimpleStringProperty organizador;
	public Formacion(String desde,String hasta,String denominacion,String organizador) {
		this.desde=LocalDate.parse(desde);
		this.hasta=LocalDate.parse(hasta);
		this.denominacion = new SimpleStringProperty(denominacion);
		this.organizador = new SimpleStringProperty(organizador);
	}
	public Formacion() {
		
	}
	@XmlAttribute
	public String getDesde() {
		return desde.toString();
	}
	public void setDesde(String desde) {
		this.desde = LocalDate.parse(desde);
	}
	@XmlAttribute
	public String getHasta() {
		return hasta.toString();
	}
	public void setHasta(String hasta) {
		this.hasta = LocalDate.parse(hasta);
	}
	@XmlElement
	public String getDenominacion() {
		return denominacion.get();
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = new SimpleStringProperty(denominacion);
	}
	@XmlElement
	public String getOrganizador() {
		return organizador.get();
	}
	public void setOrganizador(String organizador) {
		this.organizador = new SimpleStringProperty(organizador);
	}
	@Override
	public String toString() {
		return getDesde() + " " + getHasta()  + " " + getDenominacion()+ " " + getOrganizador();
	}
}
