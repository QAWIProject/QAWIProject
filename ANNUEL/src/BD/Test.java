package BD;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) throws IOException {
		try{
			Class.forName("javax.mail.Session");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			  FileInputStream inf = new FileInputStream("src/conf/IDCONNECT.txt");
			  DataInputStream dain = new DataInputStream(inf);
			  BufferedReader bufr = new BufferedReader(new InputStreamReader(dain));
			  
			  String ligne;
			  String serveur = "",user = "",password= "";
			  int nbLigne = 0;
			  //Read File Line By Line
			  while ((ligne = bufr.readLine()) != null){
				  if(nbLigne == 0){
					  serveur = ligne;
				  }else if(nbLigne == 1){
					  user = ligne;
				  }else{
					  password = ligne;
				  }
				  nbLigne++;
			  }
			  System.out.println("Host : "+serveur+"\nUser : "+user+"\nPassword : "+password);
			  dain.close();
		}catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
}


