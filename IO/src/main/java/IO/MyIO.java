package IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyIO {

    public static List <String> getFilesRecurse(File dir){
        List <String> listPath = new ArrayList<>();
        if (dir.isDirectory())
            for (File file : dir.listFiles()) {
                if(file.isDirectory()) {
                    listPath.add("|-----" + file.getName());
                    listPath.addAll(getFilesRecurse(file));
                } else {
                    listPath.add("|     " + file.getName());
                }
            }
        else
            listPath.add(String.valueOf(dir));
        return listPath;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("data\\file.txt");
        for(String element : args) {
            System.out.println("My directory - " + element);
            File dir = new File(element);
            List <String> stringList = getFilesRecurse(dir);

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(dir.getName());
                writer.append('\n');
            for (String elem : stringList) {
                    writer.write(elem);
                    writer.append('\n');
                }
                writer.close();
            }
        }
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.lines().forEach(System.out::println);


        bufferedReader.close();
        }
}
