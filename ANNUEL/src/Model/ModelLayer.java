package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BD.Connexion;
import BD.InsertData;
import BD.SelectData;
import BD.UpdateData;
import BusinessClass.User;
import BusinessClass.Usine;
import BusinessClass.Vaisseau;

public class ModelLayer {
	private List<User> oListUser = new ArrayList<User>();
	private List<Vaisseau> oListVaisseau = new ArrayList<Vaisseau>();
	private List<Usine> oListUsine = new ArrayList<Usine>();
	private Connexion  con = new Connexion("QAWI","Localhost","root","root");
	public ModelLayer(){
		con.connect();
	}
	public String getTypeVaisseau(){
		/**
		 * 1/ Se connecter a la base	
		 * 2/ Recuperer un type de vaisseau
		 * 3/ Envoyer un type de vaisseau grace a la classe Vaisseau
		 */
		SelectData select = new SelectData(con.getConnection(),""
				+ "SELECT nom_type_vaisseau"
				+ "FROM vaisseau , type_vaisseau, planete "
				+ "WHERE planete.id_planete = vaisseau.id_planete ");
		System.out.println("Recupérer le type de vaisseau en fonction de la personne : "+ select.getResultatReqString());
		return select.getResultatReqString();
	}
	/**
	 * Récupère tous les utilisateurs en BDD
	 * @return liste d'utilisateurs
	 */
	public List<User> getAllUser(){
		try {
		SelectData select = new SelectData(con.getConnection(),""
				+ "SELECT *"
				+ "FROM utilisateur");
		ResultSet res = select.getResults();
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
			}catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		return oListUser;
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
		SelectData select = new SelectData(con.getConnection(),""
				+ "SELECT vaisseau.id_vaisseau,type_vaisseau.nom_type_vaisseau,vaisseau.id_type_vaisseau "
				+ "FROM vaisseau,type_vaisseau,planete,utilisateur "
				+ "WHERE vaisseau.id_type_vaisseau = type_vaisseau.id_type_vaisseau "
				+ "AND planete.id_planete = utilisateur.id_planete "
				+ "AND utilisateur.id_util = 0 ");
		ResultSet res = select.getResults();
				if(res.first() !=  false){
					do{
						Vaisseau currentVaisseau = new Vaisseau();
						currentVaisseau.setId(Integer.toString(res.getInt("id_vaisseau")));
						currentVaisseau.setName(res.getString("nom_type_vaisseau"));
						currentVaisseau.setTypeVaisseau(Integer.toString(res.getInt("id_type_vaisseau")));
						oListVaisseau.add(currentVaisseau);
					}while(res.next());
				}
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
		SelectData select = new SelectData(con.getConnection(),""
				+ "SELECT usine.prix_usine,usine.id_usine,usine.id_type_usine,type_usine.nom_type_usine,usine.prod_usine,usine.niveau_usine "
				+ "FROM usine,type_usine,planete,utilisateur "
				+ "WHERE type_usine.id_type_usine = usine.id_type_usine "
				+ "AND planete.id_planete = usine.id_planete "
				+ "AND planete.id_util = utilisateur.id_util "
				+ "AND utilisateur.id_util = "+usr.getId()+" ");
		ResultSet res = select.getResults();
				if(res.first() !=  false){
					do{
						Usine currentUsine = new Usine();
						currentUsine.setId_usine(Integer.toString(res.getInt("id_usine")));
						currentUsine.setId_type_usine(Integer.toString(res.getInt("id_type_usine")));
						currentUsine.setNom_type_usine(res.getString("nom_type_usine"));
						currentUsine.setProd_usine(Integer.toString(res.getInt("prod_usine")));
						currentUsine.setNiveau(Integer.toString(res.getInt("niveau_usine")));
						currentUsine.setPrix_usine(Integer.toString(res.getInt("prix_usine")));
						oListUsine.add(currentUsine);
					}while(res.next());
				}
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
			System.out.println("PRIX PROCHAIN NIVEAU  --->   "+usine.getPrix_usine());
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
}
