package Arrays;

/**
 * Problem Statement:- Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 * Input:- N = 5 arr[]= {0 2 1 2 0}
 * Output:- [0 0 1 2 2]
 */

public class sort_array_of_0s_1s_2s {
    /**
     * Naive Approach:- Carry out any kind of sorting on the array
     * Time complexity for not so efficient algo = O(n^2) for Bubble sort, selection sort or insertion sort
     * Time complexity for a better sorting algo = O(nlogn) for Merge Sort or Quick Sort
     */

     /**
      * Counting sort:- Count the number of 0s, 1s and 2s in the array and then use the numbers to create another array with the correct
      * ordering of the numbers.
      * Time complexity - O(n)
      * Space complexity - Use another array ? O(n) : O(1)
      */

      static void countingSortSolution(int[] arr){
          int count0 = 0, count1 = 0;

          for(int i=0;i<arr.length;i++){
              if(arr[i] == 0){
                  count0++;
              }else if(arr[i] == 1){
                  count1++;
              }
          }

          for(int i=0;i<count0;i++){
              arr[i] = 0;
          }

          for(int i=count0;i<count1+count0;i++){
              arr[i] = 1;
          }

          for(int i=count1+count0;i<arr.length;i++){
              arr[i] = 2;
          }
      }

      /**
       * Efficient Solution
       * Take 3 pointers, i=0, j = 0 and k = arr.length - 1
       * Use j to traverse the array. If jth element = 2, swap with arr[k] and do k--
       * If arr[j] == 0, swap with arr[i] and do i++ and j++; 
       * Else simply do j++
       */

       static void efficientSolution(int[] arr){
           int i=0, j = 0, k=arr.length - 1;

           while(j<=k){
               if(arr[j]==0){
                   int temp = arr[j];
                   arr[j] = arr[i];
                   arr[i] = temp;
                   i++; j++;
               } else if(arr[j] == 1){
                   j++;
               } else {
                   int temp = arr[j];
                   arr[j] = arr[k];
                   arr[k] = temp;
                   k--;
               }
           }
       }

      public static void main(String[] args) {
          int[] arr = {1,1,0,2,0,2};

          efficientSolution(arr);

          for(int x : arr){
              System.out.print(x + " ");
          }
      }
}
