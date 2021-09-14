package Arrays;

import java.util.Scanner;

/**
 * Problem Statement: Given an array / String reverse the array
 * Input: - String s = "Geeks"
 * Output:- "skeeG"
*/

 public class reverse_the_array {
     /**
      * Approach
      * Our approach should be to take 2 pointers, one from start and the other from the end of the String or array.
      * Now, we swap the elements at the positions, then increase the start pointer by 1 and decrease the end pointer by 1
      * this will go on until start becomes greater than end

      * Time complexity - O(|S|)
      * Space Complexity - O(1)
      */

      static String reverse(String s){
          int i = 0, j = s.length() - 1;

          char[] charArray = s.toCharArray();      // Convert the string to a character array as String by default is not mutable

          while(i<j){
              char temp = charArray[i];
              charArray[i] = charArray[j];
              charArray[j] = temp;

              i++;
              j--;
          }

          String res = "";

          for(char element : charArray){
              res += element;
          }

          return res;
      }

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          
          System.out.println("Enter a string: ");
          String s = sc.next();

          System.out.println("Original String: " + s);
        
          String res = reverse(s);
          System.out.println("Reversed String: " + res);

          sc.close();
      }
 }