/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-12-06
 *
 */
public class TestObjectToIndexMapperImpl {
	
	private ObjectToIndexMapperImpl mapper;

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

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#ObjectToIndexMapperImpl(java.util.Set)}.
	 */
	@Test
	public final void testObjectToIndexMapperImpl() {
		Set<Object> keys = new LinkedHashSet<Object>();
		mapper = new ObjectToIndexMapperImpl(keys);
		assertEquals(0, mapper.keySet().size());
		assertEquals(0, mapper.values().size());
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#ObjectToIndexMapperImpl(java.util.Set)}.
	 */
	@Test
	public final void testObjectToIndexMapperImpl01() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertEquals(2, mapper.keySet().size());
		assertEquals(2, mapper.values().size());
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#get(java.lang.Object)}.
	 */
	@Test
	public final void testGet() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertEquals(0, mapper.get("eins"));
		assertEquals(1, mapper.get("zwei"));
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#get(java.lang.Object)}.
	 */
	@Test(expected=NoSuchElementException.class)
	public final void testGet01() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		mapper.get("peter");
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#getValue(int)}.
	 */
	@Test
	public final void testGetValue() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertEquals("eins", mapper.getValue(0));
		assertEquals("zwei", mapper.getValue(1));
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#getValue(int)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public final void testGetValue01() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		mapper.getValue(-1);
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#getValue(int)}.
	 */
	@Test(expected=NoSuchElementException.class)
	public final void testGetValue02() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		mapper.getValue(2);
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#containsKey(java.lang.Object)}.
	 */
	@Test
	public final void testContainsKey() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertTrue(mapper.containsKey("eins"));
		assertTrue(mapper.containsKey("zwei"));
		assertFalse(mapper.containsKey("drei"));
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#containsValue(int)}.
	 */
	@Test
	public final void testContainsValue() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertTrue(mapper.containsValue(0));
		assertTrue(mapper.containsValue(1));
		assertFalse(mapper.containsValue(2));
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#values()}.
	 */
	@Test
	public final void testValues() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertArrayEquals(new Integer[]{0,1}, mapper.values().toArray());
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.collections.impl.ObjectToIndexMapperImpl#keySet()}.
	 */
	@Test
	public final void testKeySet() {
		Set<Object> keys = new LinkedHashSet<Object>();
		keys.add("eins");
		keys.add("zwei");
		mapper = new ObjectToIndexMapperImpl(keys);
		assertArrayEquals(keys.toArray(), mapper.keySet().toArray());
	}

}