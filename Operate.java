import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operate {
    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }


    Operate(File myFile){
        Count(myFile);
    }

    private void Count(File myFile){
         list = new ArrayList<String>();
        try (Scanner scan = new Scanner(myFile)) {
            while(scan.hasNext()){
                String word = scan.next().toLowerCase().replaceAll("[^\\s\\w]*","");
                if(!list.contains(word)){
                    list.add(word);
                }

            }

            if(list.size() == 0){
                System.out.println("There are no words in "+myFile);
                return;
            }

            System.out.println("There are "+list.size()+" distinct words in "+ myFile);

        }

        catch(FileNotFoundException ex){
            System.out.println("File not found at "+myFile+"! Please try again...");
            Main.getInput();
        }

        catch(Exception e){
            System.out.println("Error! Please try again...");
            Main.getInput();
        }



    }


}
