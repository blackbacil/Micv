package dad.Micv.javafx;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
@XmlType
public class Telefonos {
		private SimpleStringProperty Tipo;
		private SimpleIntegerProperty numero;
		
		public Telefonos(String Tipo,int numero) {
			this.Tipo = new SimpleStringProperty(Tipo);
			this.numero=new SimpleIntegerProperty(numero);
		}
		public Telefonos() {
		}
		@XmlAttribute
		public String getTipo() {
			return Tipo.get();
		}
		public void setTipo(String Tipo) {
			this.Tipo = new SimpleStringProperty(Tipo);
		}
		@XmlAttribute
		public int getNumero() {
			return numero.get();
		}
		public void setNumero(int numero) {
			this.numero = new SimpleIntegerProperty(numero);
		}
		@Override
		public String toString() {
			return getNumero() + " " + getTipo();
		}

}
