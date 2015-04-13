package td.td7;

import java.io.*; // Pour pouvoir utiliser les fichiers
class Personne
{

// D�finition des attributs d'une personne
private int id ;
private String nom ;
private String prenom ;
private char genre ;
private int anneeNaiss ;
private String groupe ;
private int categorie ;

// Pour m�moriser le nombre de personnes d�j� cr�ees, accessible via Personnes.nbPers 
private static int nbPers = 0 ;


/********** Constructeurs **********/
// Constructeur sans param�tre
Personne(){nbPers++ ;this.id = nbPers ;} ;

// Constructeur avec param�tres
Personne(String leNom, String lePrenom, char leGenre, int lAnnee, String leGroupe,  int laCategorie)
{
	nbPers++ ;
	this.id = nbPers ;
	this.nom = leNom ;
	this.prenom = lePrenom ;
	this.genre = leGenre ;
	this.anneeNaiss = lAnnee ;
	this.groupe = leGroupe ;
	this.categorie = laCategorie ;
}


/********** Getters ****************/
// Pour conna�tre les valeurs stock�es dans une personne
public int getId() 		{ return this.id ; }
public String getNom() 		{ return this.nom ; }
public String getPrenom() 	{ return this.prenom ; }
public boolean estHomme() 	{ return this.genre == 'h' ; }
public boolean estFemme() 	{ return this.genre == 'f' ; }
public int getAnneeNaiss()      { return this.anneeNaiss ; }
public String getGroupe() 	{ return this.groupe ; }
public int getCategorie() 	{ return this.categorie ; }


/********* Setters *****************/
// Pour modifier les valeurs stock�es dans une personne
public void setGroupe(String leGroupe) { this.groupe = leGroupe ; }
public void setCategorie(int laCategorie) { this.categorie = laCategorie ; }

/******** Affichage **************/

public void afficher()
{
	String naissance = "né en "  ;
	if(this.estFemme()) naissance = "née en " ;
	System.out.println(this.prenom +" " + this.nom + ", " + naissance + this.anneeNaiss + ", " + this.groupe + " de catégorie " + this.categorie) ;
}

// Les �tudiants ecrirons la m�thode toString


/********* Fichiers **************/
// Lit une personne dans un fichier
	public void lireDansFichier(StreamTokenizer entree) throws IOException
	{
		entree.nextToken() ;
		this.id=(int)entree.nval ;
		entree.nextToken() ;
		this.nom=entree.sval ;
		entree.nextToken() ;
		this.prenom=entree.sval ;
		entree.nextToken() ;
		this.genre=entree.sval.charAt(0) ;
		entree.nextToken() ;
		this.anneeNaiss=(int)entree.nval ;
		entree.nextToken() ;
		this.groupe=entree.sval ;
		entree.nextToken() ;
		this.categorie=(int)entree.nval ;
	}

} // Fin de la classe Personne