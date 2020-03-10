package br.com.calculadoraswing;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JPanel {
	private static final long serialVersionUID = 1L;

	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	JButton btnSom, btnDiv, btnSub, btnMult, btnResult, btnLimpar, btnPonto, btnSqrt, btnPow;
	JTextField campoNumero;
	JLabel labelTitulo;
	JPanel tela;

	public Calculadora() {

		criarComponentes();
		criarEventos();

	}

	double valorX, valorY, quad;
	String operacao;

	private void criarComponentes() {
		setLayout(null);

		campoNumero = new JTextField();
		campoNumero.setFont(new Font(campoNumero.getFont().getName(), Font.PLAIN, 30));
		campoNumero.setBounds(35, 110, 320, 50);
		add(campoNumero);

		btn1 = new JButton("1");
		btn1.setFont(new Font(btn1.getFont().getName(), Font.PLAIN, 20));
		btn1.setBounds(35, 180, 100, 50);
		add(btn1);

		btn2 = new JButton("2");
		btn2.setFont(new Font(btn2.getFont().getName(), Font.PLAIN, 20));
		btn2.setBounds(145, 180, 100, 50);
		add(btn2);

		btn3 = new JButton("3");
		btn3.setFont(new Font(btn3.getFont().getName(), Font.PLAIN, 20));
		btn3.setBounds(255, 180, 100, 50);
		add(btn3);

		btn4 = new JButton("4");
		btn4.setFont(new Font(btn4.getFont().getName(), Font.PLAIN, 20));
		btn4.setBounds(35, 240, 100, 50);
		add(btn4);

		btn5 = new JButton("5");
		btn5.setFont(new Font(btn5.getFont().getName(), Font.PLAIN, 20));
		btn5.setBounds(145, 240, 100, 50);
		add(btn5);

		btn6 = new JButton("6");
		btn6.setFont(new Font(btn6.getFont().getName(), Font.PLAIN, 20));
		btn6.setBounds(255, 240, 100, 50);
		add(btn6);

		btn7 = new JButton("7");
		btn7.setFont(new Font(btn7.getFont().getName(), Font.PLAIN, 20));
		btn7.setBounds(35, 300, 100, 50);
		add(btn7);

		btn8 = new JButton("8");
		btn8.setFont(new Font(btn8.getFont().getName(), Font.PLAIN, 20));
		btn8.setBounds(145, 300, 100, 50);
		add(btn8);

		btn9 = new JButton("9");
		btn9.setFont(new Font(btn9.getFont().getName(), Font.PLAIN, 20));
		btn9.setBounds(255, 300, 100, 50);
		add(btn9);

		btn0 = new JButton("0");
		btn0.setFont(new Font(btn0.getFont().getName(), Font.PLAIN, 20));
		btn0.setBounds(145, 360, 100, 50);
		add(btn0);

		btnSom = new JButton("+");
		btnSom.setFont(new Font(btnSom.getFont().getName(), Font.PLAIN, 20));
		btnSom.setBounds(35, 430, 100, 50);
		add(btnSom);

		btnSub = new JButton("-");
		btnSub.setFont(new Font(btnSub.getFont().getName(), Font.PLAIN, 20));
		btnSub.setBounds(255, 430, 100, 50);
		add(btnSub);

		btnDiv = new JButton("/");
		btnDiv.setFont(new Font(btnDiv.getFont().getName(), Font.PLAIN, 20));
		btnDiv.setBounds(35, 490, 100, 50);
		add(btnDiv);

		btnMult = new JButton("*");
		btnMult.setFont(new Font(btnMult.getFont().getName(), Font.PLAIN, 20));
		btnMult.setBounds(145, 490, 100, 50);
		add(btnMult);

		btnResult = new JButton("=");
		btnResult.setFont(new Font(btnResult.getFont().getName(), Font.PLAIN, 20));
		btnResult.setBounds(255, 490, 100, 50);
		add(btnResult);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font(btnLimpar.getFont().getName(), Font.PLAIN, 20));
		btnLimpar.setBounds(145, 570, 100, 50);
		add(btnLimpar);

		btnPonto = new JButton(".");
		btnPonto.setFont(new Font(btnPonto.getFont().getName(), Font.PLAIN, 20));
		btnPonto.setBounds(145, 430, 100, 50);
		add(btnPonto);

		btnSqrt = new JButton("sqrt");
		btnSqrt.setFont(new Font(btnSqrt.getFont().getName(), Font.PLAIN, 20));
		btnSqrt.setBounds(255, 360, 100, 50);
		add(btnSqrt);

		btnPow = new JButton("pow");
		btnPow.setFont(new Font(btnPow.getFont().getName(), Font.PLAIN, 15));
		btnPow.setBounds(35, 360, 100, 50);
		add(btnPow);

	}

	private void criarEventos() {

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "1");

			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "2");

			}

		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "3");

			}

		});
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "4");

			}

		});
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "5");

			}

		});
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "6");

			}

		});
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "7");

			}

		});
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "8");

			}

		});

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "9");

			}

		});
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + "0");

			}

		});
		btnPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(campoNumero.getText() + ".");

			}

		});
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoNumero.setText(" ");

			}

		});

		btnSom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText("");
				operacao = "somar";
			}

		});
		btnSub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText(" ");
				operacao = "subtrair";

			}

		});
		btnDiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText(" ");
				operacao = "dividir";
			}

		});
		btnMult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText(" ");
				operacao = "multiplicar";

			}

		});
		btnSqrt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText(" ");
				valorX = Math.sqrt(valorX);
				operacao = Double.toString(valorX);
				campoNumero.setText(operacao);

			}

		});

		btnPow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorX = Double.parseDouble(campoNumero.getText());
				campoNumero.setText("");
				operacao = "potencia";

			}

		});
		btnResult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				valorY = Double.parseDouble(campoNumero.getText());

				switch (operacao) {
				case "somar":
					valorX = valorX + valorY;
					operacao = Double.toString(valorX);
					campoNumero.setText(operacao);
					break;

				case "subtrair":
					valorX = valorX - valorY;
					operacao = Double.toString(valorX);
					campoNumero.setText(operacao);
					break;

				case "dividir":
					valorX = valorX / valorY;
					operacao = Double.toString(valorX);
					campoNumero.setText(operacao);
					break;

				case "multiplicar":
					valorX = valorX * valorY;
					operacao = Double.toString(valorX);
					campoNumero.setText(operacao);
					break;

				case "potencia":
					valorX = Math.pow(valorX, valorY);
					operacao = Double.toString(valorX);
					campoNumero.setText(operacao);
					break;

				}

			}
		});

	}

}
