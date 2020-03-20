package br.com.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Quizz extends Application {

	public static void main(String args[]) {

		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Quizz");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 40, 40);
		rootNode.setAlignment(Pos.CENTER);
		primaryStage.setScene(new Scene(rootNode, 600, 500));

		Label labelTitulo = new Label();
		labelTitulo.setText("Bem vindo ao Quizz Java.");

		Label labelQuest = new Label();
		labelQuest.setText("( 1 ) - Estrutura de dados que permite armazenar uma coleção de objetos?");
		labelQuest.setFont(new Font(14));

		CheckBox checkBox1 = new CheckBox("checkBox1");
		checkBox1.setText("ArrayList");
		checkBox1.setFont(new Font(14));

		CheckBox checkBox2 = new CheckBox("checkBox2");
		checkBox2.setText("Variável inteira");
		checkBox2.setFont(new Font(14));

		CheckBox checkBox3 = new CheckBox("checkBox3");
		checkBox3.setText("Laço for");
		checkBox3.setFont(new Font(14));

		CheckBox checkBox4 = new CheckBox("checkBox4");
		checkBox4.setText("JPanel");
		checkBox4.setFont(new Font(14));

		Label labelResponse = new Label();
		labelResponse.setText("");
		labelResponse.setFont(new Font(14));

		Button btnFechar = new Button("Fechar");
		btnFechar.setFont(new Font(14));
		btnFechar.setPickOnBounds(true);

		primaryStage.show();

		rootNode.getChildren().addAll(labelQuest, checkBox1, checkBox2,checkBox3,checkBox4, labelResponse, btnFechar);

		checkBox1.setOnAction((ae) -> {

			if (checkBox1.isSelected())
				labelResponse.setText("Parabésns você acertou!.");
			else
				labelResponse.setText("");

		});
		checkBox2.setOnAction((ae) -> {

			if (checkBox2.isSelected())
				labelResponse.setText("Você errou!.");
			else
				labelResponse.setText("");
		});
		checkBox3.setOnAction((ae) -> {

			if (checkBox3.isSelected())
				labelResponse.setText("Você errou!.");
			else
				labelResponse.setText("");
		});
		checkBox4.setOnAction((ae) -> {

			if (checkBox4.isSelected())
				labelResponse.setText("Você errou!.");
			else
				labelResponse.setText("");
		});

		btnFechar.setOnAction((ae)->{
			System.exit(1);

		});
	}


}
