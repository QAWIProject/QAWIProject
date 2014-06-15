package com.qawi.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;






public class Acceuil {

	  
	 
	  private Accueil  gui = new Accueil ();
	  



	  class Accueil  extends javax.swing.JFrame 
	  {
	
	    
	    public Accueil () {
	      super();
	      lancementAccueil();
	    }
	    
	    private void lancementAccueil () {
	      try {
	    	// Création de la barre de menu
	          JMenuBar menu= new JMenuBar();

	    // Création d'un "bouton" "Jouer" dans la barre de menu
	          JMenu menuPlay = new JMenu("Jouer");
	          
	    // Création d'un élément du menu « Inscription »
	          JMenuItem inscription = new JMenuItem("Inscription");
	          
	    // Ajout d'un élément (Inscription ) au menu nommé Jouer
	          menuPlay.add(inscription);
	          
	    // Création d'un deuxième élément du menu « Connexion »
	          JMenuItem connexion = new JMenuItem("Connexion");
	          
	    // Ajout d'un élément (connexion) au menu nommé Jouer
	          menuPlay.add(connexion);
	    // Ajout du "bouton" Joueur à la barre de menu
	          menu.add(menuPlay);

	          JMenu admin = new JMenu("Administration");
	          JMenuItem adminConnect = new JMenuItem("Connexion");
	          admin.add(adminConnect);
	          admin.addActionListener(null);
	          JMenuItem aPropos=  new JMenuItem("A propos");
	          admin.add(aPropos);
	          

	    // Ajout du "bouton" Administration à la barre de menu
	          menu.add(admin);

	    // Permet de définir le menu utilisé dans la JFrame
	          this.setJMenuBar(menu);
	          
	          
	          
	          /*Le conteneur principal (c'est à dire le Jframe) contiendra un nouvel objet de type AfficheImage 
	          auquel on passera en paramètre  le chemin de l'image*/
	          this.setContentPane(new AfficheImage("E:\\mybc.jpg"));

	                  // le conteneur principal se servira d'une grille de placement de type  BorderLayout
	                  this.getContentPane().setLayout(new BorderLayout());

	                  // Création d'un nouvel objet de type JPanel
	                  JPanel jpHaut = new JPanel();
	                  JPanel jpCentre = new JPanel();
	                  JPanel jpGauche= new JPanel();
	                  JPanel jpBas= new JPanel();
	                  JPanel jpWest= new JPanel();
	                  JPanel jpEast= new JPanel();

	                  // le fond de ce JPanel sera transparent
	                  jpHaut.setOpaque(false);

	                  // Création d'un nouvel objet de type JLabel
	                  //JLabel jlNom = new JLabel("Bienvenue  sur QAWI");

	                  // Ajout du JLabel nommé  jlNom au JPanel nommé  jpHaut
	                 // jpHaut.add(jlNom);
	                  JLabel lNomJoueurCon = new JLabel("Nom de joueur: ");
	                  lNomJoueurCon.setForeground(Color.WHITE);
	                  JTextField tFNomJoueurCon = new JTextField(10);
	                  jpHaut.add(lNomJoueurCon);
	                  jpHaut.add(tFNomJoueurCon);
	                  
	                  JLabel lMdpCon = new JLabel("Mot de passe: "); 
	    	          JPasswordField pfMdpCon = new JPasswordField(10);
	    	          lMdpCon.setForeground(Color.WHITE);
	                  jpHaut.add(lMdpCon);
	                  jpHaut.add(pfMdpCon);
	                  
	                  JButton bLogin = new JButton("Login");
	                  jpHaut.add(bLogin);

	                  // Création d'un nouvel objet de type Jpanel
	                  
	                  JLabel cr = new JLabel("Copyright Ivan KLARMAN - Quentin TOUATIOUI - Walson RENE ");
	                  jpBas.add(cr);
	                  
	                  
	                  

	                  // Création d'un nouvel objet de type JButton
	                  //JButton btOK= new JButton("ok");

	                  // Le fond de ce JPanel sera transparent
	                  jpBas.setOpaque(false);
	                  jpHaut.setOpaque(false);
	                  jpGauche.setOpaque(false);
	                  jpCentre.setOpaque(false);
	                  jpWest.setOpaque(false);
	                  jpEast.setOpaque(false);
	                  
	                  

	                  // Ajout du JButton nommé  btOK au JPanel nommé jpBas
	                  //jpBas.add(btOK);

	                  // Ajout des deux JPanel au JFrame
	                  jpWest.setPreferredSize(new Dimension(300, 50));
	                  jpEast.setPreferredSize(new Dimension(300, 50));
	                  this.add(jpWest, BorderLayout.WEST);
	                  this.add(jpEast, BorderLayout.EAST);
	                  this.add(jpHaut, BorderLayout.NORTH);
	                  this.add(jpBas, BorderLayout.SOUTH);
	                  
	    	          GridBagLayout gbl = new GridBagLayout();
	    	          jpGauche.setLayout(gbl);
	                  
	                  GridBagConstraints gbc = new GridBagConstraints();
	                  
	                  
	                  JLabel lNomJoueur = new JLabel("Nom de joueur: ");
	                  JTextField tFNomJoueur = new JTextField(10);
	                  lNomJoueur.setForeground(Color.WHITE);
	                  gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 0;
	                  gbl.setConstraints(lNomJoueur, gbc);
	                  jpGauche.add(lNomJoueur, gbc);
	                  
	                  gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 1;
	                  gbl.setConstraints(tFNomJoueur, gbc);
	                  jpGauche.add(tFNomJoueur);

	                  
	                  
	                  JLabel lMdp = new JLabel("Mot de passe: "); 
	    	          JPasswordField pfMdp = new JPasswordField(10);
	    	          lMdp.setForeground(Color.WHITE);
	                  gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 2;
	                  gbl.setConstraints(lMdp, gbc);
	                  jpGauche.add(lMdp);
	                  
	                  gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 3;
	                  gbl.setConstraints(pfMdp, gbc);
	                  jpGauche.add(pfMdp);
	    	          
	    	          JLabel lMail = new JLabel("Adresse mail: "); 
	    	          JTextField tFMail = new JTextField(10);
	    	          lMail.setForeground(Color.WHITE);
	    	          gbc.fill = gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 4;
	                  gbl.setConstraints(lMail, gbc);
	    	          jpGauche.add(lMail);
	    	          
	    	          gbc.fill = gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 5;
	                  gbl.setConstraints(tFMail, gbc);
	                  jpGauche.add(tFMail);
	                  
	                  
	    	          JCheckBox cbCgu = new JCheckBox("J'accepte les CGU et la Déclaration de confidentialité");
	    	          gbc.fill = gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 6;
	                  gbl.setConstraints(cbCgu, gbc);
	    	          jpGauche.add(cbCgu);
	    	          
	                  
	                  JButton bInscription = new JButton("S'inscrire");
	    	          gbc.fill = gbc.fill =GridBagConstraints.NONE;
	                  gbc.gridx = 0;
	                  gbc.gridy = 7;
	                  gbl.setConstraints(bInscription, gbc);
	                  jpGauche.add(bInscription);
	    	          


	    	          
	    	          
	    	          jpCentre.setLayout(new BorderLayout());
	    	          jpCentre.add(jpGauche, BorderLayout.CENTER);
	    	          
	    	          


	    	          this.add(jpCentre, BorderLayout.CENTER);

	                  // La taille de la fenêtre sera adaptée à la taille des composants
	                  this.pack();

	                  // Le JFrame s'ouvrira au milieu de l'écran
	                  this.setLocationRelativeTo(null);

	                  this.setVisible(true);
	              
	          


	          // Création de la classe AfficheImage héritant de la classe JPanel



	        this.setTitle(" Welcome "+" QAWI ");
	        this.setSize(1024, 768);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  }
	  


}





