// Java program for recursive implementation 
// of Bubble sort 
  
import java.util.Arrays; 
  
public class Bubble  
{ 
    // A function to implement bubble sort 
    static void bubbleSort(int arr[], int n) 
    { 
        // Base case 
        if (n == 1) 
            return; 
       
        // One pass of bubble sort. After 
        // this pass, the largest element 
        // is moved (or bubbled) to end. 
        for (int i=0; i<n-1; i++) 
            if (arr[i] > arr[i+1]) 
            { 
                // swap arr[i], arr[i+1] 
                int temp = arr[i]; 
                arr[i] = arr[i+1]; 
                arr[i+1] = temp; 
            } 
       
        // Largest element is fixed, 
        // recur for remaining array 
        bubbleSort(arr, n-1); 
    } 
    
    static void bubbleSortIter(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
      
    // Driver Method 
    public static void main(String[] args) 
    { 
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
       
        //bubbleSort(arr, arr.length); 
        bubbleSortIter(arr); 
          
        System.out.println("Sorted array : "); 
        System.out.println(Arrays.toString(arr)); 
    } 
} 