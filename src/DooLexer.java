
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 TOKENIZER OF DOOLANG

*/


public class DooLexer {


    ////////////////////  GLOBAL VARIABLES AND CONFIGS.  //////////////////////////


    static ArrayList<String> Constant = new ArrayList<>();
    static int tnum = 0;
    static int l =-1;

    static ArrayList<String> Identifiers = new ArrayList<>();

    // for alpha conditions
    static int row = 0;
    static int column = -1;
    static char[][] variables = new char[20][20];
    static ArrayList<Integer> Numbers;
    static int[] lastpos = new int[10];
    static int lp_n = 0; // holds last pos of column number in isAlpha condition

    // for oprator ,seperator , puntuators conditions ;
    static ArrayList<Character> Operator;
    static int o_i = -1; // operator count

    static ArrayList<Character> Seperator;
    static int s_i = -1; // seperator count

    static ArrayList<Character> Punctuator;
    static int p_i = -1; // punctuators count

    //////////////////// GLOBAL VARIABLES AND CONFIGS.///////////////////////

    // PRESEVED KEYS
    // static String[] keywords = {"frd","bkd","rt","lt"};
    static ArrayList<String> Keywords = new ArrayList<>();

    static ArrayList preserved_keywords = new ArrayList() {
        {
            add("print");
            add("bkd");
            add("rt");
            add("lt");
            add("frd");

        }
    };

    static List<Character> OPERATORS = new ArrayList() {
        {
            add(':');
        }
    };

    static List<Character> SEPERATORS = new ArrayList<Character>() {
        {
            add('{');
            add('}');
            add('(');
            add(')');
            add('[');
            add(']');
            add(',');

        }
    };

    static List<Character> PUNCTUATORS = new ArrayList<Character>() {
        {
            add(',');
            add(';');
            add('.');
        }
    };

    DooLexer() {
        // Empty construtor;
        Numbers = new ArrayList<>();
        Seperator = new ArrayList<>();
        Operator = new ArrayList<>();
        Punctuator = new ArrayList<>();
    }


    /////////////////////////////////////// Lexer ///////////////////

    void init_lexer(String source) {

        String expr[] = source.split("");
        print("<< Tokens :" + Arrays.toString(expr));
        int n = expr.length;
        ArrayList<Integer> ascii = new ArrayList<>();

        for (String s : expr) {
            ascii.add((int) s.charAt(0));
        }

        // print(ascii.toString());

        /////////////////////////////////////// Lexical Analysis/////////////////

        for (int k = 0; k < n; ++k) {

            /////////////////// Checking if ascii is digit////////////

            // char curr_char = (expr[k]).charAt(0);
            // System.out.println(k);

            if (Character.isDigit(expr[k].charAt(0)) ) {
                // print(expr[i]+" is a digit");
                while ( Character.isDigit(expr[k].charAt(0))) {
                    tnum = 10 * tnum + ascii.get(k) - '0';
                    k++;
                }
                l++;
//                constants[l] = tnum;
                Numbers.add(tnum);
                tnum = 0;
            }

            /////////////////// Checking if ascii is digit////////////

            /////////// Checking if element is seperator //////////////////////////////

            if (SEPERATORS.contains(expr[k].charAt(0))) {
                s_i++;
                Seperator.add(s_i,expr[k].charAt(0));
             //   seperator[s_i] = expr[k].charAt(0);
            }

            /////////// Checking if ascii is SEPERATOR //////////////////////////////

            /////////// Checking if element is punctuators //////////////////////////////

            if (PUNCTUATORS.contains(expr[k].charAt(0))) {
                p_i++;
                Punctuator.add(p_i,expr[k].charAt(0));

            }

            /////////// Checking if ascii is SEPERATOR //////////////////////////////

            //////////////////////////// Checking if ascii is alphabet////////////

            if (Character.isLetter(expr[k].charAt(0))) {

                while (Character.isLetter(expr[k].charAt(0)) || Character.isDigit(expr[k].charAt(0))
                        || expr[k].charAt(0) == '_') {
                    column++; // column number increases in every iteration
                    variables[row][column] = expr[k].charAt(0);
                    k++;
                }
                row++;
                lastpos[lp_n] = column; // save last position of column number
                lp_n++;
                column = -1;
            }

            //////////////////////////// Checking if ascii is alphabet//////////

            /////////// Checking if ascii is Operator //////////////////////////////
            if (OPERATORS.contains(expr[k].charAt(0))) {
                o_i++;
                Operator.add(o_i,expr[k].charAt(0));
            }
        }
        /////////// Checking if ascii is Operator //////////////////////////////

        ///////////////////////////////////////// converting 2d array to 1-D for
        ///////////////////////////////////////// identifiers;

        int lp = 0;
        n = lastpos.length;

        StringBuilder t_id = new StringBuilder();

        for (int i = 0; i < 20; ++i) {

            if (lp < lastpos.length) {
                for (int j = 0; j < (lastpos[lp] + 1); j++) {

                    t_id.append(variables[i][j]);

                }
                lp++;
                if (!preserved_keywords.contains(String.valueOf(t_id))) {
                    Identifiers.add(String.valueOf(t_id));
                    t_id.delete(0, t_id.length());
                }else{
                    Keywords.add(String.valueOf(t_id));
                    t_id.delete(0, t_id.length());
                }

            }

        }



        /////////////////////////////////////////converting 2d array to 1-D for identifiers




    }






    void _printTokens(){

        System.out.println("<< Classification :\n\n");
        System.out.println("<< Constants :"+Constant);

        System.out.println("<< Operators :"+Operator);

        System.out.println("<< Seperator :"+Seperator);

        System.out.println("<< Punctuators :"+Punctuator);

        System.out.println("<< Identifiers :"+ Identifiers);
        System.out.println("<< Keywords :" + Keywords);
        System.out.println("<< Numbers :" + Numbers);



    }




    static void print(String inp){
        System.out.println(inp);

    }

}
