import java.util.ArrayList;
import java.util.*;
public class ErrorSuggest {

    /*

        Suggest outputs from token db if the invalid token is similar to one in tokendb
        Example:
         intput > frdi : 60 ;
         output > Syntax error : "frdi"
                  Do you mean : "frd" ?
        
    */
   static ArrayList<String> preserved_keywords = new ArrayList() {
        {
            add("frd");
            add("elegance");
            add("hello");
            add("temper");
            add("enter");
            add("elephant");

        }
    };

   static void suggest(String source){
       String[] tokens = source.split("");
       // System.out.println(Arrays.toString(tokens));
        int ninp = tokens.length;
        int source_length = source.length();
        System.out.println("<< Syntax error : "+source);
        for (int i = 0 ; i < preserved_keywords.size() ; ++i){
            int match_count = 0;
            int not_matched = 0;

            String curr_keyword = preserved_keywords.get(i);
           // System.out.println(curr_keyword);
            
            String ss[] = splitStrings(curr_keyword);
            int nref = ss.length;
            //System.out.println(Arrays.toString(ss));
           if (ninp>nref){
            for (int j = 0 ; j < nref; j++){
                
                if (tokens[j].equals(ss[j])){
                    match_count++;
                }else{
                    not_matched ++;    
                }
            }
           }else{
            for (int j = 0 ; j < tokens.length; j++){
                
                if (tokens[j].equals(ss[j])){
                    match_count++;
                }else{
                    not_matched ++;
                }
            }
        }
           // System.out.println(curr_keyword+" : Matched >"+match_count+" Not Matched :"+not_matched);
           
           if (match_count>not_matched){
                System.out.println(">> Do you meant : "+curr_keyword+"?");
                
           }

        }

       
    }


    static String[] splitStrings(String s){

        String splitString[] = s.split("");

        return splitString;
    }



    public static void main(String[] args) {
        suggest("e");
    }

    
}
