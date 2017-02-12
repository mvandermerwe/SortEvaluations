package sort_evaluations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Insertion_Sort_Test {

	/**
	 * Test running the sort through the Insertion_Sort class. Simple test case
	 * of small array.
	 */
	@Test
	public void testSort() {
		Insertion_Sort insertion_sort = new Insertion_Sort();

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

		insertion_sort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

	/**
	 * Test running of sort w/ a zero array.
	 */
	@Test
	public void testZeroSort() {
		Insertion_Sort insertion_sort = new Insertion_Sort();

		ArrayList<Integer> intArray = new ArrayList<>();
		ArrayList<Integer> intShouldBe = new ArrayList<>();
		insertion_sort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

	/**
	 * Test for completing an insertion sort w/ bounds. Note this uses the
	 * static method from Sort_Utils.
	 */
	@Test
	public void testInsertionWithBounds() {
		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(4);
		intArray.add(23);
		intArray.add(7);
		intArray.add(4);
		intArray.add(8);
		intArray.add(5);

		ArrayList<Integer> intShouldBe = new ArrayList<>();
		intShouldBe.add(4);
		intShouldBe.add(4);
		intShouldBe.add(7);
		intShouldBe.add(23);
		intShouldBe.add(8);
		intShouldBe.add(5);

		Sort_Utils.insertion_sort(intArray, 0, 4);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

}
