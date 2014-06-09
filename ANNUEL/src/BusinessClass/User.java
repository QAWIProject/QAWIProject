package BusinessClass;

public class User {
	/**
	 * ATTRIBUT
	 */
	private String id;
	private String pseudo;
	private String email;
	private String mdp;
	private String idPlanete;
	private int point;
	/**
	 * CONSTRUCTEURS
	 */
	public User(){	
	}
	/**
	 * METHODES
	 */
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getIdPlanete() {
		return idPlanete;
	}
	public void setIdPlanete(String idPlanete) {
		this.idPlanete = idPlanete;
	}
}
