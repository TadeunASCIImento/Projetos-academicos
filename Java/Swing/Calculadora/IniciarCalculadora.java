package br.com.calculadoraswing;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class IniciarCalculadora extends JPanel {

	public static JPanel tela;
	public static JFrame frame;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		criarComponentes();

	}

	private static void criarComponentes() {

		frame = new JFrame("Calculadora Java (Swing) Operacoes basicas");
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		tela = new Calculadora();
		frame.add(tela);
		frame.setVisible(true);
	}

}
