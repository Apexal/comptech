public class Sorting {
	
	/**
	 * This method is used to find the index of the smallest value in an array for selection sorting. 
	 *  
	 * @param startIndex The index of the passed array that the searching will start at.
	 * @param array The integer array that will be searched.
	 * @return int The index of the smallest array value.
	 */
	static int getIndexOfSmallest(int startIndex, int[] array) {
		int index = startIndex;
		int smallestValue = array[index];
		
		for(int i = index + 1; i < array.length; i++) {
			if(array[i] < smallestValue) {
				index = i;
				smallestValue = array[i];
			}
		}
		
		return index;
	}
	
	/**
	 * This method checks whether an array's values are in order or not for the bubble sort method.
	 * 
	 * @param a The integer array that will be evaluated.
	 * @return boolean Whether or not the passed array is sorted.
	 */
	static boolean isSorted(int[] a) {
		// Use a.length - 1 because it checks two at a time and not subtracting one would allow it to go out of bounds
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i + 1])
				return false; // Only need knowledge of at least one unsorted pair 
		}
		
		return true;
	}
	
	
	/**
	 * This method uses the process of selection sorting to iterate through
	 * an array and repeatedly move unsorted values to the beginning of the 
	 * unsorted section of the array until it is entirely in order.
	 * 
	 * @param a The integer array that will be sorted.
	 * @return int[] The final sorted array.
	 */
	static int[] selectionSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int iOfNextSm = getIndexOfSmallest(i, a);
			
			// Swap the two
			int temp = a[i]; // Keep this value since it is about to be overwritten
			a[i] = a[iOfNextSm];
			a[iOfNextSm] = temp;
		}
		return a;
	}
	
	
	/**
	 * This method uses the process of bubble sorting to sort an array
	 * by swapping unordered consecutive values over and over until the
	 * entire array is sorted.
	 * 
	 * @param a The integer array that will be sorted.
	 * @return int[] The final sorted array.
	 */
	static int[] bubbleSort(int[] a) {
		while(!isSorted(a)) {
			for(int i = 0; i < a.length - i; i++) {
				if(a[i] > a[i + 1]) {
					// Swap the two
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 5, 1, 6, 89, -1};
		
		int[] ordered = selectionSort(nums);
		for(int item : ordered) {
			System.out.println(item);
		}
		
		int[] ordered2 = bubbleSort(nums);
		for(int item : ordered2) {
			System.out.println(item);
		}
	}
}
