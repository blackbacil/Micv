package dad.Micv.javafx;

import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlType
public class Webs {
	private SimpleStringProperty URL;
	public Webs(String URL) {
		this.URL = new SimpleStringProperty(URL);
	}
	public Webs() {
		
	}
	@XmlAttribute
	public String getURL() {
		return URL.get();
	}
	public void setURL(String URL) {
		this.URL = new SimpleStringProperty(URL);
	}
	@Override
	public String toString() {
		return getURL();
	}

}


