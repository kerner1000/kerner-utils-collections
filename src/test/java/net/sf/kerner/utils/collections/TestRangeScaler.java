package net.sf.kerner.utils.collections;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRangeScaler {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private RangeScaler rs;

    @Before
    public void setUp() throws Exception {
	rs = new RangeScaler();
    }

    @After
    public void tearDown() throws Exception {
	rs = null;
    }

    @Test
    public final void testScale01() {
	final double[] arr = new double[] { 2, 4, 8 };
	final double[] exp = new double[] { 4, 8, 16 };
	final double[] result = rs.scale(arr, 16);
	assertEquals(exp.length, result.length);
	for (int i = 0; i < exp.length; i++) {
	    assertEquals(exp[i], result[i], 0.0);
	}
    }
}
