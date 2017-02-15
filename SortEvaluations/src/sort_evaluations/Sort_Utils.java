package sort_evaluations;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * Methods for generating test data, testing sortedness, timing, etc.
 * 
 * 
 * 
 */
public class Sort_Utils {

	// two fields to store start time and end time values
	private long startTime;
	private long endTime;

	/**
	 * Test to make sure the array is sorted from smallest to largest.
	 * 
	 * @param array
	 *            - array to assert is sorted
	 * @return whether array is sorted
	 */
	private static boolean is_sorted(ArrayList<Integer> array) {
		// If size is 0 or 1, array guaranteed to be sorted.
		if (array.size() == 0 || array.size() == 1) {
			return true;
		}

		// Check each value against the previous one, if prev. is bigger, not
		// sorted.
		int previous = array.get(0);
		for (int index = 1; index < array.size(); index++) {
			if (previous > array.get(index))
				return false;
			previous = array.get(index);
		}
		// If we reach here, each is larger than previous so its sorted.
		return true;
	}

	/**
	 * test to (kindof) make sure two arrays contain the same values
	 * 
	 * @param array1
	 *            - first array to compare.
	 * @param array2
	 *            - second array to compare.
	 * @return whether the provided arrays's sums are equal.
	 */
	private static boolean sum_equals(ArrayList<Integer> array1, ArrayList<Integer> array2) {
		if (array1.size() != array2.size()) {
			// If two are diff size, can't be equal.
			return false;
		}

		// Add together all elements in both arrays and compare sums.
		int sumArray1 = 0;
		int sumArray2 = 0;

		for (int index = 0; index < array1.size(); index++) {
			sumArray1 += array1.get(index);
			sumArray2 += array2.get(index);
		}

		return sumArray1 == sumArray2;
	}

	/**
	 * generate an array of 'size' which is already sorted
	 * 
	 * @param size
	 *            - length of sorted array.
	 * @return array list of sorted data of specified size.
	 */
	private static ArrayList<Integer> generate_sorted_array(int size) {
		// Generate arraylist with each value same as index.
		ArrayList<Integer> sortedArray = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			sortedArray.add(index);
		}
		return sortedArray;
	}

	/**
	 * generate an array of 'size' which is in reverse order largest to smallest
	 * 
	 * @param size
	 *            - length of back sorted array.
	 * @return array list of reverse sorted data of specified size.
	 */
	private static ArrayList<Integer> generate_reverse_sorted_array(int size) {
		// Generate arraylist with value size - index.
		ArrayList<Integer> sortedArray = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			sortedArray.add(size - index);
		}
		return sortedArray;
	}

	/**
	 * generate an array of 'size' that has random elements with values from 0
	 * to max
	 * 
	 * @param size
	 *            - length of array.
	 * @param max
	 *            - highest bound for random val.
	 * @return array list of random data.
	 */
	private static ArrayList<Integer> generate_random_array(int size, int max) {
		Random randomNumGen = new Random();

		// Generate arraylist with random value.
		ArrayList<Integer> sortedArray = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			sortedArray.add(randomNumGen.nextInt(max));
		}
		return sortedArray;
	}

	/**
	 * generate an array of 'size' that has all the same element
	 * 
	 * @param size
	 *            - length of array.
	 * @param element
	 *            - element to place in each position.
	 * @return array list of same data.
	 */
	private static ArrayList<Integer> generate_same_array(int size, int element) {
		// Generate arraylist with each location being element.
		ArrayList<Integer> sortedArray = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			sortedArray.add(element);
		}
		return sortedArray;
	}

	/**
	 * This function will call the implemented sorted routines and time them. It
	 * will check already sorted arrays, reverse sorted arrays, random value
	 * arrays, and the same value arrays
	 *
	 * 
	 * @param sort_routine
	 *            - the routine to test
	 * @param start_count
	 *            - how many elements to put in the array
	 * @param count_increment
	 *            - how many elments to go up for each iteration
	 * @param max_count
	 *            - when to stop testing
	 * @param timeout_threshold_seconds
	 *            - if the last iteration of the test took more time than this
	 *            number, don't do any more tests in this category.
	 * 
	 *            Note: the timeout_threshold_seconds probably won't come into
	 *            consideration until you start timing really big array sets
	 */
	public void test_and_time(Sorter<Integer> sort_routine, int start_count, int count_increment, int max_count,
			int timeout_threshold_seconds) {
		System.out.printf("Sorting Using %s:\n", sort_routine.name_of_sort());
		System.out.printf("Time Analysis for \n");
		System.out.printf("\t\t\t\t\t\tRandom * 10e6 vs.\tWorst Case * 10e6 vs. \n");
		System.out.printf("   count\tsorted\treverse\trandom\tsame\t%10s\t%10s\n",
				sort_routine.get_expected_complexity_class().toString(),
				sort_routine.get_expected_complexity_class().toString());
		System.out.flush();

		double time_sorted = -1;
		double time_reverse_sorted = -1;
		double time_random = -1;
		double time_all_same = -1;

		boolean do_sorted = true;
		boolean do_reverse = true;
		boolean do_random = true;
		boolean do_same = true;

		for (int count = start_count; count <= max_count; count += count_increment) {

			ArrayList<Integer> test = null;

			///////////////////////////////////////////////////
			// TEST All Same
			if (do_same) {

				try {
					test = generate_same_array(count, count);

					timer_on();
					sort_routine.sort(test);
					timer_off();
					time_all_same = get_time();

					if (!is_sorted(test)) {
						System.out.printf("Error encountered. Array not sorted!\n");
						return;
					}

					if (time_all_same > timeout_threshold_seconds) {
						System.out.println("Sorting all same array taking too long");
						do_same = false;
						time_all_same = -1;
					}

				} catch (java.lang.OutOfMemoryError error) {
					System.out.println(" Sorting the same numbers caused an out of memory error");
					do_same = false;
					time_all_same = -1;
				} catch (java.lang.StackOverflowError error) {
					System.out.println(
							" Stack Overflow - Probably sorting the same numbers caused an stack overflow error");
					do_same = false;
					time_all_same = -1;
				}
			}

			///////////////////////////////////////////////////
			// TEST RANDOM
			if (do_random) {

				try {
					test = generate_random_array(count, count);

					timer_on();
					sort_routine.sort(test);
					timer_off();
					time_random = get_time();

					if (!is_sorted(test)) {
						System.out.printf("Error encountered. Array not sorted!\n");
						return;
					}

					if (time_random > timeout_threshold_seconds) {
						System.out.println("Sorting random array taking too long");
						do_random = false;
						time_random = -1;
					}

				} catch (java.lang.OutOfMemoryError error) {
					System.out.println(" Sorting random numbers caused an out of memory error");
					do_random = false;
					time_random = -1;
				} catch (java.lang.StackOverflowError error) {
					System.out.println(
							" Stack Overflow - Probably sorting random numbers caused an stack overflow error");
					do_random = false;
					time_random = -1;
				}
			}

			/////////////////////////////////////////////////////////
			// TEST already SORTED
			if (do_sorted) {

				try {
					test = generate_random_array(count, count);

					timer_on();
					sort_routine.sort(test);
					timer_off();
					time_sorted = get_time();

					if (!is_sorted(test)) {
						System.out.printf("Error encountered. Array not sorted!\n");
						return;
					}

					if (time_sorted > timeout_threshold_seconds) {
						System.out.println("Sorting sorted array taking too long");
						do_sorted = false;
						time_sorted = -1;
					}

				} catch (java.lang.OutOfMemoryError error) {
					System.out.println(" Sorting sorted numbers caused an out of memory error");
					do_sorted = false;
					time_sorted = -1;
				} catch (java.lang.StackOverflowError error) {
					System.out.println(
							" Stack Overflow - Probably sorting sorted numbers caused an stack overflow error");
					do_sorted = false;
					time_sorted = -1;
				}
			}

			////////////////////////////////////////////////////////////////
			// FIXME: TEST REVERSE SORTED
			if (do_reverse) {

				try {
					test = generate_random_array(count, count);

					timer_on();
					sort_routine.sort(test);
					timer_off();
					time_reverse_sorted = get_time();

					if (!is_sorted(test)) {
						System.out.printf("Error encountered. Array not sorted!\n");
						return;
					}

					if (time_sorted > timeout_threshold_seconds) {
						System.out.println("Sorting reverse sorted array taking too long");
						do_reverse = false;
						time_reverse_sorted = -1;
					}

				} catch (java.lang.OutOfMemoryError error) {
					System.out.println(" Sorting reverse sorted numbers caused an out of memory error");
					do_reverse = false;
					time_reverse_sorted = -1;
				} catch (java.lang.StackOverflowError error) {
					System.out.println(
							" Stack Overflow - Probably sorting reverse sorted numbers caused an stack overflow error");
					do_reverse = false;
					time_reverse_sorted = -1;
				}
			}

			//////////////////////////////////////////////////////////////////////
			// Print out timing information!

			System.out.printf("%8d\t%s\t%s\t%s\t%s\t", count,
					time_sorted < 0 ? "     " : String.format("%5.2f", time_sorted),
					time_reverse_sorted < 0 ? "     " : String.format("%5.2f", time_reverse_sorted),
					time_random < 0 ? "     " : String.format("%5.2f", time_random),
					time_all_same < 0 ? "     " : String.format("%5.2f", time_all_same));

			double time_worst = Math.max(time_random,
					Math.max(time_sorted, Math.max(time_reverse_sorted, time_all_same)));

			// Calculate constant on Big-Oh
			if (sort_routine.get_expected_complexity_class() == Complexity_Class.NLogN) {
				double time_random_divided_by_N_log_N = time_random / (count * Math.log(count));
				double time_worst_divided_by_N_log_N = time_worst / (count * Math.log(count));

				System.out.printf("%f\t%f\n", time_random_divided_by_N_log_N, time_worst_divided_by_N_log_N);
			}
			if (sort_routine.get_expected_complexity_class() == Complexity_Class.Nsquared) {
				double time_random_divided_by_N_squared = time_random / (Math.pow(count, 2));
				double time_worst_divided_by_N_squared = time_worst / (Math.pow(count, 2));

				System.out.printf("%f\t%f\n", time_random_divided_by_N_squared, time_worst_divided_by_N_squared);
			}

			System.out.flush();
		}

	}

	/**
	 * Insertion Sort.
	 * 
	 * An inplace insertion sort that works on the VIRTUAL array defined by the
	 * actual array from [start --> end]
	 * 
	 * @param array
	 *            - array to sort.
	 * @param start
	 *            - start value to sort from in the array.
	 * @param end
	 *            - end value to sort to in the array - NOTE: THIS IS AN
	 *            EXCLUSIVE UPPER BOUND.
	 */
	public static <Type extends Comparable<? super Type>> void insertion_sort(ArrayList<Type> array, int start,
			int end) {
		// Go through each element.
		for (int index = start; index < end; index++) {
			// Each element compares to the one before it until it is
			// greater than the one before it.
			for (int idx = index; idx > start && array.get(idx).compareTo(array.get(idx - 1)) < 0; idx--) {
				Type temp = array.get(idx - 1);
				array.set(idx - 1, array.get(idx));
				array.set(idx, temp);
			}
		}
	}

	/**
	 * test the sorting routines with RANDOM data but changing the "constant"
	 * for the sort every time. This is useful to see what the best GAP for
	 * shell sort is or the best Insertion Sort Cutoff for Quick Sortis
	 *
	 * 
	 * @param sort_routine
	 *            - which routine to test for various "constant" changes
	 * @param start_value
	 *            - start value of "constant"
	 * @param increment
	 *            - increment value of "constant"
	 * @param end_value
	 *            - final value of "constant"
	 * @param items_to_sort
	 *            - number of items to sort on
	 */
	public void time_constant_change(Sorter<Integer> sort_routine, double start_value, double increment,
			double end_value, int items_to_sort) {

		final int total = items_to_sort;

		System.out.printf("Sorting Using %s: (Cutoff, Time (Seconds), Constant(*10e6) (of %d elements)\n",
				sort_routine.name_of_sort(), total);

		double time_random = 0;

		ArrayList<Integer> sample = new ArrayList<Integer>(items_to_sort);

		System.out.printf("Insertion Sort Cutoff\tTotal Time\t Constant = time/NLogN\n");

		for (double cutoff = start_value; cutoff <= end_value; cutoff += increment) {
			// Slow things down so we can get other work (like debugging)
			// done
			/*
			 * try { Thread.sleep(10); } catch (InterruptedException exception)
			 * { // should never happen... exception.printStackTrace(); }
			 */
			///////////////////////////////////////////////////
			// TEST RANDOM
			//
			// Make X runs over random data and average time

			time_random = 0;
			sort_routine.set_constant(cutoff);
			int runs = 10;

			for (int run = 0; run < runs; run++) {

				sample = generate_random_array(total, total);

				timer_on();
				sort_routine.sort(sample);
				timer_off();

				if (!is_sorted(sample)) {
					System.out.printf("Error encountered Sorting an array of random numbers. Array not sorted!\n");
					time_random = -1;
					return;
				}

				time_random += get_time();
			}

			time_random /= runs;

			System.out.printf("%8d\t%9.4f\t%10.4f\n", (int) cutoff, time_random,
					1000000.0 * time_random / (total * (Math.log(total) / Math.log(Math.E))));

			System.out.flush();
		}
	}

	/**
	 * start the timer
	 */
	private void timer_on() {
		this.startTime = System.nanoTime();
	}

	/**
	 * turn off the timer
	 */
	private void timer_off() {
		this.endTime = System.nanoTime();
	}

	/**
	 * get the time in seconds between on and off.
	 */
	private double get_time() {
		// Divide for seconds.
		return (endTime - startTime) / 1000000000.;
	}

}
