package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
        exampleRange1 = new Range(-1, 1);
        exampleRange2 = new Range(1, 5);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange1.getCentralValue(), .000000001d);
    }
    
    
    /*
     * Testing toString function
     * Input: range with 1 lower and 5 upper
     * Expected result: Range[1.0,5.0]
     */
    @Test
    public void toStringTest() {
        assertEquals("The expected toString() return does not match expected. ",
                "Range[1.0,5.0]",exampleRange2.toString());
    }
    /*
     * Testing toString function with negative range
     * Input: range with -1 lower and 1 upper
     * Expected result: Range[-1.0,1.0]
     */
    @Test
    public void toStringTestWithNegative() {
        assertEquals("The expected toString() return does not match expected. ",
                "Range[-1.0,1.0]",exampleRange1.toString());
    }
    
    /*
     * Testing shift function with a positive delta on a Range with positive bounds 
     * Input: Range[1.0,5.0]
     * Expected result: Range[3.0,7.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, 2), new Range(3.0, 7.0));
    }
    
    /*
     * Testing shift function with a positive delta on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[1.0,3.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange1, 2), new Range(1.0, 3.0));
    }
    
    /*
     * Testing shift function with a positive delta on a Range with a negative bound 
     * Input: Range[1.0,5.0]
     * Expected result: Range[-1.0,3.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, -2), new Range(-1.0, 3.0));
    }
    
    /*
     * Testing shift function with a positive delta on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[-3.0,-1.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange1, -2), new Range(-3.0, -1.0));
    }
    
    /*
     * Testing intersects function on ranges that intersect within bounds
     * Input: Range[-1.0,1.0] with 0.0 and 2.0
     * Expected result: True
     */
    @Test
    public void intersectsWithinBoundsTest() {
    	assertTrue("Ranges from -1 to 1 and 0 to 2 don't intersect as expected", exampleRange1.intersects(0.0, 2.0));
    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 0.0 and 2.0
     * Expected result: True
     */
    @Test
    public void intersectsOnBoundsTest() {
    	assertTrue("Ranges from -1 to 1 and 1 to 2 don't intersect as expected", exampleRange1.intersects(1.0, 2.0));
    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 2.0 and 3.0
     * Expected result: False
     */
    @Test
    public void intersectOutsideBoundsTest() {
    	assertFalse("Ranges from -1 to 1 and 2 to 3 shouldn't intersect", exampleRange1.intersects(2.0, 3.0));
    }
    
    
    @After
    public void tearDown() throws Exception {
    	exampleRange1 = null;
        exampleRange2 = null;
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}