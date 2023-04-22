import java.util.HashMap;

public class CharacterPropertiesFactory {
    private static HashMap<String, CharacterProperties> characterPropertiesMap = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + color + size;
        CharacterProperties properties;
        if (characterPropertiesMap.containsKey(key))
            properties = characterPropertiesMap.get(key);
        else {
            properties = new CharacterProperties(font, color, size);
            characterPropertiesMap.put(key, properties);
        }
        return properties;
    }
}