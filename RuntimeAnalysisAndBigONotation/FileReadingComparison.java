import java.io.*;

public class FileReadingComparison {

    public static void main(String[] args) throws Exception {
        File file = new File("largefile.txt"); // Use a large text file ~500MB+

        // FileReader Benchmark
        long startFileReader = System.nanoTime();
        FileReader fr = new FileReader(file);
        while (fr.read() != -1) {}
        fr.close();
        long endFileReader = System.nanoTime();
        System.out.printf("FileReader Time: %.2f ms%n", (endFileReader - startFileReader) / 1_000_000.0);

        // InputStreamReader Benchmark
        long startISR = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        while (isr.read() != -1) {}
        isr.close();
        long endISR = System.nanoTime();
        System.out.printf("InputStreamReader Time: %.2f ms%n", (endISR - startISR) / 1_000_000.0);
    }
}
