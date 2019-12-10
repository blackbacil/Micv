package dad.Micv.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private MainController controller;
	public Stage hola;

	@Override
	public void start(Stage primaryStage) throws Exception {
		hola=primaryStage;
		primaryStage=hola;
		controller = new MainController();
		
		Scene escena = new Scene(controller.getRoot(),600,500);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("MiCV");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
