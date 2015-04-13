///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package td.td8;
//
//import java.util.ArrayList;
///**
// *
// * @author Grégory
// */
//public class Td8j {
////1. Prise en main des structures de données
//public static void main(String[]args){
//ArrayList<Personne> u;
//u = new ArrayList();
//Personne p1 = new Personne ();
//Personne p2 = new Personne ();
//u.add(p1);
//u.add(p2);
//}
//
//public static void afficherPersonnes ( ArrayList<Personne> u ) {
//	for ( int i=0 ; i<u.size ; i++ ) {
//		System.out.println( u.get(i).getNom() );
//	}
//}
//
//public static Personne personneDeNumero ( ArrayList<Personne> ps, int n ) {
//	int i=0 ;
//	while( i<ps.size && ps.get(i).getNumero()!=n ) {
//		i++;
//	}
//	if ( i<ps.size() ) {
//		return ps.get(i);
//	} else {
//		return null ;
//	}
//}
//
//question 4 {
//ArrayList<Personne> joueurs;
//joueurs = new ArrayList();
//System.out.println( personneDeNumero(joueurs,5).getNom() );
//}
//
////2.Gestion des scores obtenus durant un jeu
//public static void afficherScores ( Arraylist<Score> top, ArrayList<Personne> joueurs ) {
//	for ( Score s : top ) {
//		Personne p=personneDeNumero(joueurs,s.getNumPers());
//		System.out.println(p.getNom() + " " + p.getPrenom + " a obtenu " + s.getResultat + " points");
//	}
//}
//
//public static int meilleurScore ( Arraylist<Score> top ) {
//	int scoreMax = 0;
//	for ( Score s : top ) {
//		if ( s.getResultat()>scoreMax ) {
//			scoreMax=s.getResultat();
//		}
//	}
//	return scoreMax;
//}
//
//public static ArrayList scoresDuJoueur ( ArrayList<Score> top, int n ) {
//	ArrayList<Score> listeScores = new ArrayList();
//	for ( Score s : top ){
//		if ( s.getNumPers()==n ) {
//			listeScores.add( s.getResultat );
//		}
//	}
//	return listeScores;
//}
//
//public static void ajouterScore ( int n, int nbPoint , ArrayList<Score> listeScores ) {
//	
//}
//=========================================*/