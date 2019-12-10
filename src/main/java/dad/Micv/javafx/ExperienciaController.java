package dad.Micv.javafx;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExperienciaController implements Initializable{
	public Stage SstageExp;
	public ObservableList<Experiencias> Exp = null;
	public static final Set<Experiencias> setExp = new HashSet<>();
	private NuevaExperienciaController controller;
    @FXML
    private HBox root;

    @FXML
    public TableView<Experiencias> tablaExperiencia;

    @FXML
    public TableColumn<Experiencias, String> columnDesdeExp;

    @FXML
    public TableColumn<Experiencias, String> columnHastaExp;

    @FXML
    public TableColumn<Experiencias, String> columnDenominacionExp;

    @FXML
    public TableColumn<Experiencias, String> columnEmpleador;

    @FXML
    void OnAñadirExperiencia(ActionEvent event) throws IOException {
    	controller = new NuevaExperienciaController();
    	SstageExp= new Stage();
		
		Scene escena = new Scene(controller.getRoot(),600,400);
		
		SstageExp.setScene(escena);
		SstageExp.setTitle("Nuevo título");
		SstageExp.show();
		SstageExp.setOnHidden(e->getOnMouseClicked());
    }

    @FXML
    void OnEliminarExperiencia(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			setExp.remove(tablaExperiencia.getSelectionModel().getSelectedItem());
			Exp = FXCollections.observableArrayList(setExp);
			columnDesdeExp.setCellValueFactory(new PropertyValueFactory<>("Desde"));
			columnHastaExp.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
			columnDenominacionExp.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
			columnEmpleador.setCellValueFactory(new PropertyValueFactory<>("Empleador"));
			tablaExperiencia.setItems(Exp);
		} else {
		    alert.close();
		}
    }
    public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	Exp = FXCollections.observableArrayList(setExp);
		columnDesdeExp.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		columnHastaExp.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		columnDenominacionExp.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnEmpleador.setCellValueFactory(new PropertyValueFactory<>("Empleador"));
		tablaExperiencia.setItems(Exp);
    }

    public HBox getRoot() {
    	return root;
    }
    void getOnMouseClicked(){
		Exp = FXCollections.observableArrayList(setExp);
		columnDesdeExp.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		columnHastaExp.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		columnDenominacionExp.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnEmpleador.setCellValueFactory(new PropertyValueFactory<>("Empleador"));
		tablaExperiencia.setItems(Exp);
	}

}

