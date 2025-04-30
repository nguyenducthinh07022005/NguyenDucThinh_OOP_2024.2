package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "test.exe"; // Replace with a large file
        byte[] inputBytes;
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Using StringBuilder: " + (endTime - startTime) + "ms");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}