package Data;
import java.util.ArrayList;
import java.util.List;

import BD.Connexion;
import BD.SelectData;
import BD.StartConnexion;
import BusinessClass.User;
import BusinessClass.Usine;
import BusinessClass.Vaisseau;
import Model.ModelLayer;
import Model.PrixVaisseau;
public class Main {
	// ++++++++++++++++++++++++++++++++++++++++++
	// ++++++++++++ VUE et CONTROLEUR +++++++++++
	// ++++++++++++++++++++++++++++++++++++++++++
		
	public static void main(String[] args) {
		ModelLayer mod = new ModelLayer();
		List<User> oListUser = new ArrayList<User>();
		List<Vaisseau> oListVaisseau = new ArrayList<Vaisseau>();
		List<Usine> oListUsine = new ArrayList<Usine>();
		/**
		 * Récupération Utilisateur dans une liste d'utilisateur 
		 * Exemples : 
		 * List<User> maListeUserPrésentEnBDD = mod.getAllUser();
		 */
		oListUser = mod.getAllUser();
		/**
		 * Affiche tous les utilisateurs
		 */
		 mod.displayAllUser();
		 
		 
		/** 
		 * Récupération de tous les Vaisseaux des utilisateurs dans une liste de Vaisseau 
		 * Exemples : 
		 * List<Vaisseau> maListeVaisseauDeUserPrésentEnBDD = mod.getAllVaisseau();
		 */
		 for(User usr : oListUser){
			 oListVaisseau = mod.getAllVaisseauByUser(usr);
		 }
		 /**
		  * Affichage de tous les vaisseaux
		  */
		 mod.displayAllVaisseau();
		 
		 
		 
		/** 
		 * Récupération de toutes les Usines des utilisateurs dans une liste d'usine 
		 * Exemples : 
		 * List<Vaisseau> maListeVaisseauDeUserPrésentEnBDD = mod.getAllVaisseau();
		 */
		 for(User usr : oListUser){
			 oListUsine = mod.getAllUsineByUser(usr);
		 }
		 /**
		  * Affichage de toutes les usines
		  */
		 mod.displayAllUsine();
		 
		 
		 /**
		  * Insertion d'un vaisseau en fonction de l'utilisateur
		  * OK
		  */
		 User ivan = new User();
		 ivan.setIdPlanete("0");
		 Vaisseau cl = new Vaisseau();
		 cl.setTypeVaisseau("1");
		 mod.insertVaisseau(ivan,cl);
		 
		 /**
		  * Monter le niveau d'une usine
		  */
		 Usine us = new Usine();
		 us.setId_usine("4");
		 us.setNiveau("0");
		 mod.monterNiveauUsine(ivan, us);
		 mod.addRessourcesAllUsine();
	}
	
	
			//unPrix.getPrice();
			//String table = "type_vaisseau";
			//String[] valeurs = {"0","Destructeur","1200","300"};
			//String[] valeurs2 = {"1","Chasseur Leger","100","50"};
			//InsertData uneInsertion = new InsertData(uneConnex.getConnection(),table,valeurs);
			//System.out.println(uneInsertion.getReq());
			//SelectData unSelect = new SelectData(uneConnex.getConnection(),"SELECT * FROM type_vaisseau");
			//System.out.println(unSelect.getResultatReq());
}