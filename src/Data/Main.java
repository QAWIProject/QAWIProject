package Data;
import Data.Database;
public class Main {
	public static void main(String[] args) {
		Database uneConnex = new Database("test","localhost","root","root");		
		uneConnex.connect();
		String table = "type_vaisseau";
		String[] valeurs = {"0","Destructeur","1200","300"};
		String[] valeurs2 = {"1","Chasseur Leger","100","50"};
		//InsertData uneInsertion = new InsertData(uneConnex.getConnection(),table,valeurs);
		//System.out.println(uneInsertion.getReq());
		SelectData unSelect = new SelectData(uneConnex.getConnection(),"SELECT * FROM type_vaisseau");
		System.out.println(unSelect.getResultatReq());
	}
}
