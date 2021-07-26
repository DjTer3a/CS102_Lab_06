import java.util.*;
import java.io.*;

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

    public static void createBinary(int start,  int size, char[] ch){
        if(start == size){
            System.out.println(toString(ch)+" ");
            return;
        }

        if(ch[size-1] == '0'){
            ch[size] = '1';
            createBinary(start, size+1, ch);
            ch[size] = '0';
            createBinary(start, size+1, ch);
        }

        if(ch[size-1] == '1'){
            ch[size] = '0';

            createBinary(start, size+1, ch);
        }
    }

    public static void allBinary(int start){
        if(start <=0){
            return;
        }

        char[] ch = new char[start];

        ch[0] = '1';
        createBinary(start, 1, ch);

        ch[0] = '0';
        createBinary(start, 1, ch);

    }

    public static String toString(char[] ch){
        String string = new String(ch);
        return string;
    }

    private static long counter = 0;

    public static void fileCounter(File[] files, int start, int deeper){
        
        if(start == files.length){
            System.out.println(counter);
            return ;
        }
        if(files[start].isFile()){
            counter++;
        }
        else if(files[start].isDirectory()){
            fileCounter(files[start].listFiles(), 0, deeper+1);
        }
        fileCounter(files, ++start, deeper);
    }
    

    public static void main(String[] args){

        String string = "CS102 is the best";
        System.out.println(stringLength(string));
        
        String string2 = "CS102 is start good course";
        System.out.println(stringLength(string2));
        System.out.println(countNonVowels(string2));
        System.out.println(string2.length()-countNonVowels(string2));

        int num = 4;
        allBinary(num);

        
        String path = "C:\\Users\\djter\\Desktop\\cs102 summer";
        File file = new File(path);
        System.out.println();
        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();

            fileCounter(files, 0, 0);
        }


    }


}
