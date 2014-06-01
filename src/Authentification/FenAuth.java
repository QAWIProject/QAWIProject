package Authentification;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FenAuth extends JFrame{
	private JTextField mailField = new JTextField();
	private JPanel pan = new JPanel();
	private JLabel title = new JLabel("<html><center><h3 style='color:red;'>Bienvenue <br />Veuillez vous authentifier : <br /></h3></center></html>");
	private JLabel txtMail = new JLabel("Adresse Mail :");
	private JLabel txtPass = new JLabel("Password :");
	private JButton submit = new JButton("Connexion");
	private JPasswordField passField = new JPasswordField();
	private JPasswordField passFieldBis = new JPasswordField();
	public FenAuth(){
		this.initComponent();
		setLocationRelativeTo(null);
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.add(title);
		pan.add(txtMail);
		pan.add(mailField);
		pan.add(txtPass);
		pan.add(passField);
		pan.add(submit);
		getContentPane().add(pan);
	}
	public void initComponent(){
		mailField.setSize(50, 30);
		passField.setSize(50, 30);
	}
}
