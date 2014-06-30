package Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BD.Connexion;
import BD.SelectData;
import BD.StartConnexion;
import BusinessClass.Flotte;
import BusinessClass.Planete;
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
/*		List<User> oListUser = new ArrayList<User>();
		List<Vaisseau> oListVaisseau = new ArrayList<Vaisseau>();
		List<Usine> oListUsine = new ArrayList<Usine>();
		*//**
		 * Recuperation Utilisateur dans une liste d'utilisateur 
		 * Exemples : 
		 * List<User> maListeUserPrésentEnBDD = mod.getAllUser();
		 *//*
		oListUser = mod.getAllUser();
		*//**
		 * Affiche tous les utilisateurs
		 *//*
		 mod.displayAllUser();
		*//** 
		 * Recuperation de tous les Vaisseaux des utilisateurs dans une liste de Vaisseau 
		 * Exemples : 
		 * List<Vaisseau> maListeVaisseauDeUserPrésentEnBDD = mod.getAllVaisseau();
		 for(User usr : oListUser){
			 oListVaisseau = mod.getAllVaisseauByUser(usr);
		 }
		 /**
		  * Affichage de tous les vaisseaux
		  *//*
		 mod.displayAllVaisseau();
		*//** 
		 * Recuperation de toutes les Usines des utilisateurs dans une liste d'usine 
		 * Exemples : 
		 * List<Vaisseau> maListeVaisseauDeUserPrésentEnBDD = mod.getAllVaisseau();
		 *//*
		 for(User usr : oListUser){
			 oListUsine = mod.getAllUsineByUser(usr);
		 }
		 *//**
		  * Affichage de toutes les usines
		  *//*
		 mod.displayAllUsine();
		 *//**
		  * Insertion d'un vaisseau en fonction de l'utilisateur
		  * OK
		  *//*
		 User ivan = new User();
		 ivan.setIdPlanete("0");
		 Vaisseau cl = new Vaisseau();
		 cl.setTypeVaisseau("1");
		 mod.insertVaisseau(ivan,cl);
		 *//**
		  * Ameliorer une usine
		  * OK
		  *//*
		 Usine us = new Usine();
		 us.setId_usine("4");
		 us.setId_type_usine("3");
		 us.setNiveau("1");
		 us.setProd_usine("200");
		 us.setCout_or("10");
		 us.setCout_argent("15");
		 us.setCout_pierre("20");
		 us.setCout_nourriture("15");
		 mod.ameliorerUsine(us);
		 *//**
		  * Combat de deux flottes avec envoi de rapport
		  * OK - Gerer les utilisateurs des plan�tes pour envoyer un mail
		  *//*
		 Flotte att = new Flotte();
		 Flotte def = new Flotte();
		 Planete p_attaque = new Planete();
		 Planete p_attaquante = new Planete();
		 Vaisseau v1 = new Vaisseau();
		 Vaisseau v2 = new Vaisseau();
		 v1.setTypeVaisseau("1");
		 v2.setTypeVaisseau("5");
		 att.ajouterVaisseau(v1);
		 def.ajouterVaisseau(v2);
		 try {
			mod.attaquerJoueur(att,  def, p_attaque, p_attaquante);
		} catch (IOException e) {
			e.printStackTrace();
		}
		User utilIvan = new User();
		utilIvan.setPseudo("Ivan");
		utilIvan.setMdp("MDP1992");
		mod.verifyUser(utilIvan);*/
		//mod.getAllUsine();
//		User ivan = new User();
//		ivan.setId("0");
//		ivan.setIdPlanete("0");
//		ivan.setMdp("MDP1992");
//		ivan.setPseudo("Ivan");
//		mod.addRessourcesAllUsine();
//		System.out.println(mod.getAllPlaneteByUser(ivan).getQte_or());
		mod.getAllPlanete();
		//Planete p1 = new Planete();
		//p1.setId_util("0");
		//List<Usine> lu = new ArrayList<Usine>();
		//lu = mod.getAllUsineByPlanete(p1);
		//for(Usine u : lu){
			//System.out.println(u.getId_usine());
		//}
	}
}