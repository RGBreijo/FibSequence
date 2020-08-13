/*=======================================================================
|   Source code:  FastLoopFibSequence.java
|                 Class: FastLoopFibSequence
|
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|        Section: U06
|
|
|
|
|
|        Language:  Java
|        Compile:
|                javac FastLoopFibSequence.java Sequence.java
|
|
|    Purpose: To provide a fast loop fib sequences algorithm
|
|
|     Inherits From:  None
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
|   Constructors:  FastLoopFibSequence(int startIndex) - Constructor that sets start index and found array size
|                  FastLoopFibSequence() - Empty constructor which sets default start index and found value array size
|
|   Class Methods:  No private class methods
|
|
|   Instance Methods:  next() Returns an int
|                      getFibNumber(int fibIndex) Returns an int
|
|
|  *===========================================================================*/

public class FastLoopFibSequence implements Sequence
{

    public  final int OVERFLOW_VALUE = 0;

    private final int DEFAULT_FIB_SIZE = 37;

    private int[] foundValues;

    private int fibPosition = 0;


    /**
     *  Sets the array size needed for the found values given the starting sequence,
     *  sets the starting index and default starting values
     *
     * @param startIndex The starting number of the getFibNumber sequence
     */
    public FastLoopFibSequence(int startIndex)
    {
        foundValues = new int[DEFAULT_FIB_SIZE + startIndex];
        fibPosition = startIndex;

        // Set default value (1) for array index 1
        foundValues[1] = 1;

    }

    /**
     * Sets a default array size needed for the found values given the starting sequence,
     * sets the starting index and default starting values
     */
    public FastLoopFibSequence()
    {
        final int DEFAULT_START_INDEX = 0;

        foundValues = new int[DEFAULT_FIB_SIZE];
        fibPosition = DEFAULT_START_INDEX;

        // Set default values (1) for array index 0 and 1
        foundValues[1] = 1;

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
     * Note: This algorithm is a modification of the loop algorithm found
     *       in Cay S. Horstmann - Big Java Early Objects-Wiley (2013) Page 601
     *
     * @param fibIndex The index of the getFibNumber position to search
     * @return The getFibNumber number in the desired position
     */

    public int getFibNumber(int fibIndex)
    {
        final int BASE_CASE = 2;
        final int MIN_FIB_VALUE = 1;
        final int EMPTY_ARRAY_VALUE = 0;


        if (fibIndex <= BASE_CASE)
        {
            return MIN_FIB_VALUE;
        }

        try
        {
            if (foundValues[fibIndex - 1] != EMPTY_ARRAY_VALUE) // -1 last index
            {
                // -1 last index -2 second to last index
                foundValues[fibIndex] = Math.addExact(foundValues[fibIndex - 1], foundValues[fibIndex - 2]);

                return foundValues[fibIndex];
            }


            for (int i = BASE_CASE; i <= fibIndex; i++)
            {
                // -1 last index -2 second to last index
                foundValues[i] = Math.addExact(foundValues[i - 1], foundValues[i - 2]);
            }
            return foundValues[fibIndex];

        }catch (ArithmeticException exception)
        {
            return OVERFLOW_VALUE;
        }

    }


}