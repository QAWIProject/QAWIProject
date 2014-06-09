package BD;

import java.sql.Connection;
import java.sql.Statement;

public class InsertData {
	private String fieldTable;
	private String champTable;
	private String req;
	/**
	 * Constructeur de InserData
	 * @param Une Connexion
	 * @param Une Table
	 * @param Un Tableau de Valeurs
	 */
	public InsertData(Connection oConnection,String[] champ,String oTable, String[] oValeurs){
		setReq("INSERT INTO "+oTable+setInternalNameFieldTable(champ)+" VALUES "+setInternalNameValueTable(oValeurs));
		execute(oConnection);
	}
	/**
	 * Méthode d'execution de la requête SQL d'insertion
	 * @param Une Connexion
	 */
	private void execute(Connection oConnection){
		try{
			Statement st = oConnection.createStatement();
			st.execute(getReq());
			st.close();
		}catch(Exception e){
			System.out.println("Erreur d'insertion");
		}
	}
	private String setInternalNameValueTable(String[] oValue){
		String str = "(";
		for(int i=0;i<oValue.length;i++){
			if(oValue.length-1 == i)
			{
				if(oValue[i] == null){
					str += ""+ oValue[i]+"";
				}else{
					str += "'"+ oValue[i]+"'";
				}
			}else{
				if(oValue[i] == null){
					str += ""+ oValue[i]+",";
				}else{
					str += "'"+ oValue[i]+"',";
				}
			}
		}
		str += ")";
		return str;
	}
	private String setInternalNameFieldTable(String[] oField){
		String str = "(";
		for(int i=0;i<oField.length;i++){
			if(oField.length-1 == i)
			{
				str += "`"+ oField[i]+"`";
				
			}else{
				str += "`"+ oField[i] +"`,";
			}
		}
		str += ")";
		return str;
	}
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	private String setInternalNameTable(String nameTable){
		return nameTable;
	}
	public String getFieldTable() {
		return fieldTable;
	}
	public void setFieldTable(String fieldTable) {
		this.fieldTable = fieldTable;
	}
	public String getReq() {
		return req;
	}
	private void setReq(String req) {
		this.req = req;
	}
}
