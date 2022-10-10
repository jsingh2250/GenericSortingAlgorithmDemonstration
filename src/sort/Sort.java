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
    public static <E extends Comparable<E>> boolean isArrayListSorted(ArrayList<E> arrayList, int startIndex,
            int endIndex)
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
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList) throws IndexOutOfBoundsException, NullPointerException, ClassCastException {
        for (int i = (arrayList.size() - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // If an element at an index and the element at the next index are not sorted in ascending order, swap the elements.
                if (!isArrayListSorted(arrayList, j, (j + 1))) {
                    swapArrayListElements(arrayList, j, (j + 1));
                }
            }
        }
    }

    /**
     * Sorts the elements in the inputted array list between the start index (inclusive) and the end index (inclusive) with merge sort. The array list is sorted in-place in ascending order.
     * 
     * @param arrayList The array list to sort.
     * @param startIndex The index specifying the start of the range of elements to sort in the array list. The element at this index is included in the range of elements that are sorted.
     * @param endIndex The index specifying the end of the range of elements to sort in the array list. The element at this index is included in the range of elements that are sorted.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList, int startIndex, int endIndex) throws IndexOutOfBoundsException {
        // If the range of elements in the array list only has one element in it, it does not need to be sorted because it is already sorted.
        if (startIndex == endIndex) {
            // Return to the calling function now that the specified range of elements has been sorted.
            return;
        }
        
        // Recursively split the range of elements in the array list that needs to be sorted into a half range of elements that need to be sorted and then sort each half of the range of elements. When a half range of elements returns from the recursive call, it is in sorted order. Merge the sorted half range of elements with the other sorted half range of elements when both half ranges return from their respective recursive calls. The half ranges of elements should be merged in a way such that the new range of elements in the array list is a sorted range of elements. After merging the two half ranges of elements in the array list into a sorted range of elements, return to the calling function.
        final int START_INDEX_FOR_FIRST_HALF = startIndex;
        final int END_INDEX_FOR_FIRST_HALF = ((endIndex - startIndex) / 2) + startIndex;
        final int START_INDEX_FOR_SECOND_HALF = END_INDEX_FOR_FIRST_HALF + 1;
        final int END_INDEX_FOR_SECOND_HALF = endIndex;
        mergeSort(arrayList, START_INDEX_FOR_FIRST_HALF, END_INDEX_FOR_FIRST_HALF);
        mergeSort(arrayList, START_INDEX_FOR_SECOND_HALF, END_INDEX_FOR_SECOND_HALF);
        // Both of the half ranges of elements in the array list are sorted.

        // Create an array list that can store all of the elements from the array list halves.
        ArrayList<E> sortedArrayList = new ArrayList<>(endIndex - startIndex + 1);

        // Declare indices that can aid in merging the sorted half ranges of elements into the new array list in a way such that the new array list is a sorted array list containing all of the elements from both of the half ranges of elements.
        int indexForFirstHalf = START_INDEX_FOR_FIRST_HALF;
        int indexForSecondHalf = START_INDEX_FOR_SECOND_HALF;

        // While there are elements in both of the half ranges of elements that haven't been inserted into the new array list, insert the elements from the half ranges of elements into the new array list in a way such that the new array list is a sorted array list.
        while ((indexForFirstHalf <= END_INDEX_FOR_FIRST_HALF)
                && (indexForSecondHalf <= END_INDEX_FOR_SECOND_HALF)) {
            if (arrayList.get(indexForFirstHalf).compareTo(arrayList.get(indexForSecondHalf)) <= 0) {
                sortedArrayList.add(arrayList.get(indexForFirstHalf++));
            } else {
                sortedArrayList.add(arrayList.get(indexForSecondHalf++));
            }
        }

        // Insert any remaining elements into the new sorted array list from the half range of elements that had more elements in it than the other half range of elements.
        while (indexForFirstHalf < END_INDEX_FOR_FIRST_HALF) {
            sortedArrayList.add(arrayList.get(indexForFirstHalf++));
        }
        while (indexForSecondHalf < END_INDEX_FOR_SECOND_HALF) {
            sortedArrayList.add(arrayList.get(indexForSecondHalf++));
        }

        // Replace the range of elements in the array list with the elements from the sorted array list. The sorted array list contains the same elements as the range of elements from the array list but the elements in the sorted array list are in a sorted order.
        for (int i = 0; i < sortedArrayList.size(); i++) {
            arrayList.set(i, sortedArrayList.get(indexForSecondHalf));
        }

        // Return to the calling function now that the specified range of elements has been sorted.
        return;
    }
}
