package sort;


import primeraFase.Actor;
import terceraFase.Par;

public class Ordenar <T>{
	
	public Ordenar() {}
	
	public void quickSortA(T[] targetArray, int first, int last) {
	    if (first < last) {
	        int index = partitionA(targetArray, first, last);
	 
	        quickSortA(targetArray, first, index-1);
	        quickSortA(targetArray, index+1, last);
	    }
	}
	private int partitionA(T[] targetArray, int first, int last) {
	    T pivot = targetArray[last];
	    int a = (first-1);
	 
	    for (int j = first; j < last; j++) {
	        if (((Actor) targetArray[j]).compareTo((Actor)pivot) < 0) {
	            a++;
	            T swapTemp = targetArray[a];
	            targetArray[a] = targetArray[j];
	            targetArray[j] = swapTemp;
	        }
	    }
	 
	    T swapTemp = targetArray[a+1];
	    targetArray[a+1] = targetArray[last];
	    targetArray[last] = swapTemp;
	 
	    return a+1;
	}

	public void quickSortG(T[] targetArray, int first, int last) {
		if (first < last) {
			int index = partitionG(targetArray, first, last);

			quickSortG(targetArray, first, index-1);
			quickSortG(targetArray, index+1, last);
		}
	}
	private int partitionG(T[] targetArray, int first, int last) {
		T pivot = targetArray[last];
		int a = (first-1);

		for (int j = first; j < last; j++) {
			if (((Par) targetArray[j]).compareTo((Par)pivot) > 0) {
				a++;
				T swapTemp = targetArray[a];
				targetArray[a] = targetArray[j];
				targetArray[j] = swapTemp;
			}
		}

		T swapTemp = targetArray[a+1];
		targetArray[a+1] = targetArray[last];
		targetArray[last] = swapTemp;

		return a+1;
	}
}
