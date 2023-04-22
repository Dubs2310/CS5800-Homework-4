public class Character {
    private char value;
    private CharacterProperties properties;

    public Character(char value, CharacterProperties properties) {
        this.value = value;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return value + ", " + properties.getFont() + ", " + properties.getColor() + ", " + properties.getSize() + '\n';
    }
}