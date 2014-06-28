package plug;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarFile;

public class ChargedPlugin{

		private String[] files;
		
		private ArrayList classPlugin;
		
		/**
		 * Constructeur par defaut
		 *
		 */
		public ChargedPlugin(){
			this.classPlugin = new ArrayList();
		}
		
		/**
		 * Constucteur initialisant le tableau de fichier a charger.
		 * @param files Tableau de String contenant la liste des fichiers a charger.
		 */
		public ChargedPlugin(String[] files){
			this();
			this.files = files;
		}
		
		/**
		 * Defini l'ensemble des fichiers a charger
		 * @param files
		 */
		public void setFiles(String[] files ){
			this.files = files;
		}
		
		/**
		 * Fonction de chargement de tout les plugins de type StringPlugins
		 * @return Une collection de StringPlugins contenant les instances des plugins
		 * @throws Exception si file = null ou file.length = 0
		 */
		public ChargedPlugin[] loadAllStringPlugins() throws Exception {
			
			this.initializeLoader();
			
			Plugin[] tmpPlugins = new Plugin[this.classPlugin.size()];
			
			for(int index = 0 ; index < tmpPlugins.length; index ++ ){
				
				//On creer une nouvelle instance de l'objet contenu dans la liste grace a newInstance() 
				//et on le cast en StringPlugins. Vu que la classe implemente StringPlugins, le cast est toujours correct
				tmpPlugins[index] = (Plugin)((Class)this.classPlugin.get(index)).newInstance() ;
				
			}
			
			return (ChargedPlugin[]) tmpPlugins;
		}
		private void initializeLoader() throws Exception{
			//On verifie que la liste des plugins a charger a ete initialise
			if(this.files == null || this.files.length == 0 ){
				throw new Exception("Pas de fichier specifie");
			}

			//Pour eviter le double chargement des plugins
			if(this.classPlugin.size() != 0 ){
				return ;
			}
			
			File[] f = new File[this.files.length];
			//Pour charger le .jar en memoire
			URLClassLoader loader;
			//Pour la comparaison de chaines
			String tmp = "";
			//Pour le contenu de l'archive jar
			Enumeration enumeration;
			//Pour determine quels sont les interfaces implementees
			Class tmpClass = null;
			
			for(int index = 0 ; index < f.length ; index ++ ){
				
				f[index] = new File(this.files[index]);
				//Eviter les doublons de plug in
				if( !f[index].exists() ) {
					break;
				}
				
				URL u = f[index].toURL();
				//On creer un nouveau URLClassLoader pour charger le jar qui se trouve en dehors du CLASSPATH
				loader = new URLClassLoader(new URL[] {u}); 
				
				//On charge le jar en memoire
				JarFile jar = new JarFile(f[index].getAbsolutePath());
				
				//On recupere le contenu du jar
				enumeration = jar.entries();
				
				while(enumeration.hasMoreElements()){
					
					tmp = enumeration.nextElement().toString();

					//On verifie que le fichier courant est un .class
					if(tmp.length() > 6 && tmp.substring(tmp.length()-6).compareTo(".class") == 0) {
						
						tmp = tmp.substring(0,tmp.length()-6);
						tmp = tmp.replaceAll("/",".");
						
						tmpClass = Class.forName(tmp ,true,loader);
						
						for(int i = 0 ; i < tmpClass.getInterfaces().length; i ++ ){
							//Une classe ne doit pas appartenir a deux categories de plugins differents. 
							//Si tel est le cas on ne la place que dans la categorie de la premiere interface correct
							// trouvee
							if(tmpClass.getInterfaces()[i].getName().toString().equals("plug.Plugin") ) {
								this.classPlugin.add(tmpClass);
							}
						}
						
					}
				}
				
			
			}
			
		}
}