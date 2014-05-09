package it.uniroma3.asr.geometria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VettoreTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddElemento() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		assertEquals(v.toString(), 1, v.getElemento(0),0);
		assertEquals(v.toString(), 3, v.getElemento(1),0);
	}

	@Test
	public void testEqualsVettore() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		
		Vettore v1 = new Vettore(2);
		v1.addElemento(0, 1);
		v1.addElemento(1, 3);
		
		assertTrue(v.toString(), v.equals(v1));
	}

	@Test
	public void testMoltiplicazioneVettore() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		
		Vettore v1 = new Vettore(2,true);
		v1.addElemento(0, 1);
		v1.addElemento(1, 3);
		
		assertEquals(v.toString(), 10,v.moltiplicazione(v1),0);
	}

	@Test
	public void testMoltiplicazioneFloat() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		
		Vettore v1 = new Vettore(2);
		v1.addElemento(0, 2);
		v1.addElemento(1, 6);
		
		assertTrue(v.toString(), v.moltiplicazione(2).equals(v1));
	}

	@Test
	public void testMoltiplicazioneMatrice() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 0);
		m.addElemento(1, 0, 3);
		m.addElemento(0, 1, 2);
		m.addElemento(1, 1, 2);
		
		Vettore v = new Vettore(2, true);
		v.addElemento(0, 1);
		v.addElemento(1, 1);
		
		Vettore v1 = new Vettore(2,true);
		v1.addElemento(0, 3);
		v1.addElemento(1, 4);
		
		assertTrue(v.moltiplicazione(m).toString(), v.moltiplicazione(m).equals(v1));
	}

	@Test
	public void testSommaVettore() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		
		Vettore v1 = new Vettore(2);
		v1.addElemento(0, 2);
		v1.addElemento(1, 6);
		
		assertTrue(v.toString(), v.somma(v).equals(v1));
	}

	@Test
	public void testSottrazioneVettore() {
		Vettore v = new Vettore(2);
		v.addElemento(0, 1);
		v.addElemento(1, 3);
		
		Vettore v1 = new Vettore(2);
		v1.addElemento(0, 0);
		v1.addElemento(1, 0);
		
		assertTrue(v.toString(), v.sottrazione(v).equals(v1));
	}

}
