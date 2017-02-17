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
		quickSort.set_constant(3);

		ArrayList<Integer> intArray = new ArrayList<>();
		//for(int )

		quickSort.sort(intArray);
	}
	
	/**
	 * Simple test case of small array for naive quick sort.
	 */
	@Test
	public void testSortAgain() {
		Quick_Sort_Naive<Integer> quickSort = new Quick_Sort_Naive<>();
		quickSort.set_constant(3);

		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);
		intArray.add(4);
		intArray.add(5);
		intArray.add(6);
		

		ArrayList<Integer> intShouldBe = new ArrayList<>();
		intShouldBe.add(1);
		intShouldBe.add(2);
		intShouldBe.add(3);
		intShouldBe.add(4);
		intShouldBe.add(5);
		intShouldBe.add(6);

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
