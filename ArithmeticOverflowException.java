/*=======================================================================
|   Source code:  ArithmeticOverflowException.java
|                 Class: ArithmeticOverflowException
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|        Section: U06
|
|
|        Language:  Java
|        Compile:
|                javac ArithmeticOverflowException.java
|
|
|    Purpose: To provide a user define exception for overflow values
|
|
|    Inherits From:  ArithmeticException
|
|
|     Interfaces:  None
|
|
|  +-----------------------------------------------------------------------
|
|      Constants:  No public constants
|
|
| +-----------------------------------------------------------------------
|
|   Constructors:  ArithmeticOverflowException(String message) - Constructor that sets a user defined super message
|                  ArithmeticOverflowException() - Empty constructor which sets default super message
|
|   Class Methods:  No private class methods
|
|   Instance Methods:  None
|
|
|  *===========================================================================*/

public class ArithmeticOverflowException extends ArithmeticException
{
    /**
     * Sets the msg for the error
     * @param message the msg to be displayed
     */
    public ArithmeticOverflowException(String message)
    {
        super(message);
    }

    /**
     * Sets a default msg for the error
     *
     */
    public ArithmeticOverflowException()
    {
        super("The Value caused An Overflow");

    }
}






