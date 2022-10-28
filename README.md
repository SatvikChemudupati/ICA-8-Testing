# ICA-8-Testing

Problem Statement:

In men's public toilets with urinals, there is this unwritten rule that you leave at least one urinal free between you and the next person peeing. For example if there are 3 urinals and one person is already peeing in the left one, you will choose the urinal on the right and not the one in the middle. That means that a maximum of 3 people can pee at the same time on public toilets with 5 urinals when following this rule (Only 2 if the first person pees into urinal 2 or 4). Need to create a function that returns the maximum of free urinals as an integer according to the unwritten rule.

Implemented:

1. urinals - The main class of the project
2. count_method - implements the logic behind the returning the maximum of free urinals as an integer according to the unwritten rule.
3. The main function takes input from the user to choose between the keyboard input or file input. 
    If keyboard input is selected, the function is executed and the output is displayed on the screen.
    If file input is selected, the input from the file is read checking for valid input conditions and the process is exectued with the ouput being stored in a separate file. The output file is chosen based on the exisiting files. If the file rule.txt already exists, increment a counter and rename the file using the following rule pattern: rule1.txt, rule2.txt, etc. The output is JUST THE NUMBER of free urinals. The output looks like :
    1 
    0 
    3 
    2 
    1
    
Test cases: 
Several test cases are considered in the urinaltest.java file and executed to zero errors. 

Instructions to execute the program:
1. Unzip the zip folder.
2. Add the input.dat in the root folder if you want to change the existing one.
3. Execute the urinals.java file for the output and follow the on screen instructions.
