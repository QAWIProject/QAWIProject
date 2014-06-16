package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	/**
	 * Attributs de Database
	 */
	private String user;
	private String password;
	private String serveur;
	private String port;
	private String nameDb;
	/**
	 * Constructeur Base de donn�es
	 * @param Name Database
	 * @param Serveur
	 * @param Port
	 * @param User
	 * @param Password
	 */
	public Connexion(String oNameDb,String oServeur,String oPort,String oUser,String oPassword){
		this.nameDb = oNameDb;
		this.user = oUser;
		this.password = oPassword;
		this.serveur = oServeur;
		this.port = oPort;
	}
	/**
	 * Deuxi�me Constructeur Base de Donn�es
	 * @param Name Database
	 * @param Serveur
	 * @param User
	 * @param Password
	 */
	public Connexion(String oNameDb,String oServeur,String oUser,String oPassword){
		this.setNameDb(oNameDb);
		this.user = oUser;
		this.password = oPassword;
		this.serveur = oServeur;
	}
	/**
	 * M�thode de chargement du Driver et Connexion Base de donn�es
	 * @return
	 */
	public boolean connect(){
		try {
	          Class.forName("com.mysql.jdbc.Driver").newInstance();
	          return this.connectDatabase();
	    } catch (Exception e) {
	          e.printStackTrace();
	          return false;
	    }
	}
	protected boolean connectDatabase(){
		try {
			if(this.port == ""){
				 String DBurl = "jdbc:mysql://"+this.serveur+"/"+this.nameDb;
				 Connection con = DriverManager.getConnection(DBurl,this.user,this.password);
                 Statement stmt = con.createStatement();
			}else{
				String DBurl = "jdbc:mysql://"+this.serveur+":"+this.port+"/"+this.nameDb;
				 Connection con = DriverManager.getConnection(DBurl,this.user,this.password);
			     Statement stmt = con.createStatement();
			}
	        return true;
	    }catch (SQLException e) {
	        return false;
	    }
	}
	public Connection getConnection(){
		 String DBurl = "jdbc:mysql://"+this.serveur+"/"+this.nameDb;
		 Connection con;
		try {
			con = DriverManager.getConnection(DBurl,this.user,this.password);
                        //System.out.println("Connexion reussie.");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getServeur() {
		return serveur;
	}
	public void setServeur(String serveur) {
		this.serveur = serveur;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getNameDb() {
		return nameDb;
	}
	public void setNameDb(String nameDb) {
		this.nameDb = nameDb;
	}
}