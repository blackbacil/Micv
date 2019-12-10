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

public class ConocimientosController implements Initializable{
	public Stage SstageIdioma;
	public Stage SstageConocimiento;
	public ObservableList<Habilidades> habilidad = null;
	public static final Set<Habilidades> setHab = new HashSet<>();
	private AñadirIdiomaController controller;
	private AñadirConocimientoController controller1;
    @FXML
    private HBox root;

    @FXML
    public TableView<Habilidades> tablaConocimiento;

    @FXML
    public TableColumn<Habilidades, String> columnDenominacionCono;

    @FXML
    public TableColumn<Habilidades, String> columnNivel;

    @FXML
    void OnAñadirConocimiento(ActionEvent event) throws IOException {
    	controller1 = new AñadirConocimientoController();
    	SstageConocimiento= new Stage();
		
		Scene escena = new Scene(controller1.getRoot(),600,400);
		
		SstageConocimiento.setScene(escena);
		SstageConocimiento.setTitle("Nuevo título");
		SstageConocimiento.show();
		SstageConocimiento.setOnHidden(e->getOnMouseClicked());
    }

    @FXML
    void OnAñadirIdioma(ActionEvent event) throws IOException {
    	controller = new AñadirIdiomaController();
    	SstageIdioma= new Stage();
		
		Scene escena = new Scene(controller.getRoot(),600,400);
		
		SstageIdioma.setScene(escena);
		SstageIdioma.setTitle("Nuevo título");
		SstageIdioma.show();
		SstageIdioma.setOnHidden(e->getOnMouseClicked());
    }

    @FXML
    void OnEliminarConocimiento(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			setHab.remove(tablaConocimiento.getSelectionModel().getSelectedItem());
			habilidad = FXCollections.observableArrayList(setHab);
			columnDenominacionCono.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
			columnNivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
			tablaConocimiento.setItems(habilidad);
		} else {
		    alert.close();
		}
    }
    public ConocimientosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	habilidad = FXCollections.observableArrayList(setHab);
		columnDenominacionCono.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnNivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
		tablaConocimiento.setItems(habilidad);
    }

    public HBox getRoot() {
    	return root;
    }
    void getOnMouseClicked(){
		habilidad = FXCollections.observableArrayList(setHab);
		columnDenominacionCono.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnNivel.setCellValueFactory(new PropertyValueFactory<>("Nivel"));
		tablaConocimiento.setItems(habilidad);
	}

}
