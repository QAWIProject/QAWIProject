package BusinessClass;

import java.util.ArrayList;
import java.util.List;

public class Flotte {
	private List<Vaisseau> lVaisseau = new ArrayList<Vaisseau>();
	public Flotte(){
	}
	public List<Vaisseau> getlVaisseau() {
		return lVaisseau;
	}
	public void setlVaisseau(List<Vaisseau> lVaisseau) {
		this.lVaisseau = lVaisseau;
	}
	public int getValAttaque(){
		int totalValAttaque = 0;
		for(Vaisseau va : lVaisseau){
			switch(va.getTypeVaisseau()){
			case "0":
				totalValAttaque += 50; 
				break;
			case "1":
				totalValAttaque += 70;
				break;
			case "2":
				totalValAttaque += 200;
				break;
			case "3":
				totalValAttaque += 400;
				break;
			case "4":
				totalValAttaque += 200;
				break;
			case "5":
				totalValAttaque += 1000;
				break;
			case "6":
				totalValAttaque += 1000;
				break;
			default :
				break;
			}
		}	
		return totalValAttaque;
	}
	public int getValDefense(){
		int totalValDefense = 0;
		for(Vaisseau va : lVaisseau){
			switch(va.getTypeVaisseau()){
			case "0":
				totalValDefense += 10; 
				break;
			case "1":
				totalValDefense += 20;
				break;
			case "2":
				totalValDefense += 250;
				break;
			case "3":
				totalValDefense += 300;
				break;
			case "4":
				totalValDefense += 600;
				break;
			case "5":
				totalValDefense += 400;
				break;
			case "6":
				totalValDefense += 1000;
				break;
			default :
				break;
			}
		}	
		return totalValDefense;
	}
	public void ajouterVaisseau(Vaisseau oVaisseau){
		this.lVaisseau.add(oVaisseau);
	}
	public void retirerVaisseau(Vaisseau oVaisseau){
		this.lVaisseau.remove(oVaisseau);
	}
}
