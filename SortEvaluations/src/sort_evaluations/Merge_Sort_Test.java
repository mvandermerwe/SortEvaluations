package sort_evaluations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Merge_Sort_Test {

	/**
	 * Test running the sort through the Merge_Sort class. Simple test case
	 * of small array
	 */

	@Test
	public void testSort() {
		Merge_Sort<Integer> merge_sort = new Merge_Sort<Integer>();

		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(4);
		intArray.add(5);
		intArray.add(2);
		intArray.add(3);
		intArray.add(1);
		intArray.add(6);

		ArrayList<Integer> intShouldBe = new ArrayList<>();
		intShouldBe.add(1);
		intShouldBe.add(2);
		intShouldBe.add(3);
		intShouldBe.add(4);
		intShouldBe.add(5);
		intShouldBe.add(6);

		merge_sort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}
	
	/**
	 * Test sort for a back sorted array.
	 * 
	 */
	@Test
	public void testBackSort() {
		Merge_Sort<Integer> merge_sort = new Merge_Sort<Integer>();
		
		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(5);
		intArray.add(4);
		intArray.add(3);
		intArray.add(2);
		intArray.add(1);
		intArray.add(0);

		ArrayList<Integer> intShouldBe = new ArrayList<>();
		intShouldBe.add(0);
		intShouldBe.add(1);
		intShouldBe.add(2);
		intShouldBe.add(3);
		intShouldBe.add(4);
		intShouldBe.add(5);
		
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
