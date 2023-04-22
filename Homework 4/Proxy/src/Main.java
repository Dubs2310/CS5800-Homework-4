import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printSearchResult(Song searchResult) {
        System.out.println("Title: " + searchResult.getTitle());
        System.out.println("Artist: " + searchResult.getArtist());
        System.out.println("Album: " + searchResult.getAlbum());
        System.out.println("Duration: " + searchResult.getDuration());
        System.out.println();
    }

    public static void printSearchResults(List<Song> searchResults) {
        for (Song searchResult: searchResults)
            printSearchResult(searchResult);
    }

    public static void main(String[] args) {
        List<Song> songLibrary = new ArrayList<>();
        songLibrary.add(new Song(0, "In the End", "Linkin Park", "Hybrid Theory", 218));
        songLibrary.add(new Song(1, "Numb", "Linkin Park", "Meteora", 186));
        songLibrary.add(new Song(2, "Lose Yourself", "Eminem", "8 Mile Soundtrack", 326));
        songLibrary.add(new Song(3, "Without Me", "Eminem", "The Eminem Show", 289));
        songLibrary.add(new Song(4, "Poker Face", "Lady Gaga", "The Fame", 216));
        songLibrary.add(new Song(5, "Bad Romance", "Lady Gaga", "The Fame Monster", 295));

        SongService streamingService = new MusicStreamingService(songLibrary);
        streamingService = new ProxyService(streamingService);

        Song searchResult = streamingService.searchById(4);
        System.out.println("------------------------------");
        System.out.println("Search By ID: (4)");
        printSearchResult(searchResult);

        searchResult = streamingService.searchById(4);
        System.out.println("------------------------------");
        System.out.println("Search By ID: (4)");
        printSearchResult(searchResult);

        List<Song> searchResults = streamingService.searchByTitle("th");
        System.out.println("------------------------------");
        System.out.println("Search By Title: (th)");
        printSearchResults(searchResults);

        searchResults = streamingService.searchByTitle("th");
        System.out.println("------------------------------");
        System.out.println("Search By Title: (th)");
        printSearchResults(searchResults);
        
        searchResults = streamingService.searchByAlbum("i");
        System.out.println("------------------------------");
        System.out.println("Search By Album: (i)");
        printSearchResults(searchResults);

        searchResults = streamingService.searchByAlbum("i");
        System.out.println("------------------------------");
        System.out.println("Search By Album: (i)");
        printSearchResults(searchResults);
    }
}