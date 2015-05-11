package tp.tp11;

import java.io.*; // Pour pouvoir utiliser les exceptions li�es aux fichiers
import java.io.File ; // Pour pouvoir cr�er les objets de manipulation de fichiers
import java.io.FileReader ;
import java.io.StreamTokenizer ;
import java.util.ArrayList;

class exercice1

{


public static void main(String args[])throws IOException 
{
	
String chemin = "D:/JavaTest/texte.txt" ;

//Crée une instance de fichier texte1.txt à la source du projet
File f = new File("C:/Users/USER/Documents/NetBeansProjects/TP/src/texte1.txt");
File f2 = new File("C:/Users/USER/Documents/NetBeansProjects/TP/src/copie.txt");

/********** Utilisation de la classe FILE ***************/
System.out.println("\n\n====FILE====");

if(f.exists()){ System.out.println("Le fichier existe dans l'arborescence"); } 
else { System.out.println("Le fichier n'existe pas dans l'arborescence"); }

System.out.println("Le fichier parent est: '"+f.getParent()+"'");

File folder = new File(f.getParent());
String[]list = folder.list();
System.out.println("La liste des fichiers du dossier est:");
for(int i=0;i<list.length;i++){
    System.out.println(list[i]);
}
double b = f.length();
System.out.println(b+" B");
 
/********** Utilisation de la classe STREAMTOKENIZER ***************/ 
System.out.println("\n\n====STREAMTOKENIZER====");
//REUTILISATION DE F POUR L'UTILISATION DE LA CLASSE FILE
StreamTokenizer entree = new StreamTokenizer(new FileReader(f.getAbsolutePath()));
if (entree.ttype ==  StreamTokenizer.TT_EOF){ System.out.println("Erreur de fichier StreamTokenizer"); }
while(entree.ttype != StreamTokenizer.TT_EOF){
    entree.nextToken();
    if(entree.ttype == StreamTokenizer.TT_NUMBER) {
        String buffer1=String.valueOf(entree.nval);
        System.out.println("Le nombre "+buffer1+" a été trouvé");
    }
}


	
/********* Ecrire dans un fichier avec BufferedWriter ******/
System.out.println("\n\n====BUFFERWRITER====");

StreamTokenizer entree2 = new StreamTokenizer(new FileReader(f.getAbsolutePath()));
ArrayList<String>content1 = new ArrayList(); //Objet contenu pour classe bufferedwriter

while(entree2.ttype != StreamTokenizer.TT_EOF){
    //remplissage pour bufferedwriter
    entree2.nextToken();
    //PROBLEME A CORRIGER: PAS DE DETECTION DE FIN DE LIGNE OU DE FICHIER (?!)
    if(entree2.ttype == StreamTokenizer.TT_EOL){
        content1.add("!"); //saut de ligne car EOL
    } else if(entree2.ttype == StreamTokenizer.TT_EOF){
        content1.add("#"); //fin de fichier EOF
    } else if(entree2.ttype == StreamTokenizer.TT_WORD){
        content1.add(entree2.sval+" ");
    } else if(entree2.ttype == StreamTokenizer.TT_NUMBER){
        content1.add(String.valueOf(entree2.nval+" "));
    }
}
BufferedWriter f4 = new BufferedWriter(new FileWriter(f2));
try {
    for(int i=0;i<content1.size();i++){
        String buffer = content1.get(i).toString();
        if(buffer.equals("!")){ 
            //vaut un saut de ligne si !
            f4.newLine();
            System.out.println("Un saut de ligne a été inséré");
        } 
        else if(buffer.equals("#")){
            f4.close();
            System.out.println("La fin du fichier a été atteinte. Fin du flux de copie");
        }
        else {
            f4.write(buffer);
            System.out.println("Insertion: "+buffer);
        } 
    }
    System.out.println("Le fichier a été copié");
} catch(Exception e) {
    System.out.println("Une erreur est survenue lors de l'écriture dans le fichier");
    System.out.println(e.toString());
}


/********** Utilisation de la classe FILEREADER ***************/
 

/********** Utilisation de la classe FILEWRITER ***************/	
	


} // Fin du main


}//fin de la classe