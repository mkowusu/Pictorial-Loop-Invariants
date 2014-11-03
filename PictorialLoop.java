package pictorialLoopInvariants;

import java.util.Arrays;

public class PictorialLoop {

	static int partition(int a[], int left, int right) {

		int l_spot = left + 1;
		int r_spot = right;
		int temp;


		while (l_spot <= r_spot) {

			while (a[l_spot] < a[left] && l_spot < right)
				l_spot++;

			while (a[r_spot] > a[left] && r_spot > left)
				r_spot--;
			if (l_spot <= r_spot) {
				temp = a[l_spot];
				a[l_spot] = a[r_spot];
				a[r_spot] = temp;
				l_spot++;
				r_spot--;
			}
		}

		temp = a[left];
		a[left] = a[l_spot - 1];
		a[l_spot - 1] = temp;

		return l_spot - 1;

	}


	static int select(int a[], int n, int k) {

		return (selectHelper(a, 0, n - 1, k));

	}


	static int selectHelper(int a[], int left, int right, int k) {
		int middle = partition(a, left, right);


		if (k == middle + 1) {

			return a[middle];
		}

		else if (k <= middle - left) {

			return selectHelper(a, left, middle - 1, k);
		}


		else {

			return selectHelper(a, middle + 1, right, k);
		}

	}


	static int median(int a[], int n) {
		int med = n / 2;

		if ((n % 2) == 0) {

			return (select(a, n, med) + select(a, n, med + 1)) / 2;
		}

		else {

			return select(a, n, med + 1);
		}

	}


	static void quickSortHelper(int a[], int left, int right) {
		int middle = partition(a, left, right) + 1;
		if (left < middle - 1)
			quickSortHelper(a, left, middle - 1);
		if (middle < right)
			quickSortHelper(a, middle, right);
	}

	static void quickSort(int a[], int n) {

		quickSortHelper(a, 0, n - 1);
	}

	public static void main(String[] args) {

		// QUICK SORT TESTING

		int[] A = { 7, 6, 5, 4, 3, 2, 1 };
		int[] B = { 1, 6, 7, 3, 4, 5 };
		int[] C = { 1, 2, 3, 4, 6 };
		partition(B, 1, 1);

		System.out.println("Testing of quickSort:\n");

		quickSort(A, 7);
		System.out.println(Arrays.toString(A));

		quickSort(B, 6);
		System.out.println(Arrays.toString(B));

		quickSort(C, 5);
		System.out.println(Arrays.toString(C));


		// Begin Testing for Partition

		System.out.println("\n\nTesting of Partition:\n");
		System.out.println("Arrays before being partitioned:\n");
		int array1[] = { 16, 36, 27, 11, 15, 12, 34, 29, 4, 10, 15, 40, 6, 17,
				24, 21 };
		int array2[] = { 7000, 6000, 5000, 3000, 2000, 30000, 1000, 9000,
				10000, 8000, 20000, 22000, };
		int array3[] = { 4, 2, 1, 10, 0, 2, 3, 5, 5, 6 };
		int array4[] = { 3, 2, 1 };
		int array5[] = { 1, 2, 3, 4, 5 };

		System.out.println("Array 1: " + Arrays.toString(array1));
		System.out.println("Array 2: " + Arrays.toString(array2));
		System.out.println("Array 3: " + Arrays.toString(array3));
		System.out.println("Array 4: " + Arrays.toString(array4));
		System.out.println("Array 5: " + Arrays.toString(array5) + "\n");

		partition(array1, 0, 15);
		partition(array2, 0, 11);
		partition(array3, 0, 9);
		partition(array4, 0, 2);
		partition(array5, 0, 4);

		System.out.println("Arrays after being partitioned:\n");
		System.out.println("Partitioned Array 1: " + Arrays.toString(array1));
		System.out.println("Partitioned Array 2: " + Arrays.toString(array2));
		System.out.println("Partitioned Array 3: " + Arrays.toString(array3));
		System.out.println("Partitioned Array 4: " + Arrays.toString(array4));
		System.out.println("Partitioned Array 5: " + Arrays.toString(array5));
	}
}
