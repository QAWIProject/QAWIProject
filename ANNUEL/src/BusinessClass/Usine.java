package BusinessClass;

public class Usine {
	private String id_usine;
	private String niveau;
	private String id_type_usine;
	private String prod_usine;
	private String nom_type_usine;
	private String prix_usine;
	
	public Usine(){
		
	}

	public String getId_usine() {
		return id_usine;
	}

	public void setId_usine(String id_usine) {
		this.id_usine = id_usine;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getId_type_usine() {
		return id_type_usine;
	}

	public void setId_type_usine(String id_type_usine) {
		this.id_type_usine = id_type_usine;
	}

	public String getProd_usine() {
		return prod_usine;
	}

	public void setProd_usine(String prod_usine) {
		this.prod_usine = prod_usine;
	}

	public String getNom_type_usine() {
		return nom_type_usine;
	}

	public void setNom_type_usine(String nom_type_usine) {
		this.nom_type_usine = nom_type_usine;
	}

	public String getPrix_usine() {
		return prix_usine;
	}

	public void setPrix_usine(String prix_usine) {
		this.prix_usine = prix_usine;
	}
}
