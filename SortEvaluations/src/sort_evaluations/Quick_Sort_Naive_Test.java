package sort_evaluations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Quick_Sort_Naive_Test {

	/**
	 * Simple test case of small array for naive quick sort.
	 */
	@Test
	public void testSort() {
		Quick_Sort_Naive<Integer> quickSort = new Quick_Sort_Naive<>();

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

		quickSort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

	/**
	 * Test running of sort w/ a zero array.
	 */
	@Test
	public void testZeroSort() {
		Quick_Sort_Naive<Integer> quickSort = new Quick_Sort_Naive<>();

		ArrayList<Integer> intArray = new ArrayList<>();
		ArrayList<Integer> intShouldBe = new ArrayList<>();
		quickSort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}

}