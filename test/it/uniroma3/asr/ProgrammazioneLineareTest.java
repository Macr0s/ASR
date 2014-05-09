package it.uniroma3.asr;

import static org.junit.Assert.*;
import it.uniroma3.asr.geometria.Matrice;
import it.uniroma3.asr.geometria.Vettore;

import org.junit.Before;
import org.junit.Test;

public class ProgrammazioneLineareTest {
	ProgrammazioneLineare pl;
	
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
	}

	@Test
	public void testGetCBT() {
		Vettore cbt = new Vettore(2,true);
		
		cbt.addElemento(0, 4);
		cbt.addElemento(1, 1);
		
		assertTrue(this.pl.toString(), this.pl.getCBT().equals(cbt));
	}

	@Test
	public void testGetAinversaBase() {
		Matrice ABI = new Matrice(2,2); 
		ABI.addElemento(0, 0, -0.25F);
		ABI.addElemento(0, 1, 1.25F);
		ABI.addElemento(1, 0, 0.25F);
		ABI.addElemento(1, 1, -0.25F);
		
		assertTrue(this.pl.getAinversaBase().toString(), this.pl.getAinversaBase().equals(ABI));
	}

	@Test
	public void testGetYT() {
		Vettore YT = new Vettore(2, true);
		YT.addElemento(0, -0.75F);
		YT.addElemento(1, 4.75F);
		assertTrue(this.pl.getYT().toString(), this.pl.getYT().equals(YT));
	}

	@Test
	public void testGetZ() {
		assertEquals(this.pl.toString(), 1.75F, this.pl.getZ(),0);
	}

	@Test
	public void testGetASegnato() {
		Vettore ASegnato = new Vettore(2);
		ASegnato.addElemento(0, 0.75F);
		ASegnato.addElemento(1, 0.25F);
		
		assertTrue(this.pl.toString(), this.pl.getASegnato(1).equals(ASegnato));
	}

	@Test
	public void testGetCostoRidotto() {
		assertEquals(this.pl.toString(), -0.25F, this.pl.getCostoRidotto(1), 0);
	}

	@Test
	public void testGetBSegnato() {
		Vettore BSegnato = new Vettore(2);
		
		BSegnato.addElemento(0, 0.25F);
		BSegnato.addElemento(1, 0.75F);
		
		assertTrue(this.pl.getBSegnato().toString(), this.pl.getBSegnato().equals(BSegnato));
	}
}
