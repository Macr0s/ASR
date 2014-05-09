package it.uniroma3.asr.algoritmo;

import static org.junit.Assert.*;
import it.uniroma3.asr.ProgrammazioneLineare;
import it.uniroma3.asr.geometria.Matrice;
import it.uniroma3.asr.geometria.Vettore;

import org.junit.Before;
import org.junit.Test;

public class CarryTest {
	ProgrammazioneLineare pl;
	Carry c;

	@Before
	public void setUp() throws Exception {
		this.pl = new ProgrammazioneLineare(2,4);
		this.pl.getCosti().addElemento(0, 4);
		this.pl.getCosti().addElemento(1, 3);
		this.pl.getCosti().addElemento(2, 2);
		this.pl.getCosti().addElemento(3, 1);
		this.pl.getA().addElemento(0, 0, 1);
		this.pl.getA().addElemento(0, 1, 2);
		this.pl.getA().addElemento(0, 2, 3);
		this.pl.getA().addElemento(0, 3, 5);
		this.pl.getA().addElemento(1, 0, 1);
		this.pl.getA().addElemento(1, 1, 1);
		this.pl.getA().addElemento(1, 2, 1);
		this.pl.getA().addElemento(1, 3, 1);
		this.pl.getB().addElemento(0, 4);
		this.pl.getB().addElemento(1, 1);
		this.pl.getBase().addElemento(0, 0);
		this.pl.getBase().addElemento(1, 3);
		this.pl.getNbase().addElemento(0, 1);
		this.pl.getNbase().addElemento(1, 2);
		this.c = this.pl.getCarry();
	}
	
	@Test
	public void testGenerale(){
		Matrice m = new Matrice(3,3);
		
		m.addElemento(0, 0, 0.75F);
		m.addElemento(0, 1, -4.75F);
		m.addElemento(0, 2, -1.75F);
		m.addElemento(1, 0, -0.25F);
		m.addElemento(1, 1, 1.25F);
		m.addElemento(1, 2, 0.25F);
		m.addElemento(2, 0, 0.25F);
		m.addElemento(2, 1, -0.25F);
		m.addElemento(2, 2, 0.75F);
		
		assertTrue(this.c.toString(), this.c.getMatrice().equals(m));
	}

	@Test
	public void testComplementa() {
		Matrice m = new Matrice(3,4);
		
		m.addElemento(0, 0, 0.75F);
		m.addElemento(0, 1, 0.75F);
		m.addElemento(0, 2, -4.75F);
		m.addElemento(0, 3, -1.75F);
		m.addElemento(1, 0, -0.25F);
		m.addElemento(1, 1, -0.25F);
		m.addElemento(1, 2, 1.25F);
		m.addElemento(1, 3, 0.25F);
		m.addElemento(2, 0, 0.25F);
		m.addElemento(2, 1, 0.25F);
		m.addElemento(2, 2, -0.25F);
		m.addElemento(2, 3, 0.75F);
		
		this.c.complementa(this.pl.getCostoRidotto(1), this.pl.getASegnato(1));
	}

	@Test
	public void testArgmin() {
		Vettore a = this.pl.getASegnato(1);
		a.addElemento(0, -1);
		assertEquals(this.c.toString(), 1, this.c.argmin(a, this.c.getBSegnato(), this.pl.getBase()));
	}

	@Test
	public void testCambiaBase() {
		this.c.cambiaBase(0);
		Matrice m = new Matrice(2,2);
		
		assertTrue(this.c.toString(), this.c.getMatrice().equals(m));
	}

	@Test
	public void testGetABI() {
		Matrice ABI = new Matrice(2,2); 
		ABI.addElemento(0, 0, -0.25F);
		ABI.addElemento(0, 1, 1.25F);
		ABI.addElemento(1, 0, 0.25F);
		ABI.addElemento(1, 1, -0.25F);
		
		assertTrue(this.c.toString(), this.c.getABI().equals(ABI));
	}

	@Test
	public void testGetYT() {
		Vettore YT = new Vettore(2, true);
		YT.addElemento(0, -0.75F);
		YT.addElemento(1, 4.75F);
		
		assertTrue(this.c.toString(), this.c.getYT().equals(YT));
	}

	@Test
	public void testGetBSegnato() {
		Vettore BSegnato = new Vettore(2);
		
		BSegnato.addElemento(0, 0.25F);
		BSegnato.addElemento(1, 0.75F);
		
		assertTrue(this.c.toString(), this.c.getBSegnato().equals(BSegnato));
	}

}
