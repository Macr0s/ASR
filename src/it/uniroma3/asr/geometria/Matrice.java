package it.uniroma3.asr.geometria;

/**
 * Questa classe gestisce le matrici e le operazioni su di 
 * essa necessarie per l'algorimo del simplesso rivisto
 * 
 * @author Matteo Filippi
 * @version 0.1
 * @see Vettore
 *
 */
public class Matrice {
	private float[][] matrice;
	
	/**
	 * Questo costruttore serve per inizializzare
	 * l'istanza con una matrice vuota
	 * 
	 * @param r il numero di righe
	 * @param c il numeor di colonne
	 */
	public Matrice(int r, int c){
		this.matrice = new float[r][c];
	}
	
	/**
	 * Questo costruttore serve per inizializzare l'istanza 
	 * partendo da un'altra matrice già esistente
	 * 
	 * @param m La matrice già esistente
	 */
	public Matrice(Matrice m){
		this(m.getNumRiga(), m.getNumColonne());
		for (int i = 0; i < m.getNumRiga(); i++){
			for (int j = 0; j < m.getNumColonne(); j++){
				this.addElemento(i, j, m.getElemento(i, j));
			}
		}
		
	}
	
	/**
	 * Questo costuttore server per inzializzare l'istanza 
	 * partendo da una matrice già esistente modificando il numero di
	 * colonne e il numero di righe
	 * 
	 * @param m la matrice di partenza
	 * @param max_r il numero massimo di righe
	 * @param max_c il numero massimo di colonne
	 */
	public Matrice(Matrice m, int max_r, int max_c){
		this(max_r, max_c);
		for (int i = 0; i < ((m.getNumRiga() < max_r)?m.getNumRiga():max_r); i++){
			for (int j = 0; j < ((m.getNumColonne() < max_c)?m.getNumColonne():max_c); j++){
				this.addElemento(i, j, m.getElemento(i, j));
			}
		}
	}
	
	/**
	 * Questo metodo permette di aggiungere un nuovo 
	 * elemento alla matrice
	 * 
	 * @param r la riga di destinazione
	 * @param c la colonna di destinazione
	 * @param el l'elemento da aggiungere in quella posizione
	 * @return true se l'elemento è stato aggiunto altrimenti false
	 */
	public boolean addElemento(int r, int c, float el){
		if (r >= this.matrice.length && c >= this.matrice[0].length){
			return false;
		}
		this.matrice[r][c] = el;
		return true;
	}
	
	/**
	 * Questo metodo restituisce il numero di colonne
	 * 
	 * @return il numeor di colonne
	 */
	public int getNumColonne(){
		return this.matrice[0].length;
	}
	
	/**
	 * Questo metodo restituisce l'elemento nella posizione desiderata
	 * 
	 * @param r la riga desiderata
	 * @param c la colona residerata
	 * @return l'elemento desiderato
	 */
	public float getElemento(int r, int c){
		if (r >= this.matrice.length && c >= this.matrice[0].length){
			return 0;
		}
		
		return this.matrice[r][c];
	}
	
	/**
	 * Questo metodo restituisce il numero di righe
	 * 
	 * @return il numero di righe
	 */
	public int getNumRiga(){
		return this.matrice.length;
	}
	
	/**
	 * Questo metodo rimuove una riga della matrice
	 * 
	 * @param r la riga da rimuovere
	 */
	public void removeRiga(int r){
		float[][] nuova = new float[this.matrice.length -1][this.matrice[0].length];
		int nuova_i = 0;
		
		for (int i = 0; i < this.getNumRiga(); i++){
			if (i != r){
				for (int j = 0; j < this.getNumColonne(); j++){
					nuova[nuova_i][j] = this.matrice[i][j];
				}
				nuova_i = nuova_i + 1;
			}
		}
		this.matrice = nuova;
	}
	
	/**
	 * Questo metodo rimuove una colonna della matrice
	 * 
	 * @param c la colonna della matrice
	 */
	public void removeColonna(int c){
		float[][] nuova = new float[this.getNumRiga()][this.getNumColonne() -1];
		int nuova_j = 0;
		
		for (int i = 0; i < this.getNumRiga(); i++){
			nuova_j = 0;
			for (int j = 0; j < this.getNumColonne(); j++){
				if (c != j){
					nuova[i][nuova_j] = this.matrice[i][j];
					nuova_j = nuova_j + 1;
				}
			}
		}
		this.matrice = nuova;
	}
	
	/**
	 * Questo metodo restituisce la colonna desiderata
	 * 
	 * @param c la colonna desiderata
	 * @return il vettore che corrisponde a quella colonna
	 */
	public Vettore getColonna(int c){
		if (c >= this.matrice[0].length) return null;
		Vettore v = new Vettore(this.matrice.length);
		
		for (int i = 0; i < this.matrice.length; i ++){
			v.addElemento(i, this.matrice[i][c]);
		}
		
		return v;
	}
	
	/**
	 * Questo metodo restituisce la riga desiderata
	 * 
	 * @param r la riga desiderata
	 * @return il vettore che corrisponde a quella riga
	 */
	public Vettore getRiga(int r){
		if (r >= this.matrice.length) return null;
		Vettore v = new Vettore(this.matrice[0].length, true);
		
		for (int j = 0; j < this.matrice[0].length; j++){
			v.addElemento(j, this.matrice[r][j]);
		}
		
		return v;
	}
	
	/**
	 * Questo metodo controllo se due matrici sono uguali
	 * 
	 * @param m la matrice da controllare con quella attuale
	 * @return true se sono uguali altrimenti false
	 */
	public boolean equals(Matrice m){
		if (this.getNumColonne() != m.getNumColonne() && this.getNumRiga() != m.getNumRiga()){
			return false;
		}
		
		for(int i = 0; i < this.getNumRiga(); i++){
			for (int j = 0; j < this.getNumColonne(); j++){
				if (m.getElemento(i, j) != this.matrice[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Questo metodo crea una nuova colonna dopo la colonna desiderata
	 * 
	 * @param c la colonna da spostare a destra
	 */
	public void addNuovaColonna(int c){
		Matrice nuova = new Matrice(this.getNumRiga(), this.getNumColonne() + 1);
		
		int nuova_j = 0;
		for(int i = 0; i < nuova.getNumRiga(); i++){
			nuova_j = 0;
			for(int j = 0; j < nuova.getNumColonne(); j++){
				if (j == c){
					nuova.addElemento(i, j, 0);
				}else{
					nuova.addElemento(i, j, this.getElemento(i, nuova_j));
					nuova_j = nuova_j + 1;
				}
			}
		}
		
		this.matrice = nuova.getMatrice();
	}
	
	/**
	 * Questo metodo crea una nuova riga dopo laa riga desiderata
	 * 
	 * @param r la riga da spostare in alto
	 */
	public void addNuovaRiga(int r){
		Matrice nuova = new Matrice(this.getNumRiga() + 1, this.getNumColonne());
		
		int nuova_i = 0;
		for(int i = 0; i < nuova.getNumRiga(); i++){
			for(int j = 0; j < nuova.getNumColonne(); j++){
				if (i == r)
					nuova.addElemento(i, j, 0);
				else
					nuova.addElemento(i, j, this.getElemento(nuova_i, j));
			}
			if (i != r)
				nuova_i = nuova_i + 1;
		}
		
		this.matrice = nuova.getMatrice();
	}
	
	public void addFineColonna(){
		Matrice m = new Matrice(this, this.getNumRiga(), this.getNumColonne() + 1);
		this.matrice = m.getMatrice();
	}
	
	/**
	 * Questo metodo inverte la matrice corrente
	 * 
	 * @return true se è stato possibili eseguire l'iversione altrimenti false
	 */
	public boolean inverti(){
		if (this.getNumColonne() != this.getNumRiga()) return false;
		
		Matrice inversa = new Matrice(this, this.getNumRiga(), 2*this.getNumColonne());
		for(int i = 0; i < this.getNumColonne(); i++){
			inversa.addElemento(i, this.getNumColonne() + i, 1);
		}
		
		for(int i = 0; i < this.getNumColonne(); i++){
			inversa.pivot(i, 0);
			inversa.removeColonna(0);
		}
		
		this.matrice = inversa.getMatrice();
		return true;
	}
	
	/**
	 * Questo metodo restituisce la matrice sottoforma di array
	 * 
	 * @return l'array
	 */
	public float[][] getMatrice(){
		return this.matrice;
	}
	
	/**
	 * Questo metodo moltiplica la matrice corrente con 
	 * quella passata come parametro
	 * 
	 * @param m la seconda matrice da moltiplicare
	 * @return la matrice moltiplicata
	 */
	public Matrice moltiplicazione(Matrice m){
		return Matrice.moltiplicazione(this, m);
	}
	
	/**
	 * Questo metodo moltiplica la matrice corrente con
	 * una costante
	 * 
	 * @param a la costante
	 * @return la matrice moltiplicata
	 */
	public Matrice moltiplicazione(float a){
		return Matrice.moltiplicazione(a, this);
	}
	
	/**
	 * Questo metodo moltiplica la matrice corrente con
	 * un vettore
	 * 
	 * @param v il vettore
	 * @return il vettore risultante
	 */
	public Vettore moltiplicazione(Vettore v){
		return Matrice.moltiplicazione(this, v);
	}
	
	/**
	 * Questo metodo esegue la somma tra la matrice corrente 
	 * e quella passata come parametro
	 * 
	 * @param m la seconda matrice
	 * @return la matrice risultante
	 */
	public Matrice somma(Matrice m){
		return Matrice.somma(this, m);
	}
	
	/**
	 * Questo metodo esegue la sottrazione tra la matrice
	 * corrente e quella passata come parametro
	 * 
	 * @param m la seconda matrice
	 * @return la matrice risultante
	 */
	public Matrice sottrazione(Matrice m){
		return Matrice.sottrazione(this, m);
	}
	
	/**
	 * Questo metodo sostituisce una riga della matrice con 
	 * quella del vettore trasposto
	 * 
	 * @param i la riga da sostituire
	 * @param v il vettore da inserire
	 * @return true se è stato possibile sostituire altrimenti false
	 */
	public boolean sostituisciRiga(int i, Vettore v){
		if (i >= this.getNumRiga() &&
				v.getLength() != this.getNumColonne() &&
				v.isTrasposto()){
			return false;
		}
		for (int j = 0; j < v.getLength(); j++){
			this.addElemento(i, j, v.getElemento(j));
		}
		return true;
	}
	
	/**
	 * Questo metodo sostituisce una colonna della matrice 
	 * con quella del vettore non trasposto
	 * 
	 * @param j la colonna da sostituire
	 * @param v il vettore da inseriri
	 * @return true se è stato possibile sostituire altrimenti false
	 */
	public boolean sostituisciColonna(int j, Vettore v){
		if (this.getNumColonne() >= j &&
				v.getLength() != this.getNumRiga() &&
				!v.isTrasposto()) return false;
		for (int i = 0; i < this.getNumRiga(); i++){
			this.matrice[i][j] = v.getElemento(i);
		}
		return true;
	}
	
	/**
	 * Questo metodo esegue l'operazione di pivot
	 * sulla matrice corrente
	 * 
	 * @param i la riga di pivot
	 * @param j la colonna di pivot
	 */
	public void pivot(int i, int j){
		this.matrice = Matrice.pivot(i, j, this).getMatrice();
	}
	/**
	 * Questo metodo crea una rappresentazione sottoforma
	 * di stringa della matrice corrente
	 * 
	 * @return la rappresentazione stringata
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.getNumRiga(); i++) {
			for(int j = 0; j < this.getNumColonne(); j++){
				s.append(this.matrice[i][j]);
				s.append(" ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	// Metodi statici
	
	/**
	 * Questo metodo esegue l'operazione di moltiplicazione
	 * tra due matrici
	 * 
	 * @param m1 la prima matrice
	 * @param m2 la seconda matrice
	 * @return la matrice risultante
	 */
	public static Matrice moltiplicazione(Matrice m1, Matrice m2){
		if (m1.getNumColonne() != m2.getNumRiga()) return null;
		
		Matrice nuova = new Matrice(m1.getNumRiga(), m2.getNumColonne());
		for (int i = 0; i < nuova.getNumRiga(); i++){
			for (int j = 0; j < nuova.getNumColonne(); j++){
				nuova.addElemento(i, j, m1.getRiga(i).moltiplicazione(m2.getColonna(j)));
			}
		}
		return nuova;
	}
	
	/**
	 * Questo metodo esegue l'operazione di moltiplicazione
	 * tra una costante e la matrice
	 * 
	 * @param a la costante
	 * @param m la matrice
	 * @return la matrice risultate
	 */
	public static Matrice moltiplicazione(float a, Matrice m){
		Matrice nuova = new Matrice(m.getNumRiga(), m.getNumColonne());
		for (int i = 0; i < m.getNumRiga(); i++){
			for (int j = 0; j < m.getNumColonne(); j ++){
				nuova.addElemento(i, j, m.getElemento(i, j) * a);
			}
		}
		return nuova;
	}
	
	/**
	 * Questo metodo esegue l'operazione di moltiplicazione
	 * tra un vettore e una matrice
	 * 
	 * @param v il vettore
	 * @param m la matrice
	 * @return il vettore risultante
	 */
	public static Vettore moltiplicazione(Vettore v, Matrice m){
		if (v.isTrasposto() && m.getNumRiga() == v.getLength()){
			Vettore nuovo = new Vettore(m.getNumColonne(), true);
			for (int i = 0; i < m.getNumColonne(); i++){
				nuovo.addElemento(i, v.moltiplicazione(m.getColonna(i)));
			}
			return nuovo;
		}
		return null;
	}
	
	/**
	 * Questo metodo esegue l'operazione di moltiplicazione
	 * tra una matrice e un vettore
	 * 
	 * @param m la matrice
	 * @param v il vettore
	 * @return il vettore risultante
	 */
	public static Vettore moltiplicazione(Matrice m, Vettore v){
		if (!v.isTrasposto() && m.getNumColonne() == v.getLength()){
			Vettore nuovo = new Vettore(m.getNumRiga());
			for (int i = 0; i < m.getNumRiga(); i++){
				nuovo.addElemento(i, m.getRiga(i).moltiplicazione(v));
			}
			return nuovo;
		}
		return null;
	}
	
	/**
	 * Questo metodo esegue l'operazione di somma tra due matrici
	 * 
	 * @param m1 la prima matrice
	 * @param m2 la secondo matrice
	 * @return la matrice risultante
	 */
	public static Matrice somma(Matrice m1, Matrice m2){
		if (m1.getNumRiga() != m2.getNumRiga() && m1.getNumColonne() != m2.getNumColonne()) return null;
		
		Matrice nuova = new Matrice(m1.getNumRiga(), m1.getNumColonne());
		for (int i = 0; i < m1.getNumRiga(); i++){
			for (int j = 0; j < m1.getNumColonne(); j ++){
				nuova.addElemento(i, j, m1.getElemento(i, j) + m2.getElemento(i, j));
			}
		}
		return nuova;
	}
	
	/**
	 * Questo metodo esegue l'operazione di sottrazione tra due matrici
	 * 
	 * @param m1 la prima matrice
	 * @param m2 la seconda matrice
	 * @return la matrice risultante
	 */
	public static Matrice sottrazione(Matrice m1, Matrice m2){
		if (m1.getNumRiga() != m2.getNumRiga() && m1.getNumColonne() != m2.getNumColonne()) return null;
		
		Matrice nuova = new Matrice(m1.getNumRiga(), m2.getNumColonne());
		for (int i = 0; i < m1.getNumRiga(); i++){
			for (int j = 0; j < m2.getNumColonne(); j ++){
				nuova.addElemento(i, j, m1.getElemento(i, j) - m2.getElemento(i, j));
			}
		}
		return nuova;
	}
	
	private static Vettore pivot_caso1(int r, int c, Matrice m){
		return m.getRiga(r).moltiplicazione(1F/m.getElemento(r, c));
	}
	
	private static Vettore pivot_caso2(int r, int c, int i, Matrice m){
		return m.getRiga(i).sottrazione(m.getRiga(r).moltiplicazione(m.getElemento(i, c)));
	}
	
	/**
	 * Questo metodo implementa l'operazione di pivot
	 * 
	 * @param r la riga di pivot
	 * @param c la colonna di pivot
	 * @param m la matrice sulla quale bisogna eseguire il pivot
	 * @return la matrice risultate
	 */
	public static Matrice pivot(int r, int c, Matrice m){
		Matrice nuova = new Matrice(m);
		nuova.sostituisciRiga(r, Matrice.pivot_caso1(r, c, nuova));
		
		for (int i = 0; i < nuova.getNumRiga(); i++){
			if (i != r){
				nuova.sostituisciRiga(i, Matrice.pivot_caso2(r, c, i, nuova));
			}
		}
		
		return nuova;
	}
}
