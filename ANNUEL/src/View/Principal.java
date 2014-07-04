package View;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import BusinessClass.Planete;
import BusinessClass.User;
import BusinessClass.Usine;
import BusinessClass.Vaisseau;
import Model.ModelLayer;
import javax.swing.JLabel;
import coolplugin.CoolPlugin;
import plug.ChargedPlugin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.CardLayout;
import javax.swing.JButton;

public class Principal extends JFrame implements ActionListener, MouseListener,KeyListener{
	public User userP = new User();
	public ModelLayer mod;
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
	private JLabel lblUsine = new JLabel("<html><h1 style='color: black;'> USINE </h1></html>");
	private JLabel lblGalaxie = new JLabel("<html><h1 style='color: black;'> GALAXIE </h1></html>");
	private JLabel lblCoutRessOr,lblCoutRessArgent,lblCoutRessPierre,lblCoutRessNourriture;
	private JLabel lblRefresh;
	private JLabel labelImg;
	private JLabel lblRessOr,lblRessArgent,lblRessPierre,lblRessNourriture;
	private JLabel lblNiveauOr = new JLabel("");
	private JLabel lblNiveauArgent = new JLabel("");
	private JLabel lblNiveauPierre = new JLabel("");
	private JLabel lblNiveauNourriture = new JLabel("");
	private JLabel lblValue,lblTxtRess;
	private JButton btCalculer = new JButton("Calculer");
	private JButton btAmeOr,btAmeArg,btAmePier,btAmeNou;
	private ArrayList files;
	private ChargedPlugin chargedPlugin;
	//Configuration Hangar
	private String names[] = {"Vaisseau Leger", "Vaisseau Lourd", "Intercepteur", "Bombardier", "Qawi"};
	private String namesTxt[] ={"0","1","2","3","4"};
	private Map<String, String> details = new HashMap<>();
	private List<Vaisseau> listVsType = new ArrayList<Vaisseau>();
	private List<JTextField> listJtext = new ArrayList<JTextField>();
	private JButton btAcheter = new JButton("Acheter");

	/**
	 * Constructeur de la fenetre principale
	 */
	public Principal(User u, CoolPlugin plu){
		mod = new ModelLayer(plu);
		
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
		panelHangar.setLayout(null);
		
		panelGalaxie.setBounds(0,0,200,200);
		panelGalaxie.add(lblGalaxie,BorderLayout.NORTH);
		panelContent.add(panelUsine,"1");
		
		
		//Configuration Panel Hangar
		JTextField txt;
		JLabel lbl;
		JLabel lblType;
		BufferedImage pic;
		String[] lImgVaisseau= {"vaisseaux/vl.jpg","vaisseaux/vlo.jpg","vaisseaux/int.jpg","vaisseaux/bomb.jpg","vaisseaux/qawi.jpg"};
		int y=0;
		int positionX = 50;
		int positionY = 20;
		btAcheter.addMouseListener(this);
		btAcheter.addActionListener(this);
		btAcheter.setBounds(250,220,100,30);
		while(y<5){
			try{
				pic = ImageIO.read(new File("src/extras/"+lImgVaisseau[y]));
				lbl = new JLabel(new ImageIcon(pic));
				lblType = new JLabel();
				lbl.setName(names[y]);
				lblType.setText(lbl.getName());
				lblType.setBounds(positionX+8,positionY-18,120,20);
				// Precise le nombre de caracteres
				txt = new JFormattedTextField(new MaskFormatter("*"));
				txt.setName("txt"+namesTxt[y]);
				txt.setText("0");
				txt.addKeyListener(this);
				txt.addMouseListener(this);
				txt.addActionListener(this);
				lbl.setBounds(positionX,positionY,100,100);
				txt.setBounds(positionX+41,positionY+110,22,20);
				listJtext.add(txt);
				panelHangar.add(btAcheter);
				panelHangar.add(lblType);
				panelHangar.add(lbl);
				panelHangar.add(txt);
			}catch(Exception e){
			e.printStackTrace();	
			}
			positionX += 115;
			y++;
		}
		
		//Configuration Label Cout Total
		String[] ress = {"Gold","Silver","Rock","Eat"};
		int o = 0;
		int posXCout = 40;
		while(o<4){
			JLabel lblCout = new JLabel();
			lblCout.setText("Cout "+ress[o]+" = ");
			lblCout.setBounds(posXCout,170,150,20);
			panelHangar.add(lblCout);
			posXCout += 150;
			o++;
		}
		//Configuration Récupération Cout Vaisseaux
		List<Vaisseau> listVaiss = new ArrayList<Vaisseau>();
		
		//Configuration Panel Usine
		int z = 0;
		JLabel lblImg ;
		int posX = 6;
		while(z < 4){
			try{
				BufferedImage myPicture = ImageIO.read(new File("src/extras/farm"+ress[z]+".jpg"));
				lblImg = new JLabel(new ImageIcon(myPicture));
				lblImg.setName("lblImg"+ress[z]);
				lblImg.setBounds(posX, 94, 150, 100);
				panelUsine.add(lblImg);
			}catch(Exception e){
				e.printStackTrace();
			}
			posX += 160;
			z++;
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
					lblNiveauNourriture.setBounds(565, 66, 40, 16);
					panelUsine.add(lblNiveauNourriture);
					break;
				}
				default:break;
			}
		}
		// Initialisation des boutons
	
			btAmeOr = new JButton("Améliorer");
			btAmeOr.setBounds(27, 206, 116, 29);
			btAmeOr.addActionListener(this);
			panelUsine.add(btAmeOr);
			
			btAmeArg = new JButton("Améliorer");
			btAmeArg.setBounds(179, 206, 116, 29);
			btAmeArg.addActionListener(this);
			panelUsine.add(btAmeArg);
			
			btAmePier = new JButton("Améliorer");
			btAmePier.setBounds(342, 206, 116, 29);
			btAmePier.addActionListener(this);
			panelUsine.add(btAmePier);
			
			btAmeNou = new JButton("Améliorer");
			btAmeNou.setBounds(503, 206, 116, 29);
			btAmeNou.addActionListener(this);
			panelUsine.add(btAmeNou);

		// Configuration JLabel Niveau
		int a = 0;
		int posXValue = 88;
		while(a<0){
			lblValue.setName("lblValue"+ress[a]);
			lblValue.setBounds(posXValue, 66, 16, 16);
			panelUsine.add(lblValue);
			posXValue += 150;
			a++;
		}
		
		// Configuration Panels
		panelContent.add(panelHangar,"2");
		panelContent.add(plu.getPanelGalaxie(),"3");
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
		int r = 0;
		int posXLblImg = 203;
		while(r<4){
			try{
				BufferedImage myPicture = ImageIO.read(new File("src/extras/"+ress[r]+".jpg"));
				labelImg = new JLabel(new ImageIcon(myPicture));
				labelImg.setName("labelImg"+ress[r]);
				labelImg.setBounds(posXLblImg, 94, 84, 35);
				contentPane.add(labelImg);
			}catch(Exception e){
				e.printStackTrace();
			}
			posXLblImg += 125;
			r++;
		}
		//Configuration Bouton Refresh
		try{ 
			BufferedImage myPicture = ImageIO.read(new File("src/extras/refresh.png")); 
			lblRefresh = new JLabel(new ImageIcon(myPicture)); 
			lblRefresh.setBounds(677, 113, 61, 16); 
			lblRefresh.addMouseListener(this);
			this.contentPane.add(lblRefresh); 
		}
		catch(Exception e){ e.printStackTrace(); }

		//Configuration des JLabel textes des ressources
		int h = 0;
		int posXTxtRess = 240;
		while(h < 4){
			lblTxtRess = new JLabel(ress[h]);
			lblTxtRess.setForeground(Color.WHITE);
			lblTxtRess.setBounds(posXTxtRess, 73, 70, 16);
			contentPane.add(lblTxtRess);
			posXTxtRess += 120;
			h++;
		}
		//Configuration Valeur des couts de ressources Panel Hangar
		lblCoutRessOr = new JLabel();
		lblCoutRessOr.setText("0");
		lblCoutRessOr.setForeground(Color.RED);
		lblCoutRessOr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCoutRessOr.setBounds(130, 172, 100, 16);
		panelHangar.add(lblCoutRessOr);
		
		lblCoutRessArgent = new JLabel();
		lblCoutRessArgent.setText("0");
		lblCoutRessArgent.setForeground(Color.RED);
		lblCoutRessArgent.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCoutRessArgent.setBounds(285,172, 100, 16);
		panelHangar.add(lblCoutRessArgent);
		
		lblCoutRessPierre = new JLabel();
		lblCoutRessPierre.setText("0");
		lblCoutRessPierre.setForeground(Color.RED);
		lblCoutRessPierre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCoutRessPierre.setBounds(435, 172, 100, 16);
		panelHangar.add(lblCoutRessPierre);
		
		lblCoutRessNourriture = new JLabel();
		lblCoutRessNourriture.setText("0");
		lblCoutRessNourriture.setForeground(Color.RED);
		lblCoutRessNourriture.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCoutRessNourriture.setBounds(575, 172, 100, 16);
		panelHangar.add(lblCoutRessNourriture);
		
		// Calculer
		btCalculer.addActionListener(this);
		btCalculer.setBounds(500,220,100,30);
		panelHangar.add(btCalculer);
		
		//Configuration des ressources de la planete dynamiquement
		lblRessOr = new JLabel();
		lblRessOr.setText(Integer.toString(mod.getAllPlaneteByUser(u).getQte_or()));
		lblRessOr.setForeground(Color.RED);
		lblRessOr.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessOr.setBounds(225, 141, 100, 16);
		contentPane.add(lblRessOr);
		
		lblRessArgent = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_argent()));
		lblRessArgent.setForeground(Color.RED);
		lblRessArgent.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessArgent.setBounds(360, 141, 100, 16);
		contentPane.add(lblRessArgent);
		
		lblRessPierre = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_pierre()));
		lblRessPierre.setForeground(Color.RED);
		lblRessPierre.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessPierre.setBounds(480, 141, 100, 16);
		contentPane.add(lblRessPierre);

		lblRessNourriture = new JLabel(Integer.toString(mod.getAllPlaneteByUser(u).getQte_nourriture()));
		lblRessNourriture.setForeground(Color.RED);
		lblRessNourriture.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblRessNourriture.setBounds(590, 141, 100, 16);
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
		if(arg.getSource() == btAmeArg){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("1")){
					mod.ameliorerUsine(us);
				}
			}
}
		if(arg.getSource() == btAmePier){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("2")){
					mod.ameliorerUsine(us);
				}
			}
}
		if(arg.getSource() == btAmeNou){
			List<Usine> listUsine = mod.getAllUsineByUser(userP);
			for(Usine us : listUsine){
				if(us.getId_type_usine().equals("3")){
					mod.ameliorerUsine(us);
				}
			}
		}
		if(arg.getSource() == btCalculer){
			int[] coutTotalType0 = {0,0,0,0};
			int[] coutTotalType1 = {0,0,0,0};
			int[] coutTotalType2 = {0,0,0,0};
			int[] coutTotalType3 = {0,0,0,0};
			int[] coutTotalType4 = {0,0,0,0};
			for(JTextField tf : listJtext){
				if(tf.getText().equals("0")){
					tf.setText("0");
				}else{
					int cpt = Integer.parseInt(tf.getText());
					if(tf.getName().equals("txt0")){
						while(cpt > 0){
							Vaisseau unVaisseau = new Vaisseau();
							unVaisseau.setTypeVaisseau("0");
							listVsType.add(unVaisseau);
							cpt--;
						}
						coutTotalType0 = mod.getTotalcoutVaisseaux(listVsType);
					}
					if(tf.getName().equals("txt1")){
						while(cpt > 0){
							Vaisseau unVaisseau = new Vaisseau();
							unVaisseau.setTypeVaisseau("1");
							listVsType.add(unVaisseau);
							cpt--;
						}
						coutTotalType1 = mod.getTotalcoutVaisseaux(listVsType);
					}
					if(tf.getName().equals("txt2")){
						while(cpt > 0){
							Vaisseau unVaisseau = new Vaisseau();
							unVaisseau.setTypeVaisseau("2");
							listVsType.add(unVaisseau);
							cpt--;
						}
						coutTotalType2 = mod.getTotalcoutVaisseaux(listVsType);
					}
					if(tf.getName().equals("txt3")){
						while(cpt > 0){
							Vaisseau unVaisseau = new Vaisseau();
							unVaisseau.setTypeVaisseau("3");
							listVsType.add(unVaisseau);
							cpt--;
						}
						coutTotalType3 = mod.getTotalcoutVaisseaux(listVsType);
					}
					if(tf.getName().equals("txt4")){
						while(cpt > 0){
							Vaisseau unVaisseau = new Vaisseau();
							unVaisseau.setTypeVaisseau("4");
							listVsType.add(unVaisseau);
							cpt--;
						}
						coutTotalType4 = mod.getTotalcoutVaisseaux(listVsType);
					}
				}
			}
			int[] tabTotalRess = additionner(coutTotalType0,coutTotalType1,coutTotalType2,coutTotalType3,coutTotalType4);
			lblCoutRessOr.setText(Integer.toString(tabTotalRess[0]));
			lblCoutRessArgent.setText(Integer.toString(tabTotalRess[1]));
			lblCoutRessPierre.setText(Integer.toString(tabTotalRess[2]));
			lblCoutRessNourriture.setText(Integer.toString(tabTotalRess[3]));
		}
	}
	public int[] additionner(int[] type0,int[] type1, int[] type2,int[] type3,int[] type4){
		int cpt = 0;
		int[] total= {0,0,0,0};
		while(cpt < 4){
			total[cpt] += type0[cpt] + type1[cpt] + type2[cpt] + type3[cpt]+ type4[cpt];
			cpt++;
		}
		return total;
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() == lblUsineLink){
			cl.show(panelContent,"1");
		}
		if(me.getSource() == lblHangarLink){
			cl.show(panelContent,"2");
		}
		if(me.getSource() == lblGalaxieLink){
			cl.show(panelContent,"3");
		}
		if(me.getSource().equals(lblRefresh)){
			lblRessOr.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_or()));
			lblRessArgent.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_argent()));
			lblRessPierre.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_pierre()));
			lblRessNourriture.setText(Integer.toString(mod.getAllPlaneteByUser(userP).getQte_nourriture()));
		}
		int cpt = 0;
		while(cpt<5){
			if(me.getSource() == btAcheter){
				//System.out.println("Valeur Envoyee : "+listJtext.get(cpt).getText());
			}
			if(me.getSource() == listJtext.get(cpt)){
				listJtext.get(cpt).setText("0");
			}
			cpt++;
		}
		if(me.getSource() == btAcheter){
			if(Integer.parseInt(lblRessOr.getText()) >= Integer.parseInt(lblCoutRessOr.getText())){
				if(Integer.parseInt(lblRessArgent.getText()) >= Integer.parseInt(lblCoutRessArgent.getText())){
					if(Integer.parseInt(lblRessPierre.getText()) >= Integer.parseInt(lblCoutRessPierre.getText())){
						if(Integer.parseInt(lblRessNourriture.getText()) >= Integer.parseInt(lblCoutRessNourriture.getText())){
							System.out.println("Tu peux acheter");
							Planete pla = new Planete();
							int or = Integer.parseInt(lblRessOr.getText()) - Integer.parseInt(lblCoutRessOr.getText());
							int argent = Integer.parseInt(lblRessArgent.getText()) - Integer.parseInt(lblCoutRessArgent.getText());
							int pierre = Integer.parseInt(lblRessPierre.getText()) - Integer.parseInt(lblCoutRessPierre.getText());
							int nourriture = Integer.parseInt(lblRessNourriture.getText()) - Integer.parseInt(lblCoutRessNourriture.getText());
							int[] tabCoutRess = {or,argent,pierre,nourriture};
							System.out.println(userP.getIdPlanete());
							pla.setId_planete(userP.getIdPlanete());
							mod.appliquerAchat(pla, tabCoutRess);
							mod.insertVaisseau(userP, listVsType);
						}
					}
				}
			}
							
					
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
		//config Hang
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		if(!verifyOneField(ke.getKeyChar())){
			int cpt = 0;
			while(cpt<5){
				if(ke.getSource() == listJtext.get(cpt)){
					listJtext.get(cpt).setText("0");
				}
				cpt++;
			}
		}else{
			System.out.println("OK");
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	/**
	 * Verifier le champ numérique
	 */
	public boolean verifyOneField(char cara){
		boolean flag=true;
		if(cara >= '0' && cara <= '9'){
		}else{
			flag = false;
		}
		return flag;
	}
}	

