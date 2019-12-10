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

public class NuevoTituloController implements Initializable{
    private FormacionController controller= new FormacionController();
	@FXML
    private GridPane root;

    @FXML
    private TextField textDenominacionTitulo;

    @FXML
    private TextField textOrganizadorTitulo;

    @FXML
    private DatePicker desdeTitulo;

    @FXML
    private DatePicker hastaTitulo;

    @FXML
    void OnCancelarTitulo(ActionEvent event) {
    	final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @SuppressWarnings("static-access")
	@FXML
    void OnCrearTitulo(ActionEvent event) {
		controller.setForm.add(new Formacion(desdeTitulo.getValue().toString(),hastaTitulo.getValue().toString(),textDenominacionTitulo.getText(),textOrganizadorTitulo.getText()));
		controller.titulos = FXCollections.observableArrayList(controller.setForm);
		controller.columnDesde.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		controller.columnHasta.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		controller.columnDenominacion.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		controller.columnOrganizador.setCellValueFactory(new PropertyValueFactory<>("Organizador"));
		controller.tablaFormacion.setItems(controller.titulos);
		final Node source = (Node) event.getSource();
	    final Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }
    public NuevoTituloController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoTituloView.fxml"));
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



