package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton o = (JButton)arg0.getSource();
		String temp = o.getText();
		switch(temp){
			case"Ameliorer": break;
			case"Acheter": break;
			case"Attaquer": break;
			case"Rapport par mail":break;
			default: break;
		}
	}

}
