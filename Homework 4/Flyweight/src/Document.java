import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
    private ArrayList<Character> characters = new ArrayList<>();

    public void addCharacter(char value, String font, String color, int size) {
        CharacterProperties properties = CharacterPropertiesFactory.getCharacterProperties(font, color, size);
        Character character = new Character(value, properties);
        characters.add(character);
    }

    public ArrayList<Character> getCharacters() { return characters; }

    public void saveToFile(String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            for (Character character: characters)
                writer.write(character.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to " + filename);
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] characterProps = scanner.nextLine().split(", ");
                char value = characterProps[0].charAt(0);
                String font = characterProps[1];
                String color = characterProps[2];
                int size = Integer.parseInt(characterProps[3]);
                addCharacter(value, font, color, size);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found");
            e.printStackTrace();
        }
    }
}