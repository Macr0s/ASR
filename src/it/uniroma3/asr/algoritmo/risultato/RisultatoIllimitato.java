package it.uniroma3.asr.algoritmo.risultato;

import it.uniroma3.asr.geometria.Vettore;

/**
 * Questa classe gestisce il problemma illimitatto inferiormente
 * 
 * @author Matteo Filippi
 * @see Vettore
 * @see Risultato
 * @versione 0.1
 *
 */
public class RisultatoIllimitato implements Risultato{

	@Override
	public Vettore getSoluzione() {
		return null;
	}

	@Override
	public Vettore getBase() {
		return null;
	}

	@Override
	public Vettore getNBase() {
		return null;
	}

	@Override
	public int getTipo() {
		return 0;
	}

}
