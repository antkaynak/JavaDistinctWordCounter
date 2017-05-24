import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Operate {
    private HashMap<String, Integer> list;

    Operate(File myFile){
        Count(myFile);
    }

    public void Count(File myFile) {
         list = new HashMap<String, Integer>();

        try (Scanner scan = new Scanner(myFile)) {
            while (scan.hasNext()) {

                String word = scan.next().toLowerCase().replaceAll("[^\\s\\w]*", "");
                if (!list.containsKey(word)) {
                    list.put(word, 1);
                } else {
                    int count = list.get(word) + 1;
                    list.remove(word);
                    list.put(word, count);
                }

            }

            Print(list);


        } catch (FileNotFoundException ex) {
            System.out.println("File not found at " + myFile + "! Please try again...");
            Main.getInput();
        } catch (Exception e) {
            System.out.println("Error! Please try again...");
            Main.getInput();
        }


    }



    public void Print(HashMap<String, Integer> list){
        int printCount = 0;
        List<String> printList = new ArrayList<String>();
        for (String ks: list.keySet()){
            printList.add("[ "+ks+" = "+ list.get(ks).toString()+" ]  ");
        }
        Collections.sort(printList);
        for( String s : printList){
            if(printCount > 5){
                printCount = 0;
                System.out.println("");
            }
            System.out.print(s);
            printCount++;
        }

    }



}
