package br.com.loginswing;


import javax.swing.JFrame;
import javax.swing.JPanel;

/*Criar o banco de dados usando MySQL ou outro banco,
 * crie a tabela usuarios e inserira um usuário e senha na tabela.
 */

public class IniciarLogin extends JPanel {
	private static final long serialVersionUID = 1L;

	public static JPanel tela;
	public static JFrame frame;

	public static void main(String[] args) {

		criarComponentes();

	}

	private static void criarComponentes() {

		frame = new JFrame("Logon");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);

		tela = new TelaLogin();
		tela.setVisible(true);

		frame.add(tela);
		frame.setVisible(true);
	}

}
