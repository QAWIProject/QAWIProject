package View;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import BusinessClass.User;
import BusinessClass.Usine;
import Model.ModelLayer;

import javax.swing.JLabel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import plug.ChargedPlugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;

public class Principal extends JFrame implements ActionListener, MouseListener{
	public User userP = new User();
	public ModelLayer mod = new ModelLayer();
	private JPanel panelBg = new JPanel();
	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Fichier");
	private JMenuItem menuItemGetPlug = new JMenuItem("Selectionner un Plugin");
	private JMenuItem menuItemloadPlug = new JMenuItem("Charger un Plugin");
	private JPanel panelContent = new JPanel();
	private CardLayout cl = new CardLayout();
	private JLabel lblHangarLink = new JLabel("Hangar");
	private JLabel lblUsineLink = new JLabel("Usine");
	private JLabel lblGalaxieLink = new JLabel("Galaxie");
	private JPanel panelUsine = new JPanel();
	private JPanel panelHangar = new JPanel();
	private JPanel panelGalaxie = new JPanel();
	private JLabel lblUsine = new JLabel("<html><h1 style='color:green;'> USINE </h1></html>");
	private JLabel lblHangar = new JLabel("<html><h1 style='color:green;'> HANGAR </h1></html>");
	private JLabel lblGalaxie = new JLabel("<html><h1 style='color:green;'> GALAXIE </h1></html>");
	private JLabel lblRefresh;
	private JLabel labelImgOr;
	private JLabel labelImgArgent;
	private JLabel labelImgPierre ;
	private JLabel labelImgNourriture ;
	private JLabel lblRessOr;
	private JLabel lblRessArgent;
	private JLabel lblRessPierre;
	private JLabel lblRessNourriture;
	private JLabel lblNiveauOr = new JLabel("");
	private JLabel lblNiveauArgent = new JLabel("");
	private JLabel lblNiveauPierre = new JLabel("");
	private JLabel lblNiveauNourriture = new JLabel("");
	private JLabel lblImgOr = new JLabel("");
	private JLabel lblImgArgent = new JLabel("");
	private JLabel lblImgPierre = new JLabel("");
	private JLabel lblImgNourriture = new JLabel("");
	private JLabel lblValueNivOr = new JLabel("");
	private JLabel lblValueNivArgent = new JLabel("");
	private JLabel lblValueNivPierre = new JLabel("");
	private JLabel lblValueNivNourriture = new JLabel("");
	private JButton btAmeOr = new JButton("Améliorer");
	private JButton btAmeArgent = new JButton("Améliorer");
	private JButton btAmePierre = new JButton("Améliorer");
	private JButton btAmeNourriture = new JButton("Améliorer");
	private ArrayList files;
	private ChargedPlugin chargedPlugin;

	/**
	 * Constructeur de la fenetre principale
	 */
	public Principal(User u){
		String txtNiv = "Niv.";
		this.userP = u;
		//Configuration Generale
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);
	
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/bg.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			panelBg.add(picLabel);
		}catch(Exception e){
			e.printStackTrace();
		}
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Configuration de la partie contenu avec le CardLayout
		panelContent.setLayout(cl);
		panelUsine.setBounds(0,0,200,200);
		panelUsine.setLayout(null);
		lblUsine.setBounds(290, 6, 72, 50);
		panelUsine.add(lblUsine);
		panelHangar.setBounds(0,0,200,200);
		panelHangar.add(lblHangar,BorderLayout.NORTH);
		panelGalaxie.setBounds(0,0,200,200);
		panelGalaxie.add(lblGalaxie,BorderLayout.NORTH);
		panelContent.add(panelUsine,"1");
		
		//Configuration Panel Usine
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/farmGold.jpg"));
			lblImgOr = new JLabel(new ImageIcon(myPicture));
			lblImgOr.setBounds(6, 94, 150, 100);
			panelUsine.add(lblImgOr);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/farmSilver.jpg"));
			lblImgArgent = new JLabel(new ImageIcon(myPicture));
			lblImgArgent.setBounds(168, 94, 150, 100);
			panelUsine.add(lblImgArgent);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/farmRock.jpg"));
			lblImgPierre = new JLabel(new ImageIcon(myPicture));
			lblImgPierre.setBounds(332, 94, 150, 100);
			panelUsine.add(lblImgPierre);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/farmEat.jpg"));
			lblImgNourriture = new JLabel(new ImageIcon(myPicture));
			lblImgNourriture.setBounds(507, 94, 150, 100);
			panelUsine.add(lblImgNourriture);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// Montrer les niveaux des usines
		List<Usine> listUsine = mod.getAllUsineByUser(userP);
		for(Usine us : listUsine){
			switch(us.getId_type_usine()){
				case "0":{
					lblNiveauOr.setText(txtNiv+us.getNiveau());
					lblNiveauOr.setBounds(69, 66, 40, 16);
					panelUsine.add(lblNiveauOr);
					break;
				}
				case "1":{
					lblNiveauArgent.setText(txtNiv+us.getNiveau());
					lblNiveauArgent.setBounds(234, 66, 40, 16);
					panelUsine.add(lblNiveauArgent);
					break;
				}
				case "2":{
					lblNiveauPierre.setText(txtNiv+us.getNiveau());
					lblNiveauPierre.setBounds(397, 66, 40, 16);
					panelUsine.add(lblNiveauPierre);
					break;
				}
				case "3":{
					lblNiveauNourriture.setText(txtNiv+us.getNiveau());
					lblNiveauNourriture.setBounds(571, 66, 40, 16);
					panelUsine.add(lblNiveauNourriture);
					break;
				}
				default:break;
			}
		}
		// Initialisation des boutons
		btAmeOr.setBounds(26, 206, 117, 29);
		btAmeOr.addActionListener(this);
		panelUsine.add(btAmeOr);
		
		btAmeArgent.setBounds(178, 206, 117, 29);
		btAmeArgent.addActionListener(this);
		panelUsine.add(btAmeArgent);
		
		btAmePierre.setBounds(342, 206, 117, 29);
		btAmePierre.addActionListener(this);
		panelUsine.add(btAmePierre);
		
		btAmeNourriture.setBounds(517, 206, 117, 29);
		btAmeNourriture.addActionListener(this);
		panelUsine.add(btAmeNourriture);
		
		lblValueNivOr.setBounds(88, 66, 16, 16);
		
		panelUsine.add(lblValueNivOr);
		lblValueNivArgent.setBounds(251, 66, 16, 16);
		
		panelUsine.add(lblValueNivArgent);
		lblValueNivPierre.setBounds(413, 66, 16, 16);
		
		panelUsine.add(lblValueNivPierre);
		lblValueNivNourriture.setBounds(588, 66, 16, 16);
		panelUsine.add(lblValueNivNourriture);
		
		// Configuration Panel Hangar
		panelContent.add(panelHangar,"2");
		panelContent.add(panelGalaxie,"3");
		panelContent.setBounds(104, 187, 690, 268);
		contentPane.add(panelContent);
		
		//Configuration du JMenu
		menuBar.setSize(800, 20);
		menuItemGetPlug.addActionListener(this);
		menu.add(menuItemGetPlug);
		menu.add(menuItemloadPlug);
		menuBar.add(menu);
		contentPane.add(menuBar);
		
		//Configuration des JLabel images
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/gold.jpg"));
			labelImgOr = new JLabel(new ImageIcon(myPicture));
			labelImgOr.setBounds(203, 94, 84, 35);
			contentPane.add(labelImgOr);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/argent.jpg"));
			labelImgArgent = new JLabel(new ImageIcon(myPicture));
			labelImgArgent.setBounds(310, 94, 84, 35);
			contentPane.add(labelImgArgent);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/rock.jpg"));
			labelImgPierre = new JLabel(new ImageIcon(myPicture));
			labelImgPierre.setBounds(415, 94, 84, 35);
			contentPane.add(labelImgPierre);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/nourriture.jpg"));
			labelImgNourriture = new JLabel(new ImageIcon(myPicture));
			labelImgNourriture.setBounds(537, 94, 84, 35);
			this.contentPane.add(labelImgNourriture);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{ 
			BufferedImage myPicture = ImageIO.read(new File("src/extras/refresh.png")); 
			lblRefresh = new JLabel(new ImageIcon(myPicture)); 
			lblRefresh.setBounds(677, 113, 61, 16); 
			lblRefresh.addMouseListener(this);
			this.contentPane.add(lblRefresh); 
		}
		catch(Exception e){ e.printStackTrace(); }

		//Configuration des JLabel textes des ressources
		JLabel lblOr = new JLabel("Or");
		lblOr.setForeground(Color.WHITE);
		lblOr.setBounds(240, 73, 23, 16);
		contentPane.add(lblOr);
		
		JLabel lblNewLabel = new JLabel("Argent");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(322, 73, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPierre = new JLabel("Pierre");
		lblPierre.setForeground(Color.WHITE);
		lblPierre.setBounds(438, 73, 42, 16);
		contentPane.add(lblPierre);
		
		JLabel lblNourriture = new JLabel("Nourriture");
		lblNourriture.setForeground(Color.WHITE);
		lblNourriture.setBounds(548, 73, 73, 16);
		contentPane.add(lblNourriture);
		
		//Configuration des ressources de la planete dynamiquement
		lblRessOr = new JLabel();
		lblRessOr.setText(Integer.toString(mod.getAllPlaneteByUser(u).getQte_or()));
		lblRessOr.setForeground(Color.RED);
		lblRessOr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessOr.setBounds(225, 141, 73, 16);
		contentPane.add(lblRessOr);
		
		lblRessArgent = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_argent()));
		lblRessArgent.setForeground(Color.RED);
		lblRessArgent.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessArgent.setBounds(331, 141, 73, 16);
		contentPane.add(lblRessArgent);
		
		lblRessPierre = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_pierre()));
		lblRessPierre.setForeground(Color.RED);
		lblRessPierre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessPierre.setBounds(438, 141, 73, 16);
		contentPane.add(lblRessPierre);

		lblRessNourriture = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_nourriture()));
		lblRessNourriture.setForeground(Color.RED);
		lblRessNourriture.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessNourriture.setBounds(560, 141, 73, 16);
		contentPane.add(lblRessNourriture);
		
		//Configuration des liens 
		lblUsineLink.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUsineLink.setForeground(Color.RED);
		lblUsineLink.setBounds(19, 128, 61, 16);
		lblUsineLink.addMouseListener(this);
		contentPane.add(lblUsineLink);
		

		lblHangarLink.setForeground(Color.RED);
		lblHangarLink.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblHangarLink.setBounds(19, 156, 73, 36);
		lblHangarLink.addMouseListener(this);
		contentPane.add(lblHangarLink);
		
		lblGalaxieLink.setForeground(Color.RED);
		lblGalaxieLink.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblGalaxieLink.setBounds(19, 200, 73, 36);
		lblGalaxieLink.addMouseListener(this);
		contentPane.add(lblGalaxieLink);
		
		//Configuration des JLabels Text de presentation
		JLabel lblBienvenu = new JLabel("Bienvenu sur Qawi Game ");
		lblBienvenu.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblBienvenu.setForeground(Color.WHITE);
		lblBienvenu.setBounds(240, 23, 226, 16);
		contentPane.add(lblBienvenu);
		
		JLabel lblNameUser = new JLabel(u.getPseudo());
		lblNameUser.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNameUser.setForeground(Color.WHITE);
		lblNameUser.setBounds(465, 23, 244, 16);
		contentPane.add(lblNameUser);
	
		// Configuration du Background en fond
		panelBg.setBounds(0, 0, 800, 493);
		contentPane.add(panelBg);
		
		// Rendre la JFrame Visible et pas de modification de la fenetre
		setVisible(true);
		setResizable(false);
	}
	public JPanel getContentPane(){
		return contentPane;
	}
	/**
	 * PARTIE CONTROLLEUR ET/OU EVENEMENTS
	 */
	@Override
	public void actionPerformed(ActionEvent arg) {
		if( arg.getSource() ==  this.menuItemGetPlug){
			JFileChooser f = new JFileChooser();
			if(f.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				try{
					this.files.add(f.getSelectedFile().getAbsolutePath());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(arg.getSource() == btAmeOr){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("0")){
					mod.ameliorerUsine(us);
				}
			}	
		}
		if(arg.getSource() == btAmeArgent){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("1")){
					mod.ameliorerUsine(us);
				}
			}	
		}
		if(arg.getSource() == btAmePierre){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("2")){
					mod.ameliorerUsine(us);
				}
			}	
		}
		if(arg.getSource() == btAmeNourriture){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("3")){
					mod.ameliorerUsine(us);
				}
			}	
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblUsineLink){
			cl.show(panelContent,"1");
		}
		if(e.getSource() == lblHangarLink){
			cl.show(panelContent,"2");
		}
		if(e.getSource() == lblGalaxieLink){
			cl.show(panelContent,"3");
		}
		if(e.getSource().equals(lblRefresh)){
			lblRessOr.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_or()));
			lblRessArgent.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_argent()));
			lblRessPierre.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_pierre()));
			lblRessNourriture.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_nourriture()));
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == lblUsineLink){
			lblUsineLink.setForeground(Color.WHITE);
			this.setCursor(HAND_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblHangarLink){
			lblHangarLink.setForeground(Color.WHITE);
			this.setCursor(HAND_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblGalaxieLink){
			lblGalaxieLink.setForeground(Color.WHITE);
			this.setCursor(HAND_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblRefresh){
			this.setCursor(HAND_CURSOR);
			this.repaint();
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == lblHangarLink){
			lblHangarLink.setForeground(Color.RED);
			this.setCursor(DEFAULT_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblUsineLink){
			lblUsineLink.setForeground(Color.RED);
			this.setCursor(DEFAULT_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblGalaxieLink){
			lblGalaxieLink.setForeground(Color.RED);
			this.setCursor(DEFAULT_CURSOR);
			this.repaint();
		}
		if(e.getSource() == lblRefresh){
			this.setCursor(DEFAULT_CURSOR);
			this.repaint();
		}
		
	}
}	

