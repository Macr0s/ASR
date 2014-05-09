package it.uniroma3.asr.geometria;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatriceTest {

	@Test
	public void testAddElemento() {
		Matrice m = new Matrice(1,2);
		m.addElemento(0, 0, 234.2F);
		m.addElemento(0, 1, 234.4F);
		assertEquals("",234.2F, m.getElemento(0, 0),0);
		assertEquals("",234.4F, m.getElemento(0, 1),0);
	}

	@Test
	public void testGetNumColonne() {
		Matrice m = new Matrice(1,2);
		assertEquals(2, m.getNumColonne());
	}


	@Test
	public void testGetNumRiga() {
		Matrice m = new Matrice(1,2);
		assertEquals(1, m.getNumRiga());
	}

	@Test
	public void testRemoveRiga() {
		Matrice m = new Matrice(2,2);
		m.addElemento(1, 0, 1234.4F);
		m.addElemento(1, 1, 6789F);
		m.removeRiga(0);
		assertEquals(1, m.getNumRiga());
		assertEquals(2, m.getNumColonne());
		assertEquals(1234.4F, m.getElemento(0, 0),0);
		assertEquals(6789F, m.getElemento(0, 1),0);
	}

	@Test
	public void testRemoveColonna() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1234.4F);
		m.addElemento(1, 0, 6789F);
		m.removeColonna(1);
		assertEquals(2, m.getNumRiga());
		assertEquals(1, m.getNumColonne());
		assertEquals(1234.4F, m.getElemento(0, 0),0);
		assertEquals(6789F, m.getElemento(1, 0),0);
	}

	@Test
	public void testGetColonna() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1234.4F);
		m.addElemento(1, 0, 6789F);
		m.addElemento(0, 1, 1234.4F);
		m.addElemento(1, 1, 6789F);
		
		Vettore v = new Vettore(2);
		v.addElemento(0, 1234.4F);
		v.addElemento(1, 6789F);
		
		assertTrue(m.getColonna(0).equals(v));
		assertTrue(m.getColonna(1).equals(v));
	}

	@Test
	public void testGetRiga() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1234.4F);
		m.addElemento(0, 1, 6789F);
		m.addElemento(1, 0, 1234.4F);
		m.addElemento(1, 1, 6789F);
		
		Vettore v = new Vettore(2);
		v.addElemento(0, 1234.4F);
		v.addElemento(1, 6789F);
		
		assertTrue(m.getRiga(0).equals(v));
		assertTrue(m.getRiga(1).equals(v));
	}

	@Test
	public void testEqualsMatrice() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1234.4F);
		m.addElemento(0, 1, 6789F);
		m.addElemento(1, 0, 1234.4F);
		m.addElemento(1, 1, 6789F);
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 1234.4F);
		m1.addElemento(0, 1, 6789F);
		m1.addElemento(1, 0, 1234.4F);
		m1.addElemento(1, 1, 6789F);
		
		assertTrue(m.equals(m1));
	}

	@Test
	public void testAddNuovaColonna() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Matrice m1 = new Matrice(2,3);
		m1.addElemento(0, 0, 1F);
		m1.addElemento(0, 1, 0);
		m1.addElemento(0, 2, 2F);
		m1.addElemento(1, 0, 1F);
		m1.addElemento(1, 1, 0);
		m1.addElemento(1, 2, 2F);
		
		m.addNuovaColonna(1);
		assertEquals(m.toString(), 3, m.getNumColonne());
		assertTrue(m.toString(), m.equals(m1));
	}

	@Test
	public void testAddNuovaRiga() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Matrice m1 = new Matrice(3,2);
		m1.addElemento(0, 0, 1F);
		m1.addElemento(0, 1, 2F);
		m1.addElemento(1, 0, 0);
		m1.addElemento(1, 1, 0);
		m1.addElemento(2, 0, 1F);
		m1.addElemento(2, 1, 2F);
		
		m.addNuovaRiga(1);
		assertEquals(m.toString(), 3, m.getNumRiga());
		assertTrue(m.toString(), m.equals(m1));
	}

	@Test
	public void testInverti() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1);
		m.addElemento(0, 1, 0);
		m.addElemento(1, 0, 0);
		m.addElemento(1, 1, 1);
		
		m.inverti();
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 1);
		m1.addElemento(0, 1, 0);
		m1.addElemento(1, 0, 0);
		m1.addElemento(1, 1, 1);
		
		assertTrue(m.toString(),m.equals(m1));
	}


	@Test
	public void testMoltiplicazioneMatrice() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 1F);
		m1.addElemento(0, 1, 2F);
		m1.addElemento(1, 0, 3F);
		m1.addElemento(1, 1, 4F);
		
		Matrice m2 = new Matrice(2,2);
		m2.addElemento(0, 0, 7F);
		m2.addElemento(0, 1, 10F);
		m2.addElemento(1, 0, 7F);
		m2.addElemento(1, 1, 10F);
		
		assertTrue(m.moltiplicazione(m1).equals(m2));
	}

	@Test
	public void testMoltiplicazioneFloat() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);

		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 2F);
		m1.addElemento(0, 1, 4F);
		m1.addElemento(1, 0, 2F);
		m1.addElemento(1, 1, 4F);
		
		assertTrue(m.moltiplicazione(2F).equals(m1));
	}

	@Test
	public void testMoltiplicazioneVettore() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);

		Vettore v = new Vettore(2);
		v.addElemento(0, 1F);
		v.addElemento(1, 2F);
		
		Vettore v1 = new Vettore(2);
		v1.addElemento(0, 5F);
		v1.addElemento(1, 5F);
		
		assertTrue(m.moltiplicazione(v).equals(v1));
	}

	@Test
	public void testSommaMatrice() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);

		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 2F);
		m1.addElemento(0, 1, 4F);
		m1.addElemento(1, 0, 2F);
		m1.addElemento(1, 1, 4F);
		
		Matrice m2 = new Matrice(2,2);
		m2.addElemento(0, 0, 3F);
		m2.addElemento(0, 1, 6F);
		m2.addElemento(1, 0, 3F);
		m2.addElemento(1, 1, 6F);
		
		assertTrue(m.somma(m1).equals(m2));
	}

	@Test
	public void testSottrazioneMatrice() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);

		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 1F);
		m1.addElemento(0, 1, 2F);
		m1.addElemento(1, 0, 1F);
		m1.addElemento(1, 1, 2F);
		
		Matrice m2 = new Matrice(2,2);
		m2.addElemento(0, 0, 0F);
		m2.addElemento(0, 1, 0F);
		m2.addElemento(1, 0, 0F);
		m2.addElemento(1, 1, 0F);
		
		assertTrue(m.sottrazione(m1).equals(m2));
	}

	@Test
	public void testSostituisciRiga() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Vettore v = new Vettore(2, true);
		v.addElemento(0, 3F);
		v.addElemento(1, 4F);
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 3F);
		m1.addElemento(0, 1, 4F);
		m1.addElemento(1, 0, 1F);
		m1.addElemento(1, 1, 2F);
		m.sostituisciRiga(0, v);
		
		assertTrue(m.toString(),m.equals(m1));
	}

	@Test
	public void testSostituisciColonna() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 1F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Vettore v = new Vettore(2);
		v.addElemento(0, 3F);
		v.addElemento(1, 4F);
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 3F);
		m1.addElemento(0, 1, 2F);
		m1.addElemento(1, 0, 4F);
		m1.addElemento(1, 1, 2F);
		m.sostituisciColonna(0, v);
		
		assertTrue(m.toString(), m.equals(m1));
	}

	@Test
	public void testPivotIntInt() {
		Matrice m = new Matrice(2,2);
		m.addElemento(0, 0, 2F);
		m.addElemento(0, 1, 2F);
		m.addElemento(1, 0, 1F);
		m.addElemento(1, 1, 2F);
		
		Matrice m1 = new Matrice(2,2);
		m1.addElemento(0, 0, 0F);
		m1.addElemento(0, 1, -2F);
		m1.addElemento(1, 0, 1F);
		m1.addElemento(1, 1, 2F);
		
		m.pivot(1, 0);
		
		assertTrue(m.toString(),m.equals(m1));
	}

}
