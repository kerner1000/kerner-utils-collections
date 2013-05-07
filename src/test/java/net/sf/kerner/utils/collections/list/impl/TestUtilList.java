package net.sf.kerner.utils.collections.list.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.sf.kerner.utils.ObjectPairSame;
import net.sf.kerner.utils.impl.ObjectPairSameImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtilList {

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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void testAllAgainstAll01() {
        final List<Integer> list = Arrays.asList(1, 2, 3);
        final List<ObjectPairSame<Integer>> result = UtilList.allAgainstAll(list);
        assertEquals(3, result.size());
        assertEquals(new ObjectPairSameImpl(1, 2), result.get(0));
        assertEquals(new ObjectPairSameImpl(1, 3), result.get(1));
        assertEquals(new ObjectPairSameImpl(2, 3), result.get(2));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void testAllAgainstAll02() {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4);
        final List<ObjectPairSame<Integer>> result = UtilList.allAgainstAll(list);
        assertEquals(6, result.size());
        assertEquals(new ObjectPairSameImpl(1, 2), result.get(0));
        assertEquals(new ObjectPairSameImpl(1, 3), result.get(1));
        assertEquals(new ObjectPairSameImpl(1, 4), result.get(2));
        assertEquals(new ObjectPairSameImpl(2, 3), result.get(3));
        assertEquals(new ObjectPairSameImpl(2, 4), result.get(4));
        assertEquals(new ObjectPairSameImpl(3, 4), result.get(5));
    }

}
