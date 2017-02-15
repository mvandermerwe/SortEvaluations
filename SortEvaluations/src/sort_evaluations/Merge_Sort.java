/**
 * Pseudocode:
 * 1. Test for single element array
 * 2. Divide array in half
 * 3. Merge Sort first half
 * 4. Merge Sort second half
 * 5. Combine halves
 */
package sort_evaluations;

import java.util.ArrayList;

import javax.sound.sampled.Control.Type;

/**
 * @author H. James de St. Germain
 * @date Spring 2017
 * 
 *       regular merge sort
 */
public class Merge_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

	double insertionCutoff = 3;

	/**
	 * The name of the sort
	 */
	public String name_of_sort() {
		return "Merge sort";
	}

	/**
	 * Merge Sort
	 * 
	 * split array in half sort left sort right combine
	 * 
	 * 
	 * @param array
	 *            the values to sort from small to high
	 * @param low
	 *            the index of the starting value in the "virtual array"
	 * @param high
	 *            the index of the ending value in the "virtual array"
	 * 
	 */
	private void merge_sort(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int high) {
		// If array size is small enough, do insertion sort
		if((high-low)<=insertionCutoff){
			Sort_Utils.insertion_sort(array, low, high+1);
			
		}else{
		
			int mid = low + (high - low) / 2;
			// Sort left half
			merge_sort(array, auxillary, low, mid);
			// Sort right half
			merge_sort(array, auxillary, mid + 1, high);
			// Combine halves
			combine(array, auxillary, low, mid, high);
		}
	}

	/**
	 * combine the values in array into the auxiliary
	 * 
	 * @param array
	 *            - original values (the entire array)
	 * @param auxillary
	 *            - spare space
	 * @param low
	 *            - low,mid are the lower array
	 * @param mid
	 *            - mid,high are the upper array
	 * @param high
	 * 
	 *            combine the sub arrays in the _array_ parameter. use the
	 *            _auxillary_ parameter for scratch space
	 */

	private void combine(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int mid, int high) {
		// Make new copy of current array
		for (int l = low; l <= high; l++) {
			auxillary.set(l, array.get(l));
		}
		int i = low;
		int j = mid + 1;
		
		for (int k = low; k <= high; k++) {
			// If index in lower half of array is past midpoint, grab next
			// element from higher half
			if (i > mid) {
				array.set(k, auxillary.get(j));
				j++;
				// If index in higher half of array is past highpoint, grab next
				// element from lower half
			} else if (j > high) {
				array.set(k, auxillary.get(i));
				i++;
				// If current element in higher half of array is less than
				// current element of lower half, grab element from higher half
			} else if (auxillary.get(j).compareTo(auxillary.get(i)) < 0) {
				array.set(k, auxillary.get(j));
				j++;
				// If all other conditions return false, grab element from lower
				// half of array
			} else {
				array.set(k, auxillary.get(i));
				i++;
			}
		}
	}

	/**
	 * Allow the insertion sort cut off to be changed
	 */
	public void set_constant(double cutoff) {
		this.insertionCutoff = cutoff;
	}

	/**
	 * sort the array
	 */
	@Override
	public void sort(ArrayList<Type> array) {
		// Creates an auxillary array
		ArrayList<Type> auxillary = new ArrayList<Type>(array.size());
		for (int k = 0; k < array.size(); k++) {
			auxillary.add(array.get(k));
		}
		// Calls merge sort on entire array
		merge_sort(array, auxillary, 0, array.size()-1);
	}

	@Override
	public Complexity_Class get_expected_complexity_class() {
		return Complexity_Class.NLogN;
	}

}
