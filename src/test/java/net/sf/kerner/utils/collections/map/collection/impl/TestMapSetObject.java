package net.sf.kerner.utils.collections.map.collection.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMapSetObject {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private MapSetObject mapset01;
    private MapSetObject mapset02;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        mapset01 = null;
        mapset02 = null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public final void testMapSetObject01() {
        mapset01 = new MapSetObject();
        mapset01.put(1, 1);
        mapset02 = new MapSetObject(mapset01);
        assertArrayEquals(new LinkedHashSet(Arrays.asList(1)).toArray(), mapset02.get(1).toArray());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void testPut01() {
        mapset01 = new MapSetObject();
        mapset01.put(1, 1);
        assertArrayEquals(new LinkedHashSet(Arrays.asList(1)).toArray(), mapset01.get(1).toArray());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void testPutAll01() {
        mapset01 = new MapSetObject();
        mapset01.putAll(1, Arrays.asList(1, 2, 3));
        assertArrayEquals(new LinkedHashSet(Arrays.asList(1, 2, 3)).toArray(), mapset01.get(1).toArray());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void testPutAll02() {
        mapset01 = new MapSetObject();
        mapset01.putAll(1, Arrays.asList(1, 2, 3));
        assertArrayEquals(new LinkedHashSet(Arrays.asList(1, 2, 3)).toArray(), mapset01.get(1).toArray());
    }

}
