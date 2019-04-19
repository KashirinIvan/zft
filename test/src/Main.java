import zft.kashirin.Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String readFile = args[0];
        String writeFile = getParameter(args[1]) + readFile.substring(readFile.lastIndexOf("\\") + 1);
        String contentType = getParameter(args[2]);
        String modeSort = getParameter(args[3]);

       try (Scanner scanner = new Scanner(new FileInputStream(readFile));
             PrintWriter writer = new PrintWriter(readFile.substring(0, readFile.lastIndexOf("\\") + 1) + writeFile)) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }

          //  writer.println(stringInFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        if(contentType.equals("i")){
         //   Integer[] integers = new Integer[];
        }else if(contentType.equals("s")){
         //   String [] strings = new String[];
        }

        Integer[] test = new Integer[]{1,56,5};
        String [] test1 = new String[]{"aa","bbb","c"};
        Sort <Integer> sortArr = new Sort<>();

        sortArr.insertSort( test);
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Sort<String> sortArr1 = new Sort<>(comparator);
        sortArr1.insertSort(test1);
     }

    private static String getParameter(String arg) {
        return arg.substring(arg.indexOf("=") + 1);
    }
}
