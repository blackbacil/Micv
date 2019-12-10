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
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class ContactoController implements Initializable{
    @FXML
    private VBox root;
    private ObservableList<Correo> emeils = null;
    private ObservableList<Telefonos> telefono = null;

    private ObservableList<Webs> URL = null;
    public static final Set<Correo> set = new HashSet<>();
    public static final Set<Webs> set1 = new HashSet<>();
    public static final Set<Telefonos> set2 = new HashSet<>();

	@FXML
	private TableView<Telefonos> tablaTelefonos;

	@FXML
	private TableColumn<Telefonos, Number> columnNumero;

	@FXML
	private TableColumn<Telefonos, String> columnTipo;

	@FXML
	private TableView<Correo> tablaCorreo;

	@FXML
	private TableColumn<Correo, String> columnEmail;

	@FXML
	private TableView<Webs> tablaWebs;

	@FXML
	private TableColumn<Webs, String> columnURL;

	@FXML
	void OnAñadirCorreo(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo e-mail");
		dialog.setHeaderText("Crear una nueva dirección de correo.");
		dialog.setContentText("E-mail: ");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			set.add(new Correo(result.get()));
			emeils = FXCollections.observableArrayList(set);
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			tablaCorreo.setItems(emeils);
		}

	}

	@FXML
	void OnAñadirTelefono(ActionEvent event) {
		
		TextInputDialog dialog = new TextInputDialog();
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		ObservableList<String> Choices = FXCollections.observableArrayList();
		Choices.add("Movil");
		Choices.add("Domicilio");

		TextField numero = new TextField();
		ComboBox<String> combo= new ComboBox<String>((ObservableList<String>) Choices);

		

		grid.add(new Label("Número"), 0, 0);
		grid.add(numero, 1, 0);
		grid.add(new Label("Tipo:"), 0, 1);
		grid.add(combo, 1, 1);
		dialog.setTitle("Nuevo teléfono");
		dialog.setHeaderText("Introdusca el nuevo número de teléfono.");
		
		
		
		
		dialog.getDialogPane().setContent(grid);
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			set2.add(new Telefonos(combo.getValue(),Integer.parseInt(numero.getText())));
			telefono = FXCollections.observableArrayList(set2);
			columnNumero.setCellValueFactory(new PropertyValueFactory<>("Numero"));
			columnTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
			tablaTelefonos.setItems(telefono);
		}



	}

	@FXML
	void OnAñadirWebs(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nueva web");
		dialog.setHeaderText("Crear una nueva dirección web.");
		dialog.setContentText("URL: ");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			set1.add(new Webs(result.get()));
			URL = FXCollections.observableArrayList(set1);
			columnURL.setCellValueFactory(new PropertyValueFactory<>("URL"));
			tablaWebs.setItems(URL);
		}

	}

	@FXML
	void OnEliminarCorreo(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			set.remove(tablaCorreo.getSelectionModel().getSelectedItem());
			emeils = FXCollections.observableArrayList(set);
			columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			tablaCorreo.setItems(emeils);
		} else {
		    alert.close();
		}

		
	}

	@FXML
	void OnEliminarTelefono(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			set2.remove(tablaTelefonos.getSelectionModel().getSelectedItem());
			telefono = FXCollections.observableArrayList(set2);
			columnNumero.setCellValueFactory(new PropertyValueFactory<>("Numero"));
			columnTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
			tablaTelefonos.setItems(telefono);
		} else {
		    alert.close();
		}

	}

	@FXML
	void OnEliminarWebs(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar");
		alert.setHeaderText("¿Quieres eliminarlo?");
		

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			set1.remove(tablaWebs.getSelectionModel().getSelectedItem());
			URL = FXCollections.observableArrayList(set1);
			columnURL.setCellValueFactory(new PropertyValueFactory<>("URL"));
			tablaWebs.setItems(URL);
		} else {
		    alert.close();
		}

	}
	public ContactoController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	    
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		emeils = FXCollections.observableArrayList(set);
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		tablaCorreo.setItems(emeils);
		URL = FXCollections.observableArrayList(set1);
		columnURL.setCellValueFactory(new PropertyValueFactory<>("URL"));
		tablaWebs.setItems(URL);
		columnNumero.setCellValueFactory(new PropertyValueFactory<>("Numero"));
		columnTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
		tablaTelefonos.setItems(telefono);
	}

	public VBox getRoot() {
		return root;
	}

}


