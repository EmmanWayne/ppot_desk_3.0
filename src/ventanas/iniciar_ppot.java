package ventanas;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class iniciar_ppot extends JFrame {

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		try {
			ventana_inicio ppot = new ventana_inicio();
			ppot.setLocationRelativeTo(null);
			ppot.setVisible(true);
			ppot.btnEditarJ1.setVisible(false);
			ppot.btnEditarJ2.setVisible(false);;
			ppot.reproducir("C:\\ppot_music\\ppot.wav");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
