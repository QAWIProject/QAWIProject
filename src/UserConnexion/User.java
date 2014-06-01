package UserConnexion;

public class User {
	private String idUser;
	private String nameUser;
	private String passUser;
	private String mailUser;
	// Constructeur principal
	public User(){
	}
	// Constructeur ID, NAME USER, PASSWORD USER, MAIL USER
	public User(String oIdUser,String oNameUser,String oPassUser, String oMailUser){
		this.idUser = oIdUser;
		this.nameUser = oNameUser;
		this.passUser = oPassUser;
		this.mailUser = oMailUser;
	}
	// Constructeur NAME USER, PASSWORD USER
	public User(String oNameUser,String oPassUser){
		this.nameUser = oNameUser;
		this.passUser = oPassUser;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPassUser() {
		return passUser;
	}
	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}
	public String getMailUser() {
		return mailUser;
	}
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}
}
