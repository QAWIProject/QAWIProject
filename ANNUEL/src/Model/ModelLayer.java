package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import BD.Connexion;
import BD.InsertData;
import BD.SelectData;
import BD.UpdateData;
import BusinessClass.Flotte;
import BusinessClass.Planete;
import BusinessClass.User;
import BusinessClass.Usine;
import BusinessClass.Vaisseau;

public class ModelLayer {
	private List<User> oListUser = new ArrayList<User>();
	private List<Vaisseau> oListVaisseau = new ArrayList<Vaisseau>();
	private List<Usine> oListUsine = new ArrayList<Usine>();
	private List<Planete> oListPlanete = new ArrayList<Planete>();
	private Connexion con = new Connexion("QAWI","localhost","root","root");
	private ResultSet res;
	private Statement st;
	private ResultSetMetaData rsmd;
	public ModelLayer(){
		con.connect();
	}
	public void reConnexion(){
		try {
			this.con.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con = new Connexion("QAWI","localhost","root","root");
		this.con.connect();
	}
	public boolean verifyUser(User u){
		try {
			//System.out.println("Entrer dans verifyUser \n "+u.getPseudo()+"\n "+u.getMdp());
			String req = ""
					+ "SELECT * "
					+ "FROM utilisateur "
					+ "WHERE nom_util = '"+ u.getPseudo() +"' "
					+ "AND mdp_util = '"+ u.getMdp() +"' ";
			ResultSet res = null;
			Statement st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			ResultSetMetaData rsmd = res.getMetaData();
			res.first();
			try{
				u.setId(Integer.toString(res.getInt("id_util")));
				u.setEmail(res.getString("email_util"));
				u.setIdPlanete(Integer.toString(res.getInt("id_planete")));
			}catch(Exception e){
				e.printStackTrace();
			}
			if(res.first() == false){
				//System.out.println("Entrer dans le premier if");
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			//System.out.println("Entrer dans le premier catch");
			return false;
		}
	}
	/**
	 * Recupere tous les utilisateurs en BDD
	 * @return liste d'utilisateurs
	 */
	public List<User> getAllUser(){
		try {
			String req = ""
				+ "SELECT * "
				+ "FROM utilisateur";
			ResultSet res = null;
			Statement st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			res.refreshRow();
			ResultSetMetaData rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						User currentUser = new User();
						currentUser.setId(Integer.toString(res.getInt("id_util")));
						currentUser.setPseudo(res.getString("nom_util"));
						currentUser.setEmail(res.getString("email_util"));
						currentUser.setMdp(res.getString("mdp_util"));
						currentUser.setPoint(res.getInt("point_util"));
						currentUser.setIdPlanete(res.getString("id_planete"));
						oListUser.add(currentUser);
					}while(res.next());
				}
				st.close();
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListUser;
	}
	/**
	 * Recupere toutes les usines en BDD
	 * @return liste des Usines
	 */
	public List<Usine> getAllUsine(){
		try {
		String req = ""
				+ "SELECT *"
				+ "FROM usine";
		
		Statement st = con.getConnection().createStatement();
		res = st.executeQuery(req);
		ResultSetMetaData rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						Usine currentUsine = new Usine();
						currentUsine.setId_type_usine(Integer.toString(res.getInt("id_type_usine")));
						currentUsine.setId_usine(Integer.toString(res.getInt("id_usine")));
						currentUsine.setId_planete_usine(Integer.toString(res.getInt("id_planete")));
						currentUsine.setNiveau(Integer.toString(res.getInt("niveau_usine")));
						currentUsine.setProd_usine(Integer.toString(res.getInt("prod_usine")));
						currentUsine.setCout_or(Integer.toString(res.getInt("cout_or")));
						currentUsine.setCout_argent(Integer.toString(res.getInt("cout_argent")));
						currentUsine.setCout_pierre(Integer.toString(res.getInt("cout_pierre")));
						currentUsine.setCout_nourriture(Integer.toString(res.getInt("cout_nourriture")));
						oListUsine.add(currentUsine);
					}while(res.next());
				}
				st.close();
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListUsine;
	}
	/**
	 * Recupere toutes les usines en BDD
	 * @return liste des Usines
	 */
	public List<Usine> getAllUsineByPlanete(Planete pla){
		try {
			String req = ""
				+ "SELECT * "
				+ "FROM usine,planete "
				+ "WHERE usine.id_planete = planete.id_planete "
				+ "AND planete.id_planete = '"+pla.getId_planete()+"'";
				
				st = con.getConnection().createStatement();
				res = st.executeQuery(req);
				rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						Usine currentUsine = new Usine();
						currentUsine.setId_type_usine(Integer.toString(res.getInt("id_type_usine")));
						currentUsine.setId_usine(Integer.toString(res.getInt("id_usine")));
						currentUsine.setId_planete_usine(Integer.toString(res.getInt("id_planete")));
						currentUsine.setNiveau(Integer.toString(res.getInt("niveau_usine")));
						currentUsine.setProd_usine(Integer.toString(res.getInt("prod_usine")));
						currentUsine.setCout_or(Integer.toString(res.getInt("cout_or")));
						currentUsine.setCout_argent(Integer.toString(res.getInt("cout_argent")));
						currentUsine.setCout_pierre(Integer.toString(res.getInt("cout_pierre")));
						currentUsine.setCout_nourriture(Integer.toString(res.getInt("cout_nourriture")));
						oListUsine.add(currentUsine);
					}while(res.next());
				}
			}catch (SQLException e){
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListUsine;
	}
	/**
	 * Recupere toutes les planetes en BDD
	 * @return liste des planetes
	 */
	public List<Planete> getAllPlanete(){
		try {
			
			String req = "SELECT * FROM planete ";
			ResultSet res = null;
			Statement st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			ResultSetMetaData rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						Planete currentPlanete = new Planete();
						currentPlanete.setId_planete(Integer.toString(res.getInt("id_planete")));
						currentPlanete.setQte_or(res.getInt("qte_or"));
						currentPlanete.setQte_argent(res.getInt("qte_argent"));
						currentPlanete.setQte_pierre(res.getInt("qte_pierre"));
						currentPlanete.setQte_nourriture(res.getInt("qte_nourriture"));
						currentPlanete.setNom_planete(res.getString("nom_planete"));
						oListPlanete.add(currentPlanete);
					}while(res.next());
				}
				st.close();
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListPlanete;
	}
	/**
	 * Recupere la planete d'un utilisateur
	 * @return liste des planetes
	 */
	public Planete getAllPlaneteByUser(User u){
		Planete currentPlanete = new Planete();
		try {
			String req = ""
				+ "SELECT * "
				+ "FROM planete "
				+ "WHERE planete.id_planete = "+u.getIdPlanete();
			st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			rsmd = res.getMetaData();
			
				if(res.first() !=  false){
					do{
						currentPlanete.setId_planete(Integer.toString(res.getInt("id_planete")));
						currentPlanete.setQte_or(res.getInt("qte_or"));
						currentPlanete.setQte_argent(res.getInt("qte_argent"));
						currentPlanete.setQte_pierre(res.getInt("qte_pierre"));
						currentPlanete.setQte_nourriture(res.getInt("qte_nourriture"));
						currentPlanete.setNom_planete(res.getString("nom_planete"));
						oListPlanete.add(currentPlanete);
						//System.out.println("PLANETE "+currentPlanete.getNom_planete()+"\n Qte OR "+currentPlanete.getQte_or());
					}while(res.next());
				}
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return currentPlanete;
	}
	/**
	 * Montre les utilisateurs
	 */
	public void displayAllUser(){
		for (User usr : oListUser){
			System.out.println("ID USER  --->   "+ usr.getId());
			System.out.println("ID PLANETE  --->   "+usr.getIdPlanete());
			System.out.println("PSEUDO  --->   "+usr.getPseudo());
			System.out.println("MAIL  --->   "+usr.getEmail());
			System.out.println("MOT DE PASSE  --->   "+usr.getMdp());
			System.out.println("NOMBRE DE POINTS  --->   "+usr.getPoint());
			System.out.println("----------");
		}
	}
	/**
	 * Renvois la liste des vaisseaux d'un joueur
	 * @param oUser
	 * @return Liste de vaisseau
	 */
	public List<Vaisseau> getAllVaisseauByUser(User oUser){
		try {
			String req = ""
				+ "SELECT vaisseau.id_vaisseau,type_vaisseau.nom_type_vaisseau,vaisseau.id_type_vaisseau "
				+ "FROM vaisseau,type_vaisseau,planete,utilisateur "
				+ "WHERE vaisseau.id_type_vaisseau = type_vaisseau.id_type_vaisseau "
				+ "AND planete.id_planete = utilisateur.id_planete "
				+ "AND utilisateur.id_util = 0 ";
			ResultSet res = null;
			Statement st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			ResultSetMetaData rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						Vaisseau currentVaisseau = new Vaisseau();
						currentVaisseau.setId(Integer.toString(res.getInt("id_vaisseau")));
						currentVaisseau.setName(res.getString("nom_type_vaisseau"));
						currentVaisseau.setTypeVaisseau(Integer.toString(res.getInt("id_type_vaisseau")));
						oListVaisseau.add(currentVaisseau);
					}while(res.next());
				}
				st.close();
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListVaisseau;
	}
	/**
	 * Montre les vaisseaux
	 */
	public void displayAllVaisseau(){
		for (Vaisseau vs : oListVaisseau){
			System.out.println("ID VAISSEAU  --->   "+vs.getId());
			System.out.println("NOM DU VAISSEAU  --->   "+vs.getName());
			System.out.println("TYPE DE VAISSEAU  --->   "+vs.getTypeVaisseau());
			System.out.println("----------");
		}
	}
	/**
	 * Renvois la liste des usines d'un joueur
	 * @param oUser
	 * @return Liste d'usine
	 */
	public List<Usine> getAllUsineByUser(User usr){
		try {
			String req = ""
				+ "SELECT usine.cout_or,cout_argent,cout_pierre,cout_nourriture,usine.id_usine,usine.id_type_usine,type_usine.nom_type_usine,usine.prod_usine,usine.niveau_usine "
				+ "FROM usine,type_usine,planete,utilisateur "
				+ "WHERE type_usine.id_type_usine = usine.id_type_usine "
				+ "AND planete.id_planete = usine.id_planete "
				+ "AND planete.id_planete = utilisateur.id_planete "
				+ "AND utilisateur.id_util = "+usr.getId()+" ";
			st = con.getConnection().createStatement();
			res = st.executeQuery(req);
			rsmd = res.getMetaData();
				if(res.first() !=  false){
					do{
						Usine currentUsine = new Usine();
						currentUsine.setId_usine(Integer.toString(res.getInt("id_usine")));
						currentUsine.setId_type_usine(Integer.toString(res.getInt("id_type_usine")));
						currentUsine.setNom_type_usine(res.getString("nom_type_usine"));
						currentUsine.setProd_usine(Integer.toString(res.getInt("prod_usine")));
						currentUsine.setNiveau(Integer.toString(res.getInt("niveau_usine")));
						currentUsine.setCout_or(Integer.toString(res.getInt("cout_or")));
						currentUsine.setCout_argent(Integer.toString(res.getInt("cout_argent")));
						currentUsine.setCout_pierre(Integer.toString(res.getInt("cout_pierre")));
						currentUsine.setCout_nourriture(Integer.toString(res.getInt("cout_nourriture")));
						oListUsine.add(currentUsine);
					}while(res.next());
				}
				st.close();
				return oListUsine;
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListUsine;
	}
	/**
	 * Montre les usines d'un joueur
	 */
	public void displayAllUsine(){
		for (Usine usine : oListUsine){
			System.out.println("ID USINE  --->   "+usine.getId_usine());
			System.out.println("ID TYPE USINE  --->   "+usine.getId_type_usine());
			System.out.println("NIVEAU USINE  --->   "+usine.getNiveau());
			System.out.println("PRODUCTION  --->   "+usine.getProd_usine());
			System.out.println("TYPE D'USINE  --->   "+usine.getNom_type_usine());
			System.out.println("----------");
		}
	}
	public void insertVaisseau(User oUser,Vaisseau vaiss){
		String table = "vaisseau";
		String[] field = {"id_vaisseau","id_planete","id_type_vaisseau"};
		String[] val = {null,oUser.getIdPlanete(),vaiss.getTypeVaisseau()};
		InsertData ins = new InsertData(con.getConnection(),field,table,val);
	}
	public void monterNiveauUsine(User oUser,Usine us){
		int newNiveau = Integer.parseInt(us.getNiveau())+1;
		UpdateData upd = new UpdateData(con.getConnection(),
		" UPDATE usine "
		+"SET usine.niveau_usine = "+newNiveau+" "
		+"WHERE usine.id_planete = "+oUser.getIdPlanete()+" "
		+"AND usine.id_usine = "+us.getId_usine());
	}
	/**
	 * PRODUCTION DES RESSOURCES DYNAMIQUE
	 */
	public void addRessourcesAllUsine(){
		try{
			List<Usine> listeUsines = new ArrayList<Usine>();
			List<Planete> listePlanetes = new ArrayList<Planete>();
			listePlanetes = getAllPlanete();
				for(Planete pl : listePlanetes){
					listeUsines = getAllUsineByPlanete(pl);
					for(Usine farm : listeUsines){
						switch(farm.getId_type_usine()){
							case "0" :	{
											// AJOUT DE L'OR
											UpdateData updOr = new UpdateData(con.getConnection(),
											"UPDATE planete JOIN usine ON planete.id_planete = usine.id_planete "
											+"SET planete.qte_or = "+pl.getQte_or()+" + "+farm.getProd_usine()+" "
											+"WHERE planete.id_planete = usine.id_planete "
											+"AND usine.id_planete = '"+pl.getId_planete()+"'");
											break;
										}
							case "1" : {
											//AJOUT DE L'ARGENT
											UpdateData updArgent = new UpdateData(con.getConnection(),
											" UPDATE planete JOIN usine ON planete.id_planete = usine.id_planete "
											+"SET planete.qte_argent = "+pl.getQte_argent()+" + "+farm.getProd_usine()+" "
											+"WHERE planete.id_planete = usine.id_planete "
											+"AND usine.id_planete = '"+pl.getId_planete()+"'");
											break;
										}
							case "2" : 	{	//AJOUT DE LA PIERRE
											UpdateData updPierre = new UpdateData(con.getConnection(),
											"UPDATE planete JOIN usine ON planete.id_planete = usine.id_planete "
											+"SET planete.qte_pierre = "+pl.getQte_pierre()+" + "+farm.getProd_usine()+" "
											+"WHERE planete.id_planete = usine.id_planete "
											+"AND usine.id_planete = '"+pl.getId_planete()+"'");
											break;
							}
							case "3" :  {	//AJOUT DE LA NOURRITURE
											UpdateData updNourriture = new UpdateData(con.getConnection(),
											"UPDATE planete JOIN usine ON planete.id_planete = usine.id_planete "
											+"SET planete.qte_nourriture = "+pl.getQte_nourriture()+" + "+farm.getProd_usine()+" "
											+"WHERE planete.id_planete = usine.id_planete "
											+"AND usine.id_planete = '"+pl.getId_planete()+"'");
											break;
							}
							default: break;
						}
					}
				}
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	/**
	 * Amelioration d'une usine
	 * @param usine
	 */
	public void ameliorerUsine(Usine usine){
		int newNiveau = Integer.parseInt(usine.getNiveau()) + 1;
		int newProdUsine = Integer.parseInt(usine.getProd_usine()) * newNiveau;
		UpdateData upUsine = new UpdateData(con.getConnection()," "
				+"UPDATE usine "
				+"SET usine.prod_usine = " + newProdUsine + " ,"
				+"usine.niveau_usine = "+ Integer.toString(newNiveau) +" ,"
				+"usine.cout_or = "+ Integer.parseInt(usine.getCout_or())*2 + " ,"
				+"usine.cout_argent = "+ Integer.parseInt(usine.getCout_argent())*2 + " ,"
				+"usine.cout_pierre = "+ Integer.parseInt(usine.getCout_pierre())*2 + " ,"
				+"usine.cout_nourriture = "+ Integer.parseInt(usine.getCout_nourriture())*2 + " "
				+"WHERE usine.id_usine = "+ usine.getId_usine());
	}
	/**
	 * Attaquer une planete
	 * @param fl_att
	 * @param fl_def
	 * @param pl_attaquant
	 * @param pl_defenseur
	 * @throws IOException 
	 */
	public void attaquerJoueur(Flotte fl_att,Flotte fl_def,Planete pl_attaquant,Planete pl_defenseur) throws IOException{
		if(fl_att.getValAttaque() > fl_def.getValDefense()){
			System.out.println("L'Attaquant a gagner");
			generationRapport(2);
		}else if(fl_att.getValAttaque() == fl_def.getValDefense()){
			System.out.println("Les deux flottent ont ete detruit, aucun gagnant.");
			generationRapport(1);
		}else{
			System.out.println("Le defenseur a aneanti la flotte attaquante.");
			generationRapport(0);
		}
	}
	public void generationRapport(int annonce) throws IOException{
		final String username = "klarman.ivan@gmail.com";
		final String password = "Vet1felor";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		if(annonce == 0){
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("klarman.ivan@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("klarman.ivan@gmail.com"));
				message.setSubject("Qawi - Rapport de Combat");
				 DataSource fds = new FileDataSource("images\\Background.jpg");
				message.setDataHandler(new DataHandler(fds));
				message.setContent("<h2><b>Salut combattant des �toiles <br /><br />"
					+ " <p style='color:red;'>La flotte attaquante � �chouer !</p></b></h2>"
					+ "<img height='500' width='500' src=\"http://nsa34.casimages.com/img/2014/06/23/140623010637705974.jpg\">", 
           "text/html");
	 
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}else if(annonce == 1){
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("klarman.ivan@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("klarman.ivan@gmail.com"));
				message.setSubject("Qawi - Rapport de Combat");
				message.setText("Salut combattant des �toiles"
					+ "\n\n La flotte attaquante et d�fensive sont �gales, aucun des deux joueurs n'est gagnant !");
	 
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}else{
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("klarman.ivan@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("klarman.ivan@gmail.com"));
				message.setSubject("Qawi - Rapport de Combat");
				message.setText("Salut combattant des etoiles"
					+ "\n\n La bataille a ete remporte par la flotte attaquante !");
	 
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
