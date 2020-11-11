import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Token {
    int n_elements = 2;

    ArrayList<Data> dList= new ArrayList<Data>();

    class Data{

        String direction;
        Integer magnitude;

        Data(String Dir , Integer Mag){

            this.direction = Dir;
            this.magnitude = Mag;

        }

    }

    public void append(String dir, Integer mag){
        Data data = new Data(dir,mag);
        dList.add(data);
    }

    public ArrayList<Data> returnToken(){
        return dList;
    }
    // dList has 'data' , each data packet contains two values : dir , mag
    public void print(){
        if (!dList.isEmpty()){
            for (Data data : dList){
                System.out.println("<<Tokens : [Dir: "+data.direction+" , Mag: "+data.magnitude.toString()+"]");
            }
    }else{
            System.out.println("<<Token Holder is Empty!");
        }
    }

    public void clear(){
        dList.clear();
    }

}
