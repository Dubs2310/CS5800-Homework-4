public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        document.addCharacter('H', "Arial", "Black", 12);
        document.addCharacter('e', "Calibri", "Blue", 14);
        document.addCharacter('l', "Verdana", "Red", 16);
        document.addCharacter('l', "Calibri", "Red", 12);

        document.addCharacter('o', "Arial", "Black", 12);
        document.addCharacter('W', "Calibri", "Blue", 14);
        document.addCharacter('o', "Verdana", "Red", 16);
        document.addCharacter('r', "Calibri", "Red", 12);

        document.addCharacter('l', "Arial", "Black", 12);
        document.addCharacter('d', "Calibri", "Blue", 14);
        document.addCharacter('C', "Verdana", "Red", 16);
        document.addCharacter('S', "Calibri", "Red", 12);

        document.addCharacter('5', "Arial", "Black", 12);
        document.addCharacter('8', "Calibri", "Blue", 14);
        document.addCharacter('0', "Verdana", "Red", 16);
        document.addCharacter('0', "Calibri", "Red", 12);
        
        document.saveToFile("HelloWorldCS5800.txt");
    
        Document documentCopy = new Document();
        documentCopy.loadFromFile("HelloWorldCS5800.txt");
        
        for (Character character : documentCopy.getCharacters()) {
            System.out.print(character.toString());
        }
    }
}