package sort;

import java.util.ArrayList;

/**
 * This class contains sorting methods for array lists.
 * 
 * @author Jaskaran Singh
 */
public class Sort {
    /**
     * Determines whether the range of elements in the specified array list is sorted in ascending order between the element at the specified start index (inclusive) and the element at the specified end index (inclusive). Returns true if the specified range of elements in the arraylist is sorted in ascending order. Returns false otherwise.
     * 
     * @param arrayList The array list that contains the range of elements whose sorting order needs to be checked.
     * @param startIndex The index that specifies the start of the range of elements that need to be checked in the array list. This index is inclusive.
     * @param endIndex The index that specifies the end of the range of elements that need to be checked in the array list. This index is inclusive.
     * @return Returns true if the specified range of elements in the array list is sorted in ascending order. Returns false otherwise.
     * @throws IndexOutOfBoundsException If the start index is greater than the end index.
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     */
    public static <E extends Comparable<E>> boolean isArrayListSorted(ArrayList<E> arrayList, int startIndex, int endIndex)
            throws IndexOutOfBoundsException, NullPointerException, ClassCastException {
        // Throw an IndexOutOfBoundsException if the start index is greater than the end index.
        if (startIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }

        // If the range of elements are not sorted in ascending order, return false.
        for (int i = startIndex; i < endIndex; i++) {
            if (arrayList.get(i).compareTo(arrayList.get(i + 1)) > 0) {
                return false;
            }
        }

        // The range of elements are sorted. Return true.
        return true;
    }

    /**
     * Determines whether the elements in the specified array list are sorted in ascending order. Returns true if the elements in the arraylist are sorted in ascending order. Returns false otherwise.
     * 
     * @param arrayList The array list that contains the elements whose sorting order needs to be checked.
     * @return Returns true if the elements in the array list are sorted in ascending order. Returns false otherwise.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     */
    public static <E extends Comparable<E>> boolean isArrayListSorted(ArrayList<E> arrayList)
            throws IndexOutOfBoundsException, NullPointerException, ClassCastException {
                return isArrayListSorted(arrayList, 0, (arrayList.size() - 1));
    }

    /**
     * Swaps the elements of the specified indices in the specified array list.
     * 
     * @param arrayList The array list that contains the elements that need to be swapped.
     * @param swapIndex1 The index of one of the elements in the array list that need to be swapped.
     * @param swapIndex2 The index of one of the elements in the array list that need to be swapped.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     */
    public static <E> void swapArrayListElements(ArrayList<E> arrayList, int swapIndex1, int swapIndex2)
            throws IndexOutOfBoundsException, NullPointerException, ClassCastException {
                E elementToSwap = arrayList.get(swapIndex1);
                arrayList.set(swapIndex1, arrayList.get(swapIndex2));
                arrayList.set(swapIndex2, elementToSwap);
    }

    /**
     * Sorts the inputted array list in-place with bubble sort. The array list is sorted in ascending order.
     * 
     * @param arrayList The array list to sort.
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList) {
        for (int i = (arrayList.size() - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // If an element at an index and the element at the next index are not sorted in ascending order, swap the elements.
                if (!isArrayListSorted(arrayList, j, (j + 1))) {
                    swapArrayListElements(arrayList, j, (j + 1));
                }
            }
        }
    }

    // /**
    //  * Sorts the inputted array list in-place with merge sort. The array list is sorted in ascending order.
    //  * 
    //  * @param arrayList The array list to sort.
    //  */
    // public static int[] mergeSort(int[] arrayList) {
    //     // If the array has one element in it, it does not need to be sorted because it is already sorted. Return the single element array.
    //     if (arrayList.length <= 1) {
    //         // Return the single element array.
    //         return arrayList;
    //     } else {
    //         // Store copies of halves of the inputted array in separate arrays.
    //         int arraySplitIndex = arrayList.length / 2;
    //         int[] firstHalfOfArrayToSort = Arrays.copyOfRange(arrayList, 0, arraySplitIndex);
    //         int[] secondHalfOfArrayToSort = Arrays.copyOfRange(arrayList, arraySplitIndex, arrayList.length);

    //         // Recursively store copies of the halves of the inputted array in separate arrays. When an array half returns from the recursive call, it is in a sorted order. Merge that sorted array half with the other sorted array half when the second array half is returned from its recursive call. The array halves should be merged into an array in a way such that the merged array is a sorted array. After merging the two sorted array halves into a sorted array, return the sorted array.
    //         firstHalfOfArrayToSort = mergeSort(firstHalfOfArrayToSort);
    //         secondHalfOfArrayToSort = mergeSort(secondHalfOfArrayToSort);
    //         // Both of the array halves are sorted.

    //         // Create an array that can store all of the elements from the array halves.
    //         int[] sortedArray = new int[firstHalfOfArrayToSort.length + secondHalfOfArrayToSort.length];

    //         // Declare indices that can aid in merging the array halves into an array in a way such that the merged array is a sorted array.
    //         int indexOfFirstHalfOfArrayToSort = 0;
    //         int indexOfSecondHalfOfArrayToSort = 0;
    //         int indexOfSortedArray = 0;

    //         // While there are elements in both of the array halves that haven't been inserted into the merged array, insert the elements from the array halves into an array in a way such that the merged array is a sorted array.
    //         while ((indexOfFirstHalfOfArrayToSort < firstHalfOfArrayToSort.length)
    //                 && (indexOfSecondHalfOfArrayToSort < secondHalfOfArrayToSort.length)) {
    //             if (firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort] < secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort]) {
    //                 sortedArray[indexOfSortedArray++] = firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort++];
    //             } else {
    //                 sortedArray[indexOfSortedArray++] = secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort++];
    //             }
    //         }

    //         // Insert any remaining elements into the sorted array from the array half that had more elements in it than the other array half.
    //         while (indexOfFirstHalfOfArrayToSort < firstHalfOfArrayToSort.length) {
    //             sortedArray[indexOfSortedArray++] = firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort++];
    //         }
    //         while (indexOfSecondHalfOfArrayToSort < secondHalfOfArrayToSort.length) {
    //             sortedArray[indexOfSortedArray++] = secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort++];
    //         }

    //         // Return the sorted array.
    //         return sortedArray;
    //     }
    // }
}
