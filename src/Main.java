import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



/*
>>>DOOLANG : 

Started on 10th November, 2020.
A logo type compiler , made in java.
Author - Arpit Maurya
How to push : Save>Commit>Push
  
*/
 
public class Main {
        

    public static void main(String[] args) {

   // Scanner sc = new Scanner(System.in);

    DooLexer dooLexer = new DooLexer();



    System.out.println(">>>DooLang");
    System.out.print("<<");

    String input = "frd: 120" +
            "rt:90, ;"  +
            "lt:120" +
            "bkd:20";
    input += " ";
    System.out.println(" Input : "+input);
  
   dooLexer.init_lexer(input);
   dooLexer._printTokens();

   

 }
   

    static void print(String inp){
        System.out.println(inp);

    }
    
}
