/*=======================================================================
|   Source code:  ArithmeticOverflowException.java
|                 Class: ArithmeticOverflowException
|
|
|    Assignment:  Assignment 6 Recursive Fibonacci
|
|        Course: COP 3337 (Intermediate Programming)
|        Section: U06
|        Instructor:  William Feild
|        Due Date: 6 April 2020, by the beginning of class
|
|
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
|    Inherits From:  IllegalArgumentException
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
|   Constructors:  UserInvalidValueException(String message) - Constructor that sets a user defined super message
|                  UserInvalidValueException() - Empty constructor which sets default super message
|
|   Class Methods:  No private class methods
|
|
|   Instance Methods:  None
|
|
|
|  *===========================================================================*/

public class UserInvalidValueException extends IllegalArgumentException
{
    /**
     * Sets the msg for the error
     * @param message the msg to be displayed
     */
    public UserInvalidValueException(String message)
    {
        super(message);
    }

    /**
     * Sets a default msg for the error
     *
     */
    public UserInvalidValueException()
    {
        super("The Value Interred Is Invalid");
    }

}
