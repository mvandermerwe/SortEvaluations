/**
 * Pseudocode:
 * 1. Start with first two elements
 * 2. For every element, if the element is less than the element before it, swap elements
 * 3. Swap until element is greater than element before it
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 * @author Mark Van der Merwe and Roman Clark
 * 
 *         This class is a simple insertion sort.
 */

public class Insertion_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

	/**
	 * Return the Name of the sort
	 */
	public String name_of_sort() {
		return "Insertion_Sort";
	}

	/**
	 * No affect on insertion sort.
	 */
	public void set_constant(double constant) {
		System.out.println("Ignored, doesn't effect insertion sort.");
	}

	/**
	 * Note: the actual insertion sort code should be written in the Sort_Utils
	 * package call that code in this method. Sorts the entire array using
	 * insertion sort
	 * 
	 * @param array
	 *            - array to be sorted.
	 */
	public void sort(ArrayList<Type> array) {
		Sort_Utils.insertion_sort(array, 0, array.size());
	}

	/**
	 * Return believed Big O of insertion sort should be
	 * 
	 * @return the expected complexity of this algorithm
	 */
	@Override
	public Complexity_Class get_expected_complexity_class() {
		return Complexity_Class.Nsquared;
	}

}
