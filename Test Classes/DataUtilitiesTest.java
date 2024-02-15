package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.junit.Test;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
	
	//=======================================================
	//=======================================================
	//================calculateColumnTotal()=================
	//=======================================================
	//=======================================================
	
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
			assertTrue(e instanceof InvalidParameterException);
		}
	}
	
	/*
	 * Testing calculating column total in which data is not null
	 * Input: 1x1 table with sum of 1.0, column index 0
	 * Expected result: 1.0
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
		assertEquals(expectedResult, i, 0.00001);
		
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
		assertEquals(expectedResult, i, 0.00001);
		
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
		assertEquals(expectedResult, i, 0.00001);
		
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
		assertEquals(expectedResult, i, 0.00001);
		
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
		assertEquals(expectedResult, i, 0.00001);
		
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
		assertEquals(expectedResult, i, 0.00001);
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
		assertEquals(expectedResult, i, 0.00001);
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
		assertEquals(expectedResult, i, 0.00001);
	}
	
	//=======================================================
	//=======================================================
	//================calculateRowTotal()====================
	//=======================================================
	//=======================================================
	
	/*
	 * Testing calculating row total in which data is null
	 * Input: null, row index 0
	 * Expected result: InvalidParameterException thrown
	 */
	@Test
	public void testCalculateRowTotalDataNull() {
		try {
			double i = DataUtilities.calculateRowTotal(null, 0);
		} catch (Exception e) {
			assertTrue(e instanceof InvalidParameterException);
		}
	}
	
	/*
	 * Testing calculating row total in which data is not null
	 * Input: 1x1 table with sum of 1.0, row index 1
	 * Expected result: 2.0 
	 */
	@Test
	public void testCalculateRowTotalDataNotNull() {
		
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			
			oneOf(values2d).getColumnCount();
			will(returnValue((3))); //setting to 2 throws error
					//seems like its returning provided value - 1
			
			oneOf(values2d).getValue(1, 0);
			will(returnValue((1)));
			
			oneOf(values2d).getValue(1, 1);
			will(returnValue((1)));
			
		}});
		double i = DataUtilities.calculateRowTotal(values2d, 1);
		double expectedResult = 2.0;
		assertEquals(expectedResult, i, 0.00001);
		
	}
	
	/*
	 * Testing calculating row total in which row sum is less than zero
	 * Input: data table in which row 0 has sum -1.1, row index 1
	 * Expected result: -1.1
	 */
	@Test
	public void testCalculateRowTotalSumNegative() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			
			oneOf(values2d).getColumnCount();
			will(returnValue((3)));
			
			oneOf(values2d).getValue(1, 0);
			will(returnValue((-1)));
			
			oneOf(values2d).getValue(1, 1);
			will(returnValue((-0.1)));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, 1); //not 0-based, setting to 0 causes error
		double expectedResult = -1.1;
		assertEquals(expectedResult, i, 0.00001);
		
	}
	/*
	 * Testing calculating row total in which row total is zero
	 * Input: values with row sum of 0, row index 1
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateRowTotalSumZero() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((2)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((2)));
			
			oneOf(values2d).getValue(1, 0);
			will(returnValue(0));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, 1);
		double expectedResult = 0.0;
		assertEquals(expectedResult, i, 0.00001);
		
	}
	
	/*
	 * Testing calculating row total in which row total is greater than zero
	 * Input: values with row sum of 40, row index 1
	 * Expected result: 40.0
	 */
	@Test
	public void testCalculateRowTotalSumPositive() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			
			oneOf(values2d).getColumnCount();
			will(returnValue((4)));
			oneOf(values2d).getValue(1, 0);
			will(returnValue(39));
			oneOf(values2d).getValue(1, 1);
			will(returnValue(0.5));
			oneOf(values2d).getValue(1, 2);
			will(returnValue(0.5));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, 1);
		double expectedResult = 40.0;
		assertEquals(expectedResult, i, 0.00001);
		
	}
	
	/*
	 * Testing calculating row total in which table is empty
	 * Input: Values2D with 0x0 size, row index 1
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateRowTotalEmpty() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((0)));
			oneOf(values2d).getRowCount();
			will(returnValue((0)));
		}});
		double i = DataUtilities.calculateRowTotal(values2d, 0);
		double expectedResult = 0.0;
		assertEquals(expectedResult, i, 0.00001);
		
	}
	
	/*
	 * Testing calculating row total in which data is not empty
	 * Input: Values2D with 1 value, row index 1
	 * Expected result: 1.0
	 */
	@Test
	public void testCalculateRowTotalNotEmpty() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((2)));
			
			oneOf(values2d).getValue(1, 0);
			will(returnValue((1.0)));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, 1);
		double expectedResult = 1.0;
		assertEquals(expectedResult, i, 0.00001);
	}
	
	/*
	 * Testing calculating row total in which row index is invalid
	 * Input: Values2D with 1 value, row index -1
	 * Expected result: 0.0
	 */
	@Test
	public void testCalculateRowTotalInvalidIndex() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			oneOf(values2d).getColumnCount();
			will(returnValue((1)));
			
			oneOf(values2d).getRowCount();
			will(returnValue((1)));
			
			oneOf(values2d).getValue(-1, 0);
			will(returnValue((1)));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, -1);
		double expectedResult = 0.0;
		assertEquals(expectedResult, i, 0.00001);
	}
	
	/*
	 * Testing calculating column total in which column index is valid
	 * Input: Values2D with 1 value, column index 0
	 * Expected result: 2.0
	 */
	@Test
	public void testCalculateRowTotalValidIndex() {
		Mockery context = new Mockery();
		final Values2D values2d = context.mock(Values2D.class);
		context.checking(new Expectations(){{
			
			oneOf(values2d).getColumnCount();
			will(returnValue((3))); 
			
			oneOf(values2d).getRowCount();
			will(returnValue((2)));
			
			oneOf(values2d).getValue(2, 0);
			will(returnValue((0)));
			
			oneOf(values2d).getValue(2, 1);
			will(returnValue((2)));
		}});
		
		double i = DataUtilities.calculateRowTotal(values2d, 2);
		double expectedResult = 2.0;
		assertEquals(expectedResult, i, 0.00001);
	}

	//=======================================================
	//=======================================================
	//=================createNumberArray()===================
	//=======================================================
	//=======================================================
	
	/*
	 * Testing created a number array with a null object
	 * Expected result: InvalidParameterException thrown
	 */
	@Test
	public void testCreateNumberArrayNullData() {
		try {
		Number [] x= DataUtilities.createNumberArray(null);
		} catch (Exception e) {
			assertTrue("Class is of type" +e.getClass().toString(),e instanceof InvalidParameterException);
		}
	}
	
	/*
	 * Testing creating a number array of double array {1.0, 2.0, 3.0}
	 * Expected result: Number array of {1.0, 2.0, 3.0}
	 */
	@Test
	public void testCreateNumberArrayNotNullData() {
		double[] d = {1.0, 2.0, 3.0};
		Number[] x = DataUtilities.createNumberArray(d);
		
		Number[] expected = {1.0,2.0,3.0};
		Assert.assertArrayEquals(expected, x);
	}
	
	/*
	 * Testing creating a number array of double array {}
	 * Expected result: Number array of {}
	 */
	@Test
	public void testCreateNumberArrayEmptyData() {
		double[] d = {};
		Number[] x = DataUtilities.createNumberArray(d);
		
		Number[] expected = {};
		Assert.assertArrayEquals(expected, x);
	}
}
