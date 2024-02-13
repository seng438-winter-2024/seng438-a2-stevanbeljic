package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.junit.Test;

import junit.framework.Assert;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class DataUtilitiesTest extends DataUtilities {

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
	
	/*
	 * Test code for org.jfree.data.DataUtilities class
	 */
	
	/*
	 * Testing calculating column total in which data is null
	 * Input: null, column index 0
	 * Expected result: InvalidParameterException thrown
	 */
	@Test
	public void testCalculateColumnTotalDataNull() {
		try {
			double i = DataUtilities.calculateColumnTotal(null, 0);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof InvalidParameterException);
		}
	}
	
	/*
	 * Testing calculating column total in which data is null
	 * Input: 1x1 table with sum of 1.0, column index 0
	 * Expected result: 1.0 thrown
	 */
	@Test
	public void testCalculateColumnTotalDataNotNull() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((1)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((1)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue(1));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 1.0;
		Assert.assertEquals(expectedResult, i);
		
	}
	
	/*
	 * Testing calculating column total in which column sum is less than zero
	 * Input: 2x2 data table in which column 0 has sum -4.1, column index 0
	 * Expected result: -4.1
	 */
	@Test
	public void testCalculateColumnTotalSumNegative() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((2)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((2)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue(-4.0));
			oneOf(values2d).getValue(1, 0);
			will(returnValue(-0.1));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = -4.1;
		Assert.assertEquals(expectedResult, i);
		
	}
	/*
	 * Testing calculating column total in which column total is zero
	 * Input: 2x2 values with column sum of 0, column index 0
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateColumnTotalSumZero() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((2)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((2)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue(0));
			oneOf(values2d).getValue(1, 0);
			will(returnValue(0));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 0.0;
		Assert.assertEquals(expectedResult, i);
		
	}
	
	/*
	 * Testing calculating column total in which column total is greater than zero
	 * Input: 3x2 values with column sum of 36, column index 0
	 * Expected result: 37.0
	 */
	@Test
	public void testCalculateColumnTotalSumPositive() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((2)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((3)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue(25.5));
			oneOf(values2d).getValue(1, 0);
			will(returnValue(10.5));
			oneOf(values2d).getValue(2, 0);
			will(returnValue(1));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 37.0;
		Assert.assertEquals(expectedResult, i, 0.1);
		
	}
	
	/*
	 * Testing calculating column total in which table is empty
	 * Input: Values2D with 0x0 size, column index 0
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateColumnTotalEmpty() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getRowCount();
			will(returnValue((0)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((0)));
		}});
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 0.0;
		Assert.assertEquals(expectedResult, i);
		
	}
	
	/*
	 * Testing calculating column total in which data is not empty
	 * Input: Values2D with 1 value, column index 0
	 * Expected result: 1.0
	 */
	@Test
	public void testCalculateColumnTotalNotEmpty() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((1)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((1)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue((1)));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 1.0;
		Assert.assertEquals(expectedResult, i);
	}
	
	/*
	 * Testing calculating column total in which column index is invalid
	 * Input: Values2D with 1 value, column index -1
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateColumnTotalInvalidIndex() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((1)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((1)));
			
			oneOf(values2d).getValue(0, -1);
			will(returnValue((1)));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, -1);
		double expectedResult = 1.0;
		Assert.assertEquals(expectedResult, i);
	}
	
	/*
	 * Testing calculating column total in which column index is valid
	 * Input: Values2D with 1 value, column index 0
	 * Expected result: 2.0
	 */
	@Test
	public void testCalculateColumnTotalValidIndex() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((1)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((1)));
			
			oneOf(values2d).getValue(0, 0);
			will(returnValue((2)));
		}});
		
		double i = DataUtilities.calculateColumnTotal(values2d, 0);
		double expectedResult = 2.0;
		Assert.assertEquals(expectedResult, i);
	}
	
	
}
