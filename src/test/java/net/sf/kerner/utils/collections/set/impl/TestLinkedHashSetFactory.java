package net.sf.kerner.utils.collections.set.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinkedHashSetFactory {
	
	private FactoryLinkedHashSet<String> f;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		f = new FactoryLinkedHashSet<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateCollection01() {
		assertNotNull(f.createCollection());
	}
	
	@Test
	public final void testCreateCollection02() {
		assertTrue(f.createCollection() instanceof LinkedHashSet);
	}
	
	@Test
	public final void testCreateCollection03() {
		assertArrayEquals(f.createCollection(Arrays.asList("eins", "zwei")).toArray(), new LinkedHashSet<String>(Arrays.asList("eins", "zwei")).toArray());
	}
}