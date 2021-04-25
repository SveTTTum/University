import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyIO {

    public static List<String> getFilesRecurse(File dir) {
        List<String> listPath = new ArrayList<>();
        if (dir.isDirectory())
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
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

    public static void main(String[] args) {
        File file = new File("data\\file.txt");
        for (String element : args) {
            System.out.println("My directory - " + element);
            File dir = new File(element);
            List<String> stringList = getFilesRecurse(dir);

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(dir.getName());
                writer.append('\n');
                for (String elem : stringList) {
                    writer.write(elem);
                    writer.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader reader = null;
        try {
            reader = new FileReader(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            List<String> listOfData = new BufferedReader(reader).lines().collect(Collectors.toList());
            listOfData.forEach(System.out::println);

            int counterFile = 0;
            int counterDir = 0;
            int sumLengthFiles = 0;
            for (String line : listOfData) {
                if (line.contains("-----")) {
                    counterDir++;
                }
                if (line.contains("|     ")) {
                    counterFile++;
                    sumLengthFiles += line.length();
                }
            }
        if (counterFile == 0) {
            throw new ArithmeticException("No files in this directory");
        }
        if (counterDir == 0) {
            throw new ArithmeticException("No folders in this directory");
        }
        int middleLengthFile = sumLengthFiles / counterFile;
        int middleQuantityFiles = counterFile / counterDir;
        System.out.println("Quantity of folders " + counterDir + "\n" + "Quantity of files " + counterFile);
        System.out.println("Middle length name of file " + middleLengthFile);
        System.out.println("Middle quantity of files in directory " + middleQuantityFiles);
    }
}
