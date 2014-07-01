package com.forfle.foxandvacation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.forfle.foxandvacation.FoxAndVacation;

/**
 * SRM 561 - FoxAndVacation (Test)
 * 
 * @author Yunho Lee
 * 
 */
public class FoxAndVacationTest {
	
	FoxAndVacation foxAndVacation;

	@Before
	public void setup() {
		foxAndVacation = new FoxAndVacation();
	}

	@Test
	public void 유효한인풋() {
		int expected = 4;
		int actual = foxAndVacation.maxCities(10, new int[] { 7, 1, 5, 6, 1, 3, 4 });
		assertEquals(expected, actual);
	}

	@Test
	public void 인풋제약사항1() {
		int expected = -1;
		int actual = foxAndVacation.maxCities(0, new int[] { 2, 2, 2 });
		assertEquals(expected, actual);

		actual = foxAndVacation.maxCities(51, new int[] { 2, 2, 2 });
		assertEquals(expected, actual);
	}

	@Test
	public void 인풋제약사항2() {
		int expected = -1;
		int actual = foxAndVacation.maxCities(1, new int[] {});
		assertEquals(expected, actual);

		actual = foxAndVacation.maxCities(1, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
		assertEquals(expected, actual);
	}

	@Test
	public void 인풋제약사항3() {
		int expected = -1;
		int actual = foxAndVacation.maxCities(1, new int[] { 0, 1, 1 });
		assertEquals(expected, actual);

		actual = foxAndVacation.maxCities(1, new int[] { 51, 1, 1 });
		assertEquals(expected, actual);
	}

}
