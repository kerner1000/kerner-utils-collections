package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Enumeration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIteratorToEnumerationTransformer {

	@SuppressWarnings("rawtypes")
	private IteratorToEnumerationTransformer t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testTransform01() {
		t = new IteratorToEnumerationTransformer<String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> e = t.transform(Arrays.asList("1", "2", "3").iterator());
		assertEquals("1", e.nextElement());
		assertEquals("2", e.nextElement());
		assertEquals("3", e.nextElement());
	}

}
