package pl.java_lab.maven_lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class getData {
    String data;
    ArrayList<String> words = new ArrayList<>();
    String encrypted;

    @GetMapping("/test")
    public String result() throws IOException{
        readDataFromFile();
        return "Word: " + words.get(0) +"\n" + encrypted;
    }

    public void readDataFromFile() throws IOException {
        System.out.println("Read data from file dane.txt.");
        System.out.println();
        FileReader fr = new FileReader("src\\main\\java\\pl\\java_lab\\maven_lab\\data.txt"); //"If relative path works - use it" ~Paulo Coelho
        BufferedReader br = new BufferedReader(fr);
        
        while ((data = br.readLine()) != null) {
            words.add(data);
        }

        Collections.sort(words);

        encrypted = encryptData(words.get(0), 13);
        fr.close();
    }

    private static String encryptData(String txt, int key ) {
        String encrypted = "";

        for (int i = 0; i < txt.length(); i++)
        {
            if (Character.isUpperCase(txt.charAt(i)))
            {
                int characterIndex = (char)(txt.charAt(i)) - (char)('A');
                int characterShifted = (characterIndex + key) % 26 +  (char)('A');
                encrypted += (char)(characterShifted);
            }
            else if (Character.isLowerCase(txt.charAt(i)))
            {
                int characterIndex = (char)(txt.charAt(i)) - (char)('a');
                int characterShifted = (characterIndex + key) % 26 +  (char)('a');
                encrypted += (char)(characterShifted);
            }
            else if (Character.isDigit(txt.charAt(i)))
            {
                int  characterNew = ((int)(txt.charAt(i)) + key) % 10;
                encrypted += (char)(characterNew);
            }
            else
            {
                encrypted += txt.charAt(i);
            }
        }
        return encrypted;
    }

}
