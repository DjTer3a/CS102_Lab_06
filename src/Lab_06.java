
public class Lab_06 {
    public static int stringLength(String string){
        if(string.equals("")){
            return 0;
        }
        else{
            return stringLength(string.substring(1))+1;
        }
    }
    
    public static void main(String[] args){

        String string = "CS102 is the best";
        System.out.println(stringLength(string)); 
    }


}
