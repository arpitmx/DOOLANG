import java.util.ArrayList;
import java.util.List;

public class TokenDB {

 int total_ds = 4;

  // PRESEVED KEYS
    // static String[] keywords = {"frd","bkd","rt","lt"};
    static ArrayList<String> keywords = new ArrayList<String>();
    static List<String> KEYWORDS = new ArrayList<String>() {
        {
            add("frd");
            add("bkd");
            add("rt");
            add("lt");
            add("doo");

        }
    };

    static List<Character> OPERATORS = new ArrayList<Character>() {
        {
            add('+');
            add('-');
            add('/');
            add('=');
            add('*');

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
            add(':');
            add(';');
            add('.');
        }
    };




  /*  List<String> Keywords = new ArrayList<String>();  //Keywords 
    List<Character> Operators = new ArrayList<>();  // Operators 
    List<Character> Seprators = new ArrayList<>();  // Seprators 
    List<Character> Punctuators = new ArrayList<>();  // Punctuators

*/


//List<String> kKeywords, List<Character> oOperators,List<Character> sSeprators, List<Character> pPunctuators 
  


void start_preprocessing(ArrayList<String> kKeywords, List<Character> oOperators,List<Character> sSeprators, List<Character> pPunctuators){

//Keyword preprocessing :
ArrayList<String> invalidKeywords = new ArrayList<>();  
invalidKeywords = check_keyword_validity(KEYWORDS, kKeywords);

if (!invalidKeywords.isEmpty()){
    System.out.println(">>Errors in the source syntax(if not identifiers) :"+(invalidKeywords));
}else{
    System.out.println("<< Keywords are correct.");
}




}






ArrayList<String> check_keyword_validity(List<String> keywordsdb , ArrayList<String> sourceInput){

ArrayList<String> invalidKeywords = new ArrayList<>();
int sourceInput_len = sourceInput.size();
int keywordsdb_len = keywordsdb.size();



for(int i =0;i<sourceInput_len;++i){

    String current_keyword = sourceInput.get(i);

    if (keywordsdb.contains(current_keyword))
    {
        continue;

    }else{
        System.out.println("Malformed keyword :"+current_keyword);
        invalidKeywords.add(current_keyword);
    }
}
    return invalidKeywords;
}




 }

    

