package patterns.decorate.io;

import java.io.*;

public class InputTest {
    public static void main(String[] args) {
        int c;
        File file = new File("src\\main\\resources\\testIO.txt");

        try {

            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));
            while ((c=in.read()) >=0){
                System.out.println((char)c);
            }
            in.close();
        }   catch (IOException e){
            e.printStackTrace();
        }
    }
}
