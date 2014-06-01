package Authentification;

import javax.swing.JFrame;

public class StartAuth {

	public static void main(String[] args) {
		FenAuth fen1 = new FenAuth();
		fen1.setBounds(0, 0, 400, 400);
		fen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen1.setVisible(true);
		fen1.setResizable(false);
	}

}
