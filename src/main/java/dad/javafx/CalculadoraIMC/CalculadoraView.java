package dad.javafx.CalculadoraIMC;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraView extends Application {

    private TextField pesoText = new TextField();
    private Label pesoLabel = new Label("Peso:");
    private Label kgLabel = new Label("kg");
    private TextField alturaText = new TextField();
    private Label alturaLabel = new Label("Altura:");
    private Label cmLabel = new Label("cm");
    private Label resultadoLabel = new Label(); // Etiqueta para mostrar el resultado
    private Label imcLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        HBox pesoPane = new HBox(5);
        pesoPane.setAlignment(Pos.CENTER);
        pesoPane.getChildren().addAll(pesoLabel, pesoText, kgLabel);

        HBox alturaPane = new HBox(5);
        alturaPane.setAlignment(Pos.CENTER);
        alturaPane.getChildren().addAll(alturaLabel, alturaText, cmLabel);

        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(false);
        root.getChildren().addAll(pesoPane, alturaPane, imcLabel, resultadoLabel);

        primaryStage.setTitle("IMC");
        primaryStage.setScene(new Scene(root, 320, 200));
        primaryStage.show();
    }
    
    public TextField getPesoText() {
        return pesoText;
    }

    public TextField getAlturaText() {
        return alturaText;
    }

	public Label getResultadoLabel() {
		return resultadoLabel;
	}

	public Label getImcLabel() {
		return imcLabel;
	}
    
}
