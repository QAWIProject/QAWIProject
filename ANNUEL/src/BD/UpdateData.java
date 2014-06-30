package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateData {
	private Statement st;
	public UpdateData(Connection oConnection,String req){
		try{
			st = oConnection.createStatement();
			st.executeUpdate(req);
			st.close();
		}catch(Exception e){
			System.out.println("Erreur SQL");
		}
	}
}
