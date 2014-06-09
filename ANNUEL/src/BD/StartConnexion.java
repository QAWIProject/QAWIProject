package BD;

import java.sql.Connection;

public class StartConnexion {
	private Connexion uneConnex = new Connexion("QAWI","localhost","root","root");	
	public StartConnexion(){
		uneConnex.connect();
	}
	public Connection getCurrentConnexion(){
		return this.uneConnex.getConnection();
	}
}
