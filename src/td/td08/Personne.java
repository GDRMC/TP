/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td08;

/**
 *
 * @author Grégory
 */
class Personne {
    private int numero;
    private String nom;
    private String prenom;
    Personne(){ }
    Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
    String getNom() {
        return this.nom;
    }
    String getPrenom(){
        return this.prenom;
    }
    int getNumero() {
        return this.numero;
    }
    void setNom(String nom){
        this.nom = nom;
    }
    void setPrenom(String prenom){
        this.prenom = prenom;
    }
    void setNumero(int numero){
        this.numero = numero;
    }
}
