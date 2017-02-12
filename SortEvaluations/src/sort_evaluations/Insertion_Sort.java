/**
 * Pseudocode:
 * 1. Start with first two elements
 * 2. For every element, if the element is less than the element before it, swap elements
 * 3. Swap until element is greater than element before it
 */
package sort_evaluations;

import java.util.ArrayList;

/**
 *        FIXME: every file should have your name (and your partner's name) on it, as well as the date, 
 *        a useful description, etc.
 */

public class Insertion_Sort // make generic and implement Sorter 
{

	/**
	 * FIXME: Return the Name of the sort
	 */
	public String name_of_sort();

	/**
	 * No affect on insertion sort
	 * FIXME: Simply print a debug message saying this is ignored
	 */
	public void set_constant( double constant );

	/**
	 * Note: the actual insertion sort code should be written in the Sort_Utils package
	 * call that code in this method
	 * FIXME: sort the entire array using insertion sort
	 */
	public void sort( ArrayList<Type> array );

	/**
	 * FIXME: return what you believe the Big O of insertion sort should be
	 * @return the expected complexity of this algorithm
	 */
	@Override
	public Complexity_Class get_expected_complexity_class();


}
