package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.sf.kerner.utils.impl.ComparatorIntegerDefault;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtilCollection {

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
    public final void testGetHighest01() {
        final List<Integer> input = Arrays.asList(1, 2, 1);
        assertEquals(Integer.valueOf(2), UtilCollection.getHighest(input, new ComparatorIntegerDefault()));
    }

    @Test
    public final void testGetHighest02() {
        final List<Integer> input = Arrays.asList(1, 2, 3);
        assertEquals(Integer.valueOf(3), UtilCollection.getHighest(input, new ComparatorIntegerDefault()));
    }

}
