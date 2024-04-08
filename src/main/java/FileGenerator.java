import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {

    public static File generateFile(int size) {
        File file = new File("data.txt");
        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < size; ++i) {
                Random rd = new Random();
                int value = rd.nextInt();
                fw.write(value + "\n");
                fw.flush();
            }
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
