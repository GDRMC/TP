package tp.tp10;

import java.util.Random;

/**
 *
 * @author GDRMc
 */
class Guerrier
{
	// Attributs d'un Guerrier
        private String nom;
        
        private int force,
                experience,
                etatSante,
                age;

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
	Guerrier(String nom){ 
            this.experience = experienceMin;
            this.age = entierAleatoire(ageMinDepart,ageMaxDepart);
            this.etatSante = entierAleatoire(santeMin,santeMax);
            this.force = entierAleatoire(forceMin,forceMax);
            this.nom = nom;
        }
        Guerrier(){
            this.experience = experienceMin;
            this.age = entierAleatoire(ageMinDepart,ageMaxDepart);
            this.etatSante = entierAleatoire(santeMin,santeMax);
            this.force = entierAleatoire(forceMin,forceMax);
            this.nom = "Anonyme";
        }
	
		
	/************ Méthodes **************/
        //Assesseurs
	public int getForce(){ return this.force; }
        public int getExperience(){ return this.experience; }
        public String getNom(){ return this.nom; }
        
        public void modifierExperience(int n){
            this.experience+=n;
        }
        public void modifierSante(int n){
            this.etatSante+=n;
        }
	
	// Autres
        public void vieillir(){ this.age+=1; this.evoluer(); }
	
        public boolean estMort(){
            if(this.etatSante<=0){
                return true;
            }else{
                return false;
            }
        }
        public boolean estVivant(){ 
            if(this.etatSante>0){
                return true;
            }else{
                return false;
            }
        }
        public boolean estFaible(){
            if(this.etatSante<this.limiteFaiblesse){
                return true;
            }else{
                return false;
            }
        }
        public boolean estAdulte() {
            if(this.age<=50&&this.age>=30){
                return true;
            }else{
                return false;
            }
        }

        public boolean estVieux() {
            if(this.age>50){
                return true;
            }else{
                return false;
            }
        }

        public boolean estJeune() {
            if(this.age<30){
                return true;
            }else{
                return false;
            }
        }
        public char affichage(){
            if(!this.estFaible()){
                return '|';
            }else{
                return '/';
            }
        }
        
        public void combattre(Guerrier adversaire){
            int diffExp = this.experience-adversaire.experience;
            int diffForce = this.force-adversaire.force;
            int aleatoire = entierAleatoire(-this.chanceMax,this.chanceMax);
            if(diffExp+diffForce+aleatoire<=0){
                //l'adversaire gagne
                adversaire.experience+=this.gainExperience;
                this.etatSante+=this.impactBlessure;
            }else{
                //l'adversaire perd
                this.experience+=this.gainExperience;
                adversaire.etatSante+=this.impactBlessure;
            }
        }
	
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
	public String toString(){
            String trancheAge = "";
            if(this.estJeune()){
                trancheAge="jeune";
            }else if(this.estAdulte()){
                trancheAge="adulte";
            }else if(this.estVieux()){
                trancheAge="vieux";
            }
            String toReturn =
                    "Le guerrier "+this.nom+
                    " a "+this.force+
                    " points de force, "+this.etatSante+
                    " points de vie, "+this.experience+
                    " points d'expérience, et est agé de "+this.age+
                    " ans, Il est donc "+trancheAge;
            return toReturn;
        }
        
	/************ Outils locaux (private) **********************/
	private static boolean chance(double x) {		return Math.random()<x ;	}
	
	private int entierAleatoire(int min, int max){ return (int)(min+(max+1-min)*Math.random()) ;}

}
