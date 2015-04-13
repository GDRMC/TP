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
class Guerrier
{
	// Attributs d'un Guerrier
        private String nom;
                
        private int age;
        
        private double force,
                experience,
                etatSante;

	// Attribut commun à tous les Guerriers
	private static int nb = 0 ; // Nombre total de Guerriers créés
	
	
	// Constantes 
	private final static int forceMin = 1, forceMax = 5 ;
	private final static int santeMin = 0, santeMax = 100, limiteFaiblesse = 40 ;
	private final static int impactBlessure = -10 ; // Perte de santé pour un combat perdu
	private final static int gainExperience = 1 ; // Gain d'expérience pour un combat remporté 
	private final static int experienceMin = 0, experienceMax = 10 ;
	private final static int ageMinDepart = 20, ageMaxDepart = 50 ;
	private final static int limiteJeunesse = 30, limiteVieillesse = 50 ;
	private final static int chanceMax = 10 ;
	private final static int DELTA_ETAT_RENF = 5,			// Un guerrier dont l'état de santé s'améliore gagne ce nombre d'unité
                                DELTA_ETAT_AFFAIBL = -7	;		// Un guerrier dont l'état de santé se détériore perd ce nombre d'unité
		  
	
	private static final double
		CHANCE_RENF_JEUNE_SAIN = 0.6 , 	// Un guerrier jeune et sain possède 60% de chance d'améliorer son état
		CHANCE_RENF_JEUNE_FAIBLE = 0.5,
		CHANCE_RENF_ADULTE_SAIN = 0.7 ,
		CHANCE_RENF_ADULTE_FAIBLE = 0.6,
		CHANCE_RENF_VIEUX_SAIN = 0.4 ,
		CHANCE_RENF_VIEUX_FAIBLE = 0.2				 
				;

	
	
	// Constructeurs
	
	
		
	/************ Méthodes **************/
	
	// Getteurs	de niveau 1
	
	
		
	// Getteurs de niveau 2
	
	
	// Setteurs de niveau 1
	
	
	
	
	// Setteurs de niveau 2
		
	
	
	
	// Autres
	
	
	public void evoluer()
	{
		int delta = 0 ;
		if(this.estJeune())
			if(!this.estFaible())
				if(chance(CHANCE_RENF_JEUNE_SAIN)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;
			else 
				if(chance(CHANCE_RENF_JEUNE_FAIBLE)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;
		
		if(this.estAdulte())
			if(!this.estFaible())
				if(chance(CHANCE_RENF_ADULTE_SAIN)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;
			else 
				if(chance(CHANCE_RENF_ADULTE_FAIBLE)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;				

		if(this.estVieux())
			if(!this.estFaible())
				if(chance(CHANCE_RENF_VIEUX_SAIN)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;
			else 
				if(chance(CHANCE_RENF_VIEUX_FAIBLE)) delta = DELTA_ETAT_RENF; else delta= DELTA_ETAT_AFFAIBL ;					
	
		this.modifierSante(delta) ;
	}
	
	
	/*********** Préparation à l'affichage  : méthode toString ******************/
	
	
	
		
	/************ Outils locaux (private) **********************/
	private static boolean chance(double x) {		return Math.random()<x ;	}
	
	private int entierAleatoire(int min, int max){ return (int)(min+(max+1-min)*Math.random()) ;}
	
	

}
