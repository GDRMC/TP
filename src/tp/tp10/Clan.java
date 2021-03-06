package tp.tp10;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author GDRMc
 */
public class Clan {
    private ArrayList<Guerrier>elements = new ArrayList();
    private String nom;
    
    Clan(String nom){ this.nom=nom; }
    Clan(){ this.nom="Clan Anonyme"; }
    
    public void ajouter(Guerrier g){ this.elements.add(g); }
    public void vieillir(){ 
        for(int i=0;i<elements.size();i++){
            elements.get(i).vieillir();
        }
    }
    public String toString(){
        String toReturn = "Le clan '"+this.nom+"' est composé de "+elements.size()+" guerrier(s)\n";
        for(int i=0;i<elements.size();i++){
            String toAdd = (elements.get(i).toString()+"\n");
            toReturn = toReturn + toAdd;
        }
        return toReturn;
    }
    
    public boolean estDecime(){
        boolean decime = true;
        for(int i=0;i<elements.size();i++){
            if (!elements.get(i).estMort()){
                decime = false;
            }
        }
        return decime;
    }
    
    public Clan guerriersValides(){
        Clan valides = new Clan();
        for(int i=0;i<this.elements.size();i++){
            if(!this.elements.get(i).estFaible()){
                valides.ajouter(this.elements.get(i));
            }
        }
        return valides;
    }
    
    public Clan nettoyer(){
        ArrayList<Guerrier>newl = new ArrayList();
        for (int i=0;i<elements.size();i++){
            if(!elements.get(i).estMort()){
                newl.add(elements.get(i));
            }
        }
        Clan tr = new Clan();
        for (int i=0;i<newl.size();i++){
                tr.ajouter(newl.get(i));
        }
        return tr;
    } 
    
    public String affichage(){
        String toReturn = "";
        for(int i=0;i<elements.size();i++){
            String toAdd = String.valueOf(elements.get(i).affichage());
            toReturn = toReturn + toAdd;
        }
        return toReturn;
    }
    
    public int getPlusVieux(){
        if(!this.estDecime()){
            Guerrier toReturn = this.elements.get(0);
            for(int i=0;i<this.elements.size();i++){
                if(this.elements.get(i).getAge()>=toReturn.getAge()){
                    toReturn = this.elements.get(i);
                }
            }
            return toReturn.getAge();
        }
        return 0;
    }
    

    public ArrayList<Guerrier> getList(){
       return this.elements; 
    }
}
