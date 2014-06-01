package Timer;

import java.util.Calendar;

import javax.swing.JLabel;

public class Compteur extends Thread {
  private String nom;
  private int max;
  // Gestion du Calendrier avec heure de début et heure de fin
  private Calendar rightNow = Calendar.getInstance();
  private Calendar newCalendar = ajoutMinutes(rightNow,60);
  public Compteur(String nom, int max) {
    this.nom = nom;
    this.max = max;
  }
  public void run(){
    for (int i = 1; i <= max; i++) {
      try{
        sleep(1000);
      } 
      catch(InterruptedException e) {
        System.err.println(nom + " a ete interrompu.");
      }
      System.out.println(i);
    }
    System.out.println("*** " + nom + " à terminer son amélioration " + max);
  }
  public static void main(String[] args){
    Compteur compteur = new Compteur("Usine",40);
    compteur.start();
  }
  /**
   * Ajoute le nombre de minutes à une date donnée
   * @param oCalendar
   * @param nbMinute
   * @return Calendar
   */
  public Calendar ajoutMinutes(Calendar oCalendar,int nbMinute){
	oCalendar.add(Calendar.MINUTE, nbMinute);
	return oCalendar;
  }
  /**
   * Recupère le temps sous forme de JLabel
   * @return JLabel
   */
  public JLabel getTime(){
		JLabel affEvent = new JLabel();
		affEvent.setText("Amélioration sera terminé à \n"+ Integer.toString(newCalendar.get(Calendar.HOUR_OF_DAY))+" h "+Integer.toString(newCalendar.get(Calendar.MINUTE)));
		return affEvent;
  }
}