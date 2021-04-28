import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskIO {

    public static void getFilesRecurse(FileWriter writer, File dir, int depth) {
        File[] content = dir.listFiles();
        if (content == null) {
            System.out.println("Not added directory. Please add and restart!");
        } else {
            List<File> dirs = Arrays.stream(content).filter(File::isDirectory).collect(Collectors.toList());
            List<File> files = Arrays.stream(content).filter(File::isFile).collect(Collectors.toList());
            for (File file : dirs) {
                try {
                    writer.write("\t".repeat(depth) + "|-----" + file.getName());
                    writer.append(System.lineSeparator());
                    getFilesRecurse(writer, file, depth + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (File file : files) {
                try {
                    writer.write("\t".repeat(depth + 1) + "|     " + file.getName());
                    writer.append(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args) {
        System.out.println("My directory - " + args[0]);
        File file = new File("data\\file.txt");
        File sourceFile = new File(args[0]);
        try (FileWriter writer = new FileWriter(file)) {
            if (sourceFile.isDirectory()) {
                getFilesRecurse(writer, sourceFile, 0);
            } else {
                System.out.println("Please add directory");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counterFile = 0;
        int counterDir = 0;
        int sumLengthFiles = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if (file.exists()) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains("-----")) {
                        counterDir++;
                    }
                    if (line.contains("|     ")) {
                        counterFile++;
                        sumLengthFiles += line.length();
                    }
                }
                int middleLengthFile;
                int middleQuantityFiles;
                if (counterFile != 0) {
                    middleLengthFile = sumLengthFiles / counterFile;
                } else {
                    middleLengthFile = 0;
                }
                if (counterDir != 0) {
                    middleQuantityFiles = counterFile / counterDir;
                } else {
                    middleQuantityFiles = 0;
                }
                System.out.println("Quantity of folders " + counterDir + "\n" + "Quantity of files " + counterFile);
                System.out.println("Middle length name of file " + middleLengthFile);
                System.out.println("Middle quantity of files in directory " + middleQuantityFiles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



