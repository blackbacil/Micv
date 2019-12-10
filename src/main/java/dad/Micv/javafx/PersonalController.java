package dad.Micv.javafx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PersonalController implements Initializable{

    @FXML
    private GridPane root;
    private Set<String> set = new HashSet<>();
    private ObservableList<String> paises =null;

    @FXML
    private ComboBox<String> comboPais;
    

    @FXML
    private TextField textDNI;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textApellido;


	@FXML
    private DatePicker introDate;

    @FXML
    private TextField textPostal;

    @FXML
    private TextField textLocalidad;

    @FXML
    private TextArea textNacionalidad;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextArea textDireccion;
    private int i=0;

    @FXML
    void OnAñadir(ActionEvent event) {
    	List<String> choices = new ArrayList<>();
        
        String elemento=null;
        boolean seguir = true;
        Scanner entrada = null;

        try {
            entrada = new Scanner(new File("src\\main\\resources\\nacionalidades.csv"));
        }
        catch (FileNotFoundException fnE) {
            System.out.println(fnE.getMessage());
            seguir = false;
        }
        if (seguir) {
            entrada.nextLine();
            while (entrada.hasNext()) {
                elemento=entrada.nextLine();
                choices.add(elemento);
            }
        }
    	

    	ChoiceDialog<String> dialog = new ChoiceDialog<>("Español", choices);
    	dialog.setTitle("Nueva nacionalidad");
    	dialog.setHeaderText("Añadir nacionalidad");
    	dialog.setContentText("Seleccione una nacionalidad ");

    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    		if(i==0) {
    			textNacionalidad.setText(textNacionalidad.getText()+result.get());
    			i++;
    		}
    		else
    			textNacionalidad.setText(textNacionalidad.getText()+", "+result.get());
    	}


    }

    @FXML
    void OnEliminar(ActionEvent event) {
    	
    	LocalDate a = LocalDate.parse(introDate.getValue().toString());
    	System.out.println(a.toString());
    }
    public PersonalController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	comboPais.getOnKeyPressed();
        String elemento=null;
        boolean seguir = true;
    	Scanner entradas= null;

        try {
            entradas = new Scanner(new File("src\\main\\resources\\paises.csv"));
        }
        catch (FileNotFoundException fnE) {
            System.out.println(fnE.getMessage());
            seguir = false;
        }
        if (seguir) {
            entradas.nextLine();
            while (entradas.hasNext()) {
                elemento=entradas.nextLine();
                set.add(elemento);
            }
        }
        paises= FXCollections.observableArrayList(set);
        comboPais.setPromptText(elemento);
    	comboPais.setItems(paises);
    	
    }

    public GridPane getRoot() {
    	return root;
    }
    public ComboBox<String> getComboPais() {
		return comboPais;
	}

	public TextField getTextDNI() {
		return textDNI;
	}

	public TextField getTextNombre() {
		return textNombre;
	}

	public TextField getTextApellido() {
		return textApellido;
	}

	public DatePicker getIntroDate() {
		return introDate;
	}

	public TextField getTextPostal() {
		return textPostal;
	}

	public TextField getTextLocalidad() {
		return textLocalidad;
	}

	public TextArea getTextNacionalidad() {
		return textNacionalidad;
	}

	public TextArea getTextDireccion() {
		return textDireccion;
	}


	public void setComboPais(String string) {
		this.comboPais.getSelectionModel().select(string);
	}

	public void setTextDNI(String string) {
		this.textDNI.setText(string);
	}

	public void setTextNombre(String string) {
		this.textNombre.setText(string);
	}

	public void setTextApellido(String string) {
		this.textApellido.setText(string);
	}

	public void setIntroDate(LocalDate localDate) {
		this.introDate.setValue(localDate); 
	}

	public void setTextPostal(String string) {
		this.textPostal.setText(string);
	}

	public void setTextLocalidad(String string) {
		this.textLocalidad.setText(string);
	}

	public void setTextNacionalidad(List<Nacionalidades> list) {
		this.textNacionalidad.setText(list.toString());
	}

	public void setTextDireccion(String string) {
		this.textDireccion.setText(string);
	}


}
