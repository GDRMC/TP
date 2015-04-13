package td.td07;

import java.io.*; // Pour pouvoir utiliser les fichiers
class Principal
{

public static void main(String args[])throws IOException 
{
    //première partie
    Personne p1 = new Personne("Martin","Jean-Célestin",'h',1995,"Etudiant",1);
    Personne p2 = new Personne("Durand","Jean-Patrick",'h',1975,"Employé",2);
    System.out.println(p1.getNom()+" est né(e) en "+p1.getAnneeNaiss()+" et appartient au groupe "+p1.getGroupe());
    System.out.println(p2.getNom()+" est né(e) en "+p2.getAnneeNaiss()+" et appartient au groupe "+p2.getGroupe());
    p1.setGroupe("Stagiaire");
    System.out.println(p1.getNom()+" est né(e) en "+p1.getAnneeNaiss()+" et appartient au groupe "+p1.getGroupe());
    p2.afficher();
    
    //2e partie
    Personne[]echantillon = lirePersonnes("desPersonnes.txt");
    System.out.println("La plus grande date de naissance est "+dateNaissMax(echantillon));
    System.out.println("La personne la plus jeune est "+laPlusJeune(echantillon));
    
    afficherAnalyse(echantillon);
    afficherNomsEchantillon(echantillon);
    int anneeNaissanceChoisie = 1990; //voir instruction suivante
    System.out.println("\nIl y a "+neesEn(echantillon,anneeNaissanceChoisie)+" personnes nées en "+anneeNaissanceChoisie);
    int idChoisi = 3;
    System.out.println("\nIl y a "+sameId(echantillon,idChoisi)+" personnes détenant l'ID "+idChoisi);
    
    //3e partie
    int memeAnnee1990 = 1990;
    Personne[]sameYear = neeMemeAnnee(echantillon,memeAnnee1990);
    
    //4e partie
    System.out.println("\nLa ressemblance entre p1 et p2 est évaluée à "+proximite(p1,p2)+"%");
    
    plusProche(echantillon,p1);//définir la personne la plus proche de p1 dans le tableau
    System.out.println("\nLa personne détenant la plus forte ressemblance avec p1 est "+plusProche(echantillon,p1).getPrenom()+" "+plusProche(echantillon,p1).getNom()+" avec "+proximite(plusProche(echantillon,p1),p1)+"%\n");
    lesPlusProche(echantillon,p1);
    
    //5e partie
    Personne[] supprimerCaseQuatre = supprimerPersonneTableau(echantillon,8); //supprime l'id 8 case 4
    
    //6e partie
    Personne p = echantillon[0];
    p.afficher();
    p.setGroupe("Test"); //réaffectation du groupe vers Test sans modifier le tableau de base des échantillons
    p.afficher();
    
    //7e partie
    System.out.println(p); //ça affiche l'adresse mémoire... Mais avec le type devant!
}
//Constructeur classe Personne:
//Personne(String leNom, String lePrenom, char leGenre, int lAnnee, String leGroupe,  int laCategorie)

public static int dateNaissMax(Personne[]tab){
    int anneeMax = tab[0].getAnneeNaiss();
    for(int i=1;i<tab.length;i++){
        if(anneeMax>tab[i].getAnneeNaiss()){
            anneeMax=tab[i].getAnneeNaiss();
        }
    }
    return anneeMax;
}

public static String laPlusJeune(Personne[]tab){
    String identitePlusJeune = tab[0].getNom()+" "+tab[0].getPrenom();
    int anneePlusJeune = tab[0].getAnneeNaiss();
    for(int i=1;i<tab.length;i++){
        if(anneePlusJeune>tab[i].getAnneeNaiss()){
            anneePlusJeune = tab[i].getAnneeNaiss();
            identitePlusJeune = tab[i].getNom()+" "+tab[i].getPrenom();
        }
    }
    return identitePlusJeune;
}

public static void afficherAnalyse(Personne[]tab){
    //Affiche le nombre de personnes
    System.out.println("Il y a "+tab.length+" personnes dans la liste");
    //Déclaration des variables
    int nbHommes = 0, nbFemmes = 0;
    int sommeAgesHommes = 0, sommeAgesFemmes = 0, sommeAgesPersonnes = 0;
    //boucle de remplissage des variables de statistiques
    for(int i=0;i<tab.length;i++){
        //définit l'age
        int agePersonne = (2015 - tab[i].getAnneeNaiss());
        sommeAgesPersonnes += agePersonne;
        //conditions hommes femmes
        if(tab[i].estHomme()){
            sommeAgesHommes += agePersonne;
            nbHommes++;
        } else {
            sommeAgesFemmes += agePersonne;
            nbFemmes++;
        }
    }
    //Affichage des Statistiques
    System.out.println("\n---|Statistiques|---\nIl y a "+nbHommes+" hommes et "+nbFemmes+" femmes dans l'échantillon\n"+
        "L'age moyen de l'échantillon est de "+sommeAgesPersonnes/tab.length+" ans\n"+
        "L'age moyen des hommes est de "+sommeAgesHommes/nbHommes+" ans\n"+
        "L'age moyen des femmes est de "+sommeAgesFemmes/nbFemmes+" ans\n"+
        "La proportion d'hommes dans l'échantillon est de "+nbHommes*100/tab.length+"%\n"+
        "La proportion de femmes dans l'échantillon est de "+nbFemmes*100/tab.length+"%\n"+
        "--------------------\n"
    );
}

//Procédure qui affiche le nom de toutes les personnes du tableau
public static void afficherNomsEchantillon(Personne[]tab){
    System.out.println("Personnes présentes dans l'échantillon: ");
    for(int i=0;i<tab.length;i++){
        System.out.println(tab[i].getPrenom()+" "+tab[i].getNom());
    }
}

//Retourne le nombre de personnes nées une année donnée
public static int neesEn(Personne[]tab,int anneeATester){
    int nbPersonnes = 0;
    for(int i=0;i<tab.length;i++){
        if(tab[i].getAnneeNaiss()==anneeATester){
            nbPersonnes++;
        }
    }
    return nbPersonnes;
}

//teste le nombre de personnes détenant le même ID dans un échantillon
public static int sameId(Personne[]tab,int idATester){
    int nbPersonnesId = 0;
    for(int i=0;i<tab.length;i++){
        if(tab[i].getId()==idATester){
            nbPersonnesId++;
        }
    }
    return nbPersonnesId;
}

//retourne un tableau de personnes nées une même année (demandée)
public static Personne[]neeMemeAnnee(Personne[]tab,int anneeATester){
    Personne[] temptab = new Personne[tab.length];
    int cursor = 0; //curseur d'écriture du tableau à renvoyer
    for(int i=0;i<tab.length;i++){
        if(tab[i].getAnneeNaiss()==anneeATester){
            temptab[cursor]=tab[i];
            cursor++;
        }
    }
    //valeur sentinelle en fin de remplissage, pour cela on doit créer une personne vide dans le tableau!
    temptab[cursor]=new Personne();
    temptab[cursor].setCategorie(-1);
    return temptab;
}

//fonction de proximité
public static double proximite(Personne p1, Personne p2){
    //L'indice va de 0, pas du tout de ressemblance, à 11 points, ressemblance maximale
    int indiceProximite = 0;
    
    //Si les groupes sont égaux, ajoute 4 au capital proximité, sinon 0
    if(p1.getGroupe().equals(p2.getGroupe())){
        indiceProximite += 4;
    }
    
    //Si la valeur absolue de la différence des deux groupes des personnes est égale à 0, ajoute 4 au capital, si égale à 1, ajoute 2, sinon rien
    if(  Math.abs(p1.getCategorie()-p2.getCategorie())==0  ){
        indiceProximite += 4;
    } else if(  Math.abs(p1.getCategorie()-p2.getCategorie())==  1) {
        indiceProximite += 2;
    }
    
    //Principe identique avec la différence d'âge
    if(  Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==0  ){
        indiceProximite += 4;
    } else if(  Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  1 || Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  2) {
        indiceProximite += 3;
    } else if(  Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  3 || Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  4) {
        indiceProximite += 2;
    } else if(  Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  5 || Math.abs(p1.getAnneeNaiss()-p2.getAnneeNaiss())==  6) {
        indiceProximite += 1;
    }
    //pourcentage sur indice maximal
    return indiceProximite*100/11;
}

public static Personne plusProche(Personne[]tab,Personne aTester){
    Personne laPlusProche = tab[0];
    double maxPercentage = proximite(tab[0],aTester); //pourcentage a mémoriser pour renvoi
    double currentPercentage = 0; //pourcentage curseur i
    //System.out.println("DEBUG: "+maxPercentage+"%"); //debug console
    for(int i=0;i<tab.length;i++){
        currentPercentage = proximite(tab[i],aTester);
        if(currentPercentage>maxPercentage){
            laPlusProche = tab[i];
            maxPercentage = proximite(tab[i],aTester);
        }
    }
    return laPlusProche;
}

public static Personne[] lesPlusProche(Personne[]tab,Personne p1){
    Personne[] tabLesPlusProches = new Personne[tab.length];
    int cursor = 0;
    double maxPercentage = proximite(plusProche(tab,p1),p1);
    //System.out.println("DEBUG: "+maxPercentage);
    for(int i=0;i<tab.length;i++){
        if(proximite(tab[i],p1)==maxPercentage){
            tabLesPlusProches[cursor]=tab[i];
            cursor++;
        }
    }
    //valeur sentinelle en fin de remplissage
    tabLesPlusProches[cursor]=new Personne();
    tabLesPlusProches[cursor].setCategorie(-1);
    return tabLesPlusProches;
}

//supprime une personne d'un tableau par ID
public static Personne[] supprimerPersonneTableau(Personne[]tab,int id){
    Personne[]tabModif = new Personne[tab.length];
    int cursorNewTab = 0; //curseur de placement dans le nouveau tableau
    boolean wasRowDeleted = false; //booleen controlant la suppression de la ligne
    for(int i=0;i<tab.length;i++){
        if(tab[i].getId()!=id){
            tabModif[cursorNewTab]=tab[i];
            cursorNewTab++;
        } else {
            wasRowDeleted = true;
        }
    }
    if(wasRowDeleted){
        //valeur sentinelle en fin de remplissage si jamais la ligne a été supprimée avec succes
        tabModif[cursorNewTab]=new Personne();
        tabModif[cursorNewTab].setCategorie(-1);
    }
    return tabModif;
}

public static Personne[] lirePersonnes(String nomFichier)throws IOException
{
	// Va chercher toutes les personnes contenues dans le fichier et les place dans un tableau de Personne
	// Puis renvoie ce tableau
	Personne[] resultat ;
	
	// Lecteur de fichier
	FileReader fic ;
	fic = new FileReader(nomFichier) ;
	
	// Le premier �l�ment du fichier est le nombre de personnes stock�es dans ce fichier
	// Lire ce nombre
	
	// Un StreamTokenizer est un curseur permettant de parcourir le contenu d'un fichier
	StreamTokenizer entree ;
	entree = new StreamTokenizer(fic);
	
	entree.nextToken() ; // Lire un �l�ment du fichier
	int nbPersonnesDansFichier = (int)entree.nval ; // convertir cet �l�ment en entier
	
	// R�server assez de m�moire pour stocker toutes les personnes
	resultat = new Personne[nbPersonnesDansFichier] ;
	for(int i = 0 ; i<nbPersonnesDansFichier ; i++)
	{
		Personne p = new Personne() ; // Cr�er une nouvelle personne
		p.lireDansFichier(entree); // Lire ses attributs dans le fichier
		resultat[i] = p ; // La stocker dans le tableau
	}
	return resultat ;
}




}//fin de la classe