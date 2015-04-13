package td.td10;

import java.util.ArrayList;

public class EnsembleResultats {
    //Attributs
    private ArrayList<Resultat>results;
    
    //Constructeur
    EnsembleResultats(){ this.results=new ArrayList(); }
    
    //Modificateurs
    public void inserer(Resultat r){ this.results.add(r); }
    public void supprimerNieme(int n){ this.results.remove(n); }
    
    //Observateur
    public Resultat getNieme(int n){ return this.results.get(n); }
    public int nb(){ return this.results.size(); }
    
    //Méthodes de haut niveau
    public double moyenne(int etu, int m){ 
        ArrayList<Resultat>etuMatched=new ArrayList();
        int somme=0;
        int n=0;
        for(int i=0;i<this.nb();i++){
            if(this.getNieme(i).getNumEtudiant()==etu&&this.getNieme(i).getNumMatiere()==m){
                somme+=this.getNieme(i).getNote();
                n++;
            }
        }
        return somme/n;
    }
    
    public EnsembleResultats resultatsMatiere(int mat){
        EnsembleResultats r = new EnsembleResultats();
        for(int i=0;i<this.nb();i++){
            if(this.getNieme(i).getNumMatiere()==mat){
                r.inserer(this.getNieme(i));
            }
        }
        return r;
    }
    
    public String toString(EnsembleResultats e){
        String toReturn = "";
        for(int i=0;i<e.nb();i++){
            toReturn = toReturn+e.getNieme(i).toString()+"\n";
        }
        return toReturn;
    }
}
