package dad.javafx.CalculadoraIMC;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraController extends Application {

	private CalculadoraView view;
	private CalculadoraModel model;

	public CalculadoraController() {
		view = new CalculadoraView();
		model = new CalculadoraModel();

		StringConverter<Double> converter = new DoubleStringConverter();

		view.getPesoText().textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.isEmpty()) {
				model.setPeso(converter.fromString(newValue));
			} else {
				model.setPeso(0.0);
			}
		});

		view.getAlturaText().textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.isEmpty()) {
				model.setAltura(converter.fromString(newValue));
			} else {
				model.setAltura(0.0);
			}
		});
	}

	@Override
	public void start(Stage primaryStage) {
		view.start(primaryStage);

        Bindings.bindBidirectional(view.getImcLabel().textProperty(), model.imcProperty());
        Bindings.bindBidirectional(view.getResultadoLabel().textProperty(), model.resultadoProperty());

        view.getPesoText().textProperty().addListener((obs, oldValue, newValue) -> model.calcularIMC());
        view.getAlturaText().textProperty().addListener((obs, oldValue, newValue) -> model.calcularIMC());
	}
}