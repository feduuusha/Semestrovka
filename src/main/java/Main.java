import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File output = new File("output.txt");
        try (FileWriter fileWriter = new FileWriter(output)) {
            for (int i = 100; i <= 10000; i += 100) {
                Scanner fileReader = new Scanner(FileGenerator.generateFile(i));
                int[] arr = new int[i];
                for (int j = 0; j < i; ++j) {
                    arr[j] = Integer.parseInt(fileReader.nextLine());
                }
                long start = System.nanoTime();
                MergeSort.sort(arr);
                fileWriter.write((System.nanoTime() - start) + ":" + MergeSort.getCounterOfIterations() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
