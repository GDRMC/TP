import java.io.*; // Pour pouvoir utiliser les fichiers
import java.text.DecimalFormat ;


public class LigneDeCommande
{
// ATTRIBUTS d'un objet de la classe LigneDeCommande
	private int numero ;
	private int numCommande ;
	private String article ;
	private int quantite ;
	private double prixUnitaire ;
	
	// Variable de classe (pour num�roter automatiquement les lignes de commande
	// Les variables statiques sont partag�es par tous les objets de cette classe
	private static int nbLignesCommande = 0 ;
	
// METHODES : les op�ration applicables aux objets de la classe LigneDeCommande
	
	// Constructeurs
	LigneDeCommande()
	{ // Sans param�tre
		nbLignesCommande++ ;
		this.numero = nbLignesCommande ;
	}
	
	LigneDeCommande(int leNumCommande, String larticle, int laQte, double lePU)
	{ // Avec param�tre : pour initialiser une LigneDeCommande lors de sa cr�ation
		nbLignesCommande++ ;
		this.numero = nbLignesCommande ;
		this.numCommande = leNumCommande ;
		this.article = larticle ;
		this.quantite = laQte ;
		this.prixUnitaire = lePU ;
	}
	
	// Getters
	public int getNumero(){return this.numero ;}
	public int getNumCommande(){return this.numCommande ;}
	public String getArticle(){return this.article ;}
	public int getQuantite(){return this.quantite ;}
	public double getPrixUnitaire(){return this.prixUnitaire ;}
	
	public double getPrix(){return this.quantite*this.prixUnitaire ;}
	
	// Setters
	public void setNumCommande(int leNumCommande){ this.numCommande = leNumCommande ;}
	public void setArticle(String larticle){ this.article = larticle ;}
	public void setQuantite(int laQte){ this.quantite = laQte ;}
	public void setPrixUnitaire(double lePU){ this.prixUnitaire = lePU ;}
	
	// Pr�paration � l'affichage
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("##.00€ ") ;
		return "Ligne n°" + this.numero + "\tCommande n°" + this.numCommande + "\t" + this.quantite +" x "+ this.article + "\tP.U : " + df.format(this.prixUnitaire)  ;
		// \t permet de placer une tabulation dans une chaine de caract�res
	}
			
	// Lecture dans un fichier
	public boolean lireDansFichier(FileReader fic) throws IOException
	{
	 	String buffer;	
		StreamTokenizer entree = new StreamTokenizer(fic);
		entree.nextToken() ;
		if (entree.ttype ==  StreamTokenizer.TT_EOF) return false ;
		
		this.numero=(int)entree.nval ;
		
		entree.nextToken() ;
		this.numCommande=(int)entree.nval ;
		
		entree.nextToken() ;
		this.article=entree.sval ;
		
		entree.nextToken() ;
		this.quantite=(int)entree.nval ;
		
		entree.nextToken() ;
		this.prixUnitaire=(double)entree.nval ;
		
		return true ;
	}

}