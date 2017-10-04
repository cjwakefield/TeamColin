Note from Colin G: This is all the raw text from the document. I will stick it into Word and format it nicely, add stuff like our names, etc. once I turn it in. The paper is due Monday (10/9/17) night.

# Project Proposal Paper

The project that our team has decided to work on is creating a graphing calculator. This calculator will be capable of taking any function as input, then drawing said function in a GUI for the user to see. It will all be done in Java.

This project can be broken into two main components. The first part is taking the user input, the function, and determining how to draw the function. The second part is taking said function and drawing it on the GUI output. 

## Calculating Function Points

This first component is arguably the most complex of the two. We have determined that the best way to draw each function would be to solve the function for various values of X, or whatever the variable might be in the function.

Here is an example of how this would work outside the code: -example of input/output chart in word-

On a number grid in an (X,Y) format, the values in the “input” column are the X values and the values in the “output” column are the Y values. 

While a rather trivial algebraic problem, this becomes more complicated when done in Java. The basic idea is that the program will read in a string (the function) as input from the user, then -information on how the program solves the function for every given point-
  
## Displaying The Function

The second component of the project is the displaying of information to the user. This incorporates the use of Java GUIs, something we have not learned in class yet. The user will first see a graph on which the function will be drawn. To draw the function, the program will take the points that the first component of the program calculated, then place them onto the grid in the displayed interface. 

-information on how this is accomplished in java-
