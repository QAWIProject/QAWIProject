package Data;
import Data.Database;
public class Main {
	public static void main(String[] args) {
		Database uneConnex = new Database("test","localhost","root","root");		
		uneConnex.connect();
	}
}
