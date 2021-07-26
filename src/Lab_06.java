
public class Lab_06 {
    public static int stringLength(String string){
        if(string.equals("")){
            return 0;
        }
        else{
            return stringLength(string.substring(1))+1;
        }
    }

    public static int countNonVowels(String string){
        int length = 0;
        if(string.contains("a") || string.contains("e")  || string.contains("o") || string.contains("u")  || string.contains("i")  ){    
            if (string.length() == 0){
                return length;
            }
            if(!(string.substring(0, 1)).equalsIgnoreCase("a") && !(string.substring(0, 1)).equalsIgnoreCase("e") && 
            !(string.substring(0, 1)).equalsIgnoreCase("o") && !(string.substring(0, 1)).equalsIgnoreCase("u") && 
            !(string.substring(0, 1)).equalsIgnoreCase("i")){
                length = 1 + countNonVowels(string.substring(1));
                return length;
            }
            length = countNonVowels(string.substring(1));
            return length;
        }
        else{
            return length + stringLength(string);
        }
    }

    public static void main(String[] args){

        String string = "CS102 is the best";
        System.out.println(stringLength(string));
        
        String string2 = "CS102 is a good course";
        System.out.println(stringLength(string2));
        System.out.println(countNonVowels(string2));
        System.out.println(string2.length()-countNonVowels(string2));

    }


}
