/*=======================================================================
|   Source code:  FastLoopFibSequence.java
|                 Class: FastLoopFibSequence
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|
|
|
|
|        Language:  Java
|        Compile:
|                javac FibSequence.java Sequence.java
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
|   Constructors:  FibSequence(int startIndex) - Constructor that sets start index
|                  FibSequence() - Empty constructor which sets default start index and found value array size
|
|   Class Methods:  No private class methods
|
|
|   Instance Methods:  next() Returns an int
|                      getFibNumber(int fibIndex) Returns an int
|
|
|  *===========================================================================*/

public class FibSequence implements  Sequence
{

    public final int OVERFLOW_VALUE = 0;

    private static int fibIndex = 0;



    /**
     *  sets the starting index
     *
     * @param startIndex The starting number of the getFibNumber sequence
     */
    public FibSequence(int startIndex)
    {
        fibIndex = startIndex;
    }

    /**
     *  sets a default starting index
     */

    public FibSequence()
    {
        final int DEFAULT_START_INDEX = 0;

        fibIndex = DEFAULT_START_INDEX;
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
        fibIndex++;
        return getFibNumber(fibIndex);
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
     * Note: This algorithm is the recursive algorithm found
     *       in Cay S. Horstmann - Big Java Early Objects-Wiley (2013) Page 598
     *
     *
     * @param fibIndex The index of the getFibNumber position to search
     * @return The getFibNumber number in the desired position
     */

    public int getFibNumber(int fibIndex)
    {
        final int MIN_FIB_VALUE = 1;
        final int BASE_CASE = 2;

        try
        {
            if (fibIndex <= BASE_CASE)
            {
                return MIN_FIB_VALUE;

            } else
            {
                // -1 last index -2 second to last index
                return Math.addExact(getFibNumber(fibIndex - 1),  getFibNumber(fibIndex - 2));
            }

        }catch (ArithmeticException exception)
        {
            return OVERFLOW_VALUE;
        }
    }
}
