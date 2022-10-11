package person;

/**
 * This class models a student with an ID number and a grade.
 * 
 * @author Jaskaran Singh
 */
public class Student<T extends Comparable<T>> implements Comparable<Student<T>> {
    // Static field for keeping track of the number of instantiated students.
    private static int numberOfStudents = 0;

    // Student properties.
    private int idNumber;
    private T grade;

    /**
     * Student constructor. Stores the specified grade and an ID number that's based on how many students were instantiated prior to instantiating this one.
     * 
     * @param grade The student's grade that will be stored.
     */
    public Student(T grade) {
        this.idNumber = numberOfStudents++;
        this.grade = grade;
    }

    /**
     * Returns the student's stored ID number.
     * 
     * @return Returns the student's stored ID number.
     */
    public int getIDNumber() {
        return idNumber;
    }

    /**
     * Returns the student's stored grade.
     * 
     * @return Returns the student's stored grade.
     */
    public T getGrade() {
        return grade;
    }

    /**
     * Compares this student's grade with the specified student's grade for order. Returns a negative integer, zero, or a positive integer as this student is less than, equal to, or greater than the specified student.
     * 
     * @param student
     * @return Returns a negative integer, zero, or a positive integer as this student is less than, equal to, or greater than the specified student.
     */
    @Override
    public int compareTo(Student<T> student) {
        return this.grade.compareTo(student.getGrade());
    }

    /**
     * Converts the student object into a string.
     */
    @Override
    public String toString() {
        return "[" + idNumber + ", " + grade + "]";
    }
}
