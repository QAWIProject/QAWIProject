package View;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import coolplugin.CoolPlugin;
import BusinessClass.User;
import Model.ModelLayer;

public class Connexion extends JFrame {
	//private static final long serialVersionUID = 1L;
	private JPasswordField txtFieldPassPlayer;
	private JTextField txtFieldNamePlayer;
	private final Action action = new ConnexionEvent();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 320);
		getContentPane().setLayout(null);
		try{
			BufferedImage logo = ImageIO.read(new File("src/extras/logo.png"));
			JLabel lblNewLabel = new JLabel(new ImageIcon(logo));
			lblNewLabel.setBounds(114, 48, 87, 79);
			getContentPane().add(lblNewLabel);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		txtFieldPassPlayer = new JPasswordField();
		txtFieldPassPlayer.setBounds(140, 177, 114, 19);
		getContentPane().add(txtFieldPassPlayer);
		txtFieldPassPlayer.setColumns(10);
		
		JLabel lblPassword = new JLabel("Mot de Passe");
		lblPassword.setForeground(UIManager.getColor("MenuBar.highlight"));
		lblPassword.setBounds(36, 179, 101, 15);
		getContentPane().add(lblPassword);
		
		JLabel lblNomDuJoueur = new JLabel("Nom du joueur");
		lblNomDuJoueur.setForeground(UIManager.getColor("MenuBar.highlight"));
		lblNomDuJoueur.setBounds(36, 139, 101, 15);
		getContentPane().add(lblNomDuJoueur);
		
		txtFieldNamePlayer = new JTextField();
		txtFieldNamePlayer.setBounds(140, 137, 114, 19);
		getContentPane().add(txtFieldNamePlayer);
		txtFieldNamePlayer.setColumns(10);
		
		JLabel lblQawiGame = new JLabel("QAWI GAME");
		lblQawiGame.setForeground(UIManager.getColor("MenuBar.highlight"));
		lblQawiGame.setBounds(114, 0, 87, 53);
		getContentPane().add(lblQawiGame);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setAction(action);
		btnConnexion.setBounds(95, 245, 106, 25);
		getContentPane().add(btnConnexion);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setBounds(0, 0, 300, 378);
		try{
			BufferedImage myPicture = ImageIO.read(new File("src/extras/bg.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			panelBackground.add(picLabel);
		}catch(Exception e){
			e.printStackTrace();
		}
		getContentPane().add(panelBackground);
	}
	private class ConnexionEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ConnexionEvent() {
			putValue(NAME, "Connexion");
			putValue(SHORT_DESCRIPTION, "Description");
		}
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
				PluginManager pm = PluginManagerFactory.createPluginManager();
				pm.addPluginsFrom(new File("plugins/").toURI());
				CoolPlugin plugin = pm.getPlugin(CoolPlugin.class);
				System.out.println(plugin);
				ModelLayer mo = new ModelLayer(plugin);
				User oUtil = new User();
				oUtil.setPseudo(txtFieldNamePlayer.getText());
				oUtil.setMdp(txtFieldPassPlayer.getText());
				// Test vérification User
				System.out.println(mo.verifyUser(oUtil));
				if(mo.verifyUser(oUtil) == true){
					Principal fenPrincipal = new Principal(oUtil,plugin);
					setVisible(false);
				}
		}
	}
}
