package FileOp;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations implements FileRead, FileWrite {


    @Override
    public String readFile () {
        String fileName = "pg100.txt";
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileScanner = new FileReader(fileName);
            int val = fileScanner.read();
            while (val != -1) {
                sb.append((char) val);
                val = fileScanner.read();
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public String ReadBinaryFile() {
        byte[] input;
        try {
            input = Files.readAllBytes(Paths.get("compressed.bin"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : input) {
            for (int i = 7; i >= 0; i--) {
                sb.append((b & (1 << i)) == 0 ? '0' : '1');
            }
        }
        return sb.toString();
    }

    @Override
    public void writeFile(String text) {
        try (PrintWriter pw = new PrintWriter("decompressed.txt")) {
            pw.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

