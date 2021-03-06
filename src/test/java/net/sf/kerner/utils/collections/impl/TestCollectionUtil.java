/*******************************************************************************
 * Copyright (c) 2010-2014 Alexander Kerner. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import net.sf.kerner.utils.collections.UtilCollection;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestCollectionUtil {

    @Test
    public final void testAppend01() {
	final Collection<Integer> c1 = Arrays.asList(1, 2, 3);
	final Collection<Integer> c2 = Arrays.asList(4, 5, 6);
	final Collection<Integer> c3 = UtilCollection.append(c1, c2);
	final Collection<Integer> c4 = Arrays.asList(1, 2, 3, 4, 5, 6);
	assertArrayEquals(c4.toArray(), c3.toArray());
    }

    @Test
    public final void testAppend02() {
	final Collection<Integer> c1 = Arrays.asList(1, 2, 3);
	final Collection<Integer> c2 = Arrays.asList(1);
	final Collection<Integer> c3 = UtilCollection.append(c1, c2);
	final Collection<Integer> c4 = Arrays.asList(1, 2, 3, 1);
	assertArrayEquals(c4.toArray(), c3.toArray());
    }

    @Test(expected = NullPointerException.class)
    public final void testAppend03() {
	final Collection<Integer> c1 = null;
	final Collection<Integer> c2 = Arrays.asList(1);
	UtilCollection.append(c1, c2);
    }

    @Test(expected = NullPointerException.class)
    public final void testAppend04() {
	final Collection<Integer> c1 = Arrays.asList(1);
	final Collection<Integer> c2 = null;
	UtilCollection.append(c1, c2);
    }

    @Test
    public final void testAreAllEqual01() {
	final Collection c = Arrays.asList(1, 2, 3);
	assertFalse(UtilCollection.areAllEqual(c));
    }

    @Test
    public final void testAreAllEqual02() {
	final Collection c = Arrays.asList(1, 1, 1);
	assertTrue(UtilCollection.areAllEqual(c));
    }

    @Test
    public final void testAreAllEqual03() {
	final Collection c = Arrays.asList(1, 1, 2);
	assertFalse(UtilCollection.areAllEqual(c));
    }

    @Test
    public final void testAreAllEqual04() {
	final Collection c = Arrays.asList(1, 1, 2, 2, 2, 2);
	assertFalse(UtilCollection.areAllEqual(c));
    }

    @Test
    public final void testContainsNull01() {
	final Collection<Integer> c1 = Arrays.asList(1, 2, 3);
	final boolean result = UtilCollection.containsNull(c1);
	assertEquals(false, result);
    }

    @Test
    public final void testContainsNull02() {
	final Collection<Integer> c1 = Arrays.asList(null, 2, 3);
	final boolean result = UtilCollection.containsNull(c1);
	assertEquals(true, result);
    }

    @Test(expected = NullPointerException.class)
    public final void testContainsNull03() {
	UtilCollection.containsNull(null);
    }

    @Test
    public final void testGetIntersection01() {
	final Collection a = Arrays.asList(1, 2, 3);
	final Collection b = Arrays.asList(3, 4, 5);
	assertTrue(UtilCollection.getIntersection(a, b).size() == 1);
	assertEquals(3, UtilCollection.getIntersection(a, b).iterator().next());
    }

    @Test
    public final void testGetSame01() {
	final Collection c = Arrays.asList(1, 2, 3, 3, 4, 5);
	final Collection<Collection<Integer>> same = UtilCollection.getSame(c);
	assertEquals(1, same.size());
	assertArrayEquals(new Integer[] { 3, 3 }, same.iterator().next().toArray());
    }

    @Test
    public final void testGetSame02() {
	final Collection c = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
	final Collection<Collection<Integer>> same = UtilCollection.getSame(c);
	assertEquals(2, same.size());
	final Iterator<Collection<Integer>> it = same.iterator();
	assertArrayEquals(new Integer[] { 3, 3 }, it.next().toArray());
	assertArrayEquals(new Integer[] { 4, 4 }, it.next().toArray());
    }

    @Test
    public final void testGetSame03() {
	final Collection c = Arrays.asList(4, 1, 2, 3, 3, 4, 4, 5);
	final Collection<Collection<Integer>> same = UtilCollection.getSame(c);

	assertEquals(2, same.size());
	final Iterator<Collection<Integer>> it = same.iterator();
	assertArrayEquals(new Integer[] { 4, 4, 4 }, it.next().toArray());
	assertArrayEquals(new Integer[] { 3, 3 }, it.next().toArray());

    }

    @Test
    public final void testGetSame04() {
	final Collection c = Arrays.asList(1, 2, 3);
	final Collection<Collection<Integer>> same = UtilCollection.getSame(c);
	assertEquals(0, same.size());
    }
}
