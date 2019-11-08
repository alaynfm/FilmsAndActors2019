package primeraFase;



public class Ordenar <T>{
	
	public Ordenar() {}
	
	public void quickSort(T[] targetArray, int first, int last) {
	    if (first < last) {
	        int index = partition(targetArray, first, last);
	 
	        quickSort(targetArray, first, index-1);
	        quickSort(targetArray, index+1, last);
	    }
	}
	private int partition(T[] targetArray, int first, int last) {
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
}
