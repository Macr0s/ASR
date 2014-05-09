package it.uniroma3.asr.algoritmo;

import it.uniroma3.asr.ProgrammazioneLineare;
import it.uniroma3.asr.algoritmo.risultato.Risultato;

/**
 * 
 * 
 * @author Matteo Filippi
 * @see ProgrammazioneLineare
 * @see Risultato
 * @see PLArtificiale
 *
 */
public class ASR {
	private ProgrammazioneLineare pl;
	private Carry c;
	
	/**
	 * Questo costruttore inizializza l'algoritmo 
	 * del simplesso rivisto
	 * 
	 * @param pl il problema di programmazione lineare
	 */
	public ASR(ProgrammazioneLineare pl){
		this.pl = new ProgrammazioneLineare(pl);
		this.c = this.pl.getCarry();
	}
	
	/**
	 * Questo metodo imposta il problema di programmazione
	 * lineare
	 * 
	 * @param pl il nuovo problema di programmazione lineare
	 */
	public void setPl(ProgrammazioneLineare pl) {
		this.pl = new ProgrammazioneLineare(pl);
	}
	
	/**
	 * Questo metodo restituisce il problema
	 * di programmazione lineare
	 * 
	 * @return il problema di programmazione lineare
	 */
	public ProgrammazioneLineare getPl() {
		return this.pl;
	}
	
	/**
	 * Questo metodo esegue la fase 1 dell'algoritmo
	 * del simplesso rivisto
	 * 
	 * @return il risultato della fase 1
	 */
	public Risultato eseguiFase1(){
		PLArtificiale pla = new PLArtificiale(this.pl);
		
		return null;
	}
	
	/**
	 * Questo metodo esegue la fase 2 dell'algoritmo
	 * del simplesso rivisto
	 * 
	 * @return il risultato della fase 2
	 */
	public Risultato eseguiFase2(){
		return null;
	}
	
	/**
	 * Questo metodo verifica se è giunta alla
	 * soluzione ottima oppure no
	 * 
	 * @return -1 nel caso si sia raggiunta la soluzione ottima
	 * altrimenti l'indice che deve entrare in base
	 */
	public int verificaOttima(){
		for(float i: this.pl.getNbase().getArray()){
			if (this.pl.getCostoRidotto((int)i) >= 0){
				return (int)i;
			}
		}
		return -1;
	}
	
	/**
	 * Verifica la condizione di illimitatezza
	 * 
	 * @param i l'indice da verificare
	 * @return true se il PL è illimitato inferiorimente 
	 * altrimenti false
	 */
	public boolean verificaIllimitatezza(int i){
		return !this.pl.getASegnato(i).isMaggioreDi(0);
	}
	
	/**
	 * Questo metodo verifica che un algoritmo del simplesso
	 * rivisto è uguale a quello conrrente
	 * 
	 * @param asr l'asr da confrontare
	 * @return true se sono uguali altrimenti false
	 */
	public boolean equals(ASR asr){
		return this.getPl().equals(asr.getPl());
	}
	
	/**
	 * Questo metodo crea una rappresentazione stringata
	 * dell'algoritmo del simplesso rivisto corrente
	 * 
	 * @return la rappresentazione del simplesso rivisto
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("ASR applicato su\n");
		s.append(this.pl.toString());
		return s.toString();
	}
}
