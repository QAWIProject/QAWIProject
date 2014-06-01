public class Compteur extends Thread {
  private String nom;
  private int max;
  public Compteur(String nom, int max) {
    this.nom = nom;
    this.max = max;
  }
  public void run() {
    for (int i = 1; i <= max; i++) {
      try {
        sleep(1000);
      } 
      catch(InterruptedException e) {
        System.err.println(nom + " a ete interrompu.");
      }
      System.out.println(i);
    }
    System.out.println("*** " + nom + " ˆ terminer son amŽlioration " + max);
  }

  public static void main(String[] args) {
    Compteur compteur = new Compteur("Usine",40);
      compteur.start();
  }
  
}