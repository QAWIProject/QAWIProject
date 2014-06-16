package BusinessClass;

public class Planete {
	//id_planete 	nom_planete 	qte_or 	qte_argent 	qte_pierre 	qte_nourriture 	id_util 
	private String id_planete;
	private String nom_planete;
	private int qte_or;
	private int qte_argent;
	private int qte_pierre;
	private int qte_nourriture;
	private String id_util;
	
	public Planete(){
		
	}

	public String getId_planete() {
		return id_planete;
	}

	public void setId_planete(String id_planete) {
		this.id_planete = id_planete;
	}

	public String getNom_planete() {
		return nom_planete;
	}

	public void setNom_planete(String nom_planete) {
		this.nom_planete = nom_planete;
	}

	public int getQte_or() {
		return qte_or;
	}

	public void setQte_or(int qte_or) {
		this.qte_or = qte_or;
	}

	public int getQte_pierre() {
		return qte_pierre;
	}

	public void setQte_pierre(int qte_pierre) {
		this.qte_pierre = qte_pierre;
	}

	public int getQte_argent() {
		return qte_argent;
	}

	public void setQte_argent(int qte_argent) {
		this.qte_argent = qte_argent;
	}

	public int getQte_nourriture() {
		return qte_nourriture;
	}

	public void setQte_nourriture(int qte_nourriture) {
		this.qte_nourriture = qte_nourriture;
	}

	public String getId_util() {
		return id_util;
	}

	public void setId_util(String string) {
		this.id_util = string;
	}
}
