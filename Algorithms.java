/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algortihmsfx;

import static java.lang.Integer.min;
import static java.lang.Math.sqrt;
import java.util.Arrays;

/**
 *
 * @author Ryan
 */
public class Algorithms {
    /**
     * Takes as input the array searched, the target element, and the starting
     * and end points of the array. Returns index position of element if found, 
     * and -1 if not found, based on a linear search algorithm.
     * 
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static int linearSearch(int[] arr, int target, int start, int end) {
        
        for(int i = start; i < end; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
    
    /**
     * Takes as input the array searched, the target element, and the starting
     * and end points of the array. Returns index position of element if found, 
     * and -1 if not found, based on a binary search algorithm.
     * 
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(end >= start) {
            int mid = start + (end - start)/2;
            
            if( arr[mid] == target) {
                return mid;
            }
            if ( target > arr[mid] ) {
                return binarySearch(arr, target, mid+1, end);
            }
            return binarySearch(arr, target, start, mid-1);
        }
        
        return -1;
    }
    /**
     * Takes as input the array searched, the target element, and the starting
     * and end points of the array. Returns index position of element if found, 
     * and -1 if not found, based on a jump search algorithm.
     * 
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    
    /*
    public static int jumpSearch(int[] arr, int target, int start, int end) {
        int n = arr.length;
        int m = (int)Math.sqrt(n);
        int result = -1;
        
        for(int i = 0; i < n; i += m-1) {
            if(arr[i] == target)
                result = i;
            else if(arr[i] > target)
                result = linearSearch(arr, target, i, i-m);
        }
        
        return result;
    }
    */
    public static int jumpSearch(int[] arr, int x) 
    { 
        int n = arr.length; 
  
        // Finding block size to be jumped 
        int step = (int)Math.floor(Math.sqrt(n)); 
  
        // Finding the block where element is 
        // present (if it is present) 
        int prev = 0; 
        while (arr[Math.min(step, n)-1] < x) 
        { 
            prev = step; 
            step += (int)Math.floor(Math.sqrt(n)); 
            if (prev >= n) 
                return -1; 
        } 
  
        // Doing a linear search for x in block 
        // beginning with prev. 
        while (arr[prev] < x) 
        { 
            prev++; 
  
            // If we reached next block or end of 
            // array, element is not present. 
            if (prev == Math.min(step, n)) 
                return -1; 
        } 
  
        // If element is found 
        if (arr[prev] == x) 
            return prev; 
  
        return -1; 
    } 
    
    static int interpolationSearch(int[] arr, int x) 
    { 
        // Find indexes of two corners 
        int lo = 0, hi = (arr.length - 1); 
       
        // Since array is sorted, an element present 
        // in array must be in range defined by corner 
        while (lo <= hi && x >= arr[lo] && x <= arr[hi]) 
        {         
  
            if (lo == hi) 
            { 
                if (arr[lo] == x) return lo; 
                return -1; 
            } 
         
            // Probing the position with keeping 
            // uniform distribution in mind. 
              
            int pos = lo + (((hi-lo) / 
                  (arr[hi]-arr[lo]))*(x - arr[lo])); 
       
            // Condition of target found 
            if (arr[pos] == x) 
                return pos; 
       
            // If x is larger, x is in upper part 
            if (arr[pos] < x) 
                lo = pos + 1; 
       
            // If x is smaller, x is in the lower part 
            else
                hi = pos - 1; 
        } 
        return -1; 
    } 
    
        /**
     * Takes as input the array to be sorted. Returns sorted array via bubble
     * sort algorithm.
     * 
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        return arr;
    }
    
    /**
     * Takes as input the array to be sorted. Returns sorted array via bubble
     * sort algorithm.
     * 
     * @param arr
     * @return
     */
    public static int[] recursiveBubbleSort(int[] arr, int n) {
        if(n == 1)
            return arr;
        
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        
        return recursiveBubbleSort(arr, n-1);
    }
    /**
     * Takes as input the array to be sorted. Returns sorted array via selection
     * sort algorithm.
     * 
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n-1; i++) {
            
            // Find minimum element
            int minIndex = i;
            for(int j = i+1; j < n; j++)
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            
            // Swap elements
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        return arr;
    }
    
    /**
     * Takes as input the array to be sorted. Returns sorted array via jump
     * sort algorithm.
     * 
     * @param arr
     * @param start
     * @param mid
     * @param end
     * @return
     */
    
    private static void merge(int[] arr, int start, int mid, int end) {
        int leftSubArraySize = mid - start + 1; 
        int rightSubArraySize = end - mid;
        
        int[] leftSubArray = new int[leftSubArraySize];
        int[] rightSubArray = new int[rightSubArraySize];
        
        // Populate subarrays
        for(int i = 0; i < leftSubArraySize; ++i) {
            leftSubArray[i] = arr[start + i];
        }
        for(int j = 0; j < rightSubArraySize; ++j) {
            rightSubArray[j] = arr[mid+1 + j];
        }
        
        // Merge subarrays
        int i = 0;
        int j = 0;
        int k = start;
        
        while(i < leftSubArraySize && j < rightSubArraySize) {
            if(leftSubArray[i] <= rightSubArray[j]) {
                arr[k] = leftSubArray[i];
                i++;
            }
            else {
                arr[k] = rightSubArray[j];
                j++;
            }
            k++;
        }
        
        // Copy any remaining elements if there is any
        while(i < leftSubArraySize) {
            arr[k] = leftSubArray[i];
            i++;
            k++;
        }
        
        while(j < rightSubArraySize) {
            arr[k] = rightSubArray[j];
            j++;
            k++;
        }
    }
    
    public static int[] mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            
            merge(arr, start, mid, end);
        }
        return arr;
    }
}

