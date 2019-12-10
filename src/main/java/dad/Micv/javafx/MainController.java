package dad.Micv.javafx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.Micv.javafx.utils.JAXBUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;


public class MainController implements Initializable {
	private ContactoController contactoController=new ContactoController();
	private ConocimientosController conocimientosController= new ConocimientosController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private FormacionController formacionController = new FormacionController();
	private PersonalController personalController = new PersonalController();
	private CV cv1;
	@FXML
	private VBox root;

	@FXML
	private MenuBar menu;

	@FXML
	private Menu menuArchivo;

	@FXML
	private MenuItem itemNuevo;

	@FXML
	private MenuItem itemAbrir;

	@FXML
	private MenuItem itemGuardar;

	@FXML
	private MenuItem itemGuardarcomo;

	@FXML
	private MenuItem itemSalir;

	@FXML
	private Menu menuAyuda;

	@FXML
	private MenuItem itemAcerca;

	@FXML
	private TabPane tabMain;

	@FXML
	private Tab tabPersonal;

	@FXML
	private Tab tabContacto;

	@FXML
	private Tab tabFormacion;

	@FXML
	private Tab tabExperiencia;

	@FXML
	private Tab tabConocimientos;


	

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
		
		
		
		
		tabContacto.setContent(contactoController.getRoot());
		tabConocimientos.setContent(conocimientosController.getRoot());
		tabExperiencia.setContent(experienciaController.getRoot());
		tabFormacion.setContent(formacionController.getRoot());
		tabPersonal.setContent(personalController.getRoot());
		
		itemGuardarcomo.setOnAction(e-> {
			try {
				guardarcomo();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		itemAbrir.setOnAction(e-> {
			try {
				abrir();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		itemNuevo.setOnAction(e->nuevo());
		itemGuardar.setOnAction(e-> {
			try {
				guardar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		itemSalir.setOnAction(e->Platform.exit());

	}



	@SuppressWarnings("static-access")
	private void guardar() throws Exception {
		Contactos cont = new Contactos();
		cont.getEmails().addAll(contactoController.set);
		cont.getTelefonos().addAll(contactoController.set2);
		cont.getWebs().addAll(contactoController.set1);
		Personal p1 = new Personal();
		p1.setIdentificacion(personalController.getTextDNI().getText());
		p1.setNombre(personalController.getTextNombre().getText());
		p1.setApellidos(personalController.getTextApellido().getText());
		p1.setFechaNacimiento(personalController.getIntroDate().getValue());
		p1.setDirecion(personalController.getTextDireccion().getText());
		p1.setCodigoPostal(personalController.getTextPostal().getText());
		p1.setLocalidad(personalController.getTextLocalidad().getText());
		p1.setPais(personalController.getComboPais().getValue());
		String[] nacion=personalController.getTextNacionalidad().getText().split(",");
		for(int i=0;i<nacion.length; i++)
			p1.getNacionalidades().add(new Nacionalidades(nacion[i]));
		CV cv =new CV();
		cv.getPersonal().add(p1);
		cv.getContacto().add(cont);
		cv.getExperiencias().addAll(experienciaController.setExp);
		cv.getFormacion().addAll(formacionController.setForm);
		cv.getHabilidades().addAll(conocimientosController.setHab);
		
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Guardar como");
		dialog.setContentText("Introduce la ruta y el nombre del archivo: ");

		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			JAXBUtil.save(cv, new File(result.get()));
		}
		
	}



	@SuppressWarnings("static-access")
	private void nuevo() {
		cv1=null;
		contactoController.set.clear();
		contactoController.set1.clear();
		contactoController.set2.clear();
		experienciaController.setExp.clear();
		formacionController.setForm.clear();
		conocimientosController.setHab.clear();
		personalController.setTextDNI("");
		personalController.setTextNombre("");
		personalController.setTextApellido("");
		personalController.setIntroDate(LocalDate.MIN);
		personalController.setTextDireccion("");
		personalController.setTextPostal("");
		personalController.setTextLocalidad("");
		personalController.setComboPais("");
		personalController.setTextNacionalidad(new ArrayList<Nacionalidades>());
		
		contactoController.initialize(null, null);
		experienciaController.initialize(null, null);
		conocimientosController.initialize(null, null);
		formacionController.initialize(null, null);
	}



	@SuppressWarnings("static-access")
	private void abrir() throws Exception {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Abrir");
		dialog.setContentText("Introduce la ruta y el nombre del archivo: ");

		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			cv1=JAXBUtil.load(CV.class, new File(result.get()));
			contactoController.set.addAll(cv1.getContacto().get(0).getEmails());
			contactoController.set1.addAll(cv1.getContacto().get(0).getWebs());
			contactoController.set2.addAll(cv1.getContacto().get(0).getTelefonos());
			experienciaController.setExp.addAll(cv1.getExperiencias());
			formacionController.setForm.addAll(cv1.getFormacion());
			conocimientosController.setHab.addAll(cv1.getHabilidades());
			personalController.setTextDNI(cv1.getPersonal().get(0).getIdentificacion());
			personalController.setTextNombre(cv1.getPersonal().get(0).getNombre());
			personalController.setTextApellido(cv1.getPersonal().get(0).getApellidos());
			personalController.setIntroDate(cv1.getPersonal().get(0).getFechaNacimiento());
			personalController.setTextDireccion(cv1.getPersonal().get(0).getDirecion());
			personalController.setTextPostal(cv1.getPersonal().get(0).getCodigoPostal());
			personalController.setTextLocalidad(cv1.getPersonal().get(0).getLocalidad());
			personalController.setComboPais(cv1.getPersonal().get(0).getPais());
			personalController.setTextNacionalidad(cv1.getPersonal().get(0).getNacionalidades());
			
			contactoController.initialize(null, null);
			experienciaController.initialize(null, null);
			conocimientosController.initialize(null, null);
			formacionController.initialize(null, null);
		}
		
	}
		
	



	@SuppressWarnings("static-access")
	private void guardarcomo() throws Exception {
		Contactos cont = new Contactos();
		cont.getEmails().addAll(contactoController.set);
		cont.getTelefonos().addAll(contactoController.set2);
		cont.getWebs().addAll(contactoController.set1);
		Personal p1 = new Personal();
		p1.setIdentificacion(personalController.getTextDNI().getText());
		p1.setNombre(personalController.getTextNombre().getText());
		p1.setApellidos(personalController.getTextApellido().getText());
		p1.setFechaNacimiento(personalController.getIntroDate().getValue());
		p1.setDirecion(personalController.getTextDireccion().getText());
		p1.setCodigoPostal(personalController.getTextPostal().getText());
		p1.setLocalidad(personalController.getTextLocalidad().getText());
		p1.setPais(personalController.getComboPais().getValue());
		String[] nacion=personalController.getTextNacionalidad().getText().split(",");
		for(int i=0;i<nacion.length; i++)
			p1.getNacionalidades().add(new Nacionalidades(nacion[i]));
		CV cv =new CV();
		cv.getPersonal().add(p1);
		cv.getContacto().add(cont);
		cv.getExperiencias().addAll(experienciaController.setExp);
		cv.getFormacion().addAll(formacionController.setForm);
		cv.getHabilidades().addAll(conocimientosController.setHab);
		
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Guardar como");
		dialog.setContentText("Introduce la ruta y el nombre del archivo: ");

		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			JAXBUtil.save(cv, new File(result.get()));
		}
		
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
			

	}

	public VBox getRoot() {
		return root;
	}

}
