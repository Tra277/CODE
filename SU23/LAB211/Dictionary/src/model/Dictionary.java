package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    private HashMap<String, String> dict;

    public Dictionary() throws FileNotFoundException {
        dict = new HashMap<>();
        this.loadData();        
    }

    private void loadData() throws FileNotFoundException {
        File fileDictionary = new File("dictionary.txt");
        try (Scanner scannerFile = new Scanner(fileDictionary)) {
            while (scannerFile.hasNextLine()) {
                String line = scannerFile.nextLine();
                String[] words = line.split("[-]");
                String endlishWord = words[0].trim(), vietnamMeaning = words[1].trim();
                dict.putIfAbsent(endlishWord, vietnamMeaning);
            }
            scannerFile.close();
        }
    }

    private void saveData() throws IOException {
        File fileDictionary = new File("dictionary.txt");
        try (FileWriter fileToWrite = new FileWriter(fileDictionary)) {
            for (String i : dict.keySet()) {
                fileToWrite.write(i + " - " + dict.get(i));
            }
            fileToWrite.close();
        }

    }

    public void addNewWord() throws IOException {
        System.out.println("----------ADD---------");
        String eng = Validation.getString("Enter English:");
        if (dict.containsKey(eng) && !Validation.getYN(eng + " is already exist,do you want to update???(Y/N):")) {
            return;
        }
        String vietnameseMeaning = Validation.getString("Enter VietNamese:");
        dict.put(eng, vietnameseMeaning);

        saveData();
        System.out.println("Add successfully!");
    }

    public void removeWord() throws IOException {
        System.out.println("-----------DELETE--------");
        String eng = Validation.getString("Enter English:");
        if (!dict.containsKey(eng)) {
            System.out.println("Not found!");
            return;
        }
        dict.remove(eng);

        saveData();
        System.out.println("Delete successfully!");
    }

    public void translateWord() {
        System.out.println("---------TRANSLATE-----------");
        String eng = Validation.getString("Enter English:");
        if (!dict.containsKey(eng)) {
            System.out.println("Not found!");
            return;
        }
        System.out.println("Vietnamese:　"+ dict.get(eng));

    }

}
