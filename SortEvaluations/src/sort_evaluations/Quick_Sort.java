/**
 * Pseudocode:
 * 1. Test for single element array
 * 2. Choose a pivot
 * 3. Move all values less than pivot to left of pivot and all values greater than pivot to right of pivot 
 * 4. Quicksort left half and quicksort right half
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 * This code is an abstract base class for all versions of quicksort.
 * 
 * 
 * Write Quick sort using a single array(list) and doing it in place
 * 
 * Instrument it to allow the changing of the Insertion Sort Switch over
 * 
 */
public abstract class Quick_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

	// a field for the insertion sort switchover level
	protected int insertionSwitchover;

	/**
	 * Choose a Pivot (return it's value in the array) Modify array as
	 * appropriate (e.g., median of three will move smallest value to front of
	 * array)
	 *
	 * @param array
	 *            - the array of all values (we only sort a sub piece of the
	 *            array)
	 * @param start
	 *            - the start position in the (sub) array
	 * @param end
	 *            - the end position in the (sub) array
	 * @return the pivot value
	 */
	protected abstract Type choose_pivot(ArrayList<Type> array, int start, int end);

	/**
	 * Given an array, partition the array such that all the elements lower than
	 * or equal to the pivot are on the left, all the elements greater than the
	 * pivot are on the right.
	 * 
	 * @param array
	 *            - data data to sort
	 * @param left
	 *            - the start index of the sub array (inclusive)
	 * @param right
	 *            - the end index of the sub array (inclusive)
	 * 
	 * @return the location of the pivot
	 */

	protected int partition(ArrayList<Type> array, int left, int right) {
		// WARNING: this code can be tricky to get just right. do your best
		// then pay attention in class on Tuesday
		// PLEASE: please make an attempt before Tuesday
		Type partition = choose_pivot(array, left, right);

		int i = left - 1;
		int j = right;

		// Sort array.
		while (true) {
			// Count from left till we find something larger than pivot.
			while (array.get(++i).compareTo(partition) < 0) {
				if (i == right || i == j) {
					break;
				}
			}

			// Count from right till we find something smaller than pivot.
			while (array.get(--j).compareTo(partition) > 0) {
				if (j == left) {
					break;
				}
			}

			if(i >= j ) {
				break;
			}
			
			// Swap elements at position i and j.
			Sorter.swap(array, i, j);
			// Continue this loop till pointers cross.
		}

		// Once sorted place partition at last position of j (should be
		// partition's location between two sorted halves).
		Sorter.swap(array, right, i);
		return i;

	}

	/**
	 * The actual Quick Sort on an Array routine.
	 * 
	 * Algorithm: 1) choose a pivot (store in first bucket for convenience) 2)
	 * o) move all elements higher than the pivot to the right side of the array
	 * o) move all elements lower than the pivot to the left side of the array
	 * 3) put the pivot back between upper and lower group 4) sort left side 5)
	 * sort right side (WARNING: don't sort pivot again)
	 * 
	 * @param array
	 *            - data to be sorted
	 * @param start
	 *            is the index of the beginning element
	 * @param end
	 *            is the index of the last element
	 * 
	 * 
	 */
	private void quick_sort(ArrayList<Type> array, int start, int end) {
		// 1) partition array
		// 2) sort left
		// 3) sort right (again, don't resort the pivot)

		// If matches our switchover point to insertion, do that.
		if (end - start <= 3) {
			Sort_Utils.insertion_sort(array, start, end+1);
			return;
		}

		int middle = partition(array, start, end);
		// Sort small half.
		quick_sort(array, start, middle - 1);
		// Sort last half.
		quick_sort(array, middle + 1, end);

	}

	/**
	 * the sort interface method.
	 * 
	 * call quicksort on the array
	 * 
	 */
	public void sort(ArrayList<Type> array) {
		quick_sort(array, 0, array.size() - 1);
	}

	/**
	 * Name the sort
	 */
	public abstract String name_of_sort();

	/**
	 * The constant in this case is the insertion sort cutoff level... always
	 * greater than 3
	 */
	public void set_constant(double constant) {
		this.insertionSwitchover = (int) constant;
	}

	/**
	 * @return the expected complexity for quick sort
	 */
	@Override
	public Complexity_Class get_expected_complexity_class() {
		return Complexity_Class.NLogN;
	}

}
