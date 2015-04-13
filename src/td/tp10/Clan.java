package td.tp10;

import java.util.ArrayList;

/**
 *
 * @author GDRMc
 */
public class Clan {
    private ArrayList<Guerrier>elements;
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
        String toReturn = "Le clan"+this.nom+" est composé de \n";
        for(int i=0;i<elements.size();i++){
            toReturn.concat(elements.get(i).toString()+"\n");
        }
        return toReturn;
    }
    
}
