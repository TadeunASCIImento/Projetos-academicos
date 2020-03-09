package br.com.threads;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AppRelogioDigital {

	private static JFrame frame;

	public static void main(String[] args) {

		Temporizador threadTemporizador = new Temporizador();
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(threadTemporizador);
		executor.shutdown();
		criarComponentes();
	}

	private static void criarComponentes() {

		Temporizador telaTemporizador = new Temporizador();
		telaTemporizador.setBackground(Color.BLACK);
		frame = new JFrame();
		frame.setSize(390, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(telaTemporizador);
		frame.setVisible(true);
	}
}

class Temporizador extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private static Integer intMilesimo = 0, continueLoop1 = 0;
	private static Integer intSegundo1 = 0, intSegundo2 = 0;
	private static Integer intMinuto1 = 0, intMinuto2 = 0;
	private static Integer intHora1 = 0;
	private static JLabel labelDisplayRelogio;

	public Temporizador() {
		criarComponentes();
	}

	private void criarComponentes() {

		setLayout(new FlowLayout());
		labelDisplayRelogio = new JLabel();
		labelDisplayRelogio.setFont(new Font(labelDisplayRelogio.getFont().getName(), Font.PLAIN, 70));
		labelDisplayRelogio.setForeground(Color.GREEN);
		add(labelDisplayRelogio);
	}

	private void acertarHoraRelogio() {

		boolean continueLoop2 = true;
		while (continueLoop2) {
			try {
				String strHrs1 = JOptionPane.showInputDialog("hora");
				intHora1 = Integer.parseInt(strHrs1);
				String strMin1 = JOptionPane.showInputDialog("primeiro minuto");
				intMinuto1 = Integer.parseInt(strMin1);
				String strMin2 = JOptionPane.showInputDialog("segundo minuto");
				intMinuto2 = Integer.parseInt(strMin2);
				continueLoop2 = false;
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Horário inválido tente novamente!");
			}

		}
	}

	private void mostrarDisplayRelogio() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				labelDisplayRelogio.setText(
						intHora1 + " : " + intMinuto1 + "" + intMinuto2 + " : " + intSegundo1 + "" + intSegundo2);

			}
		});

	}

	@Override
	public void run() {

		acertarHoraRelogio();

		while (true)
			do {
				continueLoop1 = Integer.parseInt(intHora1.toString());
				for (intMilesimo = 0; intMilesimo <= 9; intMilesimo++) {
					if (intMilesimo == 9) {
						++intSegundo2;
					}
					if (intSegundo2 == 10) {
						intSegundo2 = 0;
						++intSegundo1;
					}
					if (intSegundo1 == 6) {
						intSegundo1 = 0;
						++intMinuto2;
					}
					if (intMinuto2 == 10) {
						intMinuto2 = 0;
						++intMinuto1;
					}
					if (intMinuto1 == 6) {
						intMinuto1 = 0;
						++intHora1;
					}
					if (continueLoop1 == 24) {
						intHora1 = 0;

					}
					mostrarDisplayRelogio();

					try {
						Thread.sleep(99);
					} catch (InterruptedException exception) {
						labelDisplayRelogio.setText("< Erro reinicie o relógio >" + exception);
					}
				}
			} while (continueLoop1 < 23);
	}
}
