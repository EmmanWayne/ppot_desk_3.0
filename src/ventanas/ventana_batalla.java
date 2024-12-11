package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ventana_batalla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblJugador1;
	public JLabel lblJugador2;
	public JButton lblNombreJ1;
	public JButton lblNombreJ2;
	public JButton lblEleccionJ1;
	public JButton lblEleccionJ2;
	public JLabel lblBatalla;
	public JLabel lblResultado;

	public int eleccionJ1 = 0;
	public int eleccionJ2 = 0;

	final ImageIcon piedra_piedra = new ImageIcon(getClass().getResource("/recursos/piedra_piedra.png"));
	final ImageIcon papel_papel = new ImageIcon(getClass().getResource("/recursos/papel_papel.png"));
	final ImageIcon tijera_tijera = new ImageIcon(getClass().getResource("/recursos/tijera_tijera.png"));
	final ImageIcon piedra_papel = new ImageIcon(getClass().getResource("/recursos/piedra_papel.png"));
	final ImageIcon papel_piedra = new ImageIcon(getClass().getResource("/recursos/papel_piedra.png"));
	final ImageIcon tijera_papel = new ImageIcon(getClass().getResource("/recursos/tijera_papel.png"));
	final ImageIcon papel_tijera = new ImageIcon(getClass().getResource("/recursos/papel_tijera.png"));
	final ImageIcon piedra_tijera = new ImageIcon(getClass().getResource("/recursos/piedra_tijera.png"));
	final ImageIcon tijera_piedra = new ImageIcon(getClass().getResource("/recursos/tijera_piedra.png"));

	final ImageIcon empate = new ImageIcon(getClass().getResource("/recursos/empate.gif"));
	final ImageIcon g1 = new ImageIcon(getClass().getResource("/recursos/ganador1.gif"));
	final ImageIcon g2 = new ImageIcon(getClass().getResource("/recursos/ganador1.gif"));

	private JPanel panel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public ventana_batalla() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana_batalla.class.getResource("/recursos/ppot.png")));
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(10, 11, 920, 539);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(10, 421, 900, 107);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setBounds(10, 13, 196, 36);
		panel_3.add(lblJugador1);
		lblJugador1.setForeground(Color.BLACK);
		lblJugador1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNombreJ1 = new JButton("-");
		lblNombreJ1.setBackground(new Color(0, 128, 0));
		lblNombreJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJ1.setForeground(Color.WHITE);
		lblNombreJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNombreJ1.setBounds(10, 48, 196, 48);
		panel_3.add(lblNombreJ1);

		lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setBounds(694, 13, 196, 36);
		panel_3.add(lblJugador2);
		lblJugador2.setForeground(Color.BLACK);
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

		lblNombreJ2 = new JButton("-");
		lblNombreJ2.setBackground(new Color(255, 140, 0));
		lblNombreJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJ2.setForeground(Color.WHITE);
		lblNombreJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNombreJ2.setBounds(694, 48, 196, 48);
		panel_3.add(lblNombreJ2);

		JLabel lblJugador2_1 = new JLabel("VRS");
		lblJugador2_1.setBounds(10, 38, 880, 36);
		panel_3.add(lblJugador2_1);
		lblJugador2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2_1.setForeground(Color.RED);
		lblJugador2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));

		panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(216, 11, 197, 85);
		panel_3.add(panel);
		panel.setLayout(null);

		lblEleccionJ1 = new JButton("-");
		lblEleccionJ1.setBackground(new Color(0, 128, 0));
		lblEleccionJ1.setBounds(10, 11, 177, 63);
		panel.add(lblEleccionJ1);
		lblEleccionJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleccionJ1.setForeground(Color.WHITE);
		lblEleccionJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 165, 0));
		panel_4.setBounds(487, 11, 197, 85);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		lblEleccionJ2 = new JButton("-");
		lblEleccionJ2.setBackground(new Color(255, 140, 0));
		lblEleccionJ2.setBounds(10, 11, 177, 63);
		panel_4.add(lblEleccionJ2);
		lblEleccionJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleccionJ2.setForeground(Color.WHITE);
		lblEleccionJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 11, 900, 60);
		panel_1.add(panel_2);

		lblResultado = new JLabel("-");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblResultado.setBounds(182, 11, 536, 36);
		panel_2.add(lblResultado);

		JButton btnInicio = new JButton("Otros Jugadores");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_inicio ppot = new ventana_inicio();
				ppot.setLocationRelativeTo(null);
				ppot.setVisible(true);
				ppot.btnEditarJ1.setVisible(false);
				ppot.btnEditarJ2.setVisible(false);
				dispose();
			}
		});
		btnInicio.setBackground(new Color(0, 102, 255));
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnInicio.setBounds(10, 11, 162, 38);
		panel_2.add(btnInicio);

		JButton btnJugar = new JButton("Mismos Jugadores");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana_inicio ppot = new ventana_inicio();
				ppot.setLocationRelativeTo(null);
				ppot.setVisible(true);
				ppot.txtNombre1.setText(lblNombreJ1.getText().toString());
				ppot.txtNombre2.setText(lblNombreJ2.getText().toString());
				ppot.txtNombre1.setEditable(false);
				ppot.btnListoJ1.setVisible(false);
				ppot.btnEditarJ1.setVisible(true);
				ppot.txtNombre2.setEditable(false);
				ppot.btnListoJ2.setVisible(false);
				ppot.btnEditarJ2.setVisible(true);
				ppot.lblJ1.setText(ppot.txtNombre1.getText().toString());
				ppot.estado_j1 = 1;
				ppot.lblJ2.setText(ppot.txtNombre2.getText().toString());
				ppot.estado_j2 = 1;
				dispose();
			}

		});
		btnJugar.setBackground(new Color(0, 102, 255));
		btnJugar.setForeground(Color.WHITE);
		btnJugar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnJugar.setBounds(728, 11, 162, 38);
		panel_2.add(btnJugar);

		panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 75, 900, 335);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		lblBatalla = new JLabel("");
		lblBatalla.setBounds(79, 11, 742, 313);
		panel_5.add(lblBatalla);

		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(10, 11, 59, 313);
		panel_5.add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(831, 11, 59, 313);
		panel_5.add(btnNewButton_1);

	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "Desea realmente salir del juego?", "Salir del juego",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void iniciar_batalla() {
		if (eleccionJ1 == 1 && eleccionJ2 == 1) {
			final ImageIcon icono = new ImageIcon(piedra_piedra.getImage().getScaledInstance(lblBatalla.getWidth(),
					lblBatalla.getHeight(), Image.SCALE_DEFAULT));
			lblBatalla.setIcon(icono);

			final ImageIcon icono1 = new ImageIcon(empate.getImage().getScaledInstance(lblResultado.getWidth(),
					lblResultado.getHeight(), Image.SCALE_DEFAULT));
			lblResultado.setIcon(icono1);

		} else {
			if (eleccionJ1 == 2 && eleccionJ2 == 2) {
				final ImageIcon icono = new ImageIcon(papel_papel.getImage().getScaledInstance(lblBatalla.getWidth(),
						lblBatalla.getHeight(), Image.SCALE_DEFAULT));
				lblBatalla.setIcon(icono);

				final ImageIcon icono1 = new ImageIcon(empate.getImage().getScaledInstance(lblResultado.getWidth(),
						lblResultado.getHeight(), Image.SCALE_DEFAULT));
				lblResultado.setIcon(icono1);
			} else {
				if (eleccionJ1 == 3 && eleccionJ2 == 3) {
					final ImageIcon icono = new ImageIcon(tijera_tijera.getImage()
							.getScaledInstance(lblBatalla.getWidth(), lblBatalla.getHeight(), Image.SCALE_DEFAULT));
					lblBatalla.setIcon(icono);

					final ImageIcon icono1 = new ImageIcon(empate.getImage().getScaledInstance(lblResultado.getWidth(),
							lblResultado.getHeight(), Image.SCALE_DEFAULT));
					lblResultado.setIcon(icono1);
				} else {
					if (eleccionJ1 == 1 && eleccionJ2 == 2) {
						final ImageIcon icono = new ImageIcon(piedra_papel.getImage()
								.getScaledInstance(lblBatalla.getWidth(), lblBatalla.getHeight(), Image.SCALE_DEFAULT));
						lblBatalla.setIcon(icono);

						final ImageIcon icono1 = new ImageIcon(g2.getImage().getScaledInstance(lblResultado.getWidth(),
								lblResultado.getHeight(), Image.SCALE_DEFAULT));
						lblResultado.setIcon(icono1);
					} else {
						if (eleccionJ1 == 2 && eleccionJ2 == 1) {
							final ImageIcon icono = new ImageIcon(papel_piedra.getImage().getScaledInstance(
									lblBatalla.getWidth(), lblBatalla.getHeight(), Image.SCALE_DEFAULT));
							lblBatalla.setIcon(icono);

							final ImageIcon icono1 = new ImageIcon(g1.getImage().getScaledInstance(
									lblResultado.getWidth(), lblResultado.getHeight(), Image.SCALE_DEFAULT));
							lblResultado.setIcon(icono1);
						} else {
							if (eleccionJ1 == 2 && eleccionJ2 == 3) {
								final ImageIcon icono = new ImageIcon(papel_tijera.getImage().getScaledInstance(
										lblBatalla.getWidth(), lblBatalla.getHeight(), Image.SCALE_DEFAULT));
								lblBatalla.setIcon(icono);

								final ImageIcon icono1 = new ImageIcon(g2.getImage().getScaledInstance(
										lblResultado.getWidth(), lblResultado.getHeight(), Image.SCALE_DEFAULT));
								lblResultado.setIcon(icono1);
							} else {
								if (eleccionJ1 == 3 && eleccionJ2 == 2) {
									final ImageIcon icono = new ImageIcon(tijera_papel.getImage().getScaledInstance(
											lblBatalla.getWidth(), lblBatalla.getHeight(), Image.SCALE_DEFAULT));
									lblBatalla.setIcon(icono);

									final ImageIcon icono1 = new ImageIcon(g1.getImage().getScaledInstance(
											lblResultado.getWidth(), lblResultado.getHeight(), Image.SCALE_DEFAULT));
									lblResultado.setIcon(icono1);
								} else {
									if (eleccionJ1 == 3 && eleccionJ2 == 1) {
										final ImageIcon icono = new ImageIcon(
												tijera_piedra.getImage().getScaledInstance(lblBatalla.getWidth(),
														lblBatalla.getHeight(), Image.SCALE_DEFAULT));
										lblBatalla.setIcon(icono);

										final ImageIcon icono1 = new ImageIcon(
												g2.getImage().getScaledInstance(lblResultado.getWidth(),
														lblResultado.getHeight(), Image.SCALE_DEFAULT));
										lblResultado.setIcon(icono1);
									} else {
										if (eleccionJ1 == 1 && eleccionJ2 == 3) {
											final ImageIcon icono = new ImageIcon(
													piedra_tijera.getImage().getScaledInstance(lblBatalla.getWidth(),
															lblBatalla.getHeight(), Image.SCALE_DEFAULT));
											lblBatalla.setIcon(icono);

											final ImageIcon icono1 = new ImageIcon(
													g1.getImage().getScaledInstance(lblResultado.getWidth(),
															lblResultado.getHeight(), Image.SCALE_DEFAULT));
											lblResultado.setIcon(icono1);
										} else {

										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

}
