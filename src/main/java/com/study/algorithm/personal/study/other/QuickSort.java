package com.study.algorithm.personal.study.other;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 6, 2, 9, 1};

		quickSort(arr, 0, arr.length - 1);
	}

	// QuickSort function
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// Partition the array and get the pivot index
			int pivotIndex = partition(arr, low, high);

			// Recursively sort elements before and after the partition
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	// Partition function
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // Choose the last element as the pivot
		int i = low - 1;       // Index for the smaller element

		for (int j = low; j < high; j++) {
			// If the current element is smaller than or equal to the pivot
			if (arr[j] <= pivot) {
				i++; // Increment the index of the smaller element

				// Swap arr[i] and arr[j]
				swap(arr, i, j);
			}
		}

		// Swap arr[i + 1] and the pivot (arr[high])
		swap(arr, i + 1, high);

		return i + 1; // Return the pivot index
	}

	// Swap function to exchange two elements
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
