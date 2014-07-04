package coolplugin.impl;

import java.awt.Component;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;

import coolplugin.CoolPlugin;
import net.xeoh.plugins.base.Plugin;
import net.xeoh.plugins.base.annotations.PluginImplementation;

@PluginImplementation
public class CoolPluginImpl implements CoolPlugin {
	private JPanel panelGalaxie;
	private JLabel lblGalaxie;
	private Connexion con = new Connexion("QAWI","localhost","root","root");
	
	public Component getPanelGalaxie(){
		panelGalaxie = new JPanel();
		lblGalaxie = new JLabel();
		// Resultat requete
		ResultSet res = getAllUser();
		try{
			while(!res.next()){
				lblGalaxie.setText(lblGalaxie.getText() + res.getString(0)+" \n");
			}
		}catch(Exception e){
		}
		panelGalaxie.add(lblGalaxie);
		return (Component)panelGalaxie;
	}
	public ResultSet getAllUser(){
		SelectData select = new SelectData(con.getConnection(),""
		+"SELECT nom_util "
		+"FROM utilisateur ");
		return select.getResults();
	}
}
