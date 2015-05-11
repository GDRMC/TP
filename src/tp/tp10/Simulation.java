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
    private boolean end = false;
    
    Simulation(){ 
        simuler();
    }
    
    public void simuler(){
        ajouterGuerriers(20,10);
        //vieillissement
        while(!this.end){
            for(int i=0;i<simul.size();i++){
                vieillirEtAfficheClan(simul.get(i));
                this.end=isAllDecime();
            }
        }
    }
    
    private void ajouterGuerriers(int nbC, int nbG){
        for(int i=0;i<nbC;i++){
            simul.add(new Clan());
            for(int j=0;j<nbG;j++){
                simul.get(i).ajouter(new Guerrier());
            }
        }   
    }
    
    private int calcMoyAgeClan(Clan cl){
        int moy = 0;
        for(int i=0;i<cl.getList().size();i++){
            moy+=cl.getList().get(i).getAge();
        }
        return moy/cl.getList().size();
    }
    
    private void vieillirEtAfficheClan(Clan cl){
        for(int i=0;i<cl.getList().size();i++){ //par clan
            simul.get(i).vieillir();
            //simul = simul.get(i).nettoyer();
            System.out.println("La moyenne d'âge du clan est de "+calcMoyAgeClan(cl)+" ans");
            System.out.println("Clan "+i+" "+simul.get(i).toString());
        }
    }
    
    private boolean isAllDecime(){
        boolean end = true;
        for(int i=0;i<this.simul.size();i++){
            if(!this.simul.get(i).estDecime()){
                end = false;
            } 
        }
        return end;
    }
}
