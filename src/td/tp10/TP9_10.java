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
        
    }
}
