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

public class AñadirConocimientoController implements Initializable{
	private ConocimientosController controller= new ConocimientosController();
	
    @FXML
    private GridPane root;

    @FXML
    private TextField textDenominacionConocimiento;


    @FXML
    private ComboBox<String> comboNivelConocimiento;

    @FXML
    void OnCancelarConocimiento(ActionEvent event) {
    	final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @SuppressWarnings("static-access")
	@FXML
    void OnCrearConocimiento(ActionEvent event) {
    	controller.setHab.add(new Idiomas(textDenominacionConocimiento.getText(),comboNivelConocimiento.getValue(),null));
		controller.habilidad = FXCollections.observableArrayList(controller.setHab);
		controller.columnDenominacionCono.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		controller.columnNivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
		controller.tablaConocimiento.setItems(controller.habilidad);
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void OnNullConocimiento(ActionEvent event) {
    	comboNivelConocimiento.setValue(null);
    }
    public AñadirConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AñadirConocimientoView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {

		comboNivelConocimiento.getItems().removeAll(comboNivelConocimiento.getItems());
	    comboNivelConocimiento.getItems().addAll("BASICO", "MEDIO", "AVANZADO");
    	
    }

    public GridPane getRoot() {
    	return root;
    }

}
