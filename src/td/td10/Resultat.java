package td.td10;

public class Resultat {
    //Attributs
    private int numMatiere;
    private int numEpreuve;
    private int numEtudiant;
    private double note;
    
    //Constructeurs
    Resultat(){ }
    Resultat(int nMa,int nEp,int nEt,double n){ this.numMatiere=nMa; this.numEpreuve=nEp; this.numEtudiant=nEt; this.note=n; }
    
    //Observateurs
    public int getNumMatiere(){ return this.numMatiere; }
    public int getNumEpreuve(){ return this.numEpreuve; }
    public int getNumEtudiant(){ return this.numEtudiant; }
    public double getNote(){ return this.note; }
    
    //Modificateurs
    public void setNumMatiere(int nMa){ this.numMatiere=nMa; }
    public void setNumEpreuve(int nEp){ this.numEpreuve=nEp; }
    public void setNumEtudiant(int nEt){ this.numEtudiant=nEt; }
    public void setNote(double n){ this.note=n; }
    
    //Méthode d'affichage
    @Override
    public String toString(){ return "L'étudiant "+
            this.getNumEtudiant()+" a reçu la note "+
            this.getNote()+" dans la matière "+
            this.getNumMatiere()+" de l'épreuve "+
            this.getNumEpreuve(); }
}
