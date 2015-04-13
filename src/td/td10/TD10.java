/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td10;

public class TD10 {
    public static void main(String[]args){
        Resultat r1=new Resultat(2,4,127324,12.5);
        System.out.println(r1);
        System.out.println(r1.getNote());
        r1.setNote(13);
        
        EnsembleResultats ens = new EnsembleResultats();
        ens.inserer(r1);
    }
}
