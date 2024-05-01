package other.study;

import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        //writeFile();
        //writeFile2();
        //readFile();
        readFile2();
    }

    static void writeFile() {
        try {
            OutputStream output = new FileOutputStream("output.txt");
            String str = "Hello World!";
            byte[] by = str.getBytes();
            output.write(by);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    static void writeFile2() throws IOException {
        BufferedOutputStream bs = null;
        try {
            bs = new BufferedOutputStream(new FileOutputStream("output.txt"));
            String str = "Hello World!!";
            bs.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bs.close();
        }
    }

    static void readFile() {
        try {
            FileReader reader = new FileReader("output.txt");
            int cur = 0;
            while ((cur = reader.read()) != -1) {
                System.out.printf("%c", cur);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readFile2() {
        try (FileInputStream file = new FileInputStream("output.txt")) {
            byte[] readBuffer = new byte[file.available()];
            file.read(readBuffer);
            System.out.println(new String(readBuffer)); //출력
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}