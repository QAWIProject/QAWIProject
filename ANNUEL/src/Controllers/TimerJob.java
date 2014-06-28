package Controllers;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import BD.Connexion;
import Model.ModelLayer;
	 
	public class TimerJob extends TimerTask {
	    @Override
	    public void run() {
	    	// Debut du timer
	        System.out.println("Début du Timer "+new Date());
	        //Traitement
	        completeTask();
	        //Fin du timer
	        System.out.println("Fin du Timer "+new Date());
	    }
	    private void completeTask(){
	        try {
	        	Connexion con = new Connexion("QAWI","Localhost","root","root");
	            // Definit 20 secondes d'attentes pour que la tache se termine
	        	ModelLayer mod = new ModelLayer();
	        	mod.addRessourcesAllUsine();
	            Thread.sleep(60000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void main(String args[]){
	        TimerJob timerTask = new TimerJob();
	        //Met en marche le timer
	        Timer timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 1000);
	        System.out.println("TimerTask started");
	        //cancel after sometime
	        //try {
	        //    Thread.sleep(120000);
	        //} catch (InterruptedException e) {
	        //    e.printStackTrace();
	       //}
	        //timer.cancel();
	        //System.out.println("TimerTask cancelled");
	        try {
	            Thread.sleep(30000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	 
	}
