package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SelectData {
	private String resultatReq = "";
	public SelectData(Connection oConnection,String req){
		try{
			Statement st = oConnection.createStatement();
			ResultSet rs = st.executeQuery(req);
			ResultSetMetaData rsmd = rs.getMetaData();
			boolean prochain = rs.next();
			while (prochain){
				for (int i = 1; i <= rsmd.getColumnCount(); i++){
					this.resultatReq += rs.getString(i);
				}
				prochain = rs.next();
			}
		    st.close();
		}catch(Exception e){
			System.out.println("Erreur d'insertion");
		}
	}
	public String getResultatReq() {
		return resultatReq;
	}
	public void setResultatReq(String resultatReq) {
		this.resultatReq = resultatReq;
	}
}
