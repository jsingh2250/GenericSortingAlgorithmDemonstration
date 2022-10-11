import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import person.Student;
import sort.Sort;

/** This class demonstrates my generic sorting algorithms.
 * 
 * @author Jaskaran Singh
 */
public class GenericSortingAlgorithmDemonstration2 {
    // Stores the text input cursor that will be used in this program.
    private static final String TEXT_INPUT_CURSOR = ">";

    /**
     * Prints the text with a new line before and after the text.
     * @param text The text to print.
     */
    private static void printLnTextLn(String text) {
        System.out.println();
        System.out.println(text);
    }

    /**
     * Prints a formatted version of the text input cursor to show the user where to type their input.
     * @param textInputCursor The text input cursor to print.
     */
    private static void printTextInputCursor(String textInputCursor) {
        System.out.println();
        System.out.print(textInputCursor + " ");
    }

    /**
    * Prints information about the specified exception and exits out of the program.
    * 
    * @param exception The exception to print information about.
    */
    public static void printExceptionInformationAndExit(Exception exception) {
        // Print information about the exception.
        System.out.println();
        exception.printStackTrace();
        System.out.println();

        // Exit out of the program.
        System.exit(0);
    }

    /**
     * Prints a message to the user to let them know that their input was invalid.
     * 
     */
    private static void printInvalidInputMessage() {
        printLnTextLn("Your input was invalid. Please try again.");
    }

    /**
     * Prints a message to the user to ask them to specify an array list length. Reads and returns the user-specified array list length.
     * 
     * @param scanner The scanner object used to get user-input.
     * @return Returns the user-specified array list length.
     */
    public static int getArrayListLengthFromUser(Scanner scanner) {
        // Declare a variable that will store the user-specified array list length.
        // Initialize the variable to zero to indicate that the user hasn't specified a valid array list length yet.
        int arrayListLength = 0;

        // Try to get the user-specified array list length until they specify a positive integer for the array list length.
        while (arrayListLength <= 0) {
            try {
                // Print a message to the user to ask them to specify an array list length.
                printLnTextLn("Please enter an array list length. The array list length should be a positive integer.");
                printTextInputCursor(TEXT_INPUT_CURSOR);

                // Store the user-specified array list length.
                arrayListLength = Integer.parseInt(scanner.next());

                // If the user didn't enter a positive integer, throw an exception.
                if (arrayListLength <= 0) {
                    throw new Exception();
                }

            } catch (Exception exception) {
                // Print a message to the user to let them know that their input was invalid.
                printInvalidInputMessage();
            }
        }

        // Return the user-specified array list length.
        return arrayListLength;
    }

    /**
     * Creates an array list of the specified length and fills it with random numbers between the lower bound (inclusive) and upper bound (exclusive). Returns the array list.
     * 
     * @param arrayListLength The array list length of the array list that is created and filled with random numbers.
     * @param lowerBound The inclusive lower bound of the random numbers that will be inserted in the array list.
     * @param upperBound The exclusive upper bound of the random numbers that will be inserted in the array list.
     * @return Returns the array list that is created and filled with random numbers.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("unchecked")
    public static <E extends Number & Comparable<E>> ArrayList<E> createArrayListOfRandomNumbers(int arrayListLength,
            E lowerBound, E upperBound) throws IllegalArgumentException {
        // Create the array list.
        ArrayList<E> arrayList = new ArrayList<E>(arrayListLength);

        // Create a random object.
        Random random = new Random();

        // Fill the array list with random numbers of the correct type.
        if (lowerBound instanceof Integer) {
            for (int i = 0; i < arrayListLength; i++) {
                arrayList.add((E) (Integer) random.nextInt((Integer) lowerBound, (Integer) upperBound));
            }
        } else if (lowerBound instanceof Long) {
            for (int i = 0; i < arrayListLength; i++) {
                arrayList.add((E) (Long) random.nextLong((Long) lowerBound, (Long) upperBound));
            }
        } else if (lowerBound instanceof Double) {
            for (int i = 0; i < arrayListLength; i++) {
                arrayList.add((E) (Double) random.nextDouble((Double) lowerBound, (Double) upperBound));
            }
        } else if (lowerBound instanceof Float) {
            for (int i = 0; i < arrayListLength; i++) {
                arrayList.add((E) (Float) random.nextFloat((Float) lowerBound, (Float) upperBound));
            }
        }

        // Return the array list.
        return arrayList;
    }

    /**
     * Prints the elements in the specified array list with spaces between the elements.
     * 
     * @param arrayList The array list that contains the elements to print.
     */
    public static <E> void printArrayList(ArrayList<E> arrayList) {
        System.out.println();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }

    /**
    * Determines whether an array list is sorted and prints a message to the user to state the result.
    * 
    * @param arrayList The array list that needs to be checked to determine whether it is sorted.
    */
    public static <E extends Comparable<E>> void printIsArrayListSorted(ArrayList<E> arrayList) {
        printLnTextLn("The array list is sorted: " + sort.Sort.isArrayListSorted(arrayList));
    }

    /**
    * Calculates how many seconds have passed between the specified start and end times. The specified start and end times should be in milliseconds. Returns the amount of seconds that have passed between the specified start and end times.
    * 
    * @param startTimeInMilliseconds The start time in milliseconds.
    * @param endTimeInMilliseconds The end time in milliseconds.
    * @return Returns the amount of seconds that have passed between the specified start and end times.
    */
    public static double calculateTimePassedInSeconds(long startTimeInMilliseconds, long endTimeInMilliseconds) {
        return ((endTimeInMilliseconds - startTimeInMilliseconds) / 1000.0);
    }

    /**
    * Transfers values from a numeric array list into the grade properites of an array list of student objects. The numbers are stored in the grade property of each student object. Returns the array list of student objects.
    * 
    * @param numericArrayList The numeric array list whose values need to be transferred into the student array list.
    * @return Returns the array list of student objects.
    */
    public static <E extends Comparable<E>> ArrayList<Student<E>> transferArrayListValuesToStudentArrayList(
            ArrayList<E> numericArrayList) {
        // Declare the student array list.
        ArrayList<Student<E>> studentArrayList = new ArrayList<>(numericArrayList.size());

        // Transfer values from the numeric array list to the student array list.
        for (int i = 0; i < numericArrayList.size(); i++) {
            studentArrayList.add(new Student<E>(numericArrayList.get(i)));
        }

        // Return the array list of student objects.
        return studentArrayList;
    }

    /**
     * Main method of this class.
     * 
     * @param args Unused input argument.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Store the name of this program as a string.
        final String PROGRAM_NAME = "Generic Sorting Algorithm Demonstration";

        // Store the valid commands the user can input as strings.
        final String RESTART_COMMAND = "restart";

        // Print a welcome message.
        System.out.println();
        System.out.println("Welcome to the " + PROGRAM_NAME + " program!\n" +
                "This program compares sorting algorithms.");

        // Create a scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Declare a variable to store user input.
        String userInput;

        do {
            // Get an array list length from the user.
            int arrayListLength = getArrayListLengthFromUser(scanner);

            // Get the data type from the user.
            String userInputtedDataType = null;
            while (userInputtedDataType == null) {
                try {
                    // Prompt the user for a data type.
                    System.out.println();
                    System.out.println("Please enter one of the following data types:\n" +
                            "Integer\n" +
                            "Long\n" +
                            "Double\n" +
                            "Float");

                    // Print the text input cursor.
                    printTextInputCursor(TEXT_INPUT_CURSOR);

                    // Get and store the user's input.
                    userInputtedDataType = scanner.next();

                    // Throw an exception if the user gave an invalid input.
                    if (!(userInputtedDataType.equals("Integer") ||
                            userInputtedDataType.equals("Long") ||
                            userInputtedDataType.equals("Double") ||
                            userInputtedDataType.equals("Float"))) {
                        throw new Exception();
                    }
                } catch (Exception exception) {
                    userInputtedDataType = null;
                    printInvalidInputMessage();
                }
            }

            // Declare variables to store the start and end times of tasks.
            long startTimeInMilliseconds;
            long endTimeInMilliseconds;

            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Create an array list with the user-specified array list length and fill it with random numbers.
            // Create array lists of each data type.
            Integer lowerBoundAsInteger = 0, upperBoundAsInteger = 100;
            Long lowerBoundAsLong = 0L, upperBoundAsLong = 100L;
            Double lowerBoundAsDouble = 0.0, upperBoundAsDouble = 100.0;
            Float lowerBoundAsFloat = 0.0F, upperBoundAsFloat = 100.0F;
            ArrayList<Integer> integerArrayList = null;
            ArrayList<Long> longArrayList = null;
            ArrayList<Double> doubleArrayList = null;
            ArrayList<Float> floatArrayList = null;
            // Fill the array list that can store the user-specified data type with random numbers.
            switch (userInputtedDataType) {
                case "Integer":
                    integerArrayList = createArrayListOfRandomNumbers(arrayListLength, lowerBoundAsInteger,
                            upperBoundAsInteger);
                    break;
                case "Long":
                    longArrayList = createArrayListOfRandomNumbers(arrayListLength, lowerBoundAsLong, upperBoundAsLong);
                    break;
                case "Double":
                    doubleArrayList = createArrayListOfRandomNumbers(arrayListLength, lowerBoundAsDouble,
                            upperBoundAsDouble);
                    break;
                case "Float":
                    floatArrayList = createArrayListOfRandomNumbers(arrayListLength, lowerBoundAsFloat,
                            upperBoundAsFloat);
                    break;
            }
            // Create an array list of student objects and store the data from the array lists filled with random numbers as grades in this array list.
            ArrayList<Student<Integer>> studentIntegerArrayList = null;
            ArrayList<Student<Long>> studentLongArrayList = null;
            ArrayList<Student<Double>> studentDoubleArrayList = null;
            ArrayList<Student<Float>> studentFloatArrayList = null;
            if (integerArrayList != null) {
                studentIntegerArrayList = transferArrayListValuesToStudentArrayList(integerArrayList);
            } else if (longArrayList != null) {
                studentLongArrayList = transferArrayListValuesToStudentArrayList(longArrayList);
            } else if (doubleArrayList != null) {
                studentDoubleArrayList = transferArrayListValuesToStudentArrayList(doubleArrayList);
            } else if (floatArrayList != null) {
                studentFloatArrayList = transferArrayListValuesToStudentArrayList(floatArrayList);
            }
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringArrayListCreation = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that the array list has been created and filled with random numbers. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Created an array list of length %d and filled it with random numbers in %f seconds.",
                    arrayListLength, timePassedInSecondsDuringArrayListCreation);
            System.out.println();
            // // Print the array list.
            // if (studentIntegerArrayList != null) {
            //     printArrayList(studentIntegerArrayList);
            // } else if (studentLongArrayList != null) {
            //     printArrayList(studentLongArrayList);
            // } else if (studentDoubleArrayList != null) {
            //     printArrayList(studentDoubleArrayList);
            // } else if (studentFloatArrayList != null) {
            //     printArrayList(studentFloatArrayList);
            // }
            // Check whether the array list is sorted and print a message to indicate whether the array list is sorted.
            if (studentIntegerArrayList != null) {
                printIsArrayListSorted(studentIntegerArrayList);
            } else if (studentLongArrayList != null) {
                printIsArrayListSorted(studentLongArrayList);
            } else if (studentDoubleArrayList != null) {
                printIsArrayListSorted(studentDoubleArrayList);
            } else if (studentFloatArrayList != null) {
                printIsArrayListSorted(studentFloatArrayList);
            }

            // Create a copy of the unsorted array list to sort in-place with bubble sort.
            ArrayList<Student<Integer>> studentIntegerArrayListSortedWithBubbleSort = null;
            ArrayList<Student<Long>> studentLongArrayListSortedWithBubbleSort = null;
            ArrayList<Student<Double>> studentDoubleArrayListSortedWithBubbleSort = null;
            ArrayList<Student<Float>> studentFloatArrayListSortedWithBubbleSort = null;
            if (studentIntegerArrayList != null) {
                studentIntegerArrayListSortedWithBubbleSort = new ArrayList<>(studentIntegerArrayList.size());
                studentIntegerArrayListSortedWithBubbleSort.addAll(studentIntegerArrayList);
            } else if (studentLongArrayList != null) {
                studentLongArrayListSortedWithBubbleSort = new ArrayList<>(studentLongArrayList.size());
                studentLongArrayListSortedWithBubbleSort.addAll(studentLongArrayList);
            } else if (studentDoubleArrayList != null) {
                studentDoubleArrayListSortedWithBubbleSort = new ArrayList<>(studentDoubleArrayList.size());
                studentDoubleArrayListSortedWithBubbleSort.addAll(studentDoubleArrayList);
            } else if (studentFloatArrayList != null) {
                studentFloatArrayListSortedWithBubbleSort = new ArrayList<>(studentFloatArrayList.size());
                studentFloatArrayListSortedWithBubbleSort.addAll(studentFloatArrayList);
            }
            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Sort the copied array list.
            if (studentIntegerArrayListSortedWithBubbleSort != null) {
                Sort.bubbleSort(studentIntegerArrayListSortedWithBubbleSort);
            } else if (studentLongArrayListSortedWithBubbleSort != null) {
                Sort.bubbleSort(studentLongArrayListSortedWithBubbleSort);
            } else if (studentDoubleArrayListSortedWithBubbleSort != null) {
                Sort.bubbleSort(studentDoubleArrayListSortedWithBubbleSort);
            } else if (studentFloatArrayListSortedWithBubbleSort != null) {
                Sort.bubbleSort(studentFloatArrayListSortedWithBubbleSort);
            }
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringBubbleSort = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that a copy of the array list was sorted. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Used bubble sort to sort a copy of the array list in %f seconds.",
                    timePassedInSecondsDuringBubbleSort);
            System.out.println();
            // // Print the array list.
            // if (studentIntegerArrayListSortedWithBubbleSort != null) {
            //     printArrayList(studentIntegerArrayListSortedWithBubbleSort);
            // } else if (studentLongArrayListSortedWithBubbleSort != null) {
            //     printArrayList(studentLongArrayListSortedWithBubbleSort);
            // } else if (studentDoubleArrayListSortedWithBubbleSort != null) {
            //     printArrayList(studentDoubleArrayListSortedWithBubbleSort);
            // } else if (studentFloatArrayListSortedWithBubbleSort != null) {
            //     printArrayList(studentFloatArrayListSortedWithBubbleSort);
            // }
            // Check whether the array list is sorted and print a message to indicate whether the array list is sorted.
            if (studentIntegerArrayListSortedWithBubbleSort != null) {
                printIsArrayListSorted(studentIntegerArrayListSortedWithBubbleSort);
            } else if (studentLongArrayListSortedWithBubbleSort != null) {
                printIsArrayListSorted(studentLongArrayListSortedWithBubbleSort);
            } else if (studentDoubleArrayListSortedWithBubbleSort != null) {
                printIsArrayListSorted(studentDoubleArrayListSortedWithBubbleSort);
            } else if (studentFloatArrayListSortedWithBubbleSort != null) {
                printIsArrayListSorted(studentFloatArrayListSortedWithBubbleSort);
            }

            // Create a copy of the unsorted array list to sort in-place with merge sort.
            ArrayList<Student<Integer>> studentIntegerArrayListSortedWithMergeSort = null;
            ArrayList<Student<Long>> studentLongArrayListSortedWithMergeSort = null;
            ArrayList<Student<Double>> studentDoubleArrayListSortedWithMergeSort = null;
            ArrayList<Student<Float>> studentFloatArrayListSortedWithMergeSort = null;
            if (studentIntegerArrayList != null) {
                studentIntegerArrayListSortedWithMergeSort = new ArrayList<>(studentIntegerArrayList.size());
                studentIntegerArrayListSortedWithMergeSort.addAll(studentIntegerArrayList);
            } else if (studentLongArrayList != null) {
                studentLongArrayListSortedWithMergeSort = new ArrayList<>(studentLongArrayList.size());
                studentLongArrayListSortedWithMergeSort.addAll(studentLongArrayList);
            } else if (studentDoubleArrayList != null) {
                studentDoubleArrayListSortedWithMergeSort = new ArrayList<>(studentDoubleArrayList.size());
                studentDoubleArrayListSortedWithMergeSort.addAll(studentDoubleArrayList);
            } else if (studentFloatArrayList != null) {
                studentFloatArrayListSortedWithMergeSort = new ArrayList<>(studentFloatArrayList.size());
                studentFloatArrayListSortedWithMergeSort.addAll(studentFloatArrayList);
            }
            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Sort the copied array list.
            if (studentIntegerArrayListSortedWithMergeSort != null) {
                Sort.mergeSort(studentIntegerArrayListSortedWithMergeSort);
            } else if (studentLongArrayListSortedWithMergeSort != null) {
                Sort.mergeSort(studentLongArrayListSortedWithMergeSort);
            } else if (studentDoubleArrayListSortedWithMergeSort != null) {
                Sort.mergeSort(studentDoubleArrayListSortedWithMergeSort);
            } else if (studentFloatArrayListSortedWithMergeSort != null) {
                Sort.mergeSort(studentFloatArrayListSortedWithMergeSort);
            }
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringMergeSort = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that a copy of the array list was sorted. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Used merge sort to sort a copy of the array list in %f seconds.",
                    timePassedInSecondsDuringMergeSort);
            System.out.println();
            // // Print the array list.
            // if (studentIntegerArrayListSortedWithMergeSort != null) {
            //     printArrayList(studentIntegerArrayListSortedWithMergeSort);
            // } else if (studentLongArrayListSortedWithMergeSort != null) {
            //     printArrayList(studentLongArrayListSortedWithMergeSort);
            // } else if (studentDoubleArrayListSortedWithMergeSort != null) {
            //     printArrayList(studentDoubleArrayListSortedWithMergeSort);
            // } else if (studentFloatArrayListSortedWithMergeSort != null) {
            //     printArrayList(studentFloatArrayListSortedWithMergeSort);
            // }
            // Check whether the array list is sorted and print a message to indicate whether the array list is sorted.
            if (studentIntegerArrayListSortedWithMergeSort != null) {
                printIsArrayListSorted(studentIntegerArrayListSortedWithMergeSort);
            } else if (studentLongArrayListSortedWithMergeSort != null) {
                printIsArrayListSorted(studentLongArrayListSortedWithMergeSort);
            } else if (studentDoubleArrayListSortedWithMergeSort != null) {
                printIsArrayListSorted(studentDoubleArrayListSortedWithMergeSort);
            } else if (studentFloatArrayListSortedWithMergeSort != null) {
                printIsArrayListSorted(studentFloatArrayListSortedWithMergeSort);
            }

            // Ask the user if they want to use the program again.
            printLnTextLn("Would you like to use the program again?\n" + "Enter \"" + RESTART_COMMAND
                    + "\" to use the program again. Enter anything else to quit.");
            printTextInputCursor(TEXT_INPUT_CURSOR);
            userInput = scanner.next();
        } while (userInput.equals(RESTART_COMMAND));

        // Close the scanner.
        scanner.close();

        // Print a farewell message.
        System.out.println();
        System.out.println("Thank you for using the " + PROGRAM_NAME + " program!\n" + "Goodbye.");
    }
}
