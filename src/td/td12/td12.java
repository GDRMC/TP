/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td12;

import java.util.ArrayList;

/**
 *
 * @author GDRMc
 */
public class td12 {
    public static void main(String[]args){
        ArrayList<Personne>liste = new ArrayList();
        Personne p = new Personne("Toto",1975);
        inserer(liste,p);
        liste.add(new Personne("Nul",1980));
        liste.add(new Personne("Yolo",1984));
        liste.add(new Personne("Pas de nom",1992));
        liste=trier(liste);
    }
    
    public static void inserer(ArrayList<Personne>l,Personne p){
        int i=0;
        while(i<l.size()&&p.getAnneeNaissance()>=l.get(i).getAnneeNaissance()){
            i++;
        }
        l.add(i--, p);
    }
    
    public static ArrayList<Personne> trier(ArrayList<Personne>l){
        ArrayList<Personne>newtab = new ArrayList();
        for(int i=0;i<l.size();i++){
            inserer(newtab,l.get(i));
        }
        return newtab;
    }
    
    
}
