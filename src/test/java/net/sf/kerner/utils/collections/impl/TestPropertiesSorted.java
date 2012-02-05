package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertEquals;

import java.util.Enumeration;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPropertiesSorted {

	private PropertiesSorted p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		p = new PropertiesSorted();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testKeys01() {
		p.put("2", "zwei");
		p.put("3", "drei");
		p.put("1", "eins");
		Enumeration<Object> it = p.keys();
		assertEquals("1", it.nextElement());
		assertEquals("2", it.nextElement());
		assertEquals("3", it.nextElement());
	}

	@Test
	public final void testKeySet01() {
		p.put("2", "zwei");
		p.put("3", "drei");
		p.put("1", "eins");
		Iterator<Object> it = p.keySet().iterator();
		assertEquals("1", it.next());
		assertEquals("2", it.next());
		assertEquals("3", it.next());
	}

}
