package dad.javafx.CalculadoraIMC;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class CalculadoraModel {

    private final SimpleDoubleProperty peso = new SimpleDoubleProperty();
    private final SimpleDoubleProperty altura = new SimpleDoubleProperty();
    private final SimpleStringProperty imc = new SimpleStringProperty();
    private final SimpleStringProperty resultado = new SimpleStringProperty();

    public final SimpleDoubleProperty pesoProperty() {
        return this.peso;
    }

    public final double getPeso() {
        return this.pesoProperty().get();
    }

    public final void setPeso(final double peso) {
        this.pesoProperty().set(peso);
    }

    public final SimpleDoubleProperty alturaProperty() {
        return this.altura;
    }

    public final double getAltura() {
        return this.alturaProperty().get();
    }

    public final void setAltura(final double altura) {
        this.alturaProperty().set(altura);
    }

    public final SimpleStringProperty imcProperty() {
        return this.imc;
    }

    public final String getImc() {
        return this.imcProperty().get();
    }

    public final void setImc(final String imc) {
        this.imcProperty().set(imc);
    }

    public final SimpleStringProperty resultadoProperty() {
        return this.resultado;
    }

    public final String getResultado() {
        return this.resultadoProperty().get();
    }

    public final void setResultado(final String resultado) {
        this.resultadoProperty().set(resultado);
    }

    public void calcularIMC() {
        double peso = getPeso();
        double altura = getAltura() / 100.0;

        if (altura > 0) {
            double imc = peso / (altura * altura);
            setImc(String.format("%.2f", imc));
            if (imc < 18.5) {
                setResultado("Bajo peso");
            } else if (imc < 24.9) {
                setResultado("Normal");
            } else if (imc < 29.9) {
                setResultado("Sobrepeso");
            } else {
                setResultado("Obeso");
            }
        } else {
            setImc("");
            setResultado("");
        }
    }
}
