package sort_evaluations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This code wraps JAVAs arraylist built in sort to see how it compares with our
 * sorts
 * 
 */
public class Java_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

	/**
	 * Sorts the array using the arraylist built in sort and natural order
	 * comparator
	 */
	public void sort(ArrayList<Type> array) {
		array.sort(Comparator.naturalOrder());
	}

	/**
	 * Returns the Name the sort (in this case Java's sort)
	 */
	public String name_of_sort() {
		return "Java's sort";
	}

	/**
	 * Java's sort cannot be modified, does nothing
	 */
	public void set_constant(double constant) {
		System.out.println("Cannot modify Java's sort");
	}

	/**
	 * @return the expected complexity for javas sorts
	 */
	@Override
	public Complexity_Class get_expected_complexity_class() {
		return Complexity_Class.NLogN;
	}

}
