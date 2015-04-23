/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td12;

import td.td08.*;

/**
 *
 * @author Grégory
 */
class Personne {
    private String nom;
    private int anneeNaissance;
    Personne(){ }
    Personne(String nom, int anneeNaissance){
        this.nom = nom;
        this.anneeNaissance = anneeNaissance;
    }
    String getNom() {
        return this.nom;
    }
    int getAnneeNaissance() {
        return this.anneeNaissance;
    }
   
    void setNom(String nom){
        this.nom = nom;
    }
    
    void setAnneeNaissance(int annee){
        this.anneeNaissance = annee;
    }
}
