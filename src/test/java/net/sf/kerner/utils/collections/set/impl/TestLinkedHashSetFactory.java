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
package net.sf.kerner.utils.collections.set.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.kerner.utils.collections.set.FactoryLinkedHashSet;

public class TestLinkedHashSetFactory {

    private FactoryLinkedHashSet<String> f;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
	f = new FactoryLinkedHashSet<String>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testCreateCollection01() {
	assertNotNull(f.createCollection());
    }

    @Test
    public final void testCreateCollection02() {
	assertTrue(f.createCollection() instanceof LinkedHashSet);
    }

    @Test
    public final void testCreateCollection03() {
	assertArrayEquals(f.createCollection(Arrays.asList("eins", "zwei")).toArray(),
		new LinkedHashSet<String>(Arrays.asList("eins", "zwei")).toArray());
    }
}
