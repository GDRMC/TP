package tp.tp11;

public class Score {
    private String nom;
    private double score;
    
    Score(String nom, double score){
        this.nom = nom;
        this.score = score;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public double getScore(){
        return this.score;
    }
}
