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

/**
 * @author H. James de St. Germain
 * @date Spring 2017
 * 
 *       regular merge sort
 */
public class Merge_Sort// implement sorter
{

	/**
	 * FIXME: have a value for switching over to insertion sort
	 */

	/**
	 * FIXME: The name of the sort
	 */
	public String name_of_sort();;

	/**
	 * Merge Sort
	 * 
	 * split array in half
	 * sort left
	 * sort right
	 * combine
	 * 
	 * 
	 * @param array          the values to sort from small to high
	 * @param low            the index of the starting value in the "virtual array"
	 * @param high           the index of the ending value in the "virtual array"
	 * 
	 */
	private void merge_sort( ArrayList<Type> array, ArrayList<Type> auxillary, int low, int high );

	/**
	 * combine the values in array into the auxiliary
	 * 
	 * @param array           - original values (the entire array)
	 * @param auxillary       - spare space 
	 * @param low             - low,mid are the lower array
	 * @param mid             - mid,high are the upper array
	 * @param high
	 * 
	 * combine the sub arrays in the _array_ parameter. use the _auxillary_ parameter for scratch space
	 */

	private void combine( ArrayList<Type> array, ArrayList<Type> auxillary, int low, int mid, int high );

	/**
	 * Allow the insertion sort cut off to be changed
	 */
	public void set_constant( double cutoff );

	/**
	 * sort the array
	 */
	@Override
	public void sort( ArrayList<Type> array )
	{
		// Build the auxiliary array
		// call mergesort 
	}

	@Override
	public Complexity_Class get_expected_complexity_class();

}
