/*=======================================================================
|   Source code:  LoopFibSequence.java
|                 Class: LoopFibSequence
|
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|        Section: U06
|
|
|
|        Language:  Java
|        Compile:
|                javac LoopFibSequence.java Sequence.java
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
|   Constructors:  LoopFibSequence(int startIndex) - Constructor that sets start index and found array size
|                  LoopFibSequence() - Empty constructor which sets default start index and found value array size
|
|   Class Methods:  No private class methods
|
|
|   Instance Methods:  next() Returns an int
|                      getFibNumber(int fibIndex) Returns an int
|
|
|  *===========================================================================*/

public class LoopFibSequence implements Sequence
{
    public final int OVERFLOW_VALUE = 0;

    private int fibIndex = 0;


    /**
     *  sets the starting index
     *
     * @param startIndex The starting number of the getFibNumber sequence
     */
    public LoopFibSequence(int startIndex)
    {
        fibIndex = startIndex;
    }

    /**
     *  sets the starting index
     *
     */
    public LoopFibSequence()
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
     * Fibonacci Sequence:
     *
     * A Fibonacci Sequence is a series of numbers where the next number
     * is found by adding up the two numbers before it.
     *
     *  Ex:
     *   0 1 1 2 3 5 8 13…..
     *
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

        try
        {
            if (fibIndex <= BASE_CASE)
            {
                return MIN_FIB_VALUE;

            }else
            {
                int olderValue = 1;
                int oldValue = 1;
                int newValue = 1;

                for (int i = 3; i <= fibIndex; i++)
                {
                    newValue = Math.addExact(oldValue, olderValue);
                    olderValue = oldValue;
                    oldValue = newValue;

                }

                return newValue;
            }

        }catch (ArithmeticException exception)
        {
            return OVERFLOW_VALUE;
        }
    }
}



