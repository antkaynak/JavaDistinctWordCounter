import java.io.File;
import java.util.*;

public class Main {



    public static boolean Check(String fileName){
        if(fileName.toLowerCase().contains(".txt") || fileName.toLowerCase().contains(".xml")){

            return true;
        }
        System.out.println("Error! Must enter the proper extension type | .txt or .xml");
        return false;
    }

    public static void getInput(){
        System.out.println("Please enter your file's path |  hey.txt or C:\\\\Users\\\\Username\\\\hey.txt | Supported types : txt , xml \n");
        String fileName;
        do{
            Scanner input = new Scanner(System.in);
            fileName = input.nextLine().replaceAll("\\s","");
            if(Check(fileName)){
                break;
            }
        }while(true);

        File myFile = new File(fileName);
        System.gc();
        new Operate(myFile);
    }

    public static void main(String[] args) {
        getInput();
    }
}
