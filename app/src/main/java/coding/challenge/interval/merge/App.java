/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package coding.challenge.interval.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

	/**
	 * Simple immutable value object representing an interval.
	 */
	public static class Interval {
		int start;
		int end;

		/**
		 * Constructor
		 * 
		 * @param start of the interval
		 * @param end   of the interval
		 */
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		/**
		 * @return the start
		 */
		public int getStart() {
			return start;
		}

		/**
		 * @return the end
		 */
		public int getEnd() {
			return end;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}

	/**
	 * Merges a given list of intervals.
	 * 
	 * Contained intervals must be merged, when overlapping, and kept separate in
	 * the result.
	 * 
	 * @param inputIntervals the list of intervals to merge
	 * @return the list of merged intervals
	 */
	public List<Interval> merge(final List<Interval> inputIntervals) {
		// Verify validity of input first
		if (inputIntervals == null) {
			throw new IllegalArgumentException("A null input list cannot be processed.");
		}

		List<Interval> resultIntervals = new ArrayList<Interval>();
		if (inputIntervals.isEmpty()) {
			return resultIntervals;
		}

		// Make sure, the input intervals are sorted by their starts
		// As the intervals are immutable, the input list can simply be cloned
		List<Interval> sortedInputIntervals = new ArrayList<Interval>(inputIntervals);
		Collections.sort(sortedInputIntervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if (a == null || b == null) {
					throw new IllegalArgumentException(
							"The input list " + inputIntervals + " with null intervals cannot be processed.");
				}

				if (a.getStart() < b.getStart()) {
					return -1;
				}
				if (a.getStart() > b.getStart()) {
					return 1;
				}
				return 0;
			}
		});

		// Take the first interval as starting point
		Interval currentInputInterval = sortedInputIntervals.get(0);
		int currentStart = currentInputInterval.getStart();
		int currentEnd = currentInputInterval.getEnd();

		// If existent start from the second interval with processing further
		for (int i = 1; i < sortedInputIntervals.size(); i++) {
			currentInputInterval = sortedInputIntervals.get(i);

			// Is there a gap and a new result interval must be created?
			if (currentEnd < currentInputInterval.getStart()) {
				resultIntervals.add(new Interval(currentStart, currentEnd));
				currentStart = currentInputInterval.getStart();
			}

			// No gap, but maybe a new end?
			if (currentEnd < currentInputInterval.getEnd()) {
				currentEnd = currentInputInterval.getEnd();
			}
		}

		// Don't forget the last interval
		resultIntervals.add(new Interval(currentStart, currentEnd));

		return resultIntervals;
	}

	public static void main(String[] args) {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(2, 19));
		inputIntervals.add(new Interval(4, 8));
		inputIntervals.add(new Interval(14, 23));
		inputIntervals.add(new Interval(25, 30));
		System.out.println("Input intervals: " + inputIntervals);

		List<Interval> mergeResult = new App().merge(inputIntervals);
		System.out.println("Merge result: " + mergeResult);
	}
}
