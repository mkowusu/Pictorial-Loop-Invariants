package pictorialLoopInvariants;

import java.util.Arrays;
import java.util.Random;

public class DutchNationalFlag {

	enum color {
		Red, White, Blue
	}

	public static void main(String[] args) {

		color[] colors = new color[50];
		color[] values = color.values();
		Random rand = new Random();
		for (int i = 0; i < colors.length; i++)
			colors[i] = values[rand.nextInt(values.length)];


		System.out.println("Before: " + Arrays.toString(colors));


		inVariantB(colors);

		System.out.println("After : " + Arrays.toString(colors));
	}

	// function inVariantB takes an array with type color and sorts the elements
	// in the array so it has Red, white, and blue in that order.
	private static void inVariantB(color[] colorList) {

		int left = 0, mid = 0, right = colorList.length - 1;

		//continue to loop until mid>right
		while (mid <= right)			
			switch (colorList[mid]) {

			case Red:
				swap(colorList, left++, mid++);
				break;

			case White:
				mid++;
				break;

			case Blue:
				swap(colorList, mid, right--);
				break;
			}
	}

	// function inVariantC takes an array with type color and sorts the elements
		// in the array so it has Red, white, and blue in that order.
	private static void inVariantC(color[] colorList) {

		int left = 0, mid = colorList.length - 1, right = colorList.length - 1;
		

		while (mid >= left)
			switch (colorList[mid]) {

			case Red:
				swap(colorList, left++, mid);
				break;

			case White:
				mid--;
				break;

			case Blue:
				swap(colorList, mid--, right--);
				break;
			}

	}

	// function of swap two elements(array[a] and array[b]) in array arr
	private static void swap(color[] arr, int a, int b) {
		color tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}