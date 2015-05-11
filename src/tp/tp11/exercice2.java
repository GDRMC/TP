package tp.tp11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;

public class exercice2 {
    public static void main(String[]args) throws FileNotFoundException, IOException{
        
        int lines = 0;
        File f = new File("C:/Users/USER/Documents/NetBeansProjects/TP/src/scores.txt");
        
        try{
            //compte le nombre de lignes du fichier pour plus tard
            LineNumberReader  lnr = new LineNumberReader(new FileReader(f));
            lnr.skip(Long.MAX_VALUE);
            lines = lnr.getLineNumber()+1;
            lnr.close();
        } catch(Exception e){ }
        
            
        //Création des listes de noms et de scores
        //String[]noms = new String[lines+1]; //DESACTIVE
        double[]score = new double[lines+1];
        
        //remplissage des listes
        try{
            StreamTokenizer stream = new StreamTokenizer(new FileReader(f));
            int curseur = 0;
            while(stream.ttype != StreamTokenizer.TT_EOF){
                //récupère le nom
                stream.nextToken();
                //noms[curseur]=stream.sval; //DESACTIVE
                //récupère le score
                stream.nextToken();
                score[curseur]=stream.nval;
                //incrémente le curseur de ligne
                curseur++;
            }
            System.out.println("Le fichier a été lu par le programme");
        } catch(IOException e){ System.out.println("Une erreur est survenue lors de la récupération des données de scores"); }
        
        //calcul score moyen
        int moy = 0;
        double max = score[0];
        for(int i=0;i<score.length;i++){
            moy = moy+(int)score[i];
            if(score[i]>max){
                max=score[i];
            }
        }
        moy=moy/score.length;
        
        // ecriture dans le fichier de sortie
        try{
            FileWriter output = new FileWriter(new File("C:/Users/USER/Documents/NetBeansProjects/TP/src/resultats_ex2.txt"));
            output.write("La moyenne des scores est: "+moy);
            output.write("\nLe score maximal est: "+max);
            output.write("\nLe nombre de scores est: "+score.length);
            output.close();
            System.out.println("Les résultats ont été écrits dans le fichier");
        } catch(IOException e){ System.out.println("Une erreur est survenue lors de l'écriture dans le fichier de résultats"); }
    }
}
