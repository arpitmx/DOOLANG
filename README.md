# DOOLANG
 Started on 9th November, 2020.
 DOOLANG is a Java based LOGO like language.
 
////Latest Edit Nov 13, 2020;

# DOOLANG v0.0.1 SIMPLE SOURCECODE:
 
   frd:70;  //Move doo forward 70 units , making 0 degree angle with Y-axis(normal on x axis)(Default direction)
   bkd:20;  //Move backwards, towards -y axis ,0 degree with Y axis
   rt:90;   //turn right, making 90 degree agle wrt y-axis , rt:-90; or rt:270 == lt:90; 
   frd:50;
   lt:50;   //turn left , making 50 degree agle wrt  y-axis
   frd:20;

# Output: Taking 1 '|' = 1 UNIT AND '--' = 1 UNIT
   </br>
   |(X)         |
   |(X)         |   
   |>-----------^
   |
   |
   |
   |
 
# Things Done:
 1. Added a simple lexer for tokenizing source code.


# Things to add next:

 1.Work on error preprocessing , and pre syntax error correctio into the lexer;
 
 2.Start the work on Doo's v1.0 Parser;

 
