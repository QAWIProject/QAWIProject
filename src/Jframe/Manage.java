package Jframe;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manage extends Applet implements ActionListener{
	JLabel lblGestionUsine = new JLabel("<html><b style='border-radius:10px'>Gestion des usines</b></html>");
	JButton btUpgradeUsineOr = new JButton("<html><b style='color:#375D81'>Usine Or<br/>Am四iorer</b></html>");
	JButton btUpgradeUsineMetal = new JButton("<html><b style='color:#375D81'>Usine Metal<br/>Am四iorer</b></html");
	JButton btUpgradeUsineArgent = new JButton("<html><b style='color:#375D81'>Usine Argent<br/>Am四iorer</b></html");
	JButton btUpgradeUsineNourriture = new JButton("<html><b style='color:#375D81'>Usine Nourriture<br/>Am四iorer</b></html");
	GridLayout gd = new GridLayout(1,4);
	JPanel panHaut = new JPanel();
	JPanel panBas = new JPanel();
	JPanel panCentre = new JPanel();
	Boolean flag = false;
	//String heureLocale = Integer.toString(rightNow.get(Calendar.HOUR_OF_DAY)) + "h" + Integer.toString(rightNow.get(Calendar.MINUTE));
	public void init(){
		setSize(600,300);
		setBackground(new Color(70,130,180));
		setBackgroundButton();
		setPan();
	}
	public JButton setBackgroundImage(JButton button){
			button.setBackground(Color.BLACK);
			button.addActionListener(this);
			button.setOpaque(true);
		return button;
	}
	public void setPan(){
		//MET LE GRIDLAYOUT DANS LE JPANEL DU CENTRE
		panCentre.setLayout(gd);
		//AJOUT DU TITRE DANS LE JPANEL DU HAUT
		panHaut.add(lblGestionUsine);
		//AJOUT DES BOUTONS AU JPANEL DU CENTRE
		panCentre.add(btUpgradeUsineOr);
		panCentre.add(btUpgradeUsineMetal);
		panCentre.add(btUpgradeUsineArgent);
		panCentre.add(btUpgradeUsineNourriture);
		//FIXE LES POSITIONS D'AFFICHAGE DANS LA JFRAME
		add(panHaut,BorderLayout.NORTH);
		add(panCentre,BorderLayout.CENTER);
	}
	public void setBackgroundButton(){
		btUpgradeUsineOr = setBackgroundImage(btUpgradeUsineOr);
		btUpgradeUsineMetal = setBackgroundImage(btUpgradeUsineMetal);
		btUpgradeUsineArgent = setBackgroundImage(btUpgradeUsineArgent);
		btUpgradeUsineNourriture = setBackgroundImage(btUpgradeUsineNourriture);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getSource());
		if(event.getSource() ==	btUpgradeUsineOr){
			if(flag == false){
				//panBas.add(affEvent);
				add(panBas,BorderLayout.SOUTH);
				invalidate();
				validate();
				setVisible(true);
				flag = true;
			}
		}
		
	}
}
