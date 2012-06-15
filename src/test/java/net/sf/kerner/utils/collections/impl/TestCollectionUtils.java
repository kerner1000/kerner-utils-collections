package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestCollectionUtils {

    @Test
    public final void testAppend01() {
        Collection<Integer> c1 = Arrays.asList(1, 2, 3);
        Collection<Integer> c2 = Arrays.asList(4, 5, 6);
        Collection<Integer> c3 = CollectionUtil.append(c1, c2);
        Collection<Integer> c4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertArrayEquals(c4.toArray(), c3.toArray());
    }

    @Test
    public final void testAppend02() {
        Collection<Integer> c1 = Arrays.asList(1, 2, 3);
        Collection<Integer> c2 = Arrays.asList(1);
        Collection<Integer> c3 = CollectionUtil.append(c1, c2);
        Collection<Integer> c4 = Arrays.asList(1, 2, 3, 1);
        assertArrayEquals(c4.toArray(), c3.toArray());
    }

    @Test(expected = NullPointerException.class)
    public final void testAppend03() {
        Collection<Integer> c1 = null;
        Collection<Integer> c2 = Arrays.asList(1);
        CollectionUtil.append(c1, c2);
    }

    @Test(expected = NullPointerException.class)
    public final void testAppend04() {
        Collection<Integer> c1 = Arrays.asList(1);
        Collection<Integer> c2 = null;
        CollectionUtil.append(c1, c2);
    }

    @Test
    public final void testContainsNull01() {
        Collection<Integer> c1 = Arrays.asList(1, 2, 3);
        boolean result = CollectionUtil.containsNull(c1);
        assertEquals(false, result);
    }

    @Test
    public final void testContainsNull02() {
        Collection<Integer> c1 = Arrays.asList(null, 2, 3);
        boolean result = CollectionUtil.containsNull(c1);
        assertEquals(true, result);
    }

    @Test(expected = NullPointerException.class)
    public final void testContainsNull03() {
        CollectionUtil.containsNull(null);
    }

    @Test
    public final void testGetIntersection01() {
        Collection a = Arrays.asList(1, 2, 3);
        Collection b = Arrays.asList(3, 4, 5);
        assertTrue(CollectionUtil.getIntersection(a, b).size() == 1);
        assertEquals(3, CollectionUtil.getIntersection(a, b).iterator().next());
    }

}
