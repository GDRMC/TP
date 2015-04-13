/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.tp10;

/**
 *
 * @author GDRMc
 */
public class TP9_10 {
    public static void main(String[]args){
        //GUERRIER
        //A
        //crée deux guerriers
        Guerrier g1 = new Guerrier("Hector le Barbare");
        Guerrier g2 = new Guerrier("Jean le Moustachu");
        System.out.println(g1.toString()+"\n"+g2.toString());
        
        //fait vieillir les deux guerriers d'un an
        g1.vieillir();
        g2.vieillir();
        System.out.println(g1.toString()+"\n"+g2.toString());
        
        //affaiblit le premier guerrier jusqu'à ce qu'on atteigne le seuil de faiblesse
        System.out.println("===> Affaiblissement g1");
        while(!g1.estFaible()){
            g1.modifierSante(-1);
            System.out.println(g1.toString());
        }
        System.out.println("Le guerrier est maintenant faible");
        
        //test méthodes
        System.out.println("===> Affaiblissement g2");
        while(!g2.estFaible()){
            g2.modifierSante(-1);
            System.out.println(g2.toString());
            System.out.println(g2.affichage());
        }
        System.out.println("Le guerrier est maintenant faible");
        
        //B
        Guerrier g3 = new Guerrier("Alphonce le rapide");
        Guerrier gC = new Guerrier("La Muraille");
        System.out.println(g3.toString()+"\n"+gC.toString());
        System.out.println("===>Combat");
        while(g3.estVivant()&&gC.estVivant()){
            g3.combattre(gC);
            System.out.println(g3.toString()+"\n"+gC.toString());
        }
        if(g3.estMort()){
            System.out.println(g3.getNom()+" est mort");
        }else{
            System.out.println(gC.getNom()+" est mort");
        }
        
        //C
        System.out.println("===>Evolution et vieillissement");
        Guerrier g4 = new Guerrier("Mr Sale le poisseux");
        System.out.println(g4.toString());
        while(g4.estVivant()){
            g4.vieillir();
            System.out.println(g4.toString());
        }
        System.out.println(g4.getNom()+" est mort");
        
        //CLAN
        
    }
}
