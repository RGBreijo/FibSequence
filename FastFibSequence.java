/*=======================================================================
|   Source code:  FastFibSequence.java
|                 Class: FastFibSequence
|
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|        Section: U06
|
|
|        Language:  Java
|        Compile:
|                javac FastFibSequence.java Sequence.java
|
|
|    Purpose: To provide a fast recursive fib sequence algorithm
|
|
|    Inherits From:  None
|
|
|     Interfaces:  Sequence
|
|
|  +-----------------------------------------------------------------------
|
|      Constants:  OVERFLOW_VALUE - Indicates the value returned in case of an overflow
|
|
| +-----------------------------------------------------------------------
|
|   Constructors:  FastFibSequence(int startIndex) - Constructor that sets start index and found array size
|                  FastFibSequence() - Empty constructor which sets default start index and found value array size
|
|   Class Methods:  No private class methods
|
|
|   Instance Methods:  next() Returns an int
|                      getFibNumber(int fibIndex) Returns an int
|
|
|  *===========================================================================*/

public class FastFibSequence implements Sequence
{

    public final int OVERFLOW_VALUE = 0;

    private final int DEFAULT_FIB_SIZE = 37;

    private int[] foundValues;

    private int fibPosition = 0;

    /**
     * Sets the array size needed for the found values given the starting sequence
     * and sets the starting index
     *
     * @param startIndex The starting number of the getFibNumber sequence
     */
    public FastFibSequence(int startIndex)
    {
        fibPosition = startIndex;

        foundValues = new int[DEFAULT_FIB_SIZE + startIndex];
    }

    /**
     * Sets a default array size needed for the found values given the starting sequence
     * and sets the starting index
     */

    public FastFibSequence()
    {
        final int DEFAULT_START_INDEX = 0;

        foundValues = new int[DEFAULT_FIB_SIZE];
        fibPosition = DEFAULT_START_INDEX;
    }

    /**
     *
     * Provides the user with the next value given the current index in the fibonacci sequence
     *
     * @return The value of the next fibonacci number
     */

    @Override
    public int next()
    {
        fibPosition++;
        return getFibNumber(fibPosition);
    }


    /**
     *
     * Fibonacci Sequence:
     *
     * A Fibonacci Sequence is a series of numbers where the next number
     * is found by adding up the two numbers before it.
     *
     *  Ex:
     *   0 1 1 2 3 5 8 13…..
     *
     * Note: This algorithm is a modification of the recursive algorithm found
     *       in Cay S. Horstmann - Big Java Early Objects-Wiley (2013) Page 598
     *
     * @param fibIndex The index of the getFibNumber position to search
     * @return The getFibNumber number in the desired position
     */

    public int getFibNumber(int fibIndex)
    {
        final int MIN_FIB_VALUE = 1;
        final int BASE_CASE = 2;
        final int EMPTY_VALUE = 0;

        try
        {
            if (fibIndex <= BASE_CASE)
            {
                return MIN_FIB_VALUE;

            }

            if (foundValues[fibIndex] != EMPTY_VALUE)
            {
                return foundValues[fibIndex];

            }else
            {
                // -1 last index -2 second to last index
                foundValues[fibIndex]= Math.addExact(getFibNumber(fibIndex - 1), getFibNumber(fibIndex - 2));
            }

        }catch (ArithmeticException exception)
        {
            return OVERFLOW_VALUE;
        }

        return foundValues[fibIndex];
    }
}
