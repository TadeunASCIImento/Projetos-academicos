package br.com.javafx;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CalculadoraImc extends Application {

	public static void main(String[] args) {

		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculo IMC");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 30, 30);
		rootNode.setAlignment(Pos.CENTER);
		primaryStage.setScene(new Scene(rootNode, 400, 400));

		Label labelTitulo = new Label("Applet Calculadora Imc JavaFX");
		labelTitulo.setScaleX(2);
		labelTitulo.setScaleY(2);

		Label labelPeso = new Label("Peso (Kg)");
		labelPeso.setScaleX(1.5);
		labelPeso.setScaleY(1.5);

		TextField campoPeso = new TextField();
		campoPeso.setScaleY(1.5);
		campoPeso.setScaleX(1.5);

		Label labelAltura = new Label("Altura (Cm)");
		labelAltura.setScaleX(1.5);
		labelAltura.setScaleY(1.5);

		TextField campoAltura = new TextField();
		campoAltura.setScaleX(1.5);
		campoAltura.setScaleY(1.5);

		Label labelResult = new Label("");
		labelResult.setScaleX(2);
		labelResult.setScaleY(2);

		Button btnCalcular = new Button("Calcular");
		btnCalcular.setScaleX(1.5);
		btnCalcular.setScaleY(1.5);

		rootNode.getChildren().addAll(labelTitulo, labelPeso, campoPeso, labelAltura, campoAltura, btnCalcular,
				labelResult);
		primaryStage.show();

		btnCalcular.setOnAction((ae) -> {
			try {

				Double pes = Double.parseDouble(campoPeso.getText());
				Double alt = Double.parseDouble(campoAltura.getText());
				double imc = pes / (alt * alt / 10000);
				int i = (int) imc;
				labelResult.setText("( IMC = " + i + ")");

			} catch (Exception NumberFormatException) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setHeaderText("Valor invalido");
				alert.setContentText("Verifique os valores e tente novamente.");
				alert.showAndWait();

			}
		});

	}

}
