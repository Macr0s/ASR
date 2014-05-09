package it.uniroma3.asr;

import it.uniroma3.asr.algoritmo.ASR;
import it.uniroma3.asr.algoritmo.Carry;
import it.uniroma3.asr.geometria.Matrice;
import it.uniroma3.asr.geometria.Vettore;

/**
 * Questa classe memorizza il problema di programmazione lineare
 * e gestisce la sua risoluzione
 * 
 * N.B.: il problema di programmazione lineare viene considerato
 * già in forma standard
 * 
 * @author Matteo Filippi
 * @see Vettore
 * @see Matrice
 * @see ASR
 * @see Carry
 * @version 0.1
 *
 */
public class ProgrammazioneLineare {
	private Vettore costi;
	private Matrice A;
	private Vettore b;
	private Vettore base;
	private Vettore nbase;
	private int equazioni;
	private int variabili;
	
	/**
	 * Questa classe inizializza il problema di 
	 * programmazione lineare
	 * 
	 * @param r il numero di equazioni
	 * @param c il numero di variabili
	 */
	public ProgrammazioneLineare(int r, int c){
		this.costi = new Vettore(c,true);
		this.A = new Matrice(r,c);
		this.b = new Vettore(r);
		this.base = new Vettore(r);
		this.nbase = new Vettore(c-r);
		this.equazioni = r;
		this.variabili = c;
	}
	
	/**
	 * Questa classe inizializzara il problema 
	 * linare partende da uno già esistente
	 * 
	 * @param pl il problema già esistente
	 */
	public ProgrammazioneLineare(ProgrammazioneLineare pl){
		this.setA(new Matrice(pl.getA()));
		this.setCosti(new Vettore(pl.getCosti()));
		this.setB(new Vettore(pl.getB()));
		this.setBase(new Vettore(pl.getBase()));
		this.setNbase(new Vettore(pl.getNbase()));
		this.setEquazioni(pl.getEquazioni());
		this.setVariabili(pl.getVariabili());
	}
	
	/**
	 * Questo metodo restituisce la matrice A
	 * 
	 * @return la matrice A
	 */
	public Matrice getA() {
		return this.A;
	}
	
	/**
	 * Questo metodo restituisce la matrice dei termini
	 * noti
	 * 
	 * @return la matrice dei termini noti
	 */
	public Vettore getB() {
		return this.b;
	}
	
	/**
	 * Questo metodo restituisce un vettore che corrisponde
	 * all'insieme degli indici in base
	 * 
	 * @return l'insieme degli indici in base
	 */
	public Vettore getBase() {
		return this.base;
	}
	
	/**
	 * Questo metodo restituisce il vettore dei costi
	 * 
	 * @return il vettore dei costi
	 */
	public Vettore getCosti() {
		return this.costi;
	}
	
	/**
	 * Questo metodo restituisce un vettore che corrisponde
	 * all'insieme degli indici non in base
	 * 
	 * @return l'insieme degli indici non in base
	 */
	public Vettore getNbase() {
		return this.nbase;
	}
	
	/**
	 * Questo metodo restituisce il numero di equazioni
	 * del problema di programmazione lineare
	 * 
	 * @return il numero di equazioni
	 */
	public int getEquazioni() {
		return equazioni;
	}
	
	/**
	 * Questo metodo restituisce il numero di variabili
	 * del problema di programmazione lineare
	 * 
	 * @return il numero di variabili
	 */
	public int getVariabili() {
		return variabili;
	}
	
	/**
	 * Questo metodo imposta la matrice A
	 * 
	 * @param a la nuova matrice A
	 */
	public void setA(Matrice a) {
		this.A = a;
	}
	
	/**
	 * Questo metodo imposta il vettore dei termini noti
	 * 
	 * @param b il nuovo vettore dei termini noi
	 */
	public void setB(Vettore b) {
		this.b = b;
	}
	
	/**
	 * Questo metodo imposta il vettore degli indici
	 * in base
	 * 
	 * @param base il nuovo vettore degli indici in base
	 */
	public void setBase(Vettore base) {
		this.base = base;
	}
	
	/**
	 * Questo metodo imposta il vettore dei costi
	 * 
	 * @param costi il vettore dei costi
	 */
	public void setCosti(Vettore costi) {
		this.costi = costi;
	}
	
	/**
	 * Questo metodo imposta il vettore degli indici
	 * non in base
	 * 
	 * @param nbase il nuovo vettore degli indici non in base
	 */
	public void setNbase(Vettore nbase) {
		this.nbase = nbase;
	}
	
	/**
	 * Questo metodo imposta il numero di equazioni
	 * 
	 * @param equazioni il nuovo numero di equazioni
	 */
	 public void setEquazioni(int equazioni) {
		this.equazioni = equazioni;
	}
	 
	/**
	 * Questo metodo imposta il numero di variabili
	 * 
	 * @param variabili il nuovo numero di variabili
	 */
	public void setVariabili(int variabili) {
		this.variabili = variabili;
	}
	
	/**
	 * Questo metodo restituisce il vettore trasposto
	 * dei costi in base
	 * 
	 * @return il vettore trasposto dei costi in base
	 */
	public Vettore getCBT(){
		Vettore cbt = new Vettore(this.getBase().getLength(),true);
		for (int k = 0; k < cbt.getLength(); k++){
			cbt.addElemento(k, this.getCosti().getElemento((int)this.getBase().getElemento(k)));
		}
		return cbt;
	}
	
	/**
	 * Questo metodo restituisce la matrice A inversa
	 * 
	 * @return la matrice A inversa
	 */
	public Matrice getAinversa(){
		Matrice m = new Matrice(this.getA());
		m.inverti();
		return m;
	}
	
	/**
	 * Questo metodo restituisce la matrice A inversa in base
	 * 
	 * @return la matrice A inversa in base
	 */
	public Matrice getAinversaBase(){
		Matrice ABI = new Matrice(this.getEquazioni(), this.getBase().getLength());
		for(int i = 0; i < this.getBase().getLength(); i++){
			ABI.sostituisciColonna(i, this.getA().getColonna((int)this.getBase().getElemento(i)));
		}
		ABI.inverti();
		return ABI;
	}
	
	/**
	 * Questo metodo restituisce la matrice Y trasposta
	 * 
	 * @return la matrce Y trasposta
	 */
	public Vettore getYT(){
		return this.getCBT().moltiplicazione(this.getAinversaBase());
	}
	
	/**
	 * Questo metodo restituisce il coefficiente Z
	 * 
	 * @return il coefficiente Z
	 */
	public float getZ(){
		return this.getYT().moltiplicazione(this.getB());
	}
	
	/**
	 * Questo metodo restituisce il vettore A segnato
	 * 
	 * @param j l'indice della matrice A
	 * @return il vettore A segnato partendo dalla colonna j-esima
	 */
	public Vettore getASegnato(int j){
		return this.getAinversaBase().moltiplicazione(this.getA().getColonna(j));
	}
	
	/**
	 * Questo metodo restitusice il costo ridotto della variabile i
	 * 
	 * @param i la variabile
	 * @return il costo ridotto di quella variabile
	 */
	public float getCostoRidotto(int i){
		return this.getCosti().getElemento(i) - this.getYT().moltiplicazione(this.getA().getColonna(i));
	}
	
	/**
	 * Questo metodo restituisce la matrice Carry
	 * 
	 * @return la matrice Carry
	 */
	public Carry getCarry(){
		return new Carry(this);
	}
	
	/**
	 * Questo metodo restituisce il vettore Bsegnato
	 * 
	 * @return il vettore B segnato
	 */
	public Vettore getBSegnato(){
		return this.getAinversaBase().moltiplicazione(this.getB());
	}
	
	/**
	 * Questo metodo restuisce l'algoritmo del simplesso rivisto
	 * 
	 * @return l'algoritmo del simplesso rivisto
	 */
	public ASR getASR(){
		return new ASR(this);
	}
	
	/**
	 * Questo metodo controlla se una classe programmazioneLineare è uguale 
	 * a quella corrente
	 * 
	 * @param pl la programmazione lineare da confrontare
	 * @return true se sono uguali altrimenti false
	 */
	public boolean equals(ProgrammazioneLineare pl){
		return pl.getA().equals(this.A) &&
				pl.getB().equals(this.b) &&
				pl.getCosti().equals(this.costi) &&
				pl.getVariabili() == this.variabili && 
				pl.getEquazioni() == this.equazioni;
	}
	
	/**
	 * Questo metodo crea una rappresentazione stringa
	 * del problema di programmazione lineare corrente
	 * 
	 * @return la rappresentazione stringata
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		
		s.append("Vettore dei costi:\n");
		s.append(this.costi.toString());
		s.append("\n La matrice dei coefficienti: \n");
		s.append(this.A.toString());
		s.append("\n Il vettore dei termini noti: \n");
		s.append(this.b.toString());
		
		return s.toString();
	}
}
