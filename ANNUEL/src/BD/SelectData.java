package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SelectData {
	private String resultatReq = "";
	private ResultSet rs = null ;
	public SelectData(Connection oConnection,String req){
		try{
			Statement st = oConnection.createStatement();
			rs = st.executeQuery(req);
			ResultSetMetaData rsmd = rs.getMetaData();
			boolean prochain = rs.next();
			while (prochain){
				for (int i = 1; i <= rsmd.getColumnCount(); i++){
					this.resultatReq += rs.getString(i) + " ";
				}
				prochain = rs.next();
			}
		}catch(Exception e){
			System.out.println("Erreur SQL");
		}
	}
	public ResultSet getResults(){
		return rs;
	}
	public String getResultatReqString() {
		return resultatReq;
	}
	public void setResultatReq(String resultatReq) {
		this.resultatReq = resultatReq;
	}
}
