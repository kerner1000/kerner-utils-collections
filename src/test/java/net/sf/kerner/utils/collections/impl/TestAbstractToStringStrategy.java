package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAbstractToStringStrategy {

	private AbstractToStringStrategy<?> s;

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
	public final void test01() {
		s = new AbstractToStringStrategy<Object>(1) {
			public String visit(Object element) {
				return element.toString();
			}
		};
		assertEquals("1", s.toString());
	}

	@Test
	public final void test02() {
		s = new AbstractToStringStrategy<Object>(1) {
			public String visit(Object element) {
				return null;
			}
		};
		assertEquals("null", s.toString());
	}

	@Test
	public final void test03() {
		s = new AbstractToStringStrategy<Object>(null) {
			public String visit(Object element) {
				return null;
			}
		};
		assertEquals("null", s.toString());
	}

}
