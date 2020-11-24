/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package coding.challenge.interval.merge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coding.challenge.interval.merge.App.Interval;

/**
 * Unit test for {@link App}.
 */
class AppTest {

	private App classUnderTest;

	@BeforeEach
	void setUp() {
		classUnderTest = new App();
	}

	@Test
	void givenSingleInterval_ThenExpectEqualInterval() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 2));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(1, 2)), mergeResult);

	}

	@Test
	void givenEmptyIntervalList_ThenExpectEmptyList() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(), mergeResult);
	}

	@Test
	void givenNull_ThenExpectException() {
		try {
			classUnderTest.merge(null);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	@Test
	void givenTwoSeparateIntervals_ThenExpectEqualIntervals() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 2));
		inputIntervals.add(new Interval(3, 4));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(1, 2), new Interval(3, 4)), mergeResult);
	}

	@Test
	void givenTwoOverlappingIntervals_ThenExpectSingleMergedInterval() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 3));
		inputIntervals.add(new Interval(2, 4));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(1, 4)), mergeResult);
	}

	@Test
	void givenThreeOverlappingIntervals_ThenExpectSingleMergedInterval() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 3));
		inputIntervals.add(new Interval(2, 4));
		inputIntervals.add(new Interval(4, 5));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(1, 5)), mergeResult);
	}

	@Test
	void givenFourPartlyOverlappingIntervals_ThenExpectTwoMergedInterval() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(2, 19));
		inputIntervals.add(new Interval(4, 8));
		inputIntervals.add(new Interval(14, 23));
		inputIntervals.add(new Interval(25, 30));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(2, 23), new Interval(25, 30)), mergeResult);
	}

	@Test
	void givenUnsortedFourPartlyOverlappingIntervals_ThenExpectTwoMergedInterval() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(25, 30));
		inputIntervals.add(new Interval(2, 19));
		inputIntervals.add(new Interval(14, 23));
		inputIntervals.add(new Interval(4, 8));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(2, 23), new Interval(25, 30)), mergeResult);
	}

	@Test
	void givenTwoIntervalsWithOneBeingNull_ThenExpectException() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 2));
		inputIntervals.add(null);
		try {
			classUnderTest.merge(inputIntervals);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	@Test
	void givenTwoSeparateIntervalsFromMinToMax_ThenExpectEqualIntervals() {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(Integer.MIN_VALUE, 0));
		inputIntervals.add(new Interval(1, Integer.MAX_VALUE));
		List<Interval> mergeResult = classUnderTest.merge(inputIntervals);
		assertEquals(Arrays.asList(new Interval(Integer.MIN_VALUE, 0), new Interval(1, Integer.MAX_VALUE)),
				mergeResult);
	}
}
