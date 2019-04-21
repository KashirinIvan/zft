import zft.kashirin.Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Количество аргументов не верно");
            return;
        }
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
            if (contentType.equals("i")) {
                Integer[] integers = new Integer[lines.size()];
                for (int i = 0; i < lines.size(); i++) {
                    integers[i] = Integer.valueOf(lines.get(i));
                }
                Sort<Integer> sortInteger = new Sort<>();
                sortInteger.insertSort(integers, modeSort);
                for (int element : integers) {
                    writer.println(element);
                }
            } else if (contentType.equals("s")) {
                String[] strings = new String[lines.size()];
                for (int i = 0; i < lines.size(); i++) {
                    strings[i] = String.valueOf(lines.get(i));
                }
                Comparator<String> comparator = Comparator.comparingInt(String::length);
                Sort<String> sortString = new Sort<>(comparator);
                sortString.insertSort(strings, modeSort);
                for (String element : strings) {
                    writer.println(element);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    private static String getParameter(String arg) {
        return arg.substring(arg.indexOf("=") + 1);
    }
}
