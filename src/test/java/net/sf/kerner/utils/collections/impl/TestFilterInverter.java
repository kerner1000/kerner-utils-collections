package net.sf.kerner.utils.collections.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.sf.kerner.utils.collections.Filter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFilterInverter {

    private FilterInverter<Boolean> fi;

    private Filter<Boolean> f;

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
    public final void testFilterInverter01() {
        f = new Filter<Boolean>() {
            public Boolean visit(Boolean element) {
                return element;
            }
        };
        fi = new FilterInverter<Boolean>(f);
    }

    @Test(expected = NullPointerException.class)
    public final void testFilterInverter02() {
        fi = new FilterInverter<Boolean>(null);
    }

    @Test
    public final void testVisit01() {
        f = new Filter<Boolean>() {
            public Boolean visit(Boolean element) {
                return element;
            }
        };
        fi = new FilterInverter<Boolean>(f);
        assertFalse(fi.visit(Boolean.TRUE));
    }

    @Test
    public final void testVisit02() {
        f = new Filter<Boolean>() {
            public Boolean visit(Boolean element) {
                return element;
            }
        };
        fi = new FilterInverter<Boolean>(f);
        assertTrue(fi.visit(Boolean.FALSE));
    }

}
