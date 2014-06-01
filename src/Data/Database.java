package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	/**
	 * Attributs de Database
	 */
	private String user;
	private String password;
	private String serveur;
	private String port;
	private String nameDb;
	/**
	 * Constructeur Base de données
	 * @param Name Database
	 * @param Serveur
	 * @param Port
	 * @param User
	 * @param Password
	 */
	public Database(String oNameDb,String oServeur,String oPort,String oUser,String oPassword){
		this.nameDb = oNameDb;
		this.user = oUser;
		this.password = oPassword;
		this.serveur = oServeur;
		this.port = oPort;
	}
	/**
	 * Deuxième Constructeur Base de Données
	 * @param Name Database
	 * @param Serveur
	 * @param User
	 * @param Password
	 */
	public Database(String oNameDb,String oServeur,String oUser,String oPassword){
		this.setNameDb(oNameDb);
		this.user = oUser;
		this.password = oPassword;
		this.serveur = oServeur;
	}
	/**
	 * Méthode de chargement du Driver et Connexion Base de données
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
	        e.printStackTrace();
	        return false;
	    }
	}
	public Connection getConnection(){
		 String DBurl = "jdbc:mysql://"+this.serveur+"/"+this.nameDb;
		 Connection con;
		try {
			con = DriverManager.getConnection(DBurl,this.user,this.password);
                        System.out.println("Connexion réussie.");
			return con;
		} catch (SQLException e) {
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