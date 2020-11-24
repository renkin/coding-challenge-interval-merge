/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package coding.challenge.interval.merge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

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

	public List<Interval> merge(List<Interval> inputIntervals) {
		if (inputIntervals == null) {
			throw new IllegalArgumentException("null input cannot be processed.");
		}
		
		List<Interval> resultIntervals = new ArrayList<Interval>();
		if (inputIntervals.isEmpty()) {
			return resultIntervals;
		}
		
		Interval currentInputInterval = inputIntervals.get(0);
		int currentStart = currentInputInterval.getStart();
		int currentEnd = currentInputInterval.getEnd();
		for (int i = 1; i < inputIntervals.size(); i++) {
			currentInputInterval = inputIntervals.get(i);
			if (currentEnd < currentInputInterval.getStart()) {
				resultIntervals.add(new Interval(currentStart, currentEnd));
				currentStart = currentInputInterval.getStart();
			}
			if (currentEnd < currentInputInterval.getEnd()) {
				currentEnd = currentInputInterval.getEnd();
			}
		}
		resultIntervals.add(new Interval(currentStart, currentEnd));
		return resultIntervals;
	}

	public static void main(String[] args) {
		List<Interval> inputIntervals = new ArrayList<Interval>();
		inputIntervals.add(new Interval(1, 2));
		System.out.println(new App().merge(inputIntervals));
	}
}
