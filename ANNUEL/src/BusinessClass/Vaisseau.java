package BusinessClass;
public class Vaisseau {
	private String name;
	private String typeVaisseau;
	private String id;
	public Vaisseau(String oName){
		this.name = oName;
	}
	public Vaisseau(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTypeVaisseau(String unType){
		this.typeVaisseau = unType;
	}
	public String getTypeVaisseau(){
		return typeVaisseau;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
