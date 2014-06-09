package BD;

import BusinessClass.User;

public class Test {
	public static void main(String[] args) {
		Connexion oCon = new Connexion("QAWI","localhost","root","root");
		oCon.connect();
		/**
		 * METTRE L'ID A NUL POUR REUSSIR LA REQUETE
		 */
		String[] valeurs = {null,"0","5"};
		String[] champs = {"id_vaisseau","id_planete","id_type_vaisseau"};
		InsertData insert = new InsertData(oCon.getConnection(),champs,"`vaisseau`",valeurs);
		System.out.println(insert.getReq());
	}
}


