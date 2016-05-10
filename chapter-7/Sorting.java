public class Sorting {
	
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
	
	static boolean isSorted(int[] a) {
		boolean sorted = true;
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i + 1])
				sorted = false;
		}
		
		return sorted;
	}
	
	static int[] selectionSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int iOfNextSm = getIndexOfSmallest(i, a);
			
			// Swap the two
			int temp = a[i];
			a[i] = a[iOfNextSm];
			a[iOfNextSm] = temp;
		}
		
		return a;
	}
	
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
