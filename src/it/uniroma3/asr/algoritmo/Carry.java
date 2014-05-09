package it.uniroma3.asr.algoritmo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.asr.ProgrammazioneLineare;
import it.uniroma3.asr.geometria.Matrice;
import it.uniroma3.asr.geometria.Vettore;

/**
 * Questa classe gestisce ed implementa la matrice Carry
 * 
 * @author Matteo Filippi
 * @see Matrice
 * @see ProgrammazioneLineare
 * @version 0.1
 */
public class Carry {
	private Matrice matrice;
	
	/**
	 * Questo è il costruttore della matrice Carry 
	 * partendo dalle singole matrici e vettori
	 * 
	 * @param yt il vettore trasposto Y
	 * @param z il valore Z
	 * @param bsegnato il vettore B segnato
	 * @param ABI la matrice A vase inversa
	 */
	public Carry(Vettore yt, float z, Vettore bsegnato, Matrice ABI){
		this.matrice = new Matrice(ABI.getNumRiga() + 1, ABI.getNumColonne() + 1);
		yt = yt.moltiplicazione(-1);
		
		this.matrice.addElemento(0, this.matrice.getNumRiga() - 1, -z);
		for(int i = 0; i < yt.getLength(); i++){
			this.matrice.addElemento(0, i, yt.getElemento(i));
		}
		
		for(int i = 0; i < ABI.getNumRiga(); i++){
			for(int j = 0; j < ABI.getNumColonne(); j++){
				this.matrice.addElemento(i+1, j, ABI.getElemento(i, j));
			}
		}
		
		for(int i = 0; i < bsegnato.getLength(); i++){
			this.matrice.addElemento(i+1, this.matrice.getNumColonne()-1, bsegnato.getElemento(i));
		}
	}
	
	/**
	 * Questo è il costruttire che inizializza la Carray
	 * partendo dal problema di programmazione lineare
	 * 
	 * @param pl il problema di programmazione lineare
	 */
	public Carry(ProgrammazioneLineare pl){
		this(pl.getYT(), pl.getZ(), pl.getBSegnato(), pl.getAinversaBase());
	}
	
	/**
	 * Questo metodo complementa la Carry con il costo ridotto
	 * e con il vettore A segnato
	 * 
	 * @param costoridotto il costo riditto
	 * @param Asegnato il vettore A segnato
	 */
	public void complementa(float costoridotto, Vettore Asegnato){
		this.matrice.addNuovaColonna(0);
		
		this.matrice.addElemento(0, 0, costoridotto);
		
		for(int i = 0; i < Asegnato.getLength(); i++){
			this.getMatrice().addElemento(0, i + 1, Asegnato.getElemento(i));
		}
	}
	
	/**
	 * Questo metodo restituisce la matrice Carry
	 * 
	 * @return la matrice Carry
	 */
	public Matrice getMatrice() {
		return this.matrice;
	}
	
	private List<Integer> indiciMinimi(Vettore Asegnato, Vettore Bsegnato){
		List<Integer> elementi = new ArrayList<Integer>();
		float valore, minimo = 0;
		
		for(int i = 0; i <Asegnato.getLength(); i++){
			if(Asegnato.getElemento(i) > 0){
				valore = Bsegnato.getElemento(i)/Asegnato.getElemento(i);
				if (elementi.isEmpty()){
					minimo = valore;
					elementi.add(0, new Integer(i));
				}else{
					if (minimo ==valore){
						elementi.add(new Integer(i));
					}else if (valore < minimo){
						elementi.clear();
						minimo = valore;
						elementi.add(0, new Integer(i));
					}
				}
			}
		}
		return elementi;
	}
	
	/**
	 * Questo metodo calcola l'argmin della matrice
	 * 
	 * @param Asegnato il vettore A segnato
	 * @param Bsegnato il vettore B segnato
	 * @param base il vettore che contiene gli indici della base
	 * @return l'indice
	 */
	public int argmin(Vettore Asegnato, Vettore Bsegnato, Vettore base){
		List<Integer> e = this.indiciMinimi(Asegnato, Bsegnato);
		if (e.size() == 1){
			return e.get(0).intValue();
		}
		
		Iterator<Integer> i = e.iterator();	
		int  minimo = i.next().intValue(), temp;
		while(i.hasNext()){
			temp = i.next().intValue();
			if (base.getElemento(temp) < base.getElemento(minimo)){
				minimo = temp;
			}
		}
		return minimo;
		
	}
	
	/**
	 * Esegue il cambio base
	 * 
	 * @param i la nuova variabile entrante
	 */
	public void cambiaBase(int i){
		this.matrice.pivot(i + 1, 0);
		this.matrice.removeColonna(0);
	}
	
	/**
	 * Questo metodo restituisce la matrice 
	 * dei coefficieni in base inversa
	 * 
	 * @return la ABI
	 */
	public Matrice getABI(){
		Matrice m = new Matrice(this.matrice);
		m.removeColonna(m.getNumColonne() - 1);
		m.removeRiga(0);
		return m;
	}
	
	/**
	 * Questo metodo restituisce il vettore YT
	 * 
	 * @return il vettore YT
	 */
	public Vettore getYT(){
		Matrice m = new Matrice(this.matrice);
		m.removeColonna(m.getNumColonne() - 1);
		return m.getRiga(0).moltiplicazione(-1F);
	}
	
	/**
	 * Questo metodo restituisce il vettore BSegnato
	 * 
	 * @return il vettore Bsegnato
	 */
	public Vettore getBSegnato(){
		Matrice m = new Matrice(this.matrice);
		m.removeRiga(0);
		return m.getColonna(m.getNumColonne() - 1);
	}
	
	/**
	 * Questo metodo controllas se due carry sono uguali
	 * 
	 * @param c la carry da confrontare
	 * @return true se sono uguali altrimenti false
	 */
	public boolean equals(Carry c){
		return this.matrice.equals(c.getMatrice());
	}
	
	/**
	 * Questo metodo crea una rappresentazione stringata 
	 * della carry corrente
	 * 
	 * @return la rappresentazione stringata
	 */
	public String toString(){
		return this.matrice.toString();
	}
}
