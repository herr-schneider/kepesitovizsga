package hu.nive.ujratervezes.kepesitovizsga.phoneBook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output){
        if (output == null || output.isEmpty() || output.isBlank() || contacts == null){
            throw new IllegalArgumentException("Null is not a good idea!");
        }
        Path file = Path.of(output);
        try (BufferedWriter bf = Files.newBufferedWriter(file)) {
            for (Map.Entry<String,String> entry : contacts.entrySet())
            bf.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }catch (IOException ioe){
            throw new IllegalStateException();
        }
    }
}
