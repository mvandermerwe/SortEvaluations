/**
 * Pseudocode:
 * 1. Check for small size array, insertion sort if small enough
 * 2. Choose first element as array and use it as pivot
 * 3. Follow quicksort algorithm
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 * test quick sort just choosing the first value as the pivot.
 */
public class Quick_Sort_Inplace_First_Pivot<Type extends Comparable<? super Type>> extends Quick_Sort<Type> {

	/**
	 * First_Pivot
	 * 
	 * 1) choose the first element in the array as the pivot 2) Place this
	 * element at array[end]
	 * 
	 * @param array
	 *            = the array with all the data (we sort a sub piece of the
	 *            array)
	 * @param start
	 *            = index of start of array
	 * @param end
	 *            = index of end of array
	 */
	protected Type choose_pivot(ArrayList<Type> array, int start, int end) {
		// Swap to last, the return last.
		Sorter.swap(array, start, end);
		return array.get(end);
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort() {
		return "Quick Sort Inplace First Pivot (Cutoff: " +  this.insertionSwitchover + ")";
	}

}
