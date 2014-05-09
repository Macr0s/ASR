package it.uniroma3.asr.geometria;

/**
 * Questa classe gestisce un vettore
 * 
 * @author Matteo Filippi
 * @version 0.1
 * @see Matrice
 *
 */
public class Vettore {
	private float[] vettore;
	private boolean trasposto;
	
	/**
	 * Questo costruttore crea un vettore vuoto
	 * 
	 * @param r il numero di posizioni del vettore
	 */
	public Vettore(int r){
		this.vettore = new float[r];
		this.trasposto = false;
	}
	
	/**
	 * Questo costruttore crea un vettore vuoto trasposto oppure no
	 * 
	 * @param r il numero di posizioni del vettore
	 * @param t determina se il vettore è trasposto oppure no
	 */
	public Vettore(int r, boolean t){
		this.vettore = new float[r];
		this.trasposto = t;
	}
	
	public Vettore(Vettore v){
		this(v.getLength(), v.isTrasposto());
		for(int i = 0; i < this.getLength(); i++){
			this.addElemento(i, v.getElemento(i));
		}
	}
	
	/**
	 * Questo metodo aggiunge un elemento al vettore
	 * 
	 * @param i la posizione del vettore
	 * @param el l'elemento da aggiungere
	 * @return true se l'elemento è stato aggiunto altrimento false
	 */
	public boolean addElemento(int i, float el){
		if (i < this.vettore.length){
			this.vettore[i] = el;
			return true;
		}
		return false;
	}

	/**
	 * Questo metodo restituisce l'elemento nella posizione desiderata
	 * 
	 * @param i la posizione desiderata
	 * @return l'elemento nella posizione desiderata
	 */
	public float getElemento(int i){
		if (i >= this.vettore.length){
			return 0;
		}
		return this.vettore[i];
	}
	
	/**
	 * Questo metodo rimuove una posizione del vettore
	 * 
	 * @param l la posizione da rimuovere
	 */
	public void removeElemento(int l){
		int j = 0;
		float[] nuovo = new float[this.vettore.length - 1];
		for (int i = 0; i < this.vettore.length; i ++){
			if (l != j){
				nuovo[j] = vettore[i];
			}
		}
		this.vettore = nuovo;
	}
	
	/**
	 * Questo metodo determinare se il vettore è trasposto oppure no
	 * 
	 * @return true se il vettore è trasposto altrimenti false
	 */
	public boolean isTrasposto() {
		return this.trasposto;
	}
	
	/**
	 * Questo metodo imposta se il vettore è trasposto oppure no
	 * 
	 * @param trasposto true se il vettore è trasposto altrimento false
	 */
	public void setTrasposto(boolean trasposto) {
		this.trasposto = trasposto;
	}
	
	/**
	 * Questo metodo restituisce la dimensione del vettore
	 * 
	 * @return la dimensione del vettore
	 */
	public int getLength(){
		return this.vettore.length;
	}
	
	/**
	 * Questo metodo determina se due vettori sono uguali
	 * 
	 * @param v il secondo vettore da confrontare
	 * @return true se i due vettori sono uguali altrimenti false
	 */
	public boolean equals(Vettore v){
		if (v.getLength() != this.vettore.length){
			return false;
		}
		
		for(int i = 0; i < this.vettore.length; i++){
			if (v.getElemento(i) != this.vettore[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Questo metodo esegue la moltiplicazione tra il vettore 
	 * corrente e un secondo vettore
	 * 
	 * @param v un secondo vettore
	 * @return il risultato
	 */
	public float moltiplicazione(Vettore v){
		return Vettore.moltiplicazione(this, v);
	}
	
	/**
	 * Questo metodo moltiplica il vettore corrente
	 * per una costante
	 * 
	 * @param f la costante
	 * @return il vettore di destinazione
	 */
	public Vettore moltiplicazione(float f){
		return Vettore.moltiplicazione(f, this);
	}
	
	/**
	 * Questo metodo moltiplica il vettore correte 
	 * per una matrice
	 * 
	 * @param m la matrice
	 * @return il vettore risultante
	 */
	public Vettore moltiplicazione(Matrice m){
		return Matrice.moltiplicazione(this, m);
	}
	
	/**
	 * Questo metodo esegue la somma tra il vettore
	 * corrente e un secondo vettore
	 * 
	 * @param v il secondo vettore
	 * @return il vettore risultante
	 */
	public Vettore somma(Vettore v){
		return Vettore.somma(this, v);
	}
	
	/**
	 * Questo metodo esegue la sottrazione tra il vettore
	 * corrente e un secondo vettore
	 * 
	 * @param v il secondo vettore
	 * @return il vettore risultante
	 */
	public Vettore sottrazione(Vettore v){
		return Vettore.sottrazione(this, v);
	}
	
	/**
	 * Questo metodo restituisce il vettore sottoforma di array
	 * 
	 * @return il vettore sottoforma di array
	 */
	public float[] getArray(){
		return this.vettore;
	}
	
	/**
	 * Questo metodo crea una rappresentazione del vettore
	 * sottoforma di stringa
	 * 
	 * @return la rappresentazione stringata
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.getLength(); i++){
			s.append(Math.round(this.getElemento(i)));
			if (this.isTrasposto()){
				s.append(" ");
			}else{
				s.append("\n");
			}
		}
		return s.toString();
	}
	
	/**
	 * Questo metodo verifica se esiste almeno un elemento
	 * maggiore di i
	 * 
	 * @param i il valore di confronto
	 * @return true se esiste almeno uno maggiore di i altrimenti false
	 */
	public boolean isMaggioreDi(int i){
		for(float a: this.vettore){
			if (a > i){
				return true;
			} 
		}
		return false;
	}
	
	// Metodo statici
	
	/**
	 * Questo metodo implementa l'operazione di moltiplicazione
	 * tra due vettori
	 * 
	 * @param v1 il primo vettore
	 * @param v2 il secondo vettore
	 * @return Il risultato
	 */
	public static float moltiplicazione(Vettore v1, Vettore v2){
		if (v1.isTrasposto() != v2.isTrasposto() && v1.getLength() != v2.getLength()) return 0;
		float risultato = 0;
		
		for(int i = 0; i < v1.getLength(); i++){
			risultato += v1.getElemento(i) * v2.getElemento(i);
		}
		
		return risultato;
	}
	
	/**
	 * Questo metodo implementa l'operazione di moltiplicazione
	 * tra una costante e un vettore
	 * 
	 * @param f la costante
	 * @param v il vettore
	 * @return il vettore risultante
	 */
	public static Vettore moltiplicazione(float f, Vettore v){
		Vettore nuovo = new Vettore(v.getLength(), v.isTrasposto());
		for (int i = 0; i < v.getLength(); i ++){
			nuovo.addElemento(i, v.getElemento(i) * f);
		}
		return nuovo;
	}
	
	/**
	 * Questo metodo implementa l'operazione di somma tra
	 * due vettori
	 * 
	 * @param v1 il primo vettore
	 * @param v2 i seondo vettore
	 * @return il vettore risultante
	 */
	public static Vettore somma(Vettore v1, Vettore v2){
		if (v1.getLength() != v2.getLength() && v1.isTrasposto() != v2.isTrasposto()) return null;
		
		Vettore risultato = new Vettore(v1.getLength(), v1.isTrasposto());
		for(int i = 0; i < v1.getLength(); i++){
			risultato.addElemento(i, v1.getElemento(i) + v2.getElemento(i));
		}
		
		return risultato;
	}
	
	/**
	 * Questo metodo implementa l'operazione di sottrazione
	 * tra due vettori
	 * 
	 * @param v1 il primo vettore
	 * @param v2 il secondo vettore
	 * @return il vettore risultante
	 */
	public static Vettore sottrazione(Vettore v1, Vettore v2){
		if (v1.getLength() != v2.getLength() && v1.isTrasposto() != v2.isTrasposto()) return null;
		
		Vettore risultato = new Vettore(v1.getLength(), v1.isTrasposto());
		for(int i = 0; i < v1.getLength(); i++){
			risultato.addElemento(i, v1.getElemento(i) - v2.getElemento(i));
		}
		
		return risultato;
	}
}
