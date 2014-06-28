package View;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BusinessClass.User;
import Model.ModelLayer;
import javax.swing.JLabel;
import plug.ChargedPlugin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.CardLayout;

public class Principal extends JFrame implements ActionListener, MouseListener{
	public User u = new User();
	private ModelLayer mod = new ModelLayer();
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
	private JLabel lblUsine = new JLabel("CARDLAYOUT USINE");
	private JLabel lblHangar = new JLabel("CARDLAYOUT HANGAR");
	private JLabel lblGalaxie = new JLabel("CARDLAYOUT GALAXIE");
	private ArrayList files;
	private ChargedPlugin chargedPlugin;
	/**
	 * Constructeur de la fenetre principale
	 */
	public Principal(User u) {
		
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
		panelContent.add(panelUsine.add(lblUsine),"1");
		panelContent.add(panelHangar.add(lblHangar),"2");
		panelContent.add(panelHangar.add(lblGalaxie),"3");
		panelContent.setBounds(203, 187, 591, 268);
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
			JLabel lblImgOr = new JLabel(new ImageIcon(myPicture));
			lblImgOr.setBounds(203, 94, 84, 35);
			contentPane.add(lblImgOr);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/argent.jpg"));
			JLabel labelImgArgent = new JLabel(new ImageIcon(myPicture));
			labelImgArgent.setBounds(310, 94, 84, 35);
			contentPane.add(labelImgArgent);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/rock.jpg"));
			JLabel labelImgPierre = new JLabel(new ImageIcon(myPicture));
			labelImgPierre.setBounds(415, 94, 84, 35);
			contentPane.add(labelImgPierre);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/nourriture.jpg"));
			JLabel labelImgNourriture = new JLabel(new ImageIcon(myPicture));
			labelImgNourriture.setBounds(537, 94, 84, 35);
			this.contentPane.add(labelImgNourriture);
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
		JLabel lblRessOr = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_or()));
		lblRessOr.setForeground(Color.RED);
		lblRessOr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessOr.setBounds(225, 141, 73, 16);
		contentPane.add(lblRessOr);
		
		JLabel lblRessArgent = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_argent()));
		lblRessArgent.setForeground(Color.RED);
		lblRessArgent.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessArgent.setBounds(331, 141, 73, 16);
		contentPane.add(lblRessArgent);
		
		JLabel lblRessPierre = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_pierre()));
		lblRessPierre.setForeground(Color.RED);
		lblRessPierre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessPierre.setBounds(438, 141, 73, 16);
		contentPane.add(lblRessPierre);

		JLabel lblRessNourriture = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_nourriture()));
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
		else {
			
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblUsineLink){
			cl.show(panelContent,"1");
			this.invalidate();
			this.validate();
			this.repaint();
		}
		if(e.getSource() == lblHangarLink){
			cl.show(panelContent,"2");
			this.repaint();
		}
		if(e.getSource() == lblGalaxieLink){
			cl.show(panelContent,"3");
			this.repaint();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {

		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == lblUsineLink){
			lblUsineLink.setForeground(Color.WHITE);
			this.repaint();
		}
		if(e.getSource() == lblHangarLink){
			lblHangarLink.setForeground(Color.WHITE);
			this.repaint();
		}
		if(e.getSource() == lblGalaxieLink){
			lblGalaxieLink.setForeground(Color.WHITE);
			this.repaint();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == lblHangarLink){
			lblHangarLink.setForeground(Color.RED);
			this.repaint();
		}
		if(e.getSource() == lblUsineLink){
			lblUsineLink.setForeground(Color.RED);
			this.repaint();
		}
		if(e.getSource() == lblGalaxieLink){
			lblGalaxieLink.setForeground(Color.RED);
			this.repaint();
		}
		
	}
}	

