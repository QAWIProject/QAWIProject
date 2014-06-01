public class Vessel {
	private String name;
	private int niveau;
	private int prodParMin;
	
	public Vessel(String oName,int oNiveau, int oProdParMin){
		this.name = oName;
		this.niveau = oNiveau;
		this.prodParMin = oProdParMin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getProdParMin() {
		return prodParMin;
	}
	public void setProdParMin(int prodParMin) {
		this.prodParMin = prodParMin;
	}
}
