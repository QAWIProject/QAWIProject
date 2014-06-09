package BD;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateData {
	public UpdateData(Connection oConnection,String req){
		try{
			Statement st = oConnection.createStatement();
			st.executeUpdate(req);
		}catch(Exception e){
			System.out.println("Erreur SQL");
		}
	}
}
