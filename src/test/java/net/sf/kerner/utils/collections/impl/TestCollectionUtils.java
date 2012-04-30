package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCollectionUtils {

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
	public final void testFilterCollection201() {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		for (Iterator<? extends Integer> i = c.iterator(); i.hasNext();) {
			i.next();
			i.remove();
		}
		assertEquals(0, c.size());
	}

}
