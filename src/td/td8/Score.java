/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.td8;

/**
 *
 * @author Grégory
 */
class Score {
    private int numPersonne;
    private int resultat;
    Score(){ }
    Score(int n, int r){
        this.numPersonne = n;
        this.resultat = r;
    }
    int getNumPers() {
        return this.numPersonne;
    }
    void setNumPersonne(int n){
        this.numPersonne = n;
    }
    
    int getResultat() {
        return this.resultat;
    }
    void setResultat(int r){
        this.resultat = r;
    }
}
