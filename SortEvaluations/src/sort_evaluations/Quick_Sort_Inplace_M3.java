/**
 * Pseudocode:
 * 1. Test for single element array
 * 2. If 3 or more elements in array, choose first, last, middle elements, median of these 3 elements becomes pivot
 * 3. Move all values less than pivot to left of pivot and all values greater than pivot to right of pivot 
 * 4. Quicksort left half and quicksort right half
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 * use the median of three technique to compare vs random pivot selection, etc.
 */
public class Quick_Sort_Inplace_M3<Type extends Comparable<? super Type>> extends Quick_Sort<Type> {

	/**
	 * Median of Three (choose the middle element position)
	 * 
	 * WARNING: this not only chooses the pivot, but modifies the position of
	 * the three elements.
	 * 
	 * 1) Choose 3 elements from the array (start, middle, end) 2) Place the
	 * median element at array[end-1] 3) Place low element at array[start] 4)
	 * Place high element at array[end]
	 * 
	 * You shouldn't call this method when the array is smaller than 3 elements
	 * 
	 * @param array
	 *            the array with all the data (we sort a sub piece of the array)
	 * @param start
	 *            = index of start of array
	 * @param end
	 *            = index of end of array
	 */
	protected Type choose_pivot(ArrayList<Type> array, int start, int end) {
		// FIXME: implement the Median of three algorithm.
		// additionally, make sure to follow the comments above

		int middle = start + (end - start)/2;
		
		
		
		return null;
	}

	/**
	 * Name the sort
	 */
	public String name_of_sort() {
		return "Quick Sort Inplace M3 Pivot (Cutoff: " +  this.insertionSwitchover + ")";
	}

}
