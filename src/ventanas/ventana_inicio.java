package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventana_inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNombre1;
	public JTextField txtNombre2;
	public JButton btnListoJ1;
	public JButton btnListoJ2;
	public JButton btnEditarJ1;
	public JButton btnEditarJ2;
	public JLabel lblJ1;
	public JLabel lblJ2;
	public JButton btnJugar;

	public JLabel btnAcercaDe;
	public JToggleButton btnSonido;

	public int estado_j1 = 0;
	public int estado_j2 = 0;

	public String nombre1;
	public String nombre2;

	public int tipo_partida = 0;
	private JLabel lblTitulo;

	Clip clip;
	AudioInputStream inputStream;

	private int estado_sonido = 1;

	public ventana_inicio() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 344);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana_inicio.class.getResource("/recursos/ppot.png")));
		final ImageIcon ss = new ImageIcon(getClass().getResource("/recursos/sin_sonido.png"));
		final ImageIcon s = new ImageIcon(getClass().getResource("/recursos/sonido.png"));
		final ImageIcon ppot = new ImageIcon(getClass().getResource("/recursos/ppot.png"));
		final ImageIcon titulo = new ImageIcon(getClass().getResource("/recursos/titulo.gif"));
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBounds(10, 78, 744, 216);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 280, 191);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblJugador1_1_1 = new JLabel("Jugador 1");
		lblJugador1_1_1.setForeground(new Color(46, 139, 87));
		lblJugador1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJugador1_1_1.setBounds(10, 11, 260, 20);
		panel_3.add(lblJugador1_1_1);

		btnListoJ1 = new JButton("Listo");
		btnListoJ1.setForeground(Color.WHITE);
		btnListoJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnListoJ1.setBackground(new Color(0, 128, 0));
		btnListoJ1.setBounds(10, 122, 260, 58);
		panel_3.add(btnListoJ1);
		btnListoJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtNombre1.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre del jugador 1 esta vacío.");
				} else {
					txtNombre1.setEditable(false);
					btnListoJ1.setVisible(false);
					btnEditarJ1.setVisible(true);

					lblJ1.setText(txtNombre1.getText().toString());
					estado_j1 = 1;
				}

			}
		});

		txtNombre1 = new JTextField();
		txtNombre1.setForeground(Color.BLACK);
		txtNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		txtNombre1.setBounds(10, 42, 260, 69);
		panel_3.add(txtNombre1);
		txtNombre1.setColumns(10);
		txtNombre1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {

				if (txtNombre1.getText().length() == 10) {
					ke.consume();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		btnEditarJ1 = new JButton("Editar");
		btnEditarJ1.setForeground(Color.BLACK);
		btnEditarJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnEditarJ1.setBackground(Color.LIGHT_GRAY);
		btnEditarJ1.setBounds(10, 122, 260, 58);
		btnEditarJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre1.requestFocus();
				txtNombre1.setEditable(true);
				btnEditarJ1.setVisible(false);
				btnListoJ1.setVisible(true);
			}
		});

		panel_3.add(btnEditarJ1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1.setBounds(451, 11, 280, 191);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblJugador1_1_1_1 = new JLabel("Jugador 2");
		lblJugador1_1_1_1.setForeground(new Color(255, 165, 0));
		lblJugador1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador1_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJugador1_1_1_1.setBounds(10, 11, 260, 20);
		panel_3_1.add(lblJugador1_1_1_1);

		txtNombre2 = new JTextField();
		txtNombre2.setForeground(Color.BLACK);
		txtNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		txtNombre2.setColumns(10);
		txtNombre2.setBounds(10, 42, 260, 69);
		panel_3_1.add(txtNombre2);

		btnListoJ2 = new JButton("Listo");
		btnListoJ2.setForeground(Color.WHITE);
		btnListoJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnListoJ2.setBackground(new Color(255, 140, 0));
		btnListoJ2.setBounds(10, 122, 260, 58);
		panel_3_1.add(btnListoJ2);
		btnListoJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtNombre2.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre del jugador 1 esta vacío.");
				} else {
					txtNombre2.setEditable(false);
					btnListoJ2.setVisible(false);
					btnEditarJ2.setVisible(true);

					lblJ2.setText(txtNombre2.getText().toString());
					estado_j2 = 1;
				}

			}
		});

		btnEditarJ2 = new JButton("Editar");
		btnEditarJ2.setForeground(Color.BLACK);
		btnEditarJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnEditarJ2.setBackground(Color.LIGHT_GRAY);
		btnEditarJ2.setBounds(10, 122, 260, 58);
		btnEditarJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre2.requestFocus();
				txtNombre2.setEditable(true);
				btnEditarJ2.setVisible(false);
				btnListoJ2.setVisible(true);
			}
		});

		panel_3_1.add(btnEditarJ2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(300, 11, 141, 113);
		panel_1.add(panel_2_1);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setForeground(new Color(0, 128, 0));
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJ1.setBounds(10, 11, 121, 20);
		panel_2_1.add(lblJ1);

		JLabel lblNombre1_1 = new JLabel("VRS");
		lblNombre1_1.setForeground(Color.RED);
		lblNombre1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNombre1_1.setBounds(10, 42, 121, 29);
		panel_2_1.add(lblNombre1_1);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJ2.setForeground(new Color(255, 165, 0));
		lblJ2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblJ2.setBounds(10, 82, 121, 20);
		panel_2_1.add(lblJ2);

		btnJugar = new JButton("¡A Jugar!");
		btnJugar.setBounds(300, 135, 141, 67);
		panel_1.add(btnJugar);
		btnJugar.setForeground(Color.WHITE);
		btnJugar.setBackground(new Color(0, 102, 255));
		btnJugar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(81, 11, 520, 56);
		contentPane.add(lblTitulo);
		final ImageIcon icono = new ImageIcon(
				titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_DEFAULT));
		lblTitulo.setIcon(icono);

		btnAcercaDe = new JLabel("");
		btnAcercaDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana_acerca_de acercade = new ventana_acerca_de();
				acercade.setLocationRelativeTo(null);
				acercade.setVisible(true);
				dispose();
			}
		});
		btnAcercaDe.setForeground(Color.WHITE);
		btnAcercaDe.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnAcercaDe.setBackground(new Color(0, 102, 255));
		btnAcercaDe.setBounds(10, 11, 61, 58);
		contentPane.add(btnAcercaDe);
		final ImageIcon icono1 = new ImageIcon(ppot.getImage().getScaledInstance(btnAcercaDe.getWidth(),
				btnAcercaDe.getHeight(), Image.SCALE_DEFAULT));
		btnAcercaDe.setIcon(icono1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(611, 11, 143, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		btnSonido = new JToggleButton("Sonido");
		btnSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSonido.getText().toString().equals("Sonido")) {
					parar();
					estado_sonido=0;
					btnSonido.setText("Sin Sonido");
					btnSonido.setBackground(Color.red);
				}else {
					if (btnSonido.getText().toString().equals("Sin Sonido")) {
						estado_sonido=1;
						reproducir("C:\\ppot_music\\ppot.wav");
						btnSonido.setText("Sonido");
						btnSonido.setBackground(new Color(0, 102, 255));
					}else {
						
					}
				}
			}
		});
		btnSonido.setBounds(10, 11, 123, 34);
		panel.add(btnSonido);
		btnSonido.setForeground(Color.WHITE);
		btnSonido.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSonido.setBackground(new Color(0, 102, 255));

		btnJugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (estado_j1 == 0 && estado_j2 == 0) {
					JOptionPane.showMessageDialog(null,
							"¡Atención! No podemos iniciar el juego, Los nombres de los jugadores estan vacíos / o asegúrate de estar Listo.");
				} else {
					if (estado_j1 == 1 && estado_j2 == 1) {

						ventana_ppot ppot = new ventana_ppot();
						ppot.setLocationRelativeTo(null);
						ppot.setVisible(true);
						nombre1 = txtNombre1.getText().toString();
						ppot.lblJugador1.setText(nombre1);
						ppot.lblJ1.setText(nombre1);
						nombre2 = txtNombre2.getText().toString();
						ppot.lblJugador2.setText(nombre2);
						ppot.lblJ2.setText(nombre2);

						tipo_partida = 0;
						ppot.tipo_partida = tipo_partida;

						dispose();

					} else {
						if (estado_j1 == 1 && estado_j2 == 0) {
							if (JOptionPane.showConfirmDialog(rootPane,
									"¿Desea jugar con la computadora? -- Serás el Jugador 1 --", "¡Atención!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								ventana_ppot ppot = new ventana_ppot();
								ppot.setLocationRelativeTo(null);
								ppot.setVisible(true);
								nombre1 = txtNombre1.getText().toString();
								ppot.lblJugador1.setText(nombre1);
								ppot.lblJ1.setText(nombre1);
								ppot.lblJugador2.setText("Computadora");
								ppot.lblJ2.setText("Computadora");

								ppot.btnPiedraJ2.setEnabled(false);
								ppot.btnPapelJ2.setEnabled(false);
								ppot.btnTijeraJ2.setEnabled(false);

								tipo_partida = 1;
								ppot.tipo_partida = tipo_partida;

								dispose();

							}
						} else {
							if (estado_j1 == 0 && estado_j2 == 1) {
								if (JOptionPane.showConfirmDialog(rootPane,
										"¿Desea jugar con la computadora? -- Serás el Jugador 2 --", "¡Atención!",
										JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									ventana_ppot ppot = new ventana_ppot();
									ppot.setLocationRelativeTo(null);
									ppot.setVisible(true);
									nombre2 = txtNombre2.getText().toString();
									ppot.lblJugador2.setText(nombre2);
									ppot.lblJ2.setText(nombre2);
									ppot.lblJugador1.setText("Computadora");
									ppot.lblJ1.setText("Computadora");

									ppot.btnPiedraJ1.setEnabled(false);
									ppot.btnPapelJ1.setEnabled(false);
									ppot.btnTijeraJ1.setEnabled(false);

									tipo_partida = 2;
									ppot.tipo_partida = tipo_partida;

									dispose();

								}
							}
						}
					}
				}

			}
		});
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(rootPane, "Desea realmente salir del juego?", "Salir del juego",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public synchronized void reproducir(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					clip = AudioSystem.getClip();
					inputStream = AudioSystem.getAudioInputStream(new File(url));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					if (e.getMessage() != null) {
						JOptionPane.showMessageDialog(null, "Archivo no Compatible", "Fatal Error",
								JOptionPane.ERROR_MESSAGE);
						System.err.println(e.getMessage());
					} else {
						JOptionPane.showMessageDialog(null, "No hay Archivo seleccionado", "Fatal Error",
								JOptionPane.ERROR_MESSAGE);
						System.err.println(e.getMessage());
					}
				}
			}
		}).start();
	}

	public void parar() {
		try {
			clip.stop();
			clip.close();
		} catch (Exception e) {
		}
	}
}
