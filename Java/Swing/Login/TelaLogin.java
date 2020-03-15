package br.com.loginswing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JPanel {
	private static final long serialVersionUID = 1L;

	JLabel labelTitulo, labelSubTitulo, labelUsuario, labelSenha;
	JTextField campoUsuario;
	JPasswordField campoSenha;
	JButton botaoEntrar;
	boolean message;

	public TelaLogin() {
		criarComponentes();
		criarEventos();
	}

	private void criarComponentes() {
		setLayout(null);

		labelTitulo = new JLabel("Bem vindo!", JLabel.LEFT);
		labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.PLAIN, 30));
		labelTitulo.setBounds(210, 50, 300, 40);
		add(labelTitulo);

		labelSubTitulo = new JLabel("Digite seu usuário e senha", JLabel.LEFT);
		labelSubTitulo.setFont(new Font(labelSubTitulo.getFont().getName(), Font.PLAIN, 20));
		labelSubTitulo.setBounds(175, 100, 300, 40);
		add(labelSubTitulo);

		labelUsuario = new JLabel("Usuário", JLabel.LEFT);
		labelUsuario.setFont(new Font(labelTitulo.getFont().getName(), Font.PLAIN, 18));
		labelUsuario.setBounds(100, 150, 380, 40);
		add(labelUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font(campoUsuario.getFont().getName(), Font.ITALIC, 18));
		campoUsuario.setBounds(100, 190, 380, 40);
		add(campoUsuario);

		labelSenha = new JLabel("Senha", JLabel.LEFT);
		labelSenha.setFont(new Font(labelSenha.getFont().getName(), Font.PLAIN, 18));
		labelSenha.setBounds(100, 230, 380, 40);
		add(labelSenha);

		campoSenha = new JPasswordField();
		campoSenha.setFont(new Font(campoUsuario.getFont().getName(), Font.PLAIN, 20));
		campoSenha.setBounds(100, 270, 380, 40);
		add(campoSenha);

		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font(botaoEntrar.getFont().getName(), Font.PLAIN, 20));
		botaoEntrar.setBounds(100, 340, 150, 40);
		add(botaoEntrar);

	}

	private void criarEventos() {

		botaoEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarUsuario();

			}
		});
	}

	private void validarUsuario() {
		int op = 0;
		Connection conexao = null;
		Statement instrucaoSQL = null;
		ResultSet resultados;

		try {
			conexao = DriverManager.getConnection(Conexao.stringConexao, Conexao.usuario, Conexao.senha);
			instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultados = instrucaoSQL.executeQuery("SELECT nome,senha,firstname FROM usuarios");

			while (resultados.next()) {
				Usuario usuario = new Usuario();
				usuario.setNomeUsuario(resultados.getString("nome"));
				usuario.setSenhaUsuario(resultados.getString("senha"));

				do {
					if (campoUsuario.getText().equals(usuario.getNomeUsuario())
							&& new String(campoSenha.getPassword()).equals(usuario.getSenhaUsuario())) {
						JOptionPane.showMessageDialog(null,
								"Accesso Liberado ola " + resultados.getString("firstname") + " !");
						op = 1;
						break;
					}

				} while (campoUsuario.getText().equals(usuario.getNomeUsuario())
						&& new String(campoSenha.getPassword()).equals(usuario.getSenhaUsuario()));

			}

			if (op == 0) {
				JOptionPane.showMessageDialog(null, "Nao autorizado tente novamente!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Acesso nao autorizado");
			e.printStackTrace();

		} finally {

			try {

				if (instrucaoSQL != null) {
					instrucaoSQL.close();
				}

				if (conexao != null) {
					conexao.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
