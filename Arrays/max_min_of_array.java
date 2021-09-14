package Arrays;

import java.util.Scanner;

/**
 * Problem Statement:- Write a Program to find maximum and minimum of an array
 * Input:- arr = [25, 10, 3, 56, 98]
 * Output:- [3, 98]
 */

public class max_min_of_array {

    /**
     * Solution 1:- Simple Linear Search
     * take 2 variables max and min. Traverse through the array and apply the conditions for max and min
     * Time complexity - O(n)
     * Space Complexity - O(1)
     */

     static int[] linearSearchSolution(int[] arr){
         int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

         for(int i : arr){
             if(max<=i)
                max = i;
            if(min >= i)
                min = i;
         }

         return new int[]{min, max};
    }

    /**
     * Solution 2:- Finding Max Min by comparing pairwise. Using this method, we can reduce the number of comparisons
     * Take 2 variables max and min.
     * if the length of the array is odd,  assign max = arr[0] and min = arr[0] and a counter i = 1
     * if the length is even, assign max = arr[0], min = arr[1] and i = 2
     * Now, starting from the respective position of i, we can traverse the entire array and check pairwise the max and the min of the array
     * if arr[i] > arr[i+1] => check if arr[i] > max, then assign max = arr[i] and min = arr[i+1] if arr[i+1] < min
     * check for the same for vice versa
     * Finally return the values of max and min 
     * Time complexity O(n), but it is much more efficient than just linear search in terms of number of comparisons
     */

     static int[] minimumComparisonSolution(int[] arr){
         int n = arr.length,i, min, max;
         if(n%2==0){
            max = arr[0];
            min = arr[1];
            i = 2;
         } else{
             max = arr[0];
             min = arr[0];
             i = 1;
         }

         while(i<n-1){
             if(arr[i] >= arr[i+1]){
                 max = arr[i]>=max ? arr[i] : max;
                 min = arr[i+1] <= min ? arr[i+1] : min;
             } else{
                 max = arr[i+1]>=max ? arr[i+1] : max;
                 min = arr[i] <= min ? arr[i] : min;
             }

             i++;
         }

         return new int[]{min, max};
     }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter an element of the array: ");
            arr[i] = sc.nextInt();
        }

        int[] res = linearSearchSolution(arr);

        System.out.println("Min = " + res[0] + "Min = " + res[1]);
        sc.close();
     }
    
}
