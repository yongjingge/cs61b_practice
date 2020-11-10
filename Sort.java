package com.cs61b.practice;

public class Sort {
    /* Sort strings destructively */
    public static void sort(String[] s) {
        sort(s, 0);
        /* will call void sort(String[] s, int start) {}; and it will run recursively! */
    }

    /* find the smallest item, it's better to return the index of the smallest item
    * and we need to find the smallest item starting from position 'start' */
    public static int findSmallest(String[] s, int start) {
        int smallestIndex = start;
        for(int i = start; i < s.length; i++) {
            /* String1.compareTo(String2); if S1 < S2, will return -1 */
            int compare = s[i].compareTo(s[smallestIndex]);
            if(compare < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /* swap item a with b */
    public static void swap(String[] s, int a, int b) {
        String temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    /* create a helper method that sort String s starting at position 'start' */
    private static void sort(String[] s, int start) {
        if(start == s.length) {
            return;
        }
        int smallestIndex = findSmallest(s, start);
        swap(s, start, smallestIndex);
        sort(s, start + 1); //recursion!
    }
}