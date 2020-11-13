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
        //for digit conditions
    static int[] constants = new int[20];
    static int tnum = 0;
    static int l =-1;

    //for alpha conditions
    static int row = 0;
    static int column = -1;
    static char[][] variables = new char[20][20];
    static int[] lastpos = new int[10];
    static int lp_n=0; //holds last pos of column number in isAlpha condition

    //for oprator ,seperator , puntuators conditions ; 
    static char[] operators = new char[20];
    static int o_i = -1; //operator count


    static char[] seperator = new char[20];
    static int s_i = -1; //seperator count

    static char[] punctuators = new char[20];
    static int p_i = -1; //punctuators count



    //PRESEVED KEYS
    //static String[] keywords = {"frd","bkd","rt","lt"};
    static ArrayList<String> keywords = new ArrayList<>();
    static List<String> preserved_keywords=new ArrayList<>(){{
        add("frd");
        add("bkd");
        add("rt");
        add("lt");
        add("doo");
        
    }};

    static List<Character> OPERATORS=new ArrayList<>(){{
        add('+');
        add('-');
        add('/');
        add('=');
        add('*');
        
    }};

    static List<Character> SEPERATORS=new ArrayList<Character>(){{
        add('{');
        add('}');
        add('(');
        add(')');
        add('[');
        add(']');
        add(',');
        
    }};

    static List<Character> PUNCTUATORS=new ArrayList<Character>(){{
        add(':');
        add(';');
        add('.'); }};


       



/////////////////////////Variables End////////////////////





    public static void main(String[] args) {

   // Scanner sc = new Scanner(System.in);

    DooLexer dooLexer = new DooLexer();



    System.out.println(">>>DooLang");
    System.out.print("<<");

    String input = "frd a : 60;";

    System.out.println(" Input : "+input);
  
   dooLexer.init_lexer(input);
   dooLexer._printTokens();

   
    

 }
   

    static void print(String inp){
        System.out.println(inp);

    }
    
}
