package sort_evaluations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Merge_Sort_Test {

	/**
	 * Test running the sort through the Insertion_Sort class. Simple test case
	 * of small array
	 */
	@Test
	public void testSort() {
		Merge_Sort<Integer> merge_sort = new Merge_Sort<Integer>();

		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(4);
		intArray.add(7);
		intArray.add(23);
		intArray.add(4);
		intArray.add(8);
		intArray.add(5);

		ArrayList<Integer> intShouldBe = new ArrayList<>();
		intShouldBe.add(4);
		intShouldBe.add(4);
		intShouldBe.add(5);
		intShouldBe.add(7);
		intShouldBe.add(8);
		intShouldBe.add(23);

		merge_sort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

	/**
	 * Test running of sort w/ a zero array.
	 */
	@Test
	public void testZeroSort() {
		Merge_Sort<Integer> merge_sort = new Merge_Sort<Integer>();

		ArrayList<Integer> intArray = new ArrayList<>();
		ArrayList<Integer> intShouldBe = new ArrayList<>();
		merge_sort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}
}
