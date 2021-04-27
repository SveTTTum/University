import java.io.*;
import java.util.*;

public class OptionalTasks {

    //Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    public static void sortNumbersInFile() {
        File file = new File("data\\result.txt");
        Random random = new Random();
        int[] arrayNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayNumbers[i] = random.nextInt(201) - 100;
        }
        try (FileWriter writer = new FileWriter(file)) {
            for (Integer line : arrayNumbers) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<Integer> listOfNumbers;
            try (Scanner scanner = new Scanner(file)) {
                listOfNumbers = new ArrayList<>();
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        listOfNumbers.add(scanner.nextInt());
                    } else {
                        scanner.next();
                    }
                }
            }
            Collections.sort(listOfNumbers);
            System.out.println(listOfNumbers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов,
    // которые имеют средний балл более 7
    public static void getStudentsWithMarksMoreThenSeven() {
        File file = new File("data\\info.txt");
        File outputFile = new File("data\\out.txt");
        String[] student;
        String line;
        int sum = 0;
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                    while ((line = bufferedReader.readLine()) != null) {
                        student = line.trim().split(" ");
                        for (int i = 1; i < student.length - 1; i++) {
                            sum += Integer.parseInt(student[i]);
                        }
                        if (sum / (student.length - 1) > 7) {
                            bufferedWriter.append(line.replace(student[0], student[0].toLowerCase(Locale.ROOT))).append(System.lineSeparator());
                        } else {
                            bufferedWriter.append(line).append(System.lineSeparator());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
    public static void replaceFirstAndLastWordsInString() {
        List<String> listOfData;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data\\info2.txt"))) {
            listOfData = new ArrayList<>();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listOfData.add(line);
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter("data\\out2.txt"), true)) {
                String[] words;
                for (String element : listOfData) {
                    words = element.split(" ");
                    String first = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = first;
                    element = String.join(" ", words);
                    writer.printf(element);
                    writer.append('\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private
    public static final String wordPublic = "public";
    public static final String wordPrivate = "private";

    public static void changePublicOnPrivate() {
        File file = new File("data\\programExample.txt");
        File outputFile = new File("data\\outputProgramExample.txt");

        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        bufferedWriter.write(line.replace(wordPublic, wordPrivate));
                        bufferedWriter.write((System.lineSeparator()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
