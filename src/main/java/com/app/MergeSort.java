package com.app;

import com.app.wrapper.DatasetWrapper;
import com.app.wrapper.comporator.TitleComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {


    public static DatasetWrapper[] mergeSort(DatasetWrapper[] inputList, int left, int right) {
        if (left < right) {
            // Find the middle element
            int mid = (left + right) / 2;

            // Divide the array
            mergeSort(inputList, left, mid);
            mergeSort(inputList, mid + 1, right);

            // Merge the sorted halves
            merge(inputList, left, right);
        }

        return inputList;
    }

    public static void mergeTest(DatasetWrapper[] inputList, int l, int r) {
        System.out.println("l " + l + " r " + r);
    }

    public static void merge(DatasetWrapper[] inputList, int l, int r) {
        // Performing mergeSort int batches
        // update the leftIndex, rightIndex and midIndex values.
        l *= Main.MERGE_SORT_BATCH_SIZE;
        r = (r+1) * Main.MERGE_SORT_BATCH_SIZE;
        r = r > (inputList.length -1) ? (inputList.length -1) : r;

        int m = (l+r)/2;

        // create a subList
        int tempArrayLength = r-l;
        List<DatasetWrapper> leftList = new ArrayList<>(tempArrayLength);
        List<DatasetWrapper> rightList = new ArrayList<>(tempArrayLength);

        for (int i = l; i < m+1; i++) {
            leftList.add(inputList[i]);
        }
        for(int i=m+1;i<r+1;i++) {
            rightList.add(inputList[i]);
        }

        leftList.sort(new TitleComparator());
        rightList.sort(new TitleComparator());

        // Pointers for subList
        int leftSubListPointer = 0;
        int rightSubListPointer = 0;

        int leftSubListUpperLimit = leftList.size();
        int rightSubListUpperLimit = rightList.size();

        /* Merge the temp arrays */
        // Initial index of merged subarray array
        int k = l;
        while (leftSubListPointer < leftSubListUpperLimit && rightSubListPointer < rightSubListUpperLimit) {
            // compareTo function returns a -1 if the objects is lesser to object passed in the function.
            String leftTitle = leftList.get(leftSubListPointer).getTitle();
            String rightTitle = rightList.get(rightSubListPointer).getTitle();
            if (leftList.get(leftSubListPointer).getTitle().compareTo(rightList.get(rightSubListPointer).getTitle()) < 0)
                inputList[k++] = leftList.get(leftSubListPointer++);
            else
                inputList[k++] = rightList.get(rightSubListPointer++);
        }

        // Copy remaining elements of Left sub array
        while (leftSubListPointer < leftSubListUpperLimit)
            inputList[k++] = leftList.get(leftSubListPointer++);


        // Copy remaining elements of right sub list
        while (rightSubListPointer < rightSubListUpperLimit)
            inputList[k++] = rightList.get(rightSubListPointer++);

    }

    private static void print(DatasetWrapper[] sortedList, int l, int r) {
        for(int i =l;i<r;i++) {
            System.out.println(sortedList[i].getTitle());
        }
    }
}
