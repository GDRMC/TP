package tp.tp11;

import java.io.*; // Pour pouvoir utiliser les exceptions li�es aux fichiers
import java.io.File ; // Pour pouvoir cr�er les objets de manipulation de fichiers
import java.io.FileReader ;
import java.io.StreamTokenizer ;

class exercice1

{


public static void main(String args[])throws IOException 
{
	
String chemin = "D:/JavaTest/texte.txt" ;

/********** Utilisation de la classe FILE ***************/
//Crée une instance de fichier texte1.txt à la source du projet
File f = new File("C:/Users/USER/Documents/NetBeansProjects/TP/src/texte1.txt");

if(f.exists()){ System.out.println("Le fichier existe dans l'arborescence"); } 
else { System.out.println("Le fichier n'existe pas dans l'arborescence"); }

System.out.println("Le fichier parent est: '"+f.getParent()+"'");

File folder = new File(f.getParent());
String[]list = folder.list();
System.out.println("La liste des fichiers du dossier est:");
for(int i=0;i<list.length;i++){
    System.out.println(list[i]);
}

	
/********** Utilisation de la classe FILEREADER ***************/	
	

/********** Utilisation de la classe FILEWRITER ***************/	
	
 
/********** Utilisation de la classe STREAMTOKENIZER ***************/ 

	
/********* Ecrire dans un fichier avec BufferedWriter ******/	



} // Fin du main


}//fin de la classe