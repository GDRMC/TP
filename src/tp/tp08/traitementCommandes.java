package tp.tp08;

import java.io.*; // Pour pouvoir utiliser les fichiers
import java.util.ArrayList ;
import java.io.File ; // Pour pouvoir cr�er les objets de manipulation de fichiers
import java.io.FileReader ;
import java.io.StreamTokenizer ;
import java.text.DecimalFormat ;
import java.util.Arrays ;
class traitementCommandes
{
	
	public static void main(String[] args) throws IOException
	{
            //Lignes de commande
            LigneDeCommande line1 = new LigneDeCommande(1, "Pizza Bolognaise", 1, 6.54);
            LigneDeCommande line2 = new LigneDeCommande(1, "Supp Bolognaise", 1, 1.00);
            LigneDeCommande line3 = new LigneDeCommande(2, "Pizza Oignons", 2, 4.99);
            System.out.println(line1.getArticle()+" "+line1.getNumero()+"\n");
            //Ajout dans un ArrayList
            ArrayList<LigneDeCommande>lines = new ArrayList();
            lines.add(line1);
            lines.add(line2);
            lines.add(line3);
            //Affichage des noms de l'arraylist des lignes de commande
            for (int i=0;i<lines.size();i++) {
                System.out.println(lines.get(i).getArticle());
            }
            //
            System.out.println("\n"+lines.get(1).toString()+"\n");
            ArrayList<LigneDeCommande>fromFile = lectureFichier("lignesDeCommande.txt");
            
            afficher(fromFile);
            System.out.println("\nPrix total: "+prixTotal(fromFile)+"€");
            int numCommandeTotalvar = 9;
            System.out.println("\nPrix total commande n°"+numCommandeTotalvar+": "+prixCommande(fromFile,numCommandeTotalvar)+"€\n");
            afficherCommande(fromFile,numCommandeTotalvar);
            System.out.println("\nLa commande 9:");
            lignesDeLaCommande(fromFile,numCommandeTotalvar);
            afficher(lignesDeLaCommande(fromFile,numCommandeTotalvar));
            System.out.println("\nToutes les lignes de commandes sans la commande 9:");
            ArrayList<LigneDeCommande>moins=new ArrayList();
            moins=lignesSansLaCommande(fromFile,numCommandeTotalvar);
            afficher(moins);
            
            //Teste un arraylist de numéros de commandes
            int[]numCommandes=numeroCommandes(fromFile);
            
            //affiche le tout
            System.out.println("\n\n==| AFFICHAGE GLOBAL ORDONNE DES COMMANDES |==");
            afficherCommandes(fromFile,numCommandes);
            
            ecrireDansFichier("FichierSortie.txt",fromFile,numeroCommandes(fromFile));
	}
        
        //methode d'affichage globale
        public static void afficherCommandes(ArrayList<LigneDeCommande>a,int[]numCommandes){
            DecimalFormat formatter = new DecimalFormat(".00");
            for(int c=0;c<numCommandes.length&&numCommandes[c]!=-1;c++){
                //Charge le numéro de la commande
                int numC = numCommandes[c];
                //Charge le total de la commande
                double totalC = prixCommande(a,numCommandes[c]);
                //Calcul du nombre de lignes pour une commande
                int cptArtC = 0;
                for(LigneDeCommande li : a){
                    if(li.getNumCommande() == numC){
                        cptArtC++;
                    }
                }
                System.out.println("Commande n°"+numC+" : "+cptArtC+" articles pour un montant de "+formatter.format(totalC)+"€");
                afficherCommande(a,numCommandes[c]);
            }
        }
        
        //methode implémentée pour l'affichage
        public static int nombreArticles(ArrayList<LigneDeCommande> a, int numCommande) {
            int nbArticles = 0;
            for(int i=0;i<a.size();i++){
                if(a.get(i).getNumCommande()==numCommande){
                    i++;
                    nbArticles++;
                }
            }
            return nbArticles;
        }
        
        public static void afficher(ArrayList<LigneDeCommande>a){
            for(int i=0;i<a.size();i++){
                System.out.println(a.get(i).toString());
            }
        }
        
        public static double prixTotal(ArrayList<LigneDeCommande>a){
            double prixTotal = 0;
            for(int i=0;i<a.size();i++){
                prixTotal+=a.get(i).getPrix();
            }
            //System.out.println(prixTotal);
            return prixTotal;
        }
        
        public static double prixCommande(ArrayList<LigneDeCommande>a,int numCommande){
            double prixTotalCommande = 0;
            for(int i=0;i<a.size();i++){
                if(a.get(i).getNumCommande()==numCommande){
                    prixTotalCommande+=(a.get(i).getPrixUnitaire()*a.get(i).getQuantite());
                }
            }
            //System.out.println(prixTotal);
            return prixTotalCommande;
        }
        
        public static void afficherCommande(ArrayList<LigneDeCommande>a,int numCommande){
            for(int i=0;i<a.size();i++){
                if(a.get(i).getNumCommande()==numCommande){
                    System.out.println(a.get(i).toString());
                }
            }
        }
        
        public static ArrayList<LigneDeCommande> lignesDeLaCommande(ArrayList<LigneDeCommande>lignes,int numCommande){
            ArrayList<LigneDeCommande>toReturn = new ArrayList();
            for (LigneDeCommande ligne : lignes) {
                if (ligne.getNumCommande() == numCommande) {
                    toReturn.add(ligne);
                }
            }
            return toReturn;
        }
        
        public static ArrayList<LigneDeCommande> lignesSansLaCommande(ArrayList<LigneDeCommande>lignes,int numCommande){
            ArrayList<LigneDeCommande>toReturn = new ArrayList();
            for (LigneDeCommande ligne : lignes) {
                if (ligne.getNumCommande() != numCommande) {
                    toReturn.add(ligne);
                }
            }
            return toReturn;
        }
        
        public static int[] numeroCommandes(ArrayList<LigneDeCommande>lignes){
            int[]tab = new int[20];
            int cursorTab = 0;
            
            for(LigneDeCommande ligne : lignes){
                int num = ligne.getNumCommande();
                boolean isInTab = false;
                int i;
                //teste si la valeur est dans le tableau
                for(i=0;i<tab.length;i++){
                    if(tab[i]==num){
                        isInTab=true;
                    }
                }
                if(!isInTab){
                    tab[cursorTab]=num;
                    cursorTab++;
                }else{
                    
                }
            }
            tab[cursorTab]=-1;
            return tab;
        }
	
	public static ArrayList<LigneDeCommande> lectureFichier(String nomFichier) throws IOException
	{
		ArrayList<LigneDeCommande> resultat ;
		resultat = new ArrayList() ;
		
		FileReader fr = new FileReader(nomFichier) ;
		
		LigneDeCommande li = new LigneDeCommande() ;
		while(li.lireDansFichier(fr))
		{
				resultat.add(li) ;
				li = new LigneDeCommande() ;	
		}
		return resultat ;
	}
        
        public static void ecrireDansFichier(String nomFichier,ArrayList<LigneDeCommande>commandes,int[]numCommandes) throws IOException{
            File file = new File(nomFichier);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            
            DecimalFormat formatter = new DecimalFormat(".00");
            for(int c=0;c<numCommandes.length&&numCommandes[c]!=-1;c++){
                //Charge le numéro de la commande
                int numC = numCommandes[c];
                //Charge le total de la commande
                double totalC = prixCommande(commandes,numCommandes[c]);
                //Calcul du nombre de lignes pour une commande
                int cptArtC = 0;
                for(LigneDeCommande li : commandes){
                    if(li.getNumCommande() == numC){
                        cptArtC++;
                    }
                }
                addCommandToFile("Commande n°"+numC+" : "+cptArtC+" articles pour un montant de "+formatter.format(totalC)+"€",writer);
                addCommandDetailsToFile(commandes,numC,writer);
            }
            writer.close();
        }
        
        public static void addCommandToFile(String line, FileWriter writer) throws IOException{
            writer.write(line+"\n");
        }
        
        public static void addCommandDetailsToFile(ArrayList<LigneDeCommande>a,int numCommande, FileWriter writer) throws IOException{
            for (LigneDeCommande lignes : a) {
                if (lignes.getNumCommande() == numCommande) {
                    writer.write(lignes.toString()+"\n");
                }
            }
        }
}