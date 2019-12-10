package dad.Micv.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AñadirIdiomaController implements Initializable{
	private ConocimientosController controller= new ConocimientosController();
	
    @FXML
    private GridPane root;

    @FXML
    private TextField textDenominacionIdioma;

    @FXML
    private TextField textCertificacionIdioma;

    @FXML
    private ComboBox<String> comboNivelIdioma;

    @FXML
    void OnCancelarIdioma(ActionEvent event) {
    	final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @SuppressWarnings("static-access")
	@FXML
    void OnCrearIdioma(ActionEvent event) {
    	controller.setHab.add(new Idiomas(textDenominacionIdioma.getText(),comboNivelIdioma.getValue(),textCertificacionIdioma.getText()));
		controller.habilidad = FXCollections.observableArrayList(controller.setHab);
		controller.columnDenominacionCono.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		controller.columnNivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
		controller.tablaConocimiento.setItems(controller.habilidad);
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void OnNull(ActionEvent event) {
    	comboNivelIdioma.setValue(null);
    }
    public AñadirIdiomaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AñadirIdiomaView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {

		comboNivelIdioma.getItems().removeAll(comboNivelIdioma.getItems());
	    comboNivelIdioma.getItems().addAll("BASICO", "MEDIO", "AVANZADO");
    	
    }

    public GridPane getRoot() {
    	return root;
    }

}


