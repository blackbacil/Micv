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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NuevaExperienciaController implements Initializable{
	private ExperienciaController controller= new ExperienciaController();
    @FXML
    private GridPane root;

    @FXML
    private TextField textDenominacionExp;

    @FXML
    private TextField textEmpleadorExp;

    @FXML
    private DatePicker desdeExp;

    @FXML
    private DatePicker hastaExp;

    @FXML
    void OnCancelarExp(ActionEvent event) {
    	final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @SuppressWarnings("static-access")
	@FXML
    void OnCrearExp(ActionEvent event) {
		controller.setExp.add(new Experiencias(desdeExp.getValue().toString(),hastaExp.getValue().toString(),textDenominacionExp.getText(),textEmpleadorExp.getText()));
		controller.Exp = FXCollections.observableArrayList(controller.setExp);
		controller.columnDesdeExp.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		controller.columnHastaExp.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		controller.columnDenominacionExp.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		controller.columnEmpleador.setCellValueFactory(new PropertyValueFactory<>("Organizador"));
		controller.tablaExperiencia.setItems(controller.Exp);
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }
    public NuevaExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevaExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
  
    	
    }

    public GridPane getRoot() {
    	return root;
    }

}



