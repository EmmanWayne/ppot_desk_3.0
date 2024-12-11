package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ventana_ppot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblEleccionJ1;
	public JLabel lblEleccionJ2;
	public JLabel lblJugador1;
	public JLabel lblJugador2;
	public JLabel lblJ1;
	public JLabel lblJ2;

	public JButton btnPiedraJ1;
	public JButton btnPapelJ1;
	public JButton btnTijeraJ1;

	public JButton btnPiedraJ2;
	public JButton btnPapelJ2;
	public JButton btnTijeraJ2;

	public int tipo_partida;
	public int eleccionJ1 = 0;
	public int eleccionJ2 = 0;

	public JButton btnBatalla;
	public JLabel lblContador;

	public ventana_ppot() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana_ppot.class.getResource("/recursos/ppot.png")));
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				close();
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		final ImageIcon listo1 = new ImageIcon(getClass().getResource("/recursos/listo1.gif"));
		final ImageIcon listo2 = new ImageIcon(getClass().getResource("/recursos/listo2.gif"));
		final ImageIcon espera = new ImageIcon(getClass().getResource("/recursos/esperando.gif"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 300, 539);
		contentPane.add(panel);
		panel.setLayout(null);

		btnTijeraJ1 = new JButton("TIJERA");
		btnTijeraJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (tipo_partida == 0) {
					eleccionJ1 = 3;
					final ImageIcon icono03 = new ImageIcon(listo1.getImage().getScaledInstance(
							lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ1.setIcon(icono03);
				} else {
					if (tipo_partida == 1) {
						eleccionJ1 = 3;
						final ImageIcon icono003 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono003);
						generar_eleccionJ2();
						final ImageIcon icono0003 = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono0003);
					}

				}

			}
		});
		btnTijeraJ1.setForeground(Color.WHITE);
		btnTijeraJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnTijeraJ1.setBackground(new Color(0, 128, 0));
		btnTijeraJ1.setBounds(10, 401, 280, 127);
		panel.add(btnTijeraJ1);

		btnPapelJ1 = new JButton("PAPEL");
		btnPapelJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_partida == 0) {
					eleccionJ1 = 2;
					final ImageIcon icono03 = new ImageIcon(listo1.getImage().getScaledInstance(
							lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ1.setIcon(icono03);
				} else {
					if (tipo_partida == 1) {
						eleccionJ1 = 2;
						final ImageIcon icono003 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono003);
						generar_eleccionJ2();
						final ImageIcon icono0003 = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono0003);
					}

				}
			}
		});
		btnPapelJ1.setForeground(Color.WHITE);
		btnPapelJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnPapelJ1.setBackground(new Color(0, 128, 0));
		btnPapelJ1.setBounds(10, 263, 280, 127);
		panel.add(btnPapelJ1);

		btnPiedraJ1 = new JButton("PIEDRA");
		btnPiedraJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_partida == 0) {
					eleccionJ1 = 1;
					final ImageIcon icono03 = new ImageIcon(listo1.getImage().getScaledInstance(
							lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ1.setIcon(icono03);
				} else {
					if (tipo_partida == 1) {
						eleccionJ1 = 1;
						final ImageIcon icono003 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono003);
						generar_eleccionJ2();
						final ImageIcon icono0003 = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono0003);
					}

				}
			}
		});
		btnPiedraJ1.setForeground(Color.WHITE);
		btnPiedraJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnPiedraJ1.setBackground(new Color(0, 128, 0));
		btnPiedraJ1.setBounds(10, 125, 280, 127);
		panel.add(btnPiedraJ1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 11, 280, 104);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setForeground(new Color(0, 128, 0));
		lblJugador1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1.setBounds(10, 0, 260, 62);
		panel_2.add(lblJugador1);

		JLabel lblTurno1 = new JLabel("¡Elige una opción!");
		lblTurno1.setForeground(Color.BLACK);
		lblTurno1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTurno1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno1.setBounds(10, 73, 260, 20);
		panel_2.add(lblTurno1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(320, 11, 300, 539);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBounds(10, 213, 280, 113);
		panel_1.add(panel_2_1);

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setForeground(new Color(46, 139, 87));
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJ1.setBounds(10, 11, 129, 20);
		panel_2_1.add(lblJ1);

		lblContador = new JLabel("VRS");
		lblContador.setForeground(new Color(255, 0, 0));
		lblContador.setHorizontalAlignment(SwingConstants.CENTER);
		lblContador.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblContador.setBounds(79, 37, 121, 36);
		panel_2_1.add(lblContador);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ2.setForeground(new Color(255, 140, 0));
		lblJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJ2.setBounds(141, 11, 129, 20);
		panel_2_1.add(lblJ2);

		btnBatalla = new JButton("Iniciar la batalla");
		btnBatalla.setBounds(10, 77, 260, 29);
		panel_2_1.add(btnBatalla);
		btnBatalla.setForeground(Color.WHITE);
		btnBatalla.setBackground(new Color(0, 102, 255));
		btnBatalla.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnBatalla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (eleccionJ1 == 0 && eleccionJ2 == 0) {
					JOptionPane.showMessageDialog(null, "Ningún jugador ha hecho su elección.");
				} else {
					if (eleccionJ1 == 0) {
						JOptionPane.showMessageDialog(null, "El jugador 1 no ha hecho su elección.");
					} else {
						if (eleccionJ2 == 0) {
							JOptionPane.showMessageDialog(null, "El jugador 2 no ha hecho su elección.");
						} else {

							ventana_batalla batalla = new ventana_batalla();
							batalla.setLocationRelativeTo(null);
							batalla.setVisible(true);

							batalla.eleccionJ1 = eleccionJ1;
							batalla.eleccionJ2 = eleccionJ2;

							batalla.lblNombreJ1.setText(lblJugador1.getText().toString());
							batalla.lblNombreJ2.setText(lblJugador2.getText().toString());
							if (eleccionJ1 == 1) {
								batalla.lblEleccionJ1.setText("Piedra");
							} else {
								if (eleccionJ1 == 2) {
									batalla.lblEleccionJ1.setText("Papel");
								} else {
									if (eleccionJ1 == 3) {
										batalla.lblEleccionJ1.setText("Tijera");
									} else {

									}
								}
							}

							if (eleccionJ2 == 1) {
								batalla.lblEleccionJ2.setText("Piedra");
							} else {
								if (eleccionJ2 == 2) {
									batalla.lblEleccionJ2.setText("Papel");
								} else {
									if (eleccionJ2 == 3) {
										batalla.lblEleccionJ2.setText("Tijera");
									} else {

									}
								}
							}

							batalla.iniciar_batalla();
							dispose();

						}
					}
				}
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 280, 191);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblJugador1_1_1 = new JLabel("Elección Jugador 1");
		lblJugador1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJugador1_1_1.setBounds(10, 11, 260, 20);
		panel_3.add(lblJugador1_1_1);

		lblEleccionJ1 = new JLabel("");
		lblEleccionJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleccionJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEleccionJ1.setBounds(53, 66, 174, 72);
		panel_3.add(lblEleccionJ1);
		final ImageIcon icono = new ImageIcon(espera.getImage().getScaledInstance(lblEleccionJ1.getWidth(),
				lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
		lblEleccionJ1.setIcon(icono);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1.setBounds(10, 337, 280, 191);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblJugador1_1_1_1 = new JLabel("Elección Jugador 2");
		lblJugador1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJugador1_1_1_1.setBounds(10, 160, 260, 20);
		panel_3_1.add(lblJugador1_1_1_1);

		lblEleccionJ2 = new JLabel("");
		lblEleccionJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleccionJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEleccionJ2.setBounds(49, 50, 176, 68);
		panel_3_1.add(lblEleccionJ2);
		final ImageIcon icono2 = new ImageIcon(espera.getImage().getScaledInstance(lblEleccionJ2.getWidth(),
				lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
		lblEleccionJ2.setIcon(icono2);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(630, 11, 300, 539);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2_2.setBounds(10, 11, 280, 104);
		panel_1_1.add(panel_2_2);

		lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setForeground(new Color(255, 140, 0));
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblJugador2.setBounds(10, 0, 260, 62);
		panel_2_2.add(lblJugador2);

		JLabel lblTurno2 = new JLabel("¡Elige una opción!");
		lblTurno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno2.setForeground(Color.BLACK);
		lblTurno2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTurno2.setBounds(10, 73, 260, 20);
		panel_2_2.add(lblTurno2);

		btnPiedraJ2 = new JButton("PIEDRA");
		btnPiedraJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_partida == 0) {
					eleccionJ2 = 1;
					final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(lblEleccionJ2.getWidth(),
							lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ2.setIcon(icono);
				} else {
					if (tipo_partida == 2) {
						eleccionJ2 = 1;
						final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono);
						generar_eleccionJ1();
						final ImageIcon icono0 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono0);
					}

				}
			}
		});
		btnPiedraJ2.setForeground(Color.WHITE);
		btnPiedraJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnPiedraJ2.setBackground(new Color(255, 140, 0));
		btnPiedraJ2.setBounds(10, 126, 280, 127);
		panel_1_1.add(btnPiedraJ2);

		btnPapelJ2 = new JButton("PAPEL");
		btnPapelJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_partida == 0) {
					eleccionJ2 = 2;
					final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(lblEleccionJ2.getWidth(),
							lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ2.setIcon(icono);
				} else {
					if (tipo_partida == 2) {
						eleccionJ2 = 2;
						final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono);
						generar_eleccionJ1();
						final ImageIcon icono0 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono0);
					}

				}
			}
		});
		btnPapelJ2.setForeground(Color.WHITE);
		btnPapelJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnPapelJ2.setBackground(new Color(255, 140, 0));
		btnPapelJ2.setBounds(10, 264, 280, 127);
		panel_1_1.add(btnPapelJ2);

		btnTijeraJ2 = new JButton("TIJERA");
		btnTijeraJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo_partida == 0) {
					eleccionJ2 = 3;
					final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(lblEleccionJ2.getWidth(),
							lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
					lblEleccionJ2.setIcon(icono);
				} else {
					if (tipo_partida == 2) {
						eleccionJ2 = 3;
						final ImageIcon icono = new ImageIcon(listo2.getImage().getScaledInstance(
								lblEleccionJ2.getWidth(), lblEleccionJ2.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ2.setIcon(icono);
						generar_eleccionJ1();
						final ImageIcon icono0 = new ImageIcon(listo1.getImage().getScaledInstance(
								lblEleccionJ1.getWidth(), lblEleccionJ1.getHeight(), Image.SCALE_DEFAULT));
						lblEleccionJ1.setIcon(icono0);
					}

				}
			}
		});
		btnTijeraJ2.setForeground(Color.WHITE);
		btnTijeraJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnTijeraJ2.setBackground(new Color(255, 140, 0));
		btnTijeraJ2.setBounds(10, 402, 280, 127);
		panel_1_1.add(btnTijeraJ2);

	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "Desea realmente salir del juego?", "Salir del juego",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void generar_eleccionJ1() {
		int maquina = (int) (Math.random() * 3 + 0);

		if (maquina == 0) {
			eleccionJ1 = 1;

		} else if (maquina == 1) {
			eleccionJ1 = 2;

		} else if (maquina == 2) {
			eleccionJ1 = 3;

		}

		eleccionJ1 = maquina;

	}

	private void generar_eleccionJ2() {
		int maquina = (int) (Math.random() * 3 + 0);

		if (maquina == 0) {
			eleccionJ2 = 1;

		} else if (maquina == 1) {
			eleccionJ2 = 2;

		} else if (maquina == 2) {
			eleccionJ2 = 3;

		}

		eleccionJ2 = maquina;

	}

}
