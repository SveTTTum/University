import java.io.*;
import java.util.*;

public class OptionalTasks {

    //Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    public static void sortNumbersInFile () {
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


}
