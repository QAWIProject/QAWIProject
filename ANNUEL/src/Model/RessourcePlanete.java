package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import BD.SelectData;
import BD.StartConnexion;
import BusinessClass.User;

public class RessourcePlanete {
	/*
	 * private Planete oPlanet = new Planete();
	 * Appelé une méthode qui récupère l'id de l'utilisateur courant
	 * EXEMPLE :
	 * oUser.setId(oUser.getCurrentUser());
	 */
	public RessourcePlanete(){
		
	}
	/*
	 * Envoyé en paramètre un objet Planete
	 * Utiliser son ID pour trouver les ressources 
	 */
	public void getRessource(){
		StartConnexion con = new StartConnexion();
		SelectData sql = new SelectData(con.getCurrentConnexion(),"SELECT prix_or_type_vaisseau,prix_argent_type_vaisseau,prix_pierre_type_vaisseau,prix_nourriture_type_vaisseau FROM type_vaisseau");
		ResultSet result = sql.getResults();
		// Valeur récupérer 
		int prixOr;
		int prixArgent;
		int prixPierre;
		int prixNourriture;
			try {
				if(result.first() !=  false){
					do{
						prixOr=result.getInt(1);
						prixArgent = result.getInt(2);
						prixPierre = result.getInt(3);
						prixNourriture = result.getInt(4);
						System.out.println("OR : " + prixOr);
						System.out.println("ARGENT : "+ prixArgent);
						System.out.println("PIERRE : " + prixPierre);
						System.out.println("NOURRITURE : " + prixNourriture);
					 }while(result.next());
				}
			} catch (SQLException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
	}
}
