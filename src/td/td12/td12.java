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
    
    //Insertion à la meilleure place
    public static void inserer(ArrayList<Personne>l,Personne p){
        int i=0;
        while(i<l.size()&&p.getAnneeNaissance()>=l.get(i).getAnneeNaissance()){
            i++;
        }
        l.add(i--, p);
    }
    
    //Tri d'ArrayList à la meilleure place
    public static ArrayList<Personne> trier(ArrayList<Personne>l){
        ArrayList<Personne>newtab = new ArrayList();
        for(int i=0;i<l.size();i++){
            inserer(newtab,l.get(i));
        }
        return newtab;
    }
    
    //Recherche dichotomique à partir d'un tableau trié
    public static int position(ArrayList<Personne>l,int a){
        ArrayList<Personne>newtab = new ArrayList();
        int min=0, max=l.size()-1, pos=(max+min)/2;
        while(min<max&&a!=l.get(pos).getAnneeNaissance()){
            if(a<l.get(pos).getAnneeNaissance()){
                max = pos-1;
            }
            else{
                min = pos+1;
            }
            pos = (max+min)/2;
        }
        if(a==l.get(pos).getAnneeNaissance()){
            int i=pos;
            while(l.get(i-1).getAnneeNaissance()==a){
                i--;
            }
            return i;
        }else{
            return -1;
        }
    }
}
