package it.uniroma3.asr.algoritmo;

import it.uniroma3.asr.ProgrammazioneLineare;
import it.uniroma3.asr.geometria.*;

/**
 * Questa classe crea e gestisce il problema di programmazione
 * lineare artificiale
 * 
 * @author Matteo Filippi
 * @see ProgrammazioneLineare
 * @see Matrice
 * @see Vettore
 * @see ASR
 * @version 0.1
 */
public class PLArtificiale extends ProgrammazioneLineare {
	
	public boolean verificaColonnaIdentica(int i){
		Vettore v = new Vettore(super.getEquazioni());
		v.addElemento(i, 1);
		return v.equals(super.getA().getColonna(i));
	}
	/**
	 * Questo costruttore crea il problema di programmazione lineare
	 * artificiale partendo da quello in forma standard
	 * 
	 * @param pl il problema di programmazion lineare in forma standard
	 */
	public PLArtificiale(ProgrammazioneLineare pl) {
		super(pl);
		int colonna_nuova = pl.getVariabili();
		int nuova_variabile = pl.getVariabili();
		
	}
}
