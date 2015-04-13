/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td8;

import java.util.ArrayList;

/**
 *
 * @author Grégory
 */
public class Td8 {
    public static void main(String[]args){
        ArrayList<Personne> list = new ArrayList();
        Personne p1 = new Personne("Martin","Jean-Patrick");
        Personne p2 = new Personne("Dupont","Célestin");
        list.add(p1);
        list.add(p2);
        
        ArrayList<Personne> joueurs = new ArrayList();
        if(personneDeNumero(joueurs,2)!=null){
            System.out.println(personneDeNumero(joueurs,2).getNom());
        }
        ArrayList<Score> top = new ArrayList();
    }
    public static void afficherPersonnes(ArrayList<Personne> a){
        /*for(Personne e : a){
            System.out.println(e.get(a).getNom());
        }*/
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).getNom());
        }
    }
    public static Personne personneDeNumero(ArrayList<Personne> a,int n){
        Personne p = null;
        int cpt = 0;
        while(a.get(cpt).getNumero()!=n&&cpt<=a.size()){
            if(a.get(cpt).getNumero()==n){
                p = a.get(n);
            }
            cpt++;
        }
        return p;
    }
    public static String nomPersonneJoueursParNumero(ArrayList<Personne> a,int n){
        String nom = null;
        int i = 0;
        while(a.get(i).getNumero()!=n&&i<=a.size()){
            if(a.get(i).getNumero()==n){
                nom = a.get(i).getNom();
            }
            i++;
        }
        return nom;
    }
    
    public static void afficherScores(ArrayList<Score> s,ArrayList<Personne> j){
	for(int i=0;i<s.size();i++){
		Personne p=personneDeNumero(j,s.get(i).getNumPers());
		System.out.println(p.getPrenom()+" "+p.getNom()+" a obtenu "+s.get(i).getResultat()+" points");
	}
    }
    
    public static Score meilleurScore(ArrayList<Score> s){
        Score best = s.get(0);
        for(int i=0;i<s.size();i++){
            if(best.getResultat()<s.get(i).getResultat()){
                best = s.get(i);
            }
        }
        return best;
    }
    
    public static double scoreMoyenDuJoueur(ArrayList<Score> s,int n){
        double somme=0;
        int nb=0;
        for(int i=0;i<s.size();i++){
            if(s.get(i).getNumPers()==n){
                somme+=s.get(i).getResultat();
                nb++;
            }
        }
        return somme/nb;
    }
    
    public static ArrayList<Score> addScore(ArrayList<Score> s,int n){
        ArrayList<Score> u = new ArrayList();
        for(int i=0;i<s.size();i++){
            if(s.get(i).getNumPers()==n){
                u.add(s.get(i));
            }
        }
        return u;
    }
}
