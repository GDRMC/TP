/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tp10;

import java.util.ArrayList;

/**
 *
 * @author GDRMc
 */
public class Simulation {
    private ArrayList<Clan>simul = new ArrayList();
    
    Simulation(){ 
        simuler(20,10);
    }
    
    public void simuler(int nbC,int nbG){
        //permet d'ajouter nb sujets de tests dans le clan de simulation
        for(int i=0;i<nbC;i++){
            simul.add(new Clan());
            for(int j=0;j<nbG;j++){
                simul.get(i).ajouter(new Guerrier());
            }
        }
        //vieillissement
        int nbOccur = 0;
        for(int k=0;k<simul.size();k++){
            while(simul.get(k).getList().size()>0){
                System.out.println("=Occurence numéro "+nbOccur+++"=");
                for(int i=0;i<nbC;i++){ //par clan
                    int moy = 0;
                    simul.get(i).vieillir();
                    simul.get(i).nettoyer();
                    for(int j=0;j<simul.size();j++){
                        for(int l=0;l<simul.get(l).getList().size();l++)
                        moy+=simul.get(i).getList().get(i).getAge();
                    }
                    System.out.println("Moyenne d'âge du clan: "+moy/simul.get(i).getList().size());
                    System.out.println("Clan "+i+" "+simul.get(i).toString());
                }
            }
        }
        
    }
}
