package net.sf.kerner.utils.collections.list.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestListUtils {

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
	public final void testMeld01() {
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList("c", "d");
		List<String> l3 = Arrays.asList("a", "c", "b", "d");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld02() {
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList("a", "c");
		List<String> l3 = Arrays.asList("a", "b", "c");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld03() {
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList("a", "c");
		List<String> l3 = Arrays.asList("a", "b", "c");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld04() {
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList(null, "c");
		List<String> l3 = Arrays.asList("a", null, "b", "c");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld04b() {
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList(null, "c");
		List<String> l3 = Arrays.asList("a", "b", "c");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, false).toArray());
	}
	
	@Test
	public final void testMeld05() {
		List<String> l1 = Arrays.asList(null, null);
		List<String> l2 = Arrays.asList(null, null);
		List<String> l3 = Arrays.asList(null, null);
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld05b() {
		List<String> l1 = Arrays.asList(null, null);
		List<String> l2 = Arrays.asList(null, null);
		List<String> l3 = Arrays.asList();
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, false).toArray());
	}
	
	@Test
	public final void testMeld06() {
		List<String> l1 = Arrays.asList(null, null);
		List<String> l2 = Arrays.asList("a", null);
		List<String> l3 = Arrays.asList(null, "a", null);
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, true).toArray());
	}
	
	@Test
	public final void testMeld06b() {
		List<String> l1 = Arrays.asList(null, null);
		List<String> l2 = Arrays.asList("a", null);
		List<String> l3 = Arrays.asList("a");
		assertArrayEquals(l3.toArray(), ListUtils.meld(l1, l2, false).toArray());
	}
	
	@Test
	public final void testMeld07() {
		List<Double> l1 = Arrays.asList(0.1, 0.2, 0.4);
		List<Double> l2 = Arrays.asList(null, 0.3);
		List<Double> l3 = Arrays.asList(0.1,0.2,0.3,0.4);
		List<Double> l4 = ListUtils.meld(l1, l2, false);
		System.err.println(l4);
		assertArrayEquals(l3.toArray(), l4.toArray());
	}

	@Ignore
	@Test
	public final void testFill() {
		fail("Not yet implemented"); // TODO
	}

}
