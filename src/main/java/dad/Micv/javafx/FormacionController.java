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

public class FormacionController implements Initializable{
	public Stage Sstage;
	public ObservableList<Formacion> titulos = null;
	public static final Set<Formacion> setForm = new HashSet<>();
    @FXML
    private HBox root;

    @FXML
    public TableView<Formacion> tablaFormacion;

    @FXML
    public TableColumn<Formacion, String> columnDesde;

    @FXML
    public TableColumn<Formacion, String> columnHasta;

    @FXML
    public TableColumn<Formacion, String> columnDenominacion;

    @FXML
    public TableColumn<Formacion, String> columnOrganizador;
    private NuevoTituloController controller;

    @FXML
    void OnAñadirFormacion(ActionEvent event) throws IOException {
    	controller = new NuevoTituloController();
    	Sstage= new Stage();
		
		Scene escena = new Scene(controller.getRoot(),600,400);
		
		Sstage.setScene(escena);
		Sstage.setTitle("Nuevo título");
		Sstage.show();
		Sstage.setOnHidden(e->getOnMouseClicked());
		
    }
    @FXML
    void OnEliminarFormacion(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			setForm.remove(tablaFormacion.getSelectionModel().getSelectedItem());
			titulos = FXCollections.observableArrayList(setForm);
			columnDesde.setCellValueFactory(new PropertyValueFactory<>("Desde"));
			columnHasta.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
			columnDenominacion.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
			columnOrganizador.setCellValueFactory(new PropertyValueFactory<>("Organizador"));
			tablaFormacion.setItems(titulos);
		} else {
		    alert.close();
		}

    }

    
    public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	titulos = FXCollections.observableArrayList(setForm);
		columnDesde.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		columnHasta.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		columnDenominacion.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnOrganizador.setCellValueFactory(new PropertyValueFactory<>("Organizador"));
		tablaFormacion.setItems(titulos);
    }

    public HBox getRoot() {
    	return root;
    }


	void getOnMouseClicked(){
		titulos = FXCollections.observableArrayList(setForm);
		columnDesde.setCellValueFactory(new PropertyValueFactory<>("Desde"));
		columnHasta.setCellValueFactory(new PropertyValueFactory<>("Hasta"));
		columnDenominacion.setCellValueFactory(new PropertyValueFactory<>("Denominacion"));
		columnOrganizador.setCellValueFactory(new PropertyValueFactory<>("Organizador"));
		tablaFormacion.setItems(titulos);
	}

}
