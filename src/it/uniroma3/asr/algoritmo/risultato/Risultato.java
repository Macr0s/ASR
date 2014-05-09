package it.uniroma3.asr.algoritmo.risultato;

import it.uniroma3.asr.geometria.Vettore;
/**
 * Questa interfaccia unifica tutti i risultati di tutti
 * dell'algoritmo del simplesso rivisto
 * 
 * @author Matteo Filippi
 * @see Vettore
 * @version 0.1
 *
 */
public interface Risultato {
	
	/**
	 * Restituisce la soluzione dell'algoritmo del simplesso
	 * rivisto
	 * 
	 * @return Il vettore delle soluzioni nel caso abbia una soluzione
	 * altrimenti null
	 */
	public Vettore getSoluzione();
	
	/**
	 * Restituisce la base ottima dell'algoritmo del simplesso
	 * 
	 * @return il vettore della base ottima nel caso esista altrimenti
	 * null
	 */
	public Vettore getBase();
	
	/**
	 * Restituisce il vettore degli indici non in base
	 * 
	 * @return il vettore degli indici non in base nel caso esista altrimenti
	 * null
	 */
	public Vettore getNBase();
	
	/**
	 * Restituisce il tipo di soluzione dell'algoritmo del 
	 * simplesso rivisto
	 * 
	 * @return 0 nel caso di un problema illimitato inferiormente, 1 
	 * nel caso di un problema con soluzione ottima
	 */
	public int getTipo();
}
