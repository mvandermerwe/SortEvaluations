package sort_evaluations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Quick_Sort_Inplace_M3_Test {

	/**
	 * Test running the sort through the Quick Sort Inplace M3 class. Simple test case
	 * of small array.
	 */
	@Test
	public void testSort() {
		Quick_Sort_Inplace_M3<Integer> quickSort = new Quick_Sort_Inplace_M3<>();
		quickSort.set_constant(3);

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
	 * Simple test case of small array for naive quick sort.
	 */
	@Test
	public void testSortAgain() {
		Quick_Sort_Inplace_M3<Integer> quickSort = new Quick_Sort_Inplace_M3<>();
		quickSort.set_constant(3);

		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(6);
		intArray.add(5);
		intArray.add(4);
		intArray.add(3);
		intArray.add(2);
		intArray.add(1);
		

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
		Quick_Sort_Inplace_M3<Integer> quickSort = new Quick_Sort_Inplace_M3<>();

		ArrayList<Integer> intArray = new ArrayList<>();
		ArrayList<Integer> intShouldBe = new ArrayList<>();
		quickSort.sort(intArray);
		assertArrayEquals(intShouldBe.toArray(), intArray.toArray());
	}


}
