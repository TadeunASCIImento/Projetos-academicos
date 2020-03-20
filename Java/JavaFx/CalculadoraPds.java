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

public class CalculadoraPds extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	public void init() {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Calculadora  PDS.");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 40, 40);
		rootNode.setAlignment(Pos.CENTER);
		primaryStage.setScene(new Scene(rootNode, 400, 400));

		Label labelTitulo = new Label("Applet Calculadora PDS JavaFX");
		labelTitulo.setScaleY(1.5);
		labelTitulo.setScaleX(1);

		Label labelHrsIndp = new Label("Digite as horas indisponiveis do sistema:");
		labelHrsIndp.setScaleY(1.5);
		labelHrsIndp.setScaleX(1);

		TextField campoHrsIndp = new TextField();
		campoHrsIndp.setScaleY(1.5);
		campoHrsIndp.setScaleX(1);

		Button btnCalcular = new Button("Calcular Pds");
		btnCalcular.setDefaultButton(true);
		btnCalcular.setScaleY(1.5);
		btnCalcular.setScaleX(1);

		Label labelResult = new Label("");
		labelResult.setScaleX(1.5);
		labelResult.setScaleY(1.5);

		rootNode.getChildren().addAll(labelTitulo, labelHrsIndp, campoHrsIndp, btnCalcular, labelResult);
		primaryStage.show();

		btnCalcular.setOnAction((ae) -> {

			try {

				Double hrs = Double.parseDouble(campoHrsIndp.getText());
				double per = (((8760 - hrs) / 8760) * 100);
				float x = (float) per;
				labelResult.setText("PDS = ( " + x + "% )");

			} catch (Exception NumberFormatException) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setHeaderText("Valor invalido");
				alert.setContentText("Verifique os valores e tente novamente.");
				alert.showAndWait();

			}
		});
	}

	@Override
	public void stop() {

	}
}
